package com.example.newsnow;

//import android.graphics.Bitmap;

import android.graphics.Bitmap;

public class ModelClass {
    private Bitmap imageView1 ;
    private String textview1;

     ModelClass(Bitmap imageView1, String textView1) {
        this.imageView1 = imageView1;
        this.textview1=textView1;
    }

    public String getTextview1() {
        return textview1;
    }

    public Bitmap getImageView1() {
        return imageView1;
    }
}

