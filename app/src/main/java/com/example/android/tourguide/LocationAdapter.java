package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    // Pass context to BitMapWorkerTask
    Context context;

    public LocationAdapter(Context context, List<Location> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get location at this list position
        Location location = getItem(position);

        // Set layout to location_card.xml
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_card, parent, false);
        }

        // Setting name and description (text)
        TextView locationName = (TextView) convertView.findViewById(R.id.location_name);
        TextView locationDesc = (TextView) convertView.findViewById(R.id.location_description);
        locationName.setText(location.getmLocationName());
        locationDesc.setText(location.getmLocationDescription());

        // Setting image view; conditional on existence of image resource for location
        ImageView locationImageView = (ImageView) convertView.findViewById(R.id.location_image);
        if (location.hasImage()){
            BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(locationImageView, context);
            bitmapWorkerTask.execute(location.getmImageResourceId());
            return convertView;
        } else{
            locationImageView.setVisibility(View.GONE);
            return convertView;
        }
    }
}
