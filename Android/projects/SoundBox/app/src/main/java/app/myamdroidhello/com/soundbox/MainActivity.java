package app.myamdroidhello.com.soundbox;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button playButton, prevButton, nextButton;
    private MediaPlayer mediaPlayer;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.m007);

        text = (TextView) findViewById(R.id.artist_name);

        playButton = (Button) findViewById(R.id.play_button);
        prevButton = (Button) findViewById(R.id.prev_button);
        nextButton = (Button) findViewById(R.id.next_button);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_button:
                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
            case R.id.prev_button:
                prevMusic();
                break;
            case R.id.next_button:
                nextMusic();
                break;
        }
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            text.setText("Playing...");
            playButton.setBackground(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_media_pause));

        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            text.setText("Paused");
            playButton.setBackground(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic() {

    }

    public void nextMusic() {

    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
