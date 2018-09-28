package com.bgorriz.ask.eugenia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JokeUtil {

    public static Map getJokeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Airbus-A380", "Esto es un.");
        map.put("Boeing-747", "Esto es el segundo chiste");
        map.put("Boeing-767", "Esto es el tercer chiste");
        map.put("Airbus-A320", "Esto es el cuarto chiste");
        map.put("Concorde", "Esto es el quinto chiste");
        return map;
    }

    public static Map getImageMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Airbus-A380", "https://s3.amazonaws.com/ask-samples-resources/images/airbus.jpg");
        map.put("Boeing-747", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-1.jpg");
        map.put("Boeing-767", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-2.jpg");
        map.put("Airbus-A320", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-3.jpg");
        map.put("Concorde", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-4.jpg");
        return map;
    }

    public static List getKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("Airbus-A380");
        keys.add("Boeing-747");
        keys.add("Boeing-767");
        keys.add("Airbus-A320");
        keys.add("Concorde");
        return keys;
    }

}