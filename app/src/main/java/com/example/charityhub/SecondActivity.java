package com.example.charityhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class SecondActivity extends AppCompatActivity {

    private Button button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button2 = (Button) findViewById(R.id.buttonId2);
        button3 = (Button) findViewById(R.id.buttonId3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinIntent = new Intent(SecondActivity.this,DonorSignUpActivity.class);
                startActivity(signinIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinIntent = new Intent(SecondActivity.this,RecipientSignUpActivity.class);
                startActivity(signinIntent);

            }
        });












    }



    }

