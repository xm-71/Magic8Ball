package edu.iupui.jamcanno.magic8ball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addResponseActivity extends AppCompatActivity {

    private Button mCreateResponseButton;

    private EditText mNewResponseTextField;

    public static Intent newIntent(Context packageContext) {

        Intent i = new Intent(packageContext, addResponseActivity.class);

        return i;
    }

    @Override

    protected void onCreate(Bundle savedInstance) {


        super.onCreate(savedInstance);

        setContentView(R.layout.activity_add_response);


        mNewResponseTextField = (EditText) findViewById(R.id.new_response_text);
        mCreateResponseButton = (Button) findViewById(R.id.create_response_button);

        mCreateResponseButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                Response newResponse = new Response(mNewResponseTextField.getText().toString());
            }


        });


    }
}
