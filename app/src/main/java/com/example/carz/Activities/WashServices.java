package com.example.carz.Activities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carz.R;

public class WashServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_services);
        //Video
        { VideoView video = findViewById(R.id.video);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.registration_video);
        video.setVideoURI(videoPath);
        video.start();}

    }

    public void InWashServices(View view) {
    }
}