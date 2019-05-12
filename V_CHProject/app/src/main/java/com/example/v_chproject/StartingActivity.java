package com.example.v_chproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }

    public void startingButton(View view) {
        Intent goToLoadingActivity = new Intent(this, LoadingActivity.class);
        startActivity(goToLoadingActivity);
        finish();
    }

    public void informationButton(View view){
        //underline the button: "For more information about us"
        final TextView informationTextView = (TextView) findViewById(R.id.informationTextView);
        informationTextView.setPaintFlags(informationTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        //dialog
        final AlertDialog.Builder alert = new AlertDialog.Builder(StartingActivity.this);
        alert.setTitle("Alert");
        alert.setMessage("If you keep this action, editor application will be paused");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                //Go to blog
                String blog = "https://vchphotoeditor.blogspot.com/";
                Uri webaddress = Uri.parse(blog);
                Intent goToBlog = new Intent(Intent.ACTION_VIEW, webaddress);
                startActivity(goToBlog);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
