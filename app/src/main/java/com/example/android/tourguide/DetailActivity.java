package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView locationName = (TextView)findViewById(R.id.location_name);
        TextView locationDesc = (TextView)findViewById(R.id.location_description);
        ImageView locationImg = (ImageView)findViewById(R.id.location_image);

        Intent detailIntent = getIntent();

        locationName.setText(detailIntent.getStringExtra("location_name"));
        locationDesc.setText(detailIntent.getStringExtra("location_desc"));
        final int imgID = detailIntent.getIntExtra("location_imageID", -1);
        if (imgID!=-1){
            locationImg.setImageResource(imgID);
        } else {
            locationImg.setVisibility(View.GONE);
        }

        final String geoURI = detailIntent.getStringExtra("location_geoURI");
        Button goToMap = (Button)findViewById(R.id.goto_map);
        if (goToMap != null) {
            goToMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v("Coordinates", geoURI);
                    Uri gmmIntentUri = Uri.parse(geoURI);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(mapIntent);
                }
            });
        }

    }
}
