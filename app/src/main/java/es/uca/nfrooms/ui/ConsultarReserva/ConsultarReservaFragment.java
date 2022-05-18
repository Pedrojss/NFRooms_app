package es.uca.nfrooms.ui.ConsultarReserva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.uca.nfrooms.databinding.FragmentNuevaReservaBinding;


public class ConsultarReservaFragment extends Fragment {

    private FragmentNuevaReservaBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConsultarReservaViewModel ConsultarReservaViewModel =
                new ViewModelProvider(this).get(ConsultarReservaViewModel.class);

        binding = FragmentNuevaReservaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}