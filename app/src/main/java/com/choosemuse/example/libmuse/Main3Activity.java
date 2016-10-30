package com.choosemuse.example.libmuse;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main3Activity extends Activity {

    Button RockB,ClassicalB,WorldB,HipHopB;
    EditText nameEditText;
    String preferencetoastMessage="Preference Considered";

    public static String ROCK_PREFERENCE="rock";
    public static String HIPHOP_PREFERENCE="hiphop";
    public static String CLASSICAL_PREFERENCE="classical";
    public static String WORLD_PREFERNCE="world";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RockB=(Button)findViewById(R.id.rockbutton);
        ClassicalB=(Button)findViewById(R.id.classicalbutton);
        WorldB=(Button)findViewById(R.id.worldbutton);
        HipHopB=(Button)findViewById(R.id.hiphopbutton);
        nameEditText=(EditText)findViewById(R.id.nameedittext);



        double eegData = getIntent().getDoubleExtra(Intent.EXTRA_TEXT, 0.0);

        if(eegData>Utility.STRESSED_EEG)
        {
            Main2Activity.setEmotions(false,true,false,false);
        }
        else if(eegData>Utility.SAD_EEG)
        {
            Main2Activity.setEmotions(false,false,true,false);
        }
        else if(eegData>Utility.HAPPY_EEG)
        {
            Main2Activity.setEmotions(true,false,false,false);

        }
        else if(eegData>Utility.CONCENTRATION_EEG)
        {
            Main2Activity.setEmotions(false,false,false,true);
        }


        RockB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal=nameEditText.getText().toString();
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(nameVal);
                arrayList.add(ROCK_PREFERENCE);
                bundle.putStringArrayList(Intent.EXTRA_TEXT,arrayList);
                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        ClassicalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal=nameEditText.getText().toString();
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(nameVal);
                arrayList.add(CLASSICAL_PREFERENCE);
                bundle.putStringArrayList(Intent.EXTRA_TEXT,arrayList);
                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        WorldB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal=nameEditText.getText().toString();
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(nameVal);
                arrayList.add(WORLD_PREFERNCE);bundle.putStringArrayList(Intent.EXTRA_TEXT,arrayList);
                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        HipHopB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal=nameEditText.getText().toString();
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(nameVal);
                arrayList.add(HIPHOP_PREFERENCE);bundle.putStringArrayList(Intent.EXTRA_TEXT,arrayList);
                Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }

}
