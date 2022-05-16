package es.uca.nfrooms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.*;

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

        String dest = Environment.getExternalStorageDirectory().toString() + "Sala" + sala + ".pdf";

        if (new File(dest).exists()) {
            new File(dest).delete();
        }

        Context mContext = getApplicationContext();
        try {
            /**
             * Creating Document
             */
            Document document = new Document();

            // Location to save
            PdfWriter.getInstance(document, new FileOutputStream(dest));

            // Open to write
            document.open();

            // Document Settings
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("NFRooms");
            document.addCreator("Jose Luis Argudo Garrido");

            /***
             * Variables for further use....
             */
            BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
            float mHeadingFontSize = 20.0f;
            float mValueFontSize = 26.0f;

            /**
             * How to USE FONT....
             */
            BaseFont urName = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);

            // LINE SEPARATOR
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

            // Title Order Details...
            // Adding Title....
            Font mOrderDetailsTitleFont = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDetailsTitleChunk = new Chunk("Sala " + sala, mOrderDetailsTitleFont);
            Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
            mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mOrderDetailsTitleParagraph);

            // Fields of Order Details...
            // Adding Chunks for Title and value
            Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderIdChunk = new Chunk("Capacidad:", mOrderIdFont);
            Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
            document.add(mOrderIdParagraph);

            Font mOrderIdValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderIdValueChunk = new Chunk(capacidad.getText().toString(), mOrderIdValueFont);
            Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);
            document.add(mOrderIdValueParagraph);

            // Adding Line Breakable Space....
            document.add(new Paragraph(""));
            // Adding Horizontal Line...
            document.add(new Chunk(lineSeparator));
            // Adding Line Breakable Space....
            document.add(new Paragraph(""));

            // Fields of Order Details...
            Font mOrderDateFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderDateChunk = new Chunk("Precio:", mOrderDateFont);
            Paragraph mOrderDateParagraph = new Paragraph(mOrderDateChunk);
            document.add(mOrderDateParagraph);

            Font mOrderDateValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDateValueChunk = new Chunk(precio.getText().toString(), mOrderDateValueFont);
            Paragraph mOrderDateValueParagraph = new Paragraph(mOrderDateValueChunk);
            document.add(mOrderDateValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            // Fields of Order Details...
            Font mOrderAcNameFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderAcNameChunk = new Chunk("Descripcion", mOrderAcNameFont);
            Paragraph mOrderAcNameParagraph = new Paragraph(mOrderAcNameChunk);
            document.add(mOrderAcNameParagraph);

            Font mOrderAcNameValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderAcNameValueChunk = new Chunk(descripcion.getText().toString(), mOrderAcNameValueFont);
            Paragraph mOrderAcNameValueParagraph = new Paragraph(mOrderAcNameValueChunk);
            document.add(mOrderAcNameValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            document.close();

            Toast.makeText(mContext, "Created... :)", Toast.LENGTH_SHORT).show();

            AlertDialog correcto = new AlertDialog.Builder(mContext)
                    .setTitle("PDF")
                    .setMessage("PDF generado correctamente")
                    .show();


        } catch (IOException | DocumentException ie) {
            Log.e("PDF","createPdf: Error " + ie.getLocalizedMessage());
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(mContext, "No application found to open this file.", Toast.LENGTH_SHORT).show();
        }
    }
}