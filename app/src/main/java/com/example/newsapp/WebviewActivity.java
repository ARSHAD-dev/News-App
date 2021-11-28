package com.example.newsapp;

import static com.example.newsapp.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.widget.Toolbar;
public class WebviewActivity extends AppCompatActivity {
    public static final String TAG="web";
    WebView webview;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_web_view);
        webview=findViewById(R.id.webview);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webview.setWebViewClient(new WebViewClient());
        // Load the initial URL
        try {
            webview.loadUrl(url);
        } catch (Exception e) {
            Log.i(TAG, "onCreate:+++++++++ ");
            e.printStackTrace();

        }


    }




}