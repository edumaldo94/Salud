package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.exploradordefarmacias.R;

import java.util.ArrayList;


public class FarmaciaDetailsViewModel extends AndroidViewModel {

    private MutableLiveData<Farmacia> farmaciaMutableLiveData;

    public FarmaciaDetailsViewModel(@NonNull Application application) {

        super(application);

    }


    public MutableLiveData<Farmacia> getFarmaciaMutableLiveData() {
        if (farmaciaMutableLiveData == null) {
            farmaciaMutableLiveData = new MutableLiveData<>();
        }
        return farmaciaMutableLiveData;
    }

    public void cargarDatos2(Intent intent) {

        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String direccion = intent.getStringExtra("direccion");
            String horarios = intent.getStringExtra("horarios");
            int foto = intent.getIntExtra("foto", -1);

            Farmacia farmacia = new Farmacia(nombre, direccion, horarios, foto);
            farmaciaMutableLiveData.setValue(farmacia);
        }
    }
}