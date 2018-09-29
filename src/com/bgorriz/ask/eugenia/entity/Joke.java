package com.bgorriz.ask.eugenia.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "jokes")
public class Joke {

    private Integer id;
    private String text;

    public Joke() {
    }

    public Joke(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
    @DynamoDBHashKey(attributeName="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
