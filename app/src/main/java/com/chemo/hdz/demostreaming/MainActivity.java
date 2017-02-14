package com.chemo.hdz.demostreaming;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button btnOpenStreaming;
    private VideoView videoView;
    private String path = "rtmp://109.123.70.27:1935/tehnikatv777/tehnikatv777"; //Url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);

        setContentView(R.layout.activity_main);

        //Init components UI
        videoView = (VideoView) findViewById(R.id.vitamio_videoView);
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }
}

