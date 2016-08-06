package app.myamdroidhello.com.mydiary;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText enterText;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = (EditText) findViewById(R.id.ediText);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
                Log.e("dir", baseDir);
//                if (!enterText.getText().toString().equals("")) {
//                    String data = enterText.getText().toString();
//                    writeToFile(data);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please enter text", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        if (readFromFile() != null) {
            enterText.setText(readFromFile());
        }
    }

    private void writeToFile(String myData) {
        try {
            String baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(baseDir + "/" + "diary.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(myData);
            outputStreamWriter.close();     // always close your streams
        } catch (IOException e) {
            Log.e("MyActivity", e.toString());
        }
    }

    private String readFromFile() {
        String result = "";

        try {
            String baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();

            InputStream inputStream = openFileInput(baseDir + "/" + "diary.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (tempString = bufferedReader.readLine() ) != null) {
                    stringBuilder.append(tempString);
                }

                inputStream.close();
                result = stringBuilder.toString();
            }
        } catch(FileNotFoundException e) {
            Log.v("MyActivity", "file not found "+e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
