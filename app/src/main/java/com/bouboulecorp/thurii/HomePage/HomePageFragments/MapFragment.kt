package com.bouboulecorp.thurii.HomePage.HomePageFragments
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bouboulecorp.thurii.R
import com.bouboulecorp.thurii.data.map_recyclerview_item
import com.bouboulecorp.thurii.data.map_recyclerview_item_adapter
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.image.image
import com.mapbox.maps.extension.style.style

private const val CAMPING_ICON_ID = "camping"
private const val DANGER_ICON_ID = "danger"
private const val CAMERA_ICON_ID = "camera"
private const val TRASH_ICON_ID = "trash"
private const val WATER_ICON_ID = "water"

class MapFragment : Fragment() {

    private var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

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
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_recycle))
                }
                +image(WATER_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_water))
                }
                +image(CAMERA_ICON_ID) {
                    bitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_camera))
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
        filterButtonList.add(map_recyclerview_item("trash", R.drawable.ic_recycle))

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_caroussel)
        horizontalRecyclerView.adapter = map_recyclerview_item_adapter(filterButtonList, R.layout.item_on_board, requireContext())
        return view
    }
}
