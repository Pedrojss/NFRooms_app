package es.uca.nfrooms.ui.salas;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.uca.nfrooms.R;
import es.uca.nfrooms.Sala;
import es.uca.nfrooms.crearReserva;
import es.uca.nfrooms.databinding.FragmentSalasBinding;

public class SalasFragment extends Fragment {

    private FragmentSalasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalasViewModel salasViewModel =
                new ViewModelProvider(this).get(SalasViewModel.class);

        binding = FragmentSalasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        TextView linkKyoto = (TextView) root.findViewById(R.id.linkKyoto);
        linkKyoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), Sala.class);
                sala.putExtra("sala", "Kyoto");
                startActivity(sala);
            }
        });

        Button reservaKyoto = root.findViewById(R.id.reservaKyoto);
        reservaKyoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), crearReserva.class);
                sala.putExtra("sala", "Kyoto");
                startActivity(sala);
            }
        });

        TextView linkMiami = (TextView) root.findViewById(R.id.linkMiami);
        linkMiami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), Sala.class);
                sala.putExtra("sala", "Miami");
                startActivity(sala);
            }
        });
        Button reservaMiami =  root.findViewById(R.id.reservaMiami);
        reservaMiami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), crearReserva.class);
                sala.putExtra("sala", "Miami");
                startActivity(sala);
            }
        });

        TextView linkOtawa = (TextView) root.findViewById(R.id.linkOtawa);
        linkOtawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), Sala.class);
                sala.putExtra("sala", "Otawa");
                startActivity(sala);
            }
        });

        Button reservaOtawa = root.findViewById(R.id.reservaOtawa);
        reservaOtawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), crearReserva.class);
                sala.putExtra("sala", "Otawa");
                startActivity(sala);
            }
        });

        TextView linkBerlin = (TextView) root.findViewById(R.id.linkBerlin);
        linkBerlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), Sala.class);
                sala.putExtra("sala", "Berlin");
                startActivity(sala);
            }
        });

        Button reservaBerlin = root.findViewById(R.id.reservaBerlin);
        reservaBerlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sala = new Intent(getActivity(), crearReserva.class);
                sala.putExtra("sala", "Berlin");
                startActivity(sala);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}