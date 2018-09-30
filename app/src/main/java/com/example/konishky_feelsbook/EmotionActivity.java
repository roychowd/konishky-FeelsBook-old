package com.example.konishky_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

public class EmotionActivity extends AppCompatActivity {
    private EditText mDateField;
    private EditText mCommentField;
    private Emotion mEmotion;
    //private ArrayList<Emotion> mListOfEmotions = new ArrayList<>();
    private EmotionList mListOfEmotions = EmotionList.getInstance();
    public static final String EMOTION_EXTRA = "emotion";
    private int LatestAddedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emotion);

        // sets the textview to display emotion name
        Intent intent = getIntent();
        String emotionString = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.emotion_TextView);
        textView.setText(emotionString);

        // sets the datefield
        mEmotion = mListOfEmotions.grabElementByIndex(LatestAddedIndex);
        mDateField = findViewById(R.id.date_text);
        String date = mEmotion.getDate();
        Log.d( "THEINDEX", mEmotion.getDate());
        mDateField.setText(date);

        // sets the other fields
        mCommentField = findViewById(R.id.Optional_comment);
        Button addButton = findViewById(R.id.add_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LatestAddedIndex = mListOfEmotions.getListCount() - 1;
        Log.d("THEINDEX", String.valueOf(LatestAddedIndex));
    }

    /**
     * The following returns the ISO-8601 formatted date
     * i used this resource to help me
     * https://mincong-h.github.io/2017/02/16/convert-date-to-string-in-java/
     * credit belongs to the creator of the article: Mincong Huang
     * @return date string thats formatted in iso-8601
     */



    public void onAddButtonClick(View view) {
        mEmotion.setComment(mCommentField.getText().toString());
        if (mDateField.getText().toString() != mEmotion.getDate()) {
            mEmotion.setDate(mDateField.getText().toString());
        }
//        Intent returnIntent = new Intent(EmotionActivity.this, MainActivity.class);
//        returnIntent.putExtra(EMOTION_EXTRA, mEmotion);
//        setResult(Activity.RESULT_OK,returnIntent);
        finish();

    }
}