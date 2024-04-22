package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.exploradordefarmacias.R;

import java.util.ArrayList;

public class ListaDeFarmaciasViewModel extends AndroidViewModel {

    private ArrayList<Farmacia> listaF;
    private MutableLiveData<RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder>> mutableAdapter;

    public ListaDeFarmaciasViewModel(@NonNull Application application) {
        super(application);
        listaF=new ArrayList<>();

    }

    public MutableLiveData<RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder>> getMutableAdapter() {
        if(mutableAdapter==null){
            mutableAdapter=new MutableLiveData<>();
            cargarDatos();
            RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder>  adapter= new ListaDeFarmaciasAdapter(listaF,getApplication().getApplicationContext());
            mutableAdapter.setValue(adapter);
        }
        return mutableAdapter;
    }

    public void cargarDatos(){
        listaF.add(new Farmacia(" ALFA","San Martin 353",": 8:00am Hasta 22:00pm",  R.drawable.alfa));
        listaF.add(new Farmacia(" Lafinur","Balcarce 175",": 9:00am Hasta 00:00am",  R.drawable.lafinur));
        listaF.add(new Farmacia(" GRASSI","Balcarce 339",": 9:00 am Hasta 21:00pm",  R.drawable.grassi));
        listaF.add(new Farmacia(" FarmaCity","Balcarce 175"," 24hs",  R.drawable.farmcity));
        listaF.add(new Farmacia(" Smata","Lavalle 494",": 9:00 am Hasta 6:00pm",  R.drawable.smata));

    }

}