package com.example.vladk.pickupline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // grab clean button, (Button) - cast it as Button type
        Button cleanButton = (Button) findViewById(R.id.cleanButton);
        final Button dirtyButton = (Button) findViewById(R.id.dirtyButton);
        final String pickupLine = "You had me at Hello world!";
        final String pickupLine2 = "Dirty pickup line";
        cleanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLine(pickupLine);
            }
        });

        dirtyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLine(pickupLine2);
            }
        });
    }

    private void sendLine(String pickupLine) {
        // this - current activity, LineActivity - activity we are going to
        Intent intent = new Intent(this, LineActivity.class);
        intent.putExtra("PickupLine", pickupLine);
        startActivity(intent);

    }

}
