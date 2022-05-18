package es.uca.nfrooms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}
