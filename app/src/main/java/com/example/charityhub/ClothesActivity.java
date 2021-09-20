package com.example.charityhub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ClothesActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);


    }


    public void MyWeb(View view) {

        openUrl("https://jaago.com.bd/");

    }
    public void openUrl(String url){
        Uri uri= Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }

    public void MyWeb1(View view) {

        openUrl("https://bidyanondo.org/");

    }
    public void openUrl1(String url){
        Uri uri= Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }

    public void MyWeb2(View view) {

        openUrl("http://www.utshobangladesh.org/");

    }
    public void openUrl2(String url){
        Uri uri= Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }

    public void MyWeb3(View view) {

        openUrl("http://aponfoundation.org/");

    }
    public void openUrl3(String url){
        Uri uri= Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }


};
