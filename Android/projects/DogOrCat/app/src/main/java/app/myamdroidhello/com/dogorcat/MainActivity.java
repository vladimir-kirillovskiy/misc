package app.myamdroidhello.com.dogorcat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup canineRadioGroup, droolRadioGroup;
    private RadioButton canineRadioButton, droolRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private Button showResultButton;
    private int dogCounter, catCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
        seekBar = (SeekBar) findViewById(R.id.seekBarFeline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText("Comfortableness: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        catCounter = 0;
        dogCounter = 0;
    }

    public void setUp(){
        dogCounter = 0;
        catCounter = 0;

        canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
        droolRadioGroup = (RadioGroup) findViewById(R.id.radioGroupDrool);

        seekBarTextView = (TextView) findViewById(R.id.seekBarProgresTextView);
        cutestCheckBoxDog = (CheckBox) findViewById(R.id.cutestDog);
        cutestCheckBoxCat= (CheckBox) findViewById(R.id.cutestCat);
        cutestCheckBoxParrot = (CheckBox) findViewById(R.id.cutestParrot);

        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);

        showResultButton = (Button) findViewById(R.id.showResults);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);

                startActivity(i);
            }
        });
    }

    public void processCutest(CheckBox dog, CheckBox cat, CheckBox parrot){
        if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked()) {
            dogCounter += 5;
        } else if (!dog.isChecked() && cat.isChecked() && !parrot.isChecked()) {
            catCounter += 5;
        }
    }

    public void processDrool(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                droolRadioButton = (RadioButton) findViewById(radioId);

                if (droolRadioButton.getText().equals("Yes")) {
                    dogCounter += 5;
                } else {
                    catCounter += 5;
                }
            }
        });
    }

    public void processCanines(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                canineRadioButton = (RadioButton) findViewById(radioId);

                if (canineRadioButton.getText().equals("Yes")) {
                    dogCounter += 5;
                }
            }
        });
    }
}
