package com.example.a66155500.mobapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class sensor_list_detail extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "SensorDetail";
    private SensorManager manager;
    private Sensor mySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list_detail);

        TextView sensorName = (TextView) findViewById(R.id.sensorNameValue);
        TextView sensorVendor = (TextView) findViewById(R.id.sensorVendorValue);
        TextView sensorPressure = (TextView) findViewById(R.id.sensorPressureValue);

        manager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        //mPressure = manager.getDefaultSensor(Sensor.TYPE_PRESSURE);




        Bundle extras = getIntent().getExtras();
        //String sensorName = extras.getString("SENSOR_NAME");
        //String sensorVendor = extras.getString("SENSOR_VENDOR");
        int sensorType = extras.getInt("SENSOR_TYPE");

        mySensor = manager.getDefaultSensor(sensorType);

        sensorName.setText(mySensor.getName());
        sensorVendor.setText(mySensor.getVendor());

        //sensorTitle.setText("Name: " + sensorName + "\n" + "Hersteller: "+ sensorVendor);

    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) { // Do something here if sensor accuracy changes.
        Log.i(TAG, "onAccuracyChanged()");
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        TextView tvPressure = (TextView) findViewById(R.id.sensorPressureValue);
        TextView tvAcceleration = (TextView) findViewById(R.id.sensorAccelerationValue);
        if(mySensor.getType() == mySensor.TYPE_PRESSURE){
            float millibarsOfPressure = event.values[0];
            //Log.i(TAG, "onSensorChanged() Pressure = " + millibarsOfPressure + " hPa"); TextView tv = (TextView) findViewById(R.id.sensorPressureValue);
            tvPressure.setText("" + millibarsOfPressure + " hPa");
        }else if(mySensor.getType() == mySensor.TYPE_ACCELEROMETER){
            float metersPerSecondX = event.values[0];
            float metersPerSecondY = event.values[1];
            float metersPerSecondZ = event.values[2];
            float metersPerSecond = metersPerSecondX + metersPerSecondY + metersPerSecondZ;
            tvAcceleration.setText("" + metersPerSecond + " m/s");
            tvPressure.setText("Keine Daten für diesen Sensor.");
        }
        else{
            tvPressure.setText("Keine Daten für diesen Sensor.");
            tvAcceleration.setText("Keine Daten für diesen Sensor.");
        }
    }
    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        manager.registerListener(this, mySensor,manager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        manager.unregisterListener(this);
    }
}
