package com.example.a66155500.mobapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class sensorList extends AppCompatActivity {

    private  SensorManager mSensorManager;
    private  Sensor sensorNames;
    private  List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        ListView meineListe = (ListView) findViewById(R.id.sensor_list_view);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorNames= mSensorManager.getDefaultSensor(Sensor.TYPE_ALL);

        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL); //get list of sensors
        ArrayList<String> sensorNames =  new ArrayList<String>(); //list of sensor names

        //iterate through list of sensors, get name of each and append to list of names
        for(int i=0; i< sensorList.size(); i++) {
            String sensor= sensorList.get(i).getName();
            if(sensor == null || sensor.equals(""))
                continue;
            sensorNames.add(sensor);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, sensorNames);
        meineListe.setAdapter(adapter); //populate ListView with sensor names

        meineListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id ) {
                Intent sensorDetails = new Intent(sensorList.this, sensor_list_detail.class);
                //sensorDetails.putExtra("SENSOR_NAME", sensorList.get(position).getName()); //pass sensor name to detail activity
                //sensorDetails.putExtra("SENSOR_VENDOR", sensorList.get(position).getVendor()); // pass vendor name to detail activity
                sensorDetails.putExtra("SENSOR_TYPE", sensorList.get(position).getType());
                startActivity(sensorDetails);
            }
        });
    }

}
