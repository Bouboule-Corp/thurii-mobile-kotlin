package com.bouboulecorp.thurii.HomePage.HomePageFragments
import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import com.google.android.gms.location.LocationRequest
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bouboulecorp.thurii.R
import com.bouboulecorp.thurii.data.map_recyclerview_item
import com.bouboulecorp.thurii.data.map_recyclerview_item_adapter
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.expressions.dsl.generated.match
import com.mapbox.maps.extension.style.image.image
import com.mapbox.maps.extension.style.layers.generated.symbolLayer
import com.mapbox.maps.extension.style.layers.properties.generated.IconAnchor
import com.mapbox.maps.extension.style.sources.generated.geoJsonSource
import com.mapbox.maps.extension.style.style

private const val CAMPING_ICON_ID = "camping"
private const val DANGER_ICON_ID = "danger"
private const val CAMERA_ICON_ID = "camera"
private const val TRASH_ICON_ID = "trash"
private const val WATER_ICON_ID = "water"
private const val FISHING_ICON_ID = "fishing"
private const val SOURCE_ID = "source_id"
private const val LAYER_ID = "layer_id"
private const val GEOJSON_SOURCE = "https://raw.githubusercontent.com/Bouboule-Corp/thurii-forward-geojson-dataset/master/point.geojson"

class MapFragment : Fragment() {

    private var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        startLocationUpdates()
        mapView = view.findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyle(
            styleExtension = style(Style.MAPBOX_STREETS) {
                +image(CAMPING_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_camping))
                }
                +image(DANGER_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_forbiden))
                }
                +image(TRASH_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_trash))
                }
                +image(WATER_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_water))
                }
                +image(CAMERA_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_camera))
                }
                +geoJsonSource(SOURCE_ID) {
                    url(GEOJSON_SOURCE)
                }
                +symbolLayer(LAYER_ID, SOURCE_ID) {
                    iconImage(
                        match {
                            get {
                                literal("sym")
                            }
                            stop {
                                literal("Drinking Water")
                                literal(WATER_ICON_ID)
                            }
                            stop {
                                literal("Crossing")
                                literal(CAMPING_ICON_ID)
                            }
                            stop {
                                literal("Fishing Hot Spot Facility")
                                literal(FISHING_ICON_ID)
                            }
                            stop {
                                literal("Submmit")
                                literal(CAMERA_ICON_ID)
                            }
                            literal(TRASH_ICON_ID)
                        }
                    )
                    iconSize(0.15)
                    iconAllowOverlap(false)
                    iconAnchor(IconAnchor.BOTTOM)
                }
            }
        )
        val filterButtonList = arrayListOf<map_recyclerview_item>() //list of buttons
        filterButtonList.add(map_recyclerview_item("menu", R.drawable.ic_burger_menu))
        filterButtonList.add(map_recyclerview_item("plus", R.drawable.ic_plus))
        filterButtonList.add(map_recyclerview_item("camping", R.drawable.ic_camping))
        filterButtonList.add(map_recyclerview_item("climbing_spot", R.drawable.ic_climbing))
        filterButtonList.add(map_recyclerview_item("fishing_spot", R.drawable.ic_fishing))
        filterButtonList.add(map_recyclerview_item("danger", R.drawable.ic_forbiden))
        filterButtonList.add(map_recyclerview_item("water_spot", R.drawable.ic_water))
        filterButtonList.add(map_recyclerview_item("landscape", R.drawable.ic_camera))
        filterButtonList.add(map_recyclerview_item("trash", R.drawable.ic_trash))

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_caroussel)
        horizontalRecyclerView.adapter = map_recyclerview_item_adapter(
            filterButtonList, R.layout.item_on_board, requireContext()
        )
        return view
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    private val locationPermissionCode = 2
    private fun startLocationUpdates() {
        if ((ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        else {
            val locationRequest = LocationRequest()
            locationRequest.interval = 2000
            locationRequest.fastestInterval = 1000
            locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }
}
