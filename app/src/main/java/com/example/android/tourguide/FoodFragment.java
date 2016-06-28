package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class FoodFragment extends Fragment{
    public FoodFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                 new Location("Collegetown Bagels (CTB)", "description")
                ,new Location("Sangnam Indian Restaurant", "description")
                ,new Location("Alladins Natural Eatery", "description")
                ,new Location("The Nines", "description")
                ,new Location("Insomnia Cookies", "description")
                ,new Location("Ruloff's Restaurant and Bar", "description")
                ,new Location("Hawi Ethiopian Cuisine", "description")
                ,new Location("Moosewood Eatery", "description")
                ,new Location("Waffle Frolic", "description")
                ,new Location("Taste of Thai", "description")
                ,new Location("Risley Dining Hall", "description")
                ,new Location("West Campus Dining Halls", "description")
        ));
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location currentLocation = locations.get(position);
                Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
                detailIntent.putExtra("location_name", currentLocation.getmLocationName());
                detailIntent.putExtra("location_desc", currentLocation.getmLocationDescription());
                detailIntent.putExtra("location_geoURI", currentLocation.getGMapsURI());
                startActivity(detailIntent);
            }
        });
        return rootView;
    }
}
