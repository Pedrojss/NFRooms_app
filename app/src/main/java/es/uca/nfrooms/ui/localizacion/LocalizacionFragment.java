package es.uca.nfrooms.ui.localizacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import es.uca.nfrooms.MapsActivity;
import es.uca.nfrooms.R;
import es.uca.nfrooms.crearReserva;
import es.uca.nfrooms.databinding.FragmentLocalizacionBinding;


public class LocalizacionFragment extends Fragment {
    private FragmentLocalizacionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLocalizacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button mButton = (Button)root.findViewById(R.id.mButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

}