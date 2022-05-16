package es.uca.nfrooms.ui.reserva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.uca.nfrooms.databinding.FragmentReservaBinding;

public class ReservaFragment extends Fragment {

    private FragmentReservaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReservaViewModel reservaViewModel =
                new ViewModelProvider(this).get(ReservaViewModel.class);

        binding = FragmentReservaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReserva;
        reservaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}