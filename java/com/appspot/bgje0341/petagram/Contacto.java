package com.appspot.bgje0341.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contacto extends AppCompatActivity{

    TextInputLayout Ti_nombre;
    TextInputLayout Ti_email;
    TextInputLayout Ti_mensaje;
    EditText nombre;
    EditText email;
    EditText mensaje;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Ti_nombre = (TextInputLayout)findViewById(R.id.IL_nombre);
        Ti_email = (TextInputLayout)findViewById(R.id.IL_email);
        Ti_mensaje = (TextInputLayout)findViewById(R.id.IL_contenido);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String nomb = Ti_nombre.getEditText().getText().toString();
                    String from = Ti_email.getEditText().getText().toString();
                    String message = Ti_mensaje.getEditText().getText().toString();
                    Intent intentMail = new Intent(Intent.ACTION_SEND);
                    intentMail.setType("plain/text");

                    intentMail.putExtra(Intent.EXTRA_EMAIL, from);
                    intentMail.putExtra(Intent.EXTRA_TEXT, "Commentario de " + nomb + "\n" + message);
                    startActivity(intentMail);
                }catch(Exception e){
                    System.out.print("Error recuperando los campos");
                }

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Gracias Por tus comentario", Toast.LENGTH_LONG).show();
    }
}
