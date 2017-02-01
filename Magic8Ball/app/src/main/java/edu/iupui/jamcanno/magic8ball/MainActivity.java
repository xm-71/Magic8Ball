package edu.iupui.jamcanno.magic8ball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mResponseButton;
    private TextView mTextView;


    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    private int findRandomResponse(){

        return new Random().nextInt(Response.sAllResponses.size()-1);

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Response.sAllResponses == null) {

            Response.sAllResponses = new ArrayList<>();
            Response.sAllResponses.add(new Response("It is going to be bad"));
            Response.sAllResponses.add(new Response("It is going to be good"));

        }

        /*

        Response.sAllResponses = new Response[] {

                new Response("It is certain"),
                new Response("It is decidedly so"),
                new Response("Without a doubt"),
                new Response("Yes, definitely"),
                new Response("You may rely on it"),
                new Response("As I see it, yes"),
                new Response("Most likely"),
                new Response("Outlook good"),
                new Response("Yes"),
                new Response("Signs point to yes"),
                new Response("Reply hazy try again"),
                new Response("Ask again later"),
                new Response("Better not tell you now"),
                new Response("Cannot predict now"),
                new Response("Concentrate and ask again"),
                new Response("Don't count on it"),
                new Response("My reply is no"),
                new Response("My sources say no"),
                new Response("Outlook not so good"),
                new Response("Very doubtful")
        };

        */


        //wire up layout widgets

        mTextView = (TextView) findViewById(R.id.response_Text_View);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                //get a random response

                int responseIndex = findRandomResponse();

                //display the response on the screen

                mTextView.setText(Response.sAllResponses.get(responseIndex).getResponseString());


            }
        });


        //button
        mResponseButton = (Button) findViewById(R.id.response_button);
        mResponseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                //get a random response

                int responseIndex = findRandomResponse();

                //display the response on the screen

                mTextView.setText(Response.sAllResponses.get(responseIndex).getResponseString());


            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    //getters & setters


    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(TextView textView) {
        mTextView = textView;
    }

    public Button getResponseButton() {
        return mResponseButton;
    }

    public void setResponseButton(Button responseButton) {
        mResponseButton = responseButton;
    }


}
