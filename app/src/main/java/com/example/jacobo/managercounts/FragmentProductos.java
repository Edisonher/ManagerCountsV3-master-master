package com.example.jacobo.managercounts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jacobo.managercounts.Dialogos.Addprod_dialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductos extends Fragment {

    Intent intent;

    Button bAgregarpro;

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.panes, "Producto 1", "     15000","  15000",""),
            new Lista_Entrada(R.drawable.camisa, "Producto 2", "     40000","  40000",""),
            new Lista_Entrada(R.drawable.tennis, "Producto 3", "     60000","  60000",""),
            new Lista_Entrada(R.drawable.proteina, "Producto 4", "     50000","  50000","")
    };


    public FragmentProductos() {
        // Required empty public constructor
    }

    ListView list;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_productos, container, false);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.app.FragmentManager fm = getActivity().getFragmentManager();


                new Addprod_dialog().show(fm, "Addprod_dialog");


                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });



        list = (ListView) view.findViewById(R.id.lista);
        //list = (ListView) view.findViewById(R.id.lista);
        Adapter adapter = new Adapter(getContext(),datos);
        //ArrayAdapter adapter = new ArrayAdapter(FragmentoInicioVend,android.R.layout.simple_list_item_1, datos);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();

                int sel = (int) parent.getItemIdAtPosition(position);

                switch (sel) {
                    case 0:

                        /*Fragment fragment = new HistoriaFragment();
                        FragmentActivity myContext = (FragmentActivity) getActivity();
                        myContext.getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorCliente,fragment).commit();
                        break;
                    case 1:
                        Fragment fragment1 = new HistoriaDosFragment();
                        FragmentActivity myContext1 = (FragmentActivity) getActivity();
                        myContext1.getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorCliente,fragment1).commit();
                        break;
                    case 2:
                        Fragment fragment2 = new HistoriaTresFragment();
                        FragmentActivity myContext2 = (FragmentActivity) getActivity();
                        myContext2.getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorCliente,fragment2).commit();
                        break;
                    case 3:
                        Fragment fragment3 = new HistoriaCuatroFragment();
                        FragmentActivity myContext3 = (FragmentActivity) getActivity();
                        myContext3.getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorCliente,fragment3).commit();
                        break;  */
                        break;

                }
            }
        });



        return view;
    }


    public class Adapter extends ArrayAdapter<Lista_Entrada> {  //Le pasamos q tpo de datos mandamos

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listview_itemprod, datos);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_itemprod, null,true);

            TextView nombre = (TextView) item.findViewById(R.id.tNombrep);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescripp);
            descrip.setText(datos[position].getDescripcion());



            ImageView imagen = (ImageView) item.findViewById(R.id.iFotop);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);

    }
}
