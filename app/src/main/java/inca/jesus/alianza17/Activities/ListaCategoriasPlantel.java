package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import inca.jesus.alianza17.Adapters.AdapterCategoriaPlantel;
import inca.jesus.alianza17.Clases.CategoriaPlantel;
import inca.jesus.alianza17.R;

public class ListaCategoriasPlantel extends AppCompatActivity {

    RecyclerView recycler;
    AdapterCategoriaPlantel adapter;
    private LinearLayoutManager linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_plantel);
        recycler=(RecyclerView)findViewById(R.id.recycler_categoria_plantel);

        linearLayout = new LinearLayoutManager(ListaCategoriasPlantel.this, LinearLayoutManager.VERTICAL,false);
        adapter= new AdapterCategoriaPlantel(ListaCategoriasPlantel.this, CategoriaPlantel.ListaCategorias, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {


                Intent intent = new Intent(ListaCategoriasPlantel.this,CategoriaListaJugadores.class);
                intent.putExtra("Categoria_id",String.valueOf(CategoriaPlantel.ListaCategorias.get(position).getId()));
                intent.putExtra("Pos",String.valueOf(position));
                startActivity(intent);
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linearLayout);

    }
}
