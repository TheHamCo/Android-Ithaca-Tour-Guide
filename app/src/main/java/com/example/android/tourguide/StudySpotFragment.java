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
public class StudySpotFragment extends Fragment{
    public StudySpotFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                 new Location("Uris Library", "Olin and Uris Libraries house Cornell’s largest collection of resources in the humanities and social sciences including maps, DVDs, newspapers, and microfilms, as well as select engineering and physical sciences materials.",42.4477499,-76.4853009, R.drawable.ad_white)
                ,new Location("Olin Library","Olin and Uris Libraries house Cornell’s largest collection of resources in the humanities and social sciences including maps, DVDs, newspapers, and microfilms, as well as select engineering and physical sciences materials.",42.447905,-76.484293, R.drawable.olin_library)
                ,new Location("Duffield Hall","Duffield Hall, named for Cornell Engineering alumnus David Duffield '62 EE, is one of the country's most sophisticated research and teaching facilities for nanoscale science and engineering. It includes a large atrium that provides a space where faculty and students can interact in a relaxed, attractive environment, particularly during the winter months.",42.4446657,-76.4825664, R.drawable.duffield)
                ,new Location("Bill and Melinda Gates Hall","Home of Cornell Computing and Information Science",42.4450017,-76.4807989, R.drawable.gates_hall)
//                ,new Location("Klarman Hall","description",42.4491149,-76.4834872)
//                ,new Location("Snee Hall","description",42.4436527,-76.4849379)
//                ,new Location("Mann Library","description",42.448766,-76.4763118)
//                ,new Location("Physical Sciences Building","description",42.449856,-76.4818233)
//                ,new Location("Sage Hall","description", 42.4458947,-76.4832581)
//                ,new Location("Law Library","description",42.4438637,-76.4858278)
//                ,new Location("Carpenter Hall", "description",42.4447819,-76.4841869)
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
                detailIntent.putExtra("location_imageID", currentLocation.getmImageResourceId());
                startActivity(detailIntent);
            }
        });
        return rootView;
    }
}
