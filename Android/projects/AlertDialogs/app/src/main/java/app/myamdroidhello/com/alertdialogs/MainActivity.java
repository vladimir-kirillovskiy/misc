package app.myamdroidhello.com.alertdialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button showDialog;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showButtonId);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show alert dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                // set title
                dialog.setTitle(getResources().getString(R.string.dialogTitle));
                // set message
                dialog.setMessage(getResources().getString(R.string.dialogMessage));
                // set cancelable
                dialog.setCancelable(false);

                // set an icon
                //dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setIcon(android.R.drawable.star_big_on);
                // set possitive button
                dialog.setPositiveButton(getResources().getString(R.string.possitiveButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // exit
                        MainActivity.this.finish();
                    }
                });
                // set negative button
                dialog.setNegativeButton(getResources().getString(R.string.negativeButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                // create dialog
                AlertDialog alertD = dialog.create();
                // show dialog
                alertD.show();
            }
        });
    }
}
