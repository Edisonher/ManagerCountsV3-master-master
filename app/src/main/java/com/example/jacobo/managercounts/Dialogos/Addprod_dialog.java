package com.example.jacobo.managercounts.Dialogos;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jacobo.managercounts.Objetos.Clientes;
import com.example.jacobo.managercounts.Objetos.FirebaseReferences;
import com.example.jacobo.managercounts.Objetos.Productos;
import com.example.jacobo.managercounts.R;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by admin on 22/05/2017.
 */

public class Addprod_dialog extends DialogFragment{
    private static final String TAG = Addprod_dialog.class.getSimpleName();


    //DatabaseReference myRefp;

    String nombre,precio;
    private static final int GALLERY_INTENT= 1 ;
    //private StorageReference subirImagen;
    private ProgressDialog myProgressDialog;
    ImageButton ImagenBoton;
    EditText nombreprod;

    public Addprod_dialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createAddprod_dialog();
    }


    public AlertDialog createAddprod_dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_addproducto, null);

        builder.setView(v);

       // final FirebaseDatabase databasep = FirebaseDatabase.getInstance();

        nombreprod = (EditText) v.findViewById(R.id.eNombreprod);
        final EditText precioprod = (EditText) v.findViewById(R.id.ePrecioprod);

        //subirImagen = FirebaseStorage.getInstance().getReference();

        Button guardar = (Button) v.findViewById(R.id.bAdguardarprod);
        Button cancelar = (Button) v.findViewById(R.id.bcancelarprod);
        ImagenBoton = (ImageButton) v.findViewById(R.id.ImagenProd);


        guardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta...
                        nombre = nombreprod.getText().toString();
                        precio = precioprod.getText().toString();

                       // Productos producto = new Productos("","");
                        Productos producto = new Productos(nombre,precio);

                        //Clientes cliente = new Clientes("","","","","","","","");

                        /*
                        myRefp = databasep.getReference(FirebaseReferences.PRODUCTOS_REFERENCE).child(nombre);
                        myRefp.setValue(producto);
                        */

                        /*Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();*/
                       dismiss();
                    }
                }
        );

        cancelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
                        dismiss();
                    }
                }

        );

        ImagenBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);

            }
        });

        return builder.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK ){

            nombre = nombreprod.getText().toString();

            Uri uri = data.getData();
           /* StorageReference filepath = subirImagen.child("FotosProductos").child(nombre);
            //StorageReference filepath = subirImagen.child("FotosClientes").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                    Uri descargarfoto = taskSnapshot.getDownloadUrl();
                    Glide.with(Addprod_dialog.this).load(descargarfoto).fitCenter().centerCrop().into(ImagenBoton);



                }
            });*/
        }
    }

}
