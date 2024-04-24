package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.ActivityFarmaciaDetailsBinding;

public class FarmaciaDetailsFragment extends Fragment {
    private FarmaciaDetailsViewModel viewModel;
    private ActivityFarmaciaDetailsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ActivityFarmaciaDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(FarmaciaDetailsViewModel.class);

        viewModel.getFarmaciaMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {
                binding.iDhorarios.setText("Horarios: " + farmacia.getHorarios());
                binding.idFoto.setImageResource(farmacia.getFoto());
            }
        });
        viewModel.cargarDatos2(getArguments());
               return root;
    }
}

