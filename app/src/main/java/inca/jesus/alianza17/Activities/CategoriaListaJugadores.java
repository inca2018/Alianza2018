package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Adapters.AdapterCategoriaJugador;
import inca.jesus.alianza17.Adapters.AdapterCategoriaPlantel;
import inca.jesus.alianza17.Clases.CategoriaPlantel;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.R;

public class CategoriaListaJugadores extends AppCompatActivity {

    String CategoriaId;
    List<Jugadores_Plantel> temp;
    RecyclerView recycler;
    AdapterCategoriaJugador adapter;
    LinearLayoutManager linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista_jugadores);
        Bundle extras=getIntent().getExtras();
        CategoriaId=extras.getString("Categoria_id");
        recycler=(RecyclerView)findViewById(R.id.recycler_lista_jugadores);
        temp=new ArrayList<>();
        temp=CategoriaPlantel.ListaCategorias.get(Integer.parseInt(CategoriaId)-1).getListaJugadoresCateg();


        linear = new LinearLayoutManager(CategoriaListaJugadores.this, LinearLayoutManager.VERTICAL,false);

        adapter= new AdapterCategoriaJugador(CategoriaListaJugadores.this,temp, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(CategoriaListaJugadores.this, "posicion: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);


    }

}
