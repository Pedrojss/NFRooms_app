package es.uca.nfrooms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

public class verReserva extends AppCompatActivity {

    private TextView txtTelefono;
    private TextView txtSala;
    private TextView txtNombre;
    private TextView txtDNI;
    private TextView txtEmail;
    private TextView txtFecha;
    private TextView txtHoraIni;
    private TextView txtHoraFin;
    private TextView txtNPersonas;
    private TextView txtComentario;
    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vreserva);

        Bundle bundle = this.getIntent().getExtras();

        txtTelefono = (TextView)findViewById(R.id.txtTelefono3);
        txtTelefono.setText(bundle.getString("TELEFONO"));

        txtSala = (TextView)findViewById(R.id.txtSala3);
        txtSala.setText(bundle.getString("SALA"));

        txtNombre = (TextView)findViewById(R.id.txtNombre3);
        txtNombre.setText(bundle.getString("NOMBRE"));

        txtDNI = (TextView)findViewById(R.id.txtDNI3);
        txtDNI.setText(bundle.getString("DNI"));

        txtEmail = (TextView)findViewById(R.id.txtEmail3);
        txtEmail.setText(bundle.getString("EMAIL"));

        txtFecha = (TextView)findViewById(R.id.txtFecha3);
        txtFecha.setText(bundle.getString("FECHA"));

        txtHoraIni = (TextView)findViewById(R.id.txtHoraIni3);
        txtHoraIni.setText(bundle.getString("HORAINI"));

        txtHoraFin = (TextView)findViewById(R.id.txtHoraFin3);
        txtHoraFin.setText(bundle.getString("HORAFIN"));

        txtNPersonas = (TextView)findViewById(R.id.txtNPersonas3);
        txtNPersonas.setText(bundle.getString("NPERSONAS"));

        txtComentario = (TextView)findViewById(R.id.txtComentario3);
        txtComentario.setText(bundle.getString("COMENTARIO"));

        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.delete("https://nfrooms.herokuapp.com/reservas/" + bundle.getString("ID"))
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(verReserva.this , "Reserva eliminada", Toast.LENGTH_LONG).show();
                                finish();
                            }
                            @Override
                            public void onError(ANError error) {
                                Toast.makeText(verReserva.this , "Error - " + error.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
