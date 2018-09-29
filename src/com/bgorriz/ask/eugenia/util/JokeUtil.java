package com.bgorriz.ask.eugenia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JokeUtil {

    public static Map getJokeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Airbus-A380", "Saben aquel que diu... que es un tío que va corriendo detrás de un autobús y le dice un peatón: -No corra, no corra, que no lo va a alcanzar! -Pues lo tendré que intentar, porque soy el conductor!!");
        map.put("Boeing-747", "Leí en el periódico: “Mujer enseña el búlgaro”. Fui y era un idioma.");
        map.put("Boeing-767", "Dice que se encuentran dos amigos. - Oye, he encontrado trabajo. -Donde? -En Santiago. -De qué? -De Compostela");
        map.put("Airbus-A320", "Saben aquel que diu.... que en una procesión le pregunta un señor a una señora: Oiga, quién es el muerto? -Creo que el que va dentro de la caja!");
        map.put("Concorde", "Llega un tio a un portero automatico y dice: -No hay nieve en Saint Moris. Y al otro lado se escucha: -El espía vive en el sexto, gilipollas!");
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