package com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.hoangtrongminhduc.html5.dev.testhellobaby.MainActivity;
import com.hoangtrongminhduc.html5.dev.testhellobaby.R;

public class PlayerVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView ytPlayer;
    private String id;
    private String title;
    private final String API_KEY_YT ="AIzaSyAFa3KbCqG5XwyYQrqrWOftUSDc9hy3Ano";
    private TextView tvTieude;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);
        ytPlayer = (YouTubePlayerView) findViewById(R.id.ytPlayer);
        ytPlayer.initialize(API_KEY_YT, this);
        final Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        title = intent.getStringExtra("TITLE");
        tvTieude = (TextView)findViewById(R.id.tvTieude);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerVideo.this, MainActivity.class);
                startActivity(intent);

            }
        });
        tvTieude.setText(title);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.cueVideo(id);//insert bien id video o day
        }
    }



    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        } else {
            String error = String.format("Error initializing YouTube player", youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}