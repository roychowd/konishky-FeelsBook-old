package com.example.konishky_feelsbook;

import java.util.ArrayList;
import java.util.HashMap;

public class EmotionCountMap {

    private static EmotionCountMap instance;
    private static HashMap<String, Integer> countMap;
    private EmotionList emotionArr;

    private EmotionCountMap() {
        emotionArr = EmotionList.getInstance();
        countMap = new HashMap<String, Integer>();
        setCountMap();
    }

    public static EmotionCountMap getInstance() {
        if (instance == null) {
            instance = new EmotionCountMap();
        }
        return instance;
    }




    public void setCountMap() {
        countMap.put("Fear", 0);
        countMap.put("Sadness", 0);
        countMap.put("Anger", 0);
        countMap.put("Joy", 0);
        countMap.put("Surprised", 0);
        countMap.put("Love", 0);
        getCounts();
    }

    private void getCounts() {
        int size = emotionArr.getListCount();
        ArrayList<Emotion> list = EmotionList.getEmotionList();
        for (int i = 0; i < size; i++) {
            Emotion e =  list.get(i);
            String eName = e.getName();
            if (countMap.containsKey(eName)) {
                int count = countMap.get(eName);
                count++;
                countMap.put(eName, count);
            }
        }
    }

    public HashMap<String, Integer> getCountMap() {
        return countMap;
    }

    public String[] getNamesArray() {
        String[] mName = countMap.keySet().toArray(new String[countMap.size()]);
        return mName;
    }

    public Integer[] getCountArray() {
        Integer[] mCount = countMap.values().toArray(new Integer[countMap.size()]);
        return mCount;
    }




}
