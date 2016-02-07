package app.myamdroidhello.com.playmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        playMusic = (Button) findViewById(R.id.playButton);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration() / 1000;
                Toast.makeText(getApplicationContext(), "Duration: " + duration + "seconds", Toast.LENGTH_SHORT).show();
                playMusic.setText("Play");
            }
        });
    }

    public void pauseMusic(){
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    public void startMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            playMusic.setText("Pause");
        }
    }

    /*
    * Free memory then app is being closed
    *
    * */

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
