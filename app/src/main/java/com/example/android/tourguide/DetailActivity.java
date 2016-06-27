package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        final String geoURI = detailIntent.getStringExtra("location_geoURI");

        Button goToMap = (Button)findViewById(R.id.goto_map);
        if (goToMap != null) {
            goToMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?z=20?q=37.7749,-122.4192(Pin)");
//                    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?q=37.7749,-122.4192(Pin)");
                    Log.v("Coordinates", geoURI);
                    Uri gmmIntentUri = Uri.parse(geoURI);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(mapIntent);
                }
            });
        }

    }
}
