package com.softulp.exploradordefarmacias.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.location.*;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
public class MapaViewModel extends AndroidViewModel {
    private MutableLiveData<Location> mLocation;
    private FusedLocationProviderClient fused;
    private  LocationCallback callback;

    public MapaViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
    }
    public LiveData<Location> getMLocation() {

        if (mLocation == null) {

            this.mLocation = new MutableLiveData<>();
        }
        return mLocation;
    }
    public void obtenerUltimaUbicacion() {

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Log.d("salida ", "Sin permisos");
            return;
        }
        Task<Location> tarea = fused.getLastLocation();
        tarea.addOnSuccessListener(getApplication().getMainExecutor(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Log.d("salida ", "antes");
                if (location != null) {
                    mLocation.postValue(location);
                    Log.d("salida ", "dentro");
                }
            }
        });

    }

    public void lecturaPermanente() {

        LocationRequest request = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,1000).build();


        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                Location location = locationResult.getLastLocation();
                mLocation.postValue(location);
            }
        };

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fused.requestLocationUpdates(request, callback, null);

    }

    public void pararLecturaPermanete(){
        fused.removeLocationUpdates(callback);
    }
}