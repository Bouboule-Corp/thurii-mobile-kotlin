package com.bouboulecorp.thurii.HomePage.HomePageFragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bouboulecorp.thurii.R
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.mapboxsdk.Mapbox

class MapFragment : Fragment() {

    private var mapView: MapView? = null
    private var key: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getString(R.string.mapbox_access_token) != null)
            key = getString(R.string.mapbox_access_token)
        else
            key = System.getenv("MAPBOX_KEY")
        Mapbox.getInstance(requireActivity(), key)

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_map, container, false)

        mapView = view.findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
        return view
    }
}