package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.softulp.exploradordefarmacias.databinding.FragmentListadefarmaciasBinding;


public class ListaDeFarmaciasFragment extends Fragment {
    private ListaDeFarmaciasViewModel ltf;
    private FragmentListadefarmaciasBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListadefarmaciasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ltf=new ViewModelProvider(this).get(ListaDeFarmaciasViewModel.class);
        ltf.getMutableAdapter().observe(getViewLifecycleOwner(), new Observer<RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder>>() {
            @Override
            public void onChanged(RecyclerView.Adapter<ListaDeFarmaciasAdapter.FarmaciaViewHolder> FarmaciaViewHolderAdapter) {
                GridLayoutManager glm = new GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.recyclerViewt.setLayoutManager(glm);
                binding.recyclerViewt.setAdapter(FarmaciaViewHolderAdapter);
            }
        });

        return root;
    }
}
