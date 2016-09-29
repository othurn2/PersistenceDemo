package com.example.cisc.persistencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String dataName = "My data";
    String stringName = "My string";
    String defaultString = ":-(";
    String currentString = "";
    Button buttonOne;
    ArrayList<String> allStrings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize our two sharedPreferences objects
        preferences = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = preferences.edit();

        // Either load our string or if not available our default string
        currentString = preferences.getString(stringName, defaultString);

        // Make button from the burton id out layout
        buttonOne = (Button)findViewById(R.id.button);
        buttonOne.setOnClickListener(this);
        buttonOne.setText(currentString);

    }

    @Override
    public void onClick(View v) {
        // Get a random number
        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);

        currentString = currentString + ourRandom;

        editor.putString(stringName, currentString);
        editor.commit();

        buttonOne.setText(currentString);


    }

    public void printArray(ArrayList<String> a ){
        for (int i = 0; i < a.size(); i++){
            Log.i("allStrings: ", "" + a.get(i));
        }
    }
}
