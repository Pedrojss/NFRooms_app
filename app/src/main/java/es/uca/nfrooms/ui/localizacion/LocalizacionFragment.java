package es.uca.nfrooms.ui.localizacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import es.uca.nfrooms.MapsActivity;
import es.uca.nfrooms.R;
import es.uca.nfrooms.databinding.FragmentLocalizacionBinding;


public class LocalizacionFragment extends Fragment {
    private FragmentLocalizacionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLocalizacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button tButton = (Button)root.findViewById(R.id.botonTrenes);
        Button bButton = (Button)root.findViewById(R.id.botonBuses);
        Button mButton = (Button)root.findViewById(R.id.mButton);

        tButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.renfe.com/es/es?cid=generica&c=sem&fuente=google&campana=generica&fecha=2022&ubicacion=google&formato=link&elemento_clic=link%20=google&formato=link&elemento_clic=link&s_kwcid=AL!11457!3!354608896052!b!!g!!renfe&gclid=Cj0KCQjwspKUBhCvARIsAB2IYuunTPyk-LlbrPLHprRIQ8dbmBlFXkOyDiQ1mkl-VRT2H_6GSG7hLkkaApUEEALw_wcB"));
                startActivity(viewIntent);
            }
        });

        bButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://siu.cmtbc.es/es/horarios_origen_destino.php?ida=1&vuelta=41"));
                startActivity(viewIntent);
            }
        });

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