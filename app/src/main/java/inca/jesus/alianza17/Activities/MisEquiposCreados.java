package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import inca.jesus.alianza17.Adapters.AdapterCategoriaPlantel;
import inca.jesus.alianza17.Adapters.AdapterCreacionEquipo;
import inca.jesus.alianza17.Adapters.AdapterMiEquipo;
import inca.jesus.alianza17.Clases.CategoriaPlantel;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.R;

public class MisEquiposCreados extends AppCompatActivity {
    LinearLayout linear2;
    LinearLayoutManager linear;
    RecyclerView recycler;
    CardView card_crear;
    AdapterMiEquipo adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_equipos_creados);
        linear2=(LinearLayout)findViewById(R.id.linear_mis_equipos);
        recycler=(RecyclerView)findViewById(R.id.recycler_mis_equipos);
        card_crear=(CardView)findViewById(R.id.card_crear_mi_equipo);

        card_crear.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                 Intent intent=new Intent(MisEquiposCreados.this,NombreMiEquipo.class);
                 startActivity(intent);
             }
        });

        linear = new LinearLayoutManager(MisEquiposCreados.this, LinearLayoutManager.VERTICAL,false);
        adapter= new AdapterMiEquipo(MisEquiposCreados.this,MisEquipos.ListaMisEquipo , new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

             /*
                Intent intent = new Intent(ListaCategoriasPlantel.this,CategoriaListaJugadores.class);
                intent.putExtra("Categoria_id",String.valueOf(CategoriaPlantel.ListaCategorias.get(position).getId()));
                intent.putExtra("Pos",String.valueOf(position));
                startActivity(intent);*/
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);


        if(MisEquipos.ListaMisEquipo.size()==0){
            linear2.setVisibility(View.VISIBLE);
            recycler.setVisibility(View.GONE);
        }else{

            linear2.setVisibility(View.GONE);
            recycler.setVisibility(View.VISIBLE);
        }



        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter.getItemCount()==0){
                    linear2.setVisibility(View.VISIBLE);
                    recycler.setVisibility(View.GONE);

                }else{
                    linear2.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);
                }

            }
        });

    }

}
