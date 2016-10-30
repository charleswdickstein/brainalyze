package com.choosemuse.example.libmuse;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main2Activity extends YouTubeBaseActivity{


    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    String userName;
    String userPrefernce;
    String userEmotion;

    String welcomeMessage;

    public static boolean happyBool=false;
    public static boolean stressedBool=false;
    public static boolean sadBool=false;
    public static boolean concentrationBool = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        ArrayList<String> nameAndPref= getIntent().getExtras().getStringArrayList(Intent.EXTRA_TEXT);
        userName=nameAndPref.get(0);
        userPrefernce=nameAndPref.get(1);


        if(happyBool)
        {
            userEmotion="Happy";

            Log.e("Main2Activity",userName+userPrefernce+userEmotion);
            welcomeMessage= "Hello "+userName+", you are feeling "+userEmotion;
            Toast.makeText(getApplicationContext(),welcomeMessage,Toast.LENGTH_LONG).show();



        }
        else if(stressedBool)
        {
            userEmotion="Stressed";

            Log.e("Main2Activity",userName+userPrefernce+userEmotion);

            welcomeMessage="Hello "+userName+", you are feeling "+userEmotion;

            Toast.makeText(getApplicationContext(),welcomeMessage,Toast.LENGTH_LONG).show();




        }
        else if(sadBool)
        {
            userEmotion="Sad";Log.e("Main2Activity",userName+userPrefernce+userEmotion);

            welcomeMessage="Hello "+userName+", you are feeling "+userEmotion;


            Toast.makeText(getApplicationContext(),welcomeMessage,Toast.LENGTH_LONG).show();

        }
        else if(concentrationBool)
        {
            userEmotion="Focused";Log.e("Main2Activity",userName+userPrefernce+userEmotion);

            welcomeMessage="Hello "+userName+", you are feeling "+userEmotion;

            Toast.makeText(getApplicationContext(),welcomeMessage,Toast.LENGTH_LONG).show();


        }

















        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                String loadURL="SuuypjzzqRw";
                    if(happyBool) //Calm
                    {
                        if(userPrefernce.equals(Main3Activity.CLASSICAL_PREFERENCE))
                        {
                            loadURL=Utility.CLASSICAL_CALM;

                        }
                        else if(userPrefernce.equals(Main3Activity.HIPHOP_PREFERENCE))
                        {
                            loadURL=Utility.HIPHOP_CALM;
                        }
                        else if(userPrefernce.equals(Main3Activity.WORLD_PREFERNCE))
                        {
                            loadURL=Utility.WORLD_CALM;
                        }
                        else if(userPrefernce.equals(Main3Activity.ROCK_PREFERENCE))
                        {
                            loadURL=Utility.ROCK_CALM;

                        }


                    }
                else if(sadBool) //Calm
                    {
                        if(userPrefernce.equals(Main3Activity.CLASSICAL_PREFERENCE))
                        {
                            loadURL=Utility.CLASSICAL_CALM;
                        }
                        else if(userPrefernce.equals(Main3Activity.HIPHOP_PREFERENCE))
                        {
                        loadURL=Utility.HIPHOP_CALM;
                        }
                        else if(userPrefernce.equals(Main3Activity.WORLD_PREFERNCE))
                        {
                            loadURL=Utility.WORLD_CALM;
                        }
                        else if(userPrefernce.equals(Main3Activity.ROCK_PREFERENCE))
                        {

                            loadURL=Utility.ROCK_CALM;
                        }

                    }
                else if(concentrationBool) //Inspirational
                    {
                        if(userPrefernce.equals(Main3Activity.CLASSICAL_PREFERENCE))
                        {
                            loadURL=Utility.CLASSICAL_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.HIPHOP_PREFERENCE))
                        {
                            loadURL=Utility.HIPHOP_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.WORLD_PREFERNCE))
                        {
                            loadURL=Utility.WORLD_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.ROCK_PREFERENCE))
                        {

                            loadURL=Utility.ROCK_INSPIRATIONAL;
                        }

                    }
                else if(stressedBool) //Inspirational
                    {

                        if(userPrefernce.equals(Main3Activity.CLASSICAL_PREFERENCE))
                        {
                            loadURL=Utility.CLASSICAL_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.HIPHOP_PREFERENCE))
                        {
                            loadURL=Utility.HIPHOP_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.WORLD_PREFERNCE))
                        {
                            loadURL=Utility.WORLD_INSPIRATIONAL;
                        }
                        else if(userPrefernce.equals(Main3Activity.ROCK_PREFERENCE))
                        {

                            loadURL=Utility.ROCK_INSPIRATIONAL;
                        }
                    }



                    youTubePlayer.loadVideo(loadURL);
//



            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),"Initialization Failed",Toast.LENGTH_SHORT).show();
            }
        };




    }

   public static void setEmotions(boolean happy, boolean stressed, boolean sad, boolean ecstatic)
    {
        happyBool=happy;
        stressedBool=stressed;
        sadBool=sad;
        concentrationBool =ecstatic;
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  emotionTextView.setText(welcomeMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();





        youTubePlayerView.initialize(Utility.YOUTUBEAPI_KEY,onInitializedListener);



    }



}

