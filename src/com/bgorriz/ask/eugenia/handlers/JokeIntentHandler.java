package com.bgorriz.ask.eugenia.handlers;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bgorriz.ask.eugenia.entity.Joke;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;

import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;
import static com.bgorriz.ask.eugenia.util.Constants.SECOND_BREAK;

public class JokeIntentHandler implements RequestHandler {

    private DynamoDBMapper dynamoDb;


    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("chisteIntent").or(intentName("AMAZON.YesIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        int randomKey = new Random().nextInt(Integer.parseInt(System.getenv("totalKeys")));
        initDynamoDbMapper();

        Joke joke = dynamoDb.load(Joke.class, randomKey);

        String title = "Eugenia";
        //FIXME: If you would like to display additional text, please set the secondary text accordingly
        String secondaryText = "";

        String speechText = "<speak> " + joke.getText() + SECOND_BREAK + "Quieres escuchar otro chiste?" + " </speak>";


        Template template = getBodyTemplate3(title, joke.getText(), secondaryText, null);

        // Device supports display interface
        if (null != input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, joke.getText())
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText)
                    .build();
        } else {
            // Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, joke.getText())
                    .withReprompt(speechText)
                    .build();
        }
    }

    /**
     * Helper method to create a body template 3
     *
     * @param title         the title to be displayed on the template
     * @param primaryText   the primary text to be displayed on the template
     * @param secondaryText the secondary text to be displayed on the template
     * @param image         the url of the image
     * @return Template
     */
    private Template getBodyTemplate3(String title, String primaryText, String secondaryText, Image image) {
        return BodyTemplate3.builder()
                .withImage(image)
                .withTitle(title)
                .withTextContent(getTextContent(primaryText, secondaryText))
                .build();
    }

    /**
     * Helper method to create the image object for display interfaces
     *
     * @param imageUrl the url of the image
     * @return Image that is used in a body template
     */
    private Image getImage(String imageUrl) {
        List<ImageInstance> instances = getImageInstance(imageUrl);
        return Image.builder()
                .withSources(instances)
                .build();
    }

    /**
     * Helper method to create List of image instances
     *
     * @param imageUrl the url of the image
     * @return instances that is used in the image object
     */
    private List<ImageInstance> getImageInstance(String imageUrl) {
        List<ImageInstance> instances = new ArrayList<>();
        ImageInstance instance = ImageInstance.builder()
                .withUrl(imageUrl)
                .build();
        instances.add(instance);
        return instances;
    }

    /**
     * Helper method that returns text content to be used in the body template.
     *
     * @param primaryText
     * @param secondaryText
     * @return RichText that will be rendered with the body template
     */
    private TextContent getTextContent(String primaryText, String secondaryText) {
        return TextContent.builder()
                .withPrimaryText(makeRichText(primaryText))
                .withSecondaryText(makeRichText(secondaryText))
                .build();
    }

    /**
     * Helper method that returns the rich text that can be set as the text content for a body template.
     *
     * @param text The string that needs to be set as the text content for the body template.
     * @return RichText that will be rendered with the body template
     */
    private RichText makeRichText(String text) {
        return RichText.builder()
                .withText(text)
                .build();
    }

    private void initDynamoDbMapper() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(Regions.EU_WEST_1));
        this.dynamoDb = new DynamoDBMapper(client);
    }

}
