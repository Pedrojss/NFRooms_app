package es.uca.nfrooms.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import es.uca.nfrooms.R;
import es.uca.nfrooms.Reserva;
import es.uca.nfrooms.ReservaAdapter;
import es.uca.nfrooms.crearReserva;
import es.uca.nfrooms.databinding.FragmentReservaBinding;
import es.uca.nfrooms.ui.nuevaReserva.NuevaReservaViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NuevaReserva#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NuevaReservaFragment extends Fragment {

    private FragmentReservaBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NuevaReservaViewModel NuevareservaViewModel =
                new ViewModelProvider(this).get(NuevaReservaViewModel.class);

        binding = FragmentReservaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}