package com.example.konishky_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class CountedLayout extends AppCompatActivity {
    HashMap<String,Integer> countMap = new HashMap<>();
    ListView countedListView;

    public void setCountMap(HashMap<String, Integer> countMap) {
        countMap.put("Fear", 0);
        countMap.put("Sadness", 0);
        countMap.put("Anger", 0);
        countMap.put("Joy", 0);
        countMap.put("Surprised", 0);
        countMap.put("Love", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counted_layout);
        setCountMap(countMap);
        Intent intent = getIntent();
        ArrayList<Emotion> mEmotionList = EmotionList.getEmotionList();

        getCounts(mEmotionList);
        String[] mName = countMap.keySet().toArray(new String[countMap.size()]);
        Integer[] mCount = countMap.values().toArray(new Integer[countMap.size()]);
        CountViewAdapter adapter = new CountViewAdapter(this, mName, mCount);
        countedListView = findViewById(R.id.CountedListView);
        countedListView.setAdapter(adapter);

    }


    private void getCounts(ArrayList emotionArr) {
        for (int i = 0; i < emotionArr.size(); i++) {
            Emotion e = (Emotion) emotionArr.get(i);
            String eName = e.getName();

            if (countMap.containsKey(eName)) {
                int count = countMap.get(eName);
                count++;
                countMap.put(eName, count);
                int x = countMap.get(eName);
                Log.d("COUNTMAP", eName + "value is : " + String.valueOf(x) );
            }




        }
    }
}
