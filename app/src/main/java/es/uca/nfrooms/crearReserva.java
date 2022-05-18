package es.uca.nfrooms;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class crearReserva extends AppCompatActivity {

        private TextView txtSaludo;
        private Button btnCrearSala;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_creserva);


            Spinner spSala=findViewById(R.id.spSalas);


            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.salas, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spSala.setAdapter(adapter);

            String sala = getIntent().getExtras().getString("sala");
            if(sala != null){
                Log.d("Sala", sala);
                switch (sala){
                    case "Kyoto":
                        spSala.setSelection(0);
                        break;
                    case "Miami":
                        spSala.setSelection(1);
                        break;
                    case "Otawa":
                        spSala.setSelection(2);
                        break;
                    case "Berlin":
                        spSala.setSelection(3);
                        break;
                    default:
                        break;
                }
            }

            txtSaludo = (TextView)findViewById(R.id.textView2);
            txtSaludo.setText("Crea aqui tu reserva!");

            btnCrearSala = (Button)findViewById(R.id.btnCrearReserva);
            btnCrearSala.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {
                    if(validarDatosReserva()){
                        EditText n = findViewById(R.id.editTxtNombre2);
                        EditText e = findViewById(R.id.editTxtEmail);
                        EditText d = findViewById(R.id.editTxtDNI);
                        EditText t = findViewById(R.id.editTextPhone);
                        EditText i = findViewById(R.id.editTxtHoraIni);
                        EditText f = findViewById(R.id.editTxtHoraFin);
                        EditText fe = findViewById(R.id.editTxtFecha);
                        EditText np = findViewById(R.id.editTxtNPersonas);
                        EditText c = findViewById(R.id.editTxtNombre3);


                        String nombre = n.getText().toString(),
                                email = e.getText().toString(),
                                dni = d.getText().toString(),
                                tlf = t.getText().toString(),
                                hIni = i.getText().toString(),
                                hFin = f.getText().toString(),
                                fecha = fe.getText().toString(),
                                npers = np.getText().toString(),
                                comentario = c.getText().toString();

                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("Nombre", nombre);
                            jsonObject.put("email", email);
                            jsonObject.put("dni", dni);
                            jsonObject.put("telefono", tlf);
                            jsonObject.put("horaini", hIni);
                            jsonObject.put("horafin", hFin);
                            jsonObject.put("fecha", fecha);
                            jsonObject.put("npersonas", npers);
                            jsonObject.put("comentario", comentario);
                            jsonObject.put("sala", spSala.getSelectedItem());

                        } catch (JSONException err) {
                            err.printStackTrace();
                        }

                        AndroidNetworking.post("https://nfrooms.herokuapp.com/reservas")
                                .addJSONObjectBody(jsonObject) // posting json
                                .setTag("test")
                                .setPriority(Priority.MEDIUM)
                                .build()
                                .getAsJSONObject(new JSONObjectRequestListener() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        CharSequence text = "Has creado una reserva!";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(crearReserva.this , text, duration);
                                        toast.show();
                                    }
                                    @Override
                                    public void onError(ANError error) {
                                        CharSequence text = "Error - " + error.toString();
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(crearReserva.this , text, duration);
                                        toast.show();
                                    }
                                });


                    }
                }
            });


            ImageView imgSala = findViewById(R.id.imgsala);
            spSala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    switch(spSala.getSelectedItem().toString()){
                        case "Sala Kyoto":
                            imgSala.setImageDrawable(getResources().getDrawable(R.drawable.kyoto));
                            break;
                        case "Sala Miami":
                            imgSala.setImageDrawable(getResources().getDrawable(R.drawable.miami));
                            break;
                        case "Sala Otawa":
                            imgSala.setImageDrawable(getResources().getDrawable(R.drawable.otawa));
                            break;
                        case "Sala Berlin":
                            imgSala.setImageDrawable(getResources().getDrawable(R.drawable.berlin));
                            break;
                    }
                    imgSala.setVisibility(View.VISIBLE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    imgSala.setVisibility(View.GONE);
                }

            });
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private boolean validarDatosReserva(){
            EditText e = findViewById(R.id.editTxtEmail);
            EditText d = findViewById(R.id.editTxtDNI);
            EditText t = findViewById(R.id.editTextPhone);
            EditText hi = findViewById(R.id.editTxtHoraIni);
            EditText hf = findViewById(R.id.editTxtHoraFin);

            String email = e.getText().toString(),
                    dni = d.getText().toString(),
                    tlf = t.getText().toString(),
                    horaIni = hi.getText().toString(),
                    horaFin = hf.getText().toString();
            if(!email.contains("@") || !email.contains(".")){
                Toast.makeText(crearReserva.this, "Error - Email inválido", Toast.LENGTH_LONG).show();
                return false;
            }

            if(!(dni.length() == 9 && Character.isAlphabetic(dni.charAt(8)))){
                Toast.makeText(crearReserva.this, "Error - DNI inválido",Toast.LENGTH_LONG).show();
                return false;
            }

            if(!(TextUtils.isDigitsOnly(tlf))){
                Toast.makeText(crearReserva.this, "Error - Tlf inválido",Toast.LENGTH_LONG).show();
                return false;
            }
            if(horaIni.length() >4 && horaFin.length() > 4){
                String Ini = horaIni.substring(0,2);
                String Fin = horaFin.substring(0,2);
                if(!(Integer.parseInt(Ini) < Integer.parseInt(Fin))){
                    Toast.makeText(crearReserva.this, "Error - Horas inválidas",Toast.LENGTH_LONG).show();
                    return false;
                }
            }
            else{
                Toast.makeText(crearReserva.this, "Error - Horas inválidas",Toast.LENGTH_LONG).show();
                return false;
            }


            return true;
        }
}
