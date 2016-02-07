package app.myamdroidhello.com.dogorcat;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.resultTextView);
        imageView = (ImageView) findViewById(R.id.petImageView);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            int catResult = extras.getInt("catCounter");
            int dogResult = extras.getInt("dogCounter");

            if (catResult > dogResult) {

                result.setText("Cat Person");
//              imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_cat));       // deprecated
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_lg_cat));

            } else if (dogResult > catResult){

                result.setText("Dog Person");
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_lg_dog));

            } else {
                result.setText("Neither");
            }
        }
    }
}
