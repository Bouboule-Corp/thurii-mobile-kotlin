package com.bouboulecorp.thurii.HomePage.HomePageFragments
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.R
import com.mapbox.maps.MapView
import com.mapbox.maps.Style

class MapFragment : Fragment() {

    private var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val preferences = this.activity!!
            .getSharedPreferences("USER_VARIABLES", Context.MODE_PRIVATE)
        val mapboxStyle = preferences.getString("mapbox_style", "mapbox://styles/mapbox/outdoors-v11")

        mapView = view.findViewById(R.id.mapView)
        if (mapboxStyle != null) {
            mapView?.getMapboxMap()?.loadStyleUri(mapboxStyle)
        }
        return view
    }
}
