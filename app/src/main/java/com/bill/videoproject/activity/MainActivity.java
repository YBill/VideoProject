package com.bill.videoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bill.videoproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleVideo(View view) {
        Intent intent = new Intent(this, VideoSettingActivity.class);
        startActivity(intent);
    }

    public void handleAudio(View view) {
        Intent intent = new Intent(this, AudioActivity.class);
        startActivity(intent);
    }
}
