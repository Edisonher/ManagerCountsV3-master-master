package com.example.jacobo.managercounts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button bLIniciar;
    TextView tLRegistrarse;

    EditText eLUsuario, eLClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLIniciar = (Button) findViewById(R.id.bLIniciar);              //Botón Iniciar que esta en la actividad Login, al presionarse debe direccionar .
        tLRegistrarse = (TextView) findViewById(R.id.tLRegistrarse);    //El TextView REGISTRARSE funciona como un botón el cual direcciona a la actividad REGISTRO.

        eLUsuario = (EditText) findViewById(R.id.eLUsuario);
        eLClave = (EditText) findViewById(R.id.eLClave);

        tLRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1234 && resultCode == RESULT_OK){

        } else {
            if (requestCode == 1234 && resultCode == RESULT_CANCELED){
                Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Inicio(View view){
        if(eLUsuario.getText().toString().matches("Admin")) {
            Intent intent = new Intent(this, DrawerVendActivity.class);
            startActivity(intent);
            finish();
        }
        else if(eLUsuario.getText().toString().matches("Cliente")) {
            Intent intent = new Intent(this, DrawerClienteActivity.class);
            startActivity(intent);
            finish();
        }

        else{
            Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_SHORT).show();

        }



    }
}
