






package com.example.newsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class secondActivity extends AppCompatActivity {
    WebView webView;
    int noteID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        noteID= intent.getIntExtra("httpID",-1);
        if(noteID!=-1){
            Log.i("url is", MainActivity.http.get(noteID));}
        webView= findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(MainActivity.http.get(noteID));
    }

}
