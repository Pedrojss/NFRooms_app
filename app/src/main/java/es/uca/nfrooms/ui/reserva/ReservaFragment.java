package es.uca.nfrooms.ui.reserva;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import es.uca.nfrooms.R;
import es.uca.nfrooms.Reserva;
import es.uca.nfrooms.ReservaAdapter;
import es.uca.nfrooms.crearReserva;
import es.uca.nfrooms.databinding.FragmentReservaBinding;
import okhttp3.OkHttpClient;

public class ReservaFragment extends Fragment {

    private FragmentReservaBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReservaViewModel reservaViewModel =
                new ViewModelProvider(this).get(ReservaViewModel.class);

        binding = FragmentReservaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*Conexion con la API*/

        AndroidNetworking.initialize(getContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());

        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getContext(),okHttpClient);

        AndroidNetworking.get("https://nfrooms.herokuapp.com/reservas")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);
                        mRecyclerView.setHasFixedSize(true);
                        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
                        ReservaAdapter reservaAdapter = new ReservaAdapter(reservas);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        mRecyclerView.setLayoutManager(linearLayoutManager);
                        mRecyclerView.setAdapter(reservaAdapter);
                        for (int i=0; i < response.length(); i++) {
                            try {
                                reservas.add(new Reserva(response.getJSONObject(i).getString("_id"),
                                        response.getJSONObject(i).getString("telefono"),
                                        response.getJSONObject(i).getString("sala"),
                                        response.getJSONObject(i).getString("Nombre"),
                                        response.getJSONObject(i).getString("dni"),
                                        response.getJSONObject(i).getString("email"),
                                        response.getJSONObject(i).getString("fecha"),
                                        response.getJSONObject(i).getString("horaini"),
                                        response.getJSONObject(i).getString("horafin"),0,""
                                        ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Toast.makeText(getContext(), "Error - " + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Button nuevaReserva = (Button)root.findViewById(R.id.nuevaReserva);
        nuevaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), crearReserva.class);
                startActivity(intent);
            }
        });

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