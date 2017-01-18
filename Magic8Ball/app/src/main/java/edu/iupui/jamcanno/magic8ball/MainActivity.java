package edu.iupui.jamcanno.magic8ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mResponseButton;
    private TextView mTextView;
    private int findRandomResponse(){

        return new Random().nextInt(Response.sAllResponses.length - 1);

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Response.sAllResponses = new Response[] {new Response("It is certain"),
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
                new Response("Very doubtful")};


        //wire up layout widgets

        mTextView = (TextView) findViewById(R.id.response_Text_View);


        //button
        mResponseButton = (Button) findViewById(R.id.response_button);
        mResponseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                //get a random response

                int responseIndex = findRandomResponse();

                //display the response on the screen

                mTextView.setText(Response.sAllResponses[responseIndex].getResponseString());


            }

        });
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
