package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.exploradordefarmacias.R;
import com.softulp.exploradordefarmacias.databinding.ActivityFarmaciaDetailsBinding;

public class FarmaciaDetailsActivity extends AppCompatActivity {

    private FarmaciaDetailsViewModel viewModel;
    private ActivityFarmaciaDetailsBinding binding;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacia_details);
      // binding= ActivityFarmaciaDetailsBinding.inflate(getLayoutInflater());
       // View root = binding.getRoot();

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(FarmaciaDetailsViewModel.class);

        viewModel.getFarmaciaMutableLiveData().observe(this, new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {
                TextView hora=findViewById(R.id.iDhorarios);
                ImageView foto= findViewById(R.id.idFoto);

                hora.setText("horarios"+ farmacia.getHorarios());
                foto.setImageResource(farmacia.getFoto());
            }
        });


        // Obtener la actividad asociada y llamar a getIntent() desde la actividad

        viewModel.cargarDatos2(getIntent());
        button = findViewById(R.id.btnAtras);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar la actividad actual y volver a la actividad anterior en la pila
            }
        });

    }
}
