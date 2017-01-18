package edu.iupui.jamcanno.magic8ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mResponseButton;
    private TextView mTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire up layout widgets

        mTextView = (TextView) findViewById(R.id.response_Text_View);
        mResponseButton = (Button) findViewById(R.id.response_button);
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
