package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.R;

public class NombreMiEquipo extends AppCompatActivity {
    CardView card;
    EditText dd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_mi_equipo);
        card=(CardView)findViewById(R.id.card_dd);
        dd =(EditText)findViewById(R.id.nom_dd);


        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MisEquipos.MiEquipoTemp.setNombre_Categoria(dd.getText().toString());
                MisEquipos.MiEquipoTemp.setId(1);
                System.out.println("Nombre:"+MisEquipos.MiEquipoTemp.getNombre_Categoria());
                Intent intent=new Intent(NombreMiEquipo.this,CreacionEquipo.class);
                startActivity(intent);
            }
        });


    }
}
