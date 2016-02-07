package com.example.vladk.messingaround;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button answerYes, answerNo;
    private EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerYes = (Button) findViewById(R.id.yesButton);
        answerNo = (Button) findViewById(R.id.noButton);
        userNameEditText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onYesButtonClick(View view) {
        String usersName = String.valueOf(userNameEditText.getText());
        String yourYesResponse = "This is great "+ usersName;
        Toast.makeText(this, yourYesResponse, Toast.LENGTH_SHORT).show();
    }

    public void onNoButtonClick(View view) {
        String usersName = String.valueOf(userNameEditText.getText());
        String yourNoResponse = "Too bad "+ usersName;
        Toast.makeText(this, yourNoResponse, Toast.LENGTH_LONG).show();
    }
}
