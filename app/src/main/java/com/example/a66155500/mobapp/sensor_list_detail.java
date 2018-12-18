package com.example.a66155500.mobapp;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sensor_list_detail extends AppCompatActivity {

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list_detail);

        TextView sensorTitle = (TextView) findViewById(R.id.sensortitle);

        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        Bundle extras = getIntent().getExtras();
        String sensorName = extras.getString("SENSOR_NAME");
        String sensorVendor = extras.getString("SENSOR_VENDOR");
        sensorTitle.setText("Name: " + sensorName + "\n" + "Hersteller: "+ sensorVendor);
    }
}
