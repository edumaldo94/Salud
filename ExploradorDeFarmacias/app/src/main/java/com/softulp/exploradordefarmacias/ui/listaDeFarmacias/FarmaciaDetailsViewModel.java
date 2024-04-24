package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

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

    public void cargarDatos2(Bundle bundle) {
        if (bundle != null) {
            String nombre = bundle.getString("nombre");
            String direccion = bundle.getString("direccion");
            String horarios = bundle.getString("horarios");
            int foto = bundle.getInt("foto", -1);

            Farmacia farmacia = new Farmacia(nombre, direccion, horarios, foto);
            farmaciaMutableLiveData.setValue(farmacia);
        }
    }
}