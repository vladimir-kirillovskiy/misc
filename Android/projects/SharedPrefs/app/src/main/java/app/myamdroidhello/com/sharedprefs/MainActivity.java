package app.myamdroidhello.com.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextView showNameText;
    private static final String PREFS_NAME = "MyPrefsFile";
    private Button saveName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditText);
        showNameText = (TextView) findViewById(R.id.showMyNameTextView);
        saveName = (Button) findViewById(R.id.saveButton);
        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();

                if (name.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("name", name.getText().toString());
                    editor.commit();    // very important to commit
                }

            }
        });
        // get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        if (prefs.contains("name")) {
            String userName = prefs.getString("name", "not found");
            showNameText.setText("You are " + userName);
        } else {
            showNameText.setText("");
        }
    }
}
