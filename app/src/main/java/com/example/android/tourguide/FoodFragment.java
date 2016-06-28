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
 * Restaurants
 */
public class FoodFragment extends Fragment{
    public FoodFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Locations List
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                 new Location("Collegetown Bagels (CTB)", "Collegetown Bagels, affectionately known by Cornellians as \"CTB\", serves up fine, fresh sandwiches.  With over 80 options on the menu, there's a sandwich for everyone. Sit outside on a nice day—Ithaca does have a handful of them—with a pitcher of sangria or Magic Hat #9, and watch as people traverse the bridge back from class.",42.4423606,-76.4850055, R.drawable.ctb)
                ,new Location("Moosewood", "Moosewood Restaurant is known for its vegetarian cooking, and was named one of the thirteen most influential restaurants of the 20th century by Bon Appetit magazine. It won a James Beard Foundation \"American Classic\" Award in 2000. While they are most known for vegetarian cuisine, their menu does feature a daily fish entree.",42.4406492, -76.4986583, R.drawable.moosewood)
                ,new Location("The Nines", "The Nines is a primarily a pizza joint, but their menu is quite extensive, including a few appetizers and salads, a variety of burgers, many hot and cold sandwiches, and three different “dinners.” It is known, however, primarily for its pizza, and not a few older Ithacans will refer to it as “the best pizza in town.” The Nines may be the only local restaurant to serve deep dish (“Chicago-style”) pizza. ",42.440953,-76.48486, R.drawable.the_nines)
                ,new Location("Ruloff's Restaurant and Bar", "Rulloff’s Restaurant and Bar was established in 1977, serving Cornell and Collegetown for more than 30 years. During any given night, Rulloff's attracts a bar crowd and includes great cocktails, beverage specials and a late night menu. Whether you're looking for a bite to eat or a great place to hang out with friends, you'll enjoy Rulloff's warm and friendly atmosphere.",42.4422565, -76.4849855, R.drawable.ruloffs)
//                ,new Location("Insomnia Cookies", "Insomnia Cookies specializes in delivering warm, delicious cookies right to the doors of individuals and companies alike - until 3am.",42.441201,-76.484936)
//                ,new Location("Hawi Ethiopian Cuisine", "description",42.4390329, -76.4987549)
//                ,new Location("Taste of Thai", "description",42.4397029, -76.4962544)
//                ,new Location("Alladins Natural Eatery", "description",42.441812,-76.486502)
//                ,new Location("Waffle Frolic", "description",42.4397506, -76.4973999)
//                ,new Location("Sangnam Indian Restaurant", "description",42.4422048,-76.487728)
//                ,new Location("Risley Dining Hall", "description",42.45309, -76.4818905)
//                ,new Location("West Campus Dining Halls", "description",42.4473624, -76.489575)
        ));
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);
        // Go to detailed view, passing in:
        // Name, Description, Google Maps URI, ImageID
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
