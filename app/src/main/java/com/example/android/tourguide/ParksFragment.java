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
                 new Location("Cayuga Lake","Cayuga Lake is the longest of central New York's glacial Finger Lakes, and is the second largest in surface area and second largest in volume. It is just under 40 miles long.",42.6776693, -76.6990172)
                ,new Location("Triphammer Falls","Triphammer Falls is a 55ft multiple cascading fall, a centerpiece of the Cornell campus. Named for the Triphammer forge that operated here in the 1820s. University founder Ezra Cornell fell in love with this spot when he first arrived in Ithaca, and he made his name here building the first Beebe Lake Dam to deliver reliable year-round waterpower to mills downstream.",42.451580, -76.480381)
                ,new Location("Robert H. Treman State Park", "Enfield Glen is the scenic highlight of this park. This is an area of rustic beauty with craggy gorges and winding trails bearing \"fire and brimstone\" names like 115ft tall Lucifer Falls and Devil's Kitchen. Come explore our Historic Gristmill with interpretive signs. The park features six trails with spectacular rocky gorges and wooded sections. A three mile section of the Finger Lakes Trail goes through the park.", 42.3989104, -76.5680964)
                ,new Location("Taughannock Falls State Park","With a 215 foot plunge, this waterfall stands three stories taller than Niagara Falls.  The falls’ name is believed derived from the Algonquian Taconic (“in the trees”) or Taghkanic (after a Lenape chieftain killed in battle nearby). Taughannock falls carves a 400ft deep gorge through layers of sandstone, shale and limestone that were once the bed of an ancient sea.",42.5361329, -76.6115596)
                ,new Location("Buttermilk Falls State Park","Buttermilk Creek descends more than 500 feet in a series of cascades and rapids. A natural pool at the base of Buttermilk Falls provides swimming with the feel of an old swimming hole. Upstream, a scenic trail circles Lake Treman. The park features 5 trails that wander through a remarkable variety of landscapes.",42.4192149, -76.5143186)
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
