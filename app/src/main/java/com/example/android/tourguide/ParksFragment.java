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
public class ParksFragment extends Fragment{
    public ParksFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                 new Location("Cayuga Lake","description",42.6776693, -76.6990172)
                ,new Location("Triphammer Falls","description",42.451580, -76.480381)
                ,new Location("Robert H. Treman State Park", "description", 42.3989104, -76.5680964)
                ,new Location("Taughannock Falls State Park","description",42.5361329, -76.6115596)
                ,new Location("Buttermilk Falls State Park","description",42.4192149, -76.5143186)
//                ,new Location("Cayuga Waterfront Trail","description",42.4489922, -76.5140779)
//                ,new Location("Ithaca Falls on Fall Creek","description",42.452782, -76.491660)
//                ,new Location("Stewart Park","description",42.461209, -76.503880)
//                ,new Location("Greek Peak Mountain Resort","description",42.5123724, -76.1475518)
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
