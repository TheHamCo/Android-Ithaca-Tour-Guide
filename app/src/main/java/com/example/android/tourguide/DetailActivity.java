package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView locationName = (TextView)findViewById(R.id.location_name);
        TextView locationDesc = (TextView)findViewById(R.id.location_description);

        Intent detailIntent = getIntent();

        locationName.setText(detailIntent.getStringExtra("location_name"));
        locationDesc.setText(detailIntent.getStringExtra("location_desc"));

    }
}
