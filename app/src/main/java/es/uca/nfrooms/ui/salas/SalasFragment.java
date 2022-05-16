package es.uca.nfrooms.ui.salas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.uca.nfrooms.R;
import es.uca.nfrooms.Sala;
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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}