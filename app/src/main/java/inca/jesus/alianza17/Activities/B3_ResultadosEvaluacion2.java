package inca.jesus.alianza17.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.ServerConexion.Ev2Server;
import inca.jesus.alianza17.R;


public class B3_ResultadosEvaluacion2 extends AppCompatActivity {

    public TextView torneo,rival,goles,t_jgado,total;
    ProgressDialog progressDialog;
    //Deportista Depor;
    TextView total1,total2,total3,total4;
    int c1=0,c2=0,c3=0,c4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b3_resultados_evaluacion2);
        Bundle extras=getIntent().getExtras();
        //Depor=extras.getParcelable("Deportista");

        torneo=(TextView)findViewById(R.id.r_comp);
        rival=(TextView)findViewById(R.id.r_rival);
        total=(TextView)findViewById(R.id.r_total);
        goles=(TextView)findViewById(R.id.r_goles);
        t_jgado=(TextView)findViewById(R.id.r_t_jugado);
        total1=(TextView)findViewById(R.id.total_p);
        total2=(TextView)findViewById(R.id.total_r);
        total3=(TextView)findViewById(R.id.total_pg);
        total4=(TextView)findViewById(R.id.total_dr);

        torneo.setText(getIntent().getStringExtra("torneo").toString());
        rival.setText(getIntent().getStringExtra("rival").toString());
        goles.setText(getIntent().getStringExtra("gol").toString());
        t_jgado.setText(getIntent().getStringExtra("jugado").toString());
        total.setText(getIntent().getStringExtra("total").toString());


        for(int i=0;i< Campo.LISTACAMPO.size();i++){
            if(Campo.LISTACAMPO.get(i).getDato().equalsIgnoreCase("P")){
                c1=c1+1;
            }
            if(Campo.LISTACAMPO.get(i).getDato().equalsIgnoreCase("R")){
                c2=c2+1;
            }
            if(Campo.LISTACAMPO.get(i).getDato().equalsIgnoreCase("PG")){
                c3=c3+1;
            }
            if(Campo.LISTACAMPO.get(i).getDato().equalsIgnoreCase("DR")){
                c4=c4+1;
            }

        }



        total1.setText(String.valueOf(c1));
        total2.setText(String.valueOf(c2));
        total3.setText(String.valueOf(c3));
        total4.setText(String.valueOf(c4));


    }

    public void grabar_ev2(View view){

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Guardando Evaluacion");
        progressDialog.setMessage("Cargando.....");
        progressDialog.show();

        String tor=torneo.getText().toString();
        String riva=rival.getText().toString();
        String gole=goles.getText().toString();
        String tiemp=t_jgado.getText().toString();
        String tota=total.getText().toString();
        String idde= String.valueOf(DataServer.COD).toString();
        System.out.println(String.valueOf("ID deportista"+getIntent().getStringExtra("torneo").toString()));


        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {
                        Toast.makeText(B3_ResultadosEvaluacion2.this, "Registro Guardado con exito!", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(B3_ResultadosEvaluacion2.this,Activity_Principal.class);
                        intent.putExtra("o","o9");
                        startActivity(intent);
                        Campo.LISTACAMPO.clear();

                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(B3_ResultadosEvaluacion2.this);
                        builder.setMessage("Informacion no encontrada")
                                .setNegativeButton("Reintentar", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
            }
        };
        Ev2Server pe= new Ev2Server(tor,riva,gole,tiemp,tota,idde,responseListener);
        RequestQueue queue = Volley.newRequestQueue(B3_ResultadosEvaluacion2.this);
        queue.add(pe);
    }


}
