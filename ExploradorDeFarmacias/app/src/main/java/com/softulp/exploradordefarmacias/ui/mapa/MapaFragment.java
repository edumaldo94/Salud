package com.softulp.exploradordefarmacias.ui.mapa;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.FragmentMapaBinding;

public class MapaFragment extends Fragment  implements SharedPreferences.OnSharedPreferenceChangeListener {

    private FragmentMapaBinding binding;
    private MapaViewModel mapViewModel;
    private GoogleMap googleMap2;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap2=googleMap;
            mapViewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {

                  @Override
                public void onChanged(Location location) {

                    LatLng ULP = new LatLng(location.getLatitude(),  location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(ULP).title("Aca estas vos wachim"));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(ULP));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ULP, 15));
                 //   googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


                      LatLng farmacia1 = new LatLng(-33.6868716, -65.4632833); // Coordenadas de la farmacia 1
                      googleMap.addMarker(new MarkerOptions().position(farmacia1).title("ALFA"));

                      LatLng farmacia2 = new LatLng(-33.6893501, -65.468363); // Coordenadas de la farmacia 2
                      googleMap.addMarker(new MarkerOptions().position(farmacia2).title("Lafinur"));

                      LatLng farmacia3 = new LatLng(-33.6854159, -65.4672937); // Coordenadas de la farmacia 1
                      googleMap.addMarker(new MarkerOptions().position(farmacia3).title("GRASSI"));

                      LatLng farmacia4 = new LatLng(-33.6852941, -65.4663062); // Coordenadas de la farmacia 2
                      googleMap.addMarker(new MarkerOptions().position(farmacia4).title("FarmaCity"));

                      LatLng farmacia5 = new LatLng(-33.6841938, -65.4649117); // Coordenadas de la farmacia 2
                      googleMap.addMarker(new MarkerOptions().position(farmacia5).title("Smata"));

                  }
            });



        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);
        mapViewModel = new ViewModelProvider(requireActivity()).get(MapaViewModel.class);
        mapViewModel.obtenerUltimaUbicacion();

         SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        return rootView;
    }
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("map_type")) {
            // Obtén el tipo de mapa seleccionado
            String mapType = sharedPreferences.getString(key, "normal");

            // Actualiza el tipo de mapa en el objeto GoogleMap
            if (mapType.equals("normal")) {
                googleMap2.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            } else if (mapType.equals("satellite")) {
                googleMap2.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            } else if (mapType.equals("hybrid")) {
                googleMap2.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            } else if (mapType.equals("terrain")) {
                googleMap2.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {

            mapFragment.getMapAsync(callback);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
      //  mapViewModel.pararLecturaPermanete();

    }


}