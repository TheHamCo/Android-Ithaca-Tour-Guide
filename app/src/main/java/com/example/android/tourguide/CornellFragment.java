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
public class CornellFragment extends Fragment{
    public CornellFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                 new Location("McGraw Clocktower", "The clocktower is a symbol of the university and stands above Cornell and the community.  The Cornell Chimes has been the heartbeat of campus life for more than a century, marking the hours and chiming concerts. The original set of nine bells first rang out at the university’s opening ceremonies October 7, 1868. It continues to ring daily concerts, making it one of the largest and most frequently played chimes in the world.", 42.4475905, -76.4850102)
                ,new Location("Ho Plaza", "description",42.4467057,-76.4850658)
                ,new Location("Libe Slope","description", 42.4486024,-76.4863108)
                ,new Location("Arts Quad","description",42.448946,-76.4841422)
                ,new Location("Sage Chapel","description",42.4472035,-76.4843806)
                ,new Location("A.D. White Library","description",42.4477499,-76.4853009)
                ,new Location("Law School Reading Room","description",42.4438637,-76.4858278)
                ,new Location("Herbert F. Johnson Museum of Art","description",42.450694,-76.486172)
                ,new Location("Willard Straight Hall","description",42.4465919,-76.4856765)
                ,new Location("Cornell Plantations","description",42.4528032,-76.4639914)
                ,new Location("Fuertes Observatory","description",42.4527584,-76.4744878)
                ,new Location("Cornell Store","description",42.4467339,-76.4846493)
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
