package com.example.a66155500.mobapp;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class bilderWechsel extends AppCompatActivity {

    private ImageView meinBild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilder_wechsel);

        meinBild = (ImageView) findViewById(R.id.meinImageView);

        meinBild.setImageResource(R.drawable.ic_menu_camera);

        meinBild.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                meinBild.setImageResource(R.drawable.ic_menu_send);
                new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        meinBild.setImageResource(R.drawable.ic_menu_camera);
                    }

                }.start();
            }
        });
    }
}
