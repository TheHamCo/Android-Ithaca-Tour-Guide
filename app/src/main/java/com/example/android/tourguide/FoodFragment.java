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
                new Location("Collegetown Bagels (CTB)", "description",42.4423606,-76.4850055)
                ,new Location("Moosewood", "description",42.4406492, -76.4986583)
                ,new Location("The Nines", "description",42.440953,-76.48486)
                ,new Location("Ruloff's Restaurant and Bar", "description",42.4422565, -76.4849855)
                ,new Location("Hawi Ethiopian Cuisine", "description",42.4390329, -76.4987549)
                ,new Location("Insomnia Cookies", "description",42.441201,-76.484936)
                ,new Location("Taste of Thai", "description",42.4397029, -76.4962544)
                ,new Location("Alladins Natural Eatery", "description",42.441812,-76.486502)
                ,new Location("Waffle Frolic", "description",42.4397506, -76.4973999)
                ,new Location("Sangnam Indian Restaurant", "description",42.4422048,-76.487728)
                ,new Location("Risley Dining Hall", "description",42.45309, -76.4818905)
                ,new Location("West Campus Dining Halls", "description",42.4473624, -76.489575)
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
