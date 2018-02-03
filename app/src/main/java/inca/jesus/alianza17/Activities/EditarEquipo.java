package inca.jesus.alianza17.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import inca.jesus.alianza17.Adapters.AdapterCreacionEquipo;
import inca.jesus.alianza17.Adapters.AdapterEditarEquipo;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.R;

public class EditarEquipo extends AppCompatActivity {
    RecyclerView recycler;
    LinearLayoutManager linear;
    AdapterEditarEquipo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipo);
        recycler=(RecyclerView)findViewById(R.id.recycler_editar_equipo);



        linear = new LinearLayoutManager(EditarEquipo.this, LinearLayoutManager.VERTICAL,false);
        adapter= new AdapterEditarEquipo(EditarEquipo.this, MisEquipos.ListaTempEquipo, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);

    }
}
