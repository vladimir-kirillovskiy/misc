package com.example.vladk.pickupline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);



        Bundle pickupData = getIntent().getExtras();
        Button retryButton = (Button) findViewById(R.id.retryButton);

        if (pickupData == null) {
            return;
        }

        String receivedPickupLine = pickupData.getString("PickupLine");
        TextView newLine = (TextView) findViewById(R.id.pickupLine);
        newLine.setText(receivedPickupLine);

        retryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


    }

}
