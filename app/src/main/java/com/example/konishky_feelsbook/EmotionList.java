package com.example.konishky_feelsbook;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static android.provider.Telephony.Mms.Part.FILENAME;


// a singleton class

public class EmotionList {
    // an instance
    private static EmotionList instance;
    private static ArrayList<Emotion> emotionArray;

    // private constructor
    private EmotionList() {
        emotionArray = new ArrayList<Emotion>();
    }

    //access or create class instance
    public static EmotionList getInstance() {
        if (instance == null) {
            instance = new EmotionList();
        }

        return instance;
    }


    // retrieve list from anywhere
    public static ArrayList<Emotion> getEmotionList() {
        return emotionArray;

    }

    // add an emotion to our list
    public void addToEmotionList(Emotion emotion) {
        Emotion newEmotion = new Emotion(emotion.getName());
        emotionArray.add(newEmotion);
        sortArray();
    }


    public void EditEmotion(int index, Emotion e) {
        emotionArray.set(index, e);
    }

    // returns the size of the emotionlist
    public int getListCount() {
        return emotionArray.size();
    }


    // retrieves an emotion // need to work on this implementation
    public Emotion grabElementByDate(String eDate) {
        for ( Emotion next : emotionArray) {
            if (next.getDate() == eDate) {
                return next;
            }
        }

        return null;
    }

    // retrieves an emotion through index
    public Emotion grabElementByIndex(int index) {
        return emotionArray.get(index);
    }

    // deletes a particular emotion
    public void deleteEmotion(int index) {
        emotionArray.remove(index);
    }


    // sorts the emotionlist by date
    public void sortArray() {
        Collections.sort(emotionArray, new Comparator<Emotion>() {
            @Override
            public int compare(Emotion t1, Emotion t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });
    }


}
