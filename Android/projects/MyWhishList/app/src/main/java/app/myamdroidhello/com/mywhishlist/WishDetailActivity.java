package app.myamdroidhello.com.mywhishlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WishDetailActivity extends Activity {

    private TextView title, date, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);

        title = (TextView) findViewById(R.id.detailsTitle);
        date = (TextView) findViewById(R.id.detailsDateText);
        content = (TextView) findViewById(R.id.detailsTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title.setText(extras.getString("title"));
            date.setText("Created: " + extras.getString("date"));
            content.setText(" \" " + extras.getString("content") + " \" ");
        }

    }
}
