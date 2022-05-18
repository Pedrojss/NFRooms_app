package es.uca.nfrooms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.uca.nfrooms.ui.reserva.ReservaFragment;

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.MyViewHolder>{

    private ArrayList<Reserva> reservas;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        TextView name;
        ImageButton show;
        public MyViewHolder(View v) {
            super(v);
            number = (TextView) v.findViewById(R.id.number);
            name = (TextView) v.findViewById(R.id.name);
            show = (ImageButton) v.findViewById(R.id.show);
        }
    }

    public ReservaAdapter(ArrayList<Reserva> myDataset) {
        reservas = myDataset;
    }

    @Override
    public ReservaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                        parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.number.setText(String.valueOf(reservas.get(position).getFecha()));
        holder.name.setText(reservas.get(position).getNombre());
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, verReserva.class);
                Bundle b = new Bundle();
                b.putString("ID", reservas.get(position).getId());
                b.putString("TELEFONO", reservas.get(position).getTelefono());
                b.putString("SALA", reservas.get(position).getTipoSala());
                b.putString("NOMBRE", reservas.get(position).getNombre());
                b.putString("DNI", reservas.get(position).getDNI());
                b.putString("EMAIL", reservas.get(position).getEmail());
                b.putString("FECHA", reservas.get(position).getFecha());
                b.putString("HORAINI", reservas.get(position).getHoraIni());
                b.putString("HORAFIN", reservas.get(position).getHoraFin());
                b.putString("NPERSONAS", reservas.get(position).getnPersonas());
                b.putString("COMENTARIO", reservas.get(position).getComentario());
                intent.putExtras(b);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

}