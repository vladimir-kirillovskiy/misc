package app.myamdroidhello.com.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbPrint;
    private TextView result;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodResults = new String[] {
                "Someone is cranky!",
                "You are my sunshine!",
                "No comments...",
                "You're stressed out!",
                "Happy camper :)",
                "Not your day :(",
                "Smile - it's good for you.",
                "In the clouds...",
                "Pensive!",
                "Sad!",
                "Excited!"

        };

        thumbPrint = (ImageView) findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable) thumbPrint.getBackground();

        result = (TextView) findViewById(R.id.resultText);

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thumbAnimation.start();
                showResults();
                return true;
            }
        });
    }


    public void showResults() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int rand = (int) (Math.random() * moodResults.length);
                result.setText(moodResults[rand]);
                thumbAnimation.stop();
            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 5000);  // run fo 5sec
    }
}
