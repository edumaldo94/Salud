package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.FragmentListadefarmaciasBinding;

import java.util.List;

public class ListaDeFarmaciasAdapter  extends RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder> {
    private List<Farmacia> listaFarmacia;
    private Context context;

    public ListaDeFarmaciasAdapter(List<Farmacia> listaFarmacia, Context context) {
        this.listaFarmacia = listaFarmacia;
        this.context = context;
    }
    public void setFarmacias(List<Farmacia> farmacias){
        listaFarmacia.clear();
        listaFarmacia.addAll(farmacias);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FarmaciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        return new FarmaciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmaciaViewHolder holder, int position) {
        Farmacia farmacia = listaFarmacia.get(position);
        holder.nombre.setText(farmacia.getNombre());
        holder.dirección.setText(farmacia.getDirección());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("horarios", farmacia.getHorarios());
                bundle.putInt("foto", farmacia.getFoto());

                bundle.putSerializable("farmacia",farmacia);
                Navigation.findNavController((Activity) v.getContext(), R.id.nav_host_fragment_content_main).navigate(R.id.farmaciaDetailsFragment,bundle);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFarmacia.size();
    }

    public class  FarmaciaViewHolder extends  RecyclerView.ViewHolder{
        TextView nombre, dirección,horarios ;
        ImageView foto;


        public FarmaciaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.idNombre);
            dirección=itemView.findViewById(R.id.idDireccion);
            horarios= itemView.findViewById(R.id.iDhorarios);
            foto=itemView.findViewById(R.id.idFoto);

        }

    }

}