package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, List<Location> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Location location = getItem(position);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_card, parent, false);
        }

        TextView locationName = (TextView) convertView.findViewById(R.id.location_name);
        TextView locationDesc = (TextView) convertView.findViewById(R.id.location_description);

        locationName.setText(location.getmLocationName());
        locationDesc.setText(location.getmLocationDescription());

        return convertView;

    }
}
