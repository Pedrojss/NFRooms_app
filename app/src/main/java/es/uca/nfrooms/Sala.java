package es.uca.nfrooms;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;

public class Sala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);

        String sala = getIntent().getExtras().getString("sala");
        TextView nombre = findViewById(R.id.nombre);
        TextView descripcion = findViewById(R.id.descripcion);
        TextView capacidad = findViewById(R.id.capacidad);
        TextView precio = findViewById(R.id.precio);
        ImageView img = findViewById(R.id.imageView2);

        Button imprimir = findViewById(R.id.imprimir);

        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPdf();
            }
        });

        switch (sala){
            case "Kyoto":
                img.setImageDrawable(getResources().getDrawable(R.drawable.kyoto));
                SpannableString nom = new SpannableString("Nombre: Sala Kyoto");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                SpannableString desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_kyoto));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                SpannableString cap = new SpannableString("Capacidad: 50 personas");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                SpannableString price = new SpannableString("Precio: 1050€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
                break;
            case "Miami":
                img.setImageDrawable(getResources().getDrawable(R.drawable.miami));
                nom = new SpannableString("Nombre: Sala Miami");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_miami));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                cap = new SpannableString("Capacidad: 2 personas");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                price = new SpannableString("Precio: 40€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
                break;
            case "Otawa":
                img.setImageDrawable(getResources().getDrawable(R.drawable.otawa));
                nom = new SpannableString("Nombre: Sala Otawa");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_otawa));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                cap = new SpannableString("Capacidad: 1 persona");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                price = new SpannableString("Precio: 25€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
                break;
            case "Berlin":
                img.setImageDrawable(getResources().getDrawable(R.drawable.berlin));
                nom = new SpannableString("Nombre: Sala Berlin");
                nom.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                nombre.setText(nom);

                desc = new SpannableString("Descripción: " + getResources().getString(R.string.desc_berlin));
                desc.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, 0);
                descripcion.setText(desc);

                cap = new SpannableString("Capacidad: 5 personas");
                cap.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, 0);
                capacidad.setText(cap);

                price = new SpannableString("Precio: 500€");
                price.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 7, 0);
                precio.setText(price);
                break;
            default:
                break;
        }
    }

    public void createPdf() {
        String sala = getIntent().getExtras().getString("sala");
        TextView nombre = findViewById(R.id.nombre);
        TextView descripcion = findViewById(R.id.descripcion);
        TextView capacidad = findViewById(R.id.capacidad);
        TextView precio = findViewById(R.id.precio);
        ImageView img = findViewById(R.id.imageView2);

        //Datos del pdf
        String TituloText = "Sala " + sala;
        String DescText = descripcion.getText().toString();

        if(checkPermission()){
            Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show();
        }
        else{
            requestPermissions();
        }

        PdfDocument pdfDocument = new PdfDocument();
        Toast.makeText(this, "Generando PDF...", Toast.LENGTH_LONG).show();
        Paint paint = new Paint();
        TextPaint title = new TextPaint();
        TextPaint description = new TextPaint();
        TextPaint cap = new TextPaint();
        TextPaint price = new TextPaint();
        Bitmap bitmap, bitmapEscala;

        PdfDocument.PageInfo paginaInfo = new PdfDocument.PageInfo.Builder(816, 1054, 1).create();
        PdfDocument.Page pagina1 = pdfDocument.startPage(paginaInfo);

        Canvas canvas = pagina1.getCanvas();

        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        title.setTextSize(40);
        canvas.drawText(TituloText, 20, 40, title);

        //bitmap = BitmapFactory.decodeResource(getResources(), img.getId());
        bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
        bitmapEscala = Bitmap.createScaledBitmap(bitmap, 200, 170, false);
        canvas.drawBitmap(bitmapEscala, 40, 350, paint);


        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        descripcion.setTextSize(20);

        String[] arrDescripcion = DescText.split("\n");
        int y = 80;
        for(int i = 0 ; i < arrDescripcion.length ; i++) {
            canvas.drawText(arrDescripcion[i], 20, y, description);
            y += 15;
        }

        cap.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        cap.setTextSize(16);
        canvas.drawText(capacidad.getText().toString(), 20, 150, cap);

        price.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        price.setTextSize(16);
        canvas.drawText(precio.getText().toString(), 20, 180, price);

        pdfDocument.finishPage(pagina1);

        File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        File folder = new File(root.getAbsolutePath() + "/" + "NFRooms");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder.getAbsolutePath() + "/" + sala + ".pdf");
        //File file = new File(Environment.DIRECTORY_DOWNLOADS, "Sala.pdf");

        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(this, "Se creo el PDF correctamente", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al crear pdf - " + e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        pdfDocument.close();

    }

    private boolean checkPermission(){
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 200);
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grandResults){
        if(requestCode == 200){
            if(grandResults.length > 0){
                boolean writeStorage = grandResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grandResults[1] == PackageManager.PERMISSION_GRANTED;

                if(writeStorage && readStorage){
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "Permisos denegado", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }
}