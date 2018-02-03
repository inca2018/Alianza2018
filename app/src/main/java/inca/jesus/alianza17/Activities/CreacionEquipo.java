package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Adapters.AdapterCategoriaJugador;
import inca.jesus.alianza17.Adapters.AdapterCreacionEquipo;
import inca.jesus.alianza17.Adapters.AdapterEventos;
import inca.jesus.alianza17.Clases.CategoriaPlantel;
import inca.jesus.alianza17.Clases.Eventos;
import inca.jesus.alianza17.Clases.JugadorMiEquipo;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.R;

public class CreacionEquipo extends AppCompatActivity implements SearchView.OnQueryTextListener{
    AdapterCreacionEquipo adapter;
    RecyclerView recycler;
    LinearLayoutManager linear;
    Spinner lista;
    SearchView searchView;
    int cont=0;
    CardView numCantidad,Guardar;
    TextView cant_jugad;
    ImageView desmarcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_equipo);
         numCantidad=(CardView)findViewById(R.id.card_cantidad_jugadores);
         Guardar=(CardView)findViewById(R.id.card_guardar_equipo);
         cant_jugad=(TextView)findViewById(R.id.cantidad_jugadores);
        desmarcar=(ImageView)findViewById(R.id.desmarcar);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<Jugadores_Plantel.PLANTEL.size();i++){

                  if(Jugadores_Plantel.PLANTEL.get(i).isSelected()==true){
                      JugadorMiEquipo temp=new JugadorMiEquipo(Jugadores_Plantel.PLANTEL.get(i).getId(),
                              Jugadores_Plantel.PLANTEL.get(i).getNombres(),Jugadores_Plantel.PLANTEL.get(i).getDNI(),
                              Jugadores_Plantel.PLANTEL.get(i).getFecha_nacimiento(),"","",0);


                       MisEquipos.ListaTempEquipo.add(temp);


                  }
                }

                MisEquipos.MiEquipoTemp.setListaJugadoresCateg(MisEquipos.ListaTempEquipo);

                MisEquipos.ListaMisEquipo.add(MisEquipos.MiEquipoTemp);

                Intent intent=new Intent(CreacionEquipo.this,MisEquiposCreados.class);
                startActivity(intent);

            }
        });

        desmarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<Jugadores_Plantel.PLANTEL.size();i++){
                    Jugadores_Plantel.PLANTEL.get(i).setSelected(false);
                }
                adapter.notifyDataSetChanged();
            }
        });

         numCantidad.setVisibility(View.GONE);
         Guardar.setVisibility(View.GONE);
         recycler=(RecyclerView)findViewById(R.id.recycler_creacion_equipo);
         searchView = (SearchView)findViewById(R.id.search);
         searchView.setOnQueryTextListener(this);
         searchView.setQueryHint("Buscar Jugador");



        linear = new LinearLayoutManager(CreacionEquipo.this, LinearLayoutManager.VERTICAL,false);
        adapter= new AdapterCreacionEquipo(CreacionEquipo.this,Jugadores_Plantel.PLANTEL, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter.getCheke()<=16){
                    numCantidad.setVisibility(View.VISIBLE);
                    cant_jugad.setText("Selecciono:"+adapter.getCheke()+" Jugadores");
                    Guardar.setVisibility(View.GONE);
                    findViewById(R.id.overlay).setVisibility(View.GONE);
                }else{
                    recycler.setEnabled(false);
                    Guardar.setVisibility(View.VISIBLE);
                    findViewById(R.id.overlay).setVisibility(View.VISIBLE);
                }


            }
        });


    }





    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        List<Jugadores_Plantel> filteredValues = new ArrayList<Jugadores_Plantel>(Jugadores_Plantel.PLANTEL);
        for (Jugadores_Plantel value : Jugadores_Plantel.PLANTEL) {
            if (!value.getNombres().toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linear = new LinearLayoutManager(CreacionEquipo.this, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterCreacionEquipo(CreacionEquipo.this,filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);

        return false;
    }
    public void resetSearch() {
        linear = new LinearLayoutManager(CreacionEquipo.this, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterCreacionEquipo(CreacionEquipo.this,Jugadores_Plantel.PLANTEL, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
    }

}
