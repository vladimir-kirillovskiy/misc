package app.myamdroidhello.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxDog;
    private CheckBox checkBoxCat;
    private CheckBox checkBoxDragon;

    private Button showButton;
    private TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTextView = (TextView) findViewById(R.id.showTextViewId);
        checkBoxDog = (CheckBox) findViewById(R.id.checkBoxDog);
        checkBoxCat = (CheckBox) findViewById(R.id.checkBoxCat);
        checkBoxDragon = (CheckBox) findViewById(R.id.checkBoxDragon);

        showButton = (Button) findViewById(R.id.showButtonId);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(checkBoxDog.getText().toString() + "status is: " + checkBoxDog.isChecked() + "\n");
                stringBuilder.append(checkBoxCat.getText().toString() + "status is: " + checkBoxCat.isChecked() + "\n");
                stringBuilder.append(checkBoxDragon.getText().toString() + "status is: " + checkBoxDragon.isChecked() + "\n");

                showTextView.setText(stringBuilder);
            }
        });
    }
}
