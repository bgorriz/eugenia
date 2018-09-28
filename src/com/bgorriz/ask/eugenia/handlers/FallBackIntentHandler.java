package com.bgorriz.ask.eugenia.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallBackIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Perdona pero no te he entendido. Querías que te explicara un chiste?";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Eugenia", speechText)
                .withReprompt(speechText)
                .build();
    }

}
