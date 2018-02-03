package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.VDiagServer;
import inca.jesus.alianza17.ServerConexion.VFisicaServer;
import inca.jesus.alianza17.ServerConexion.VTecnicaServer;
import inca.jesus.alianza17.ServerConexion.ValidarPuntajeServer;

public class C2_ListaOpciones extends AppCompatActivity {

    String id1,id2;
    ImageView volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2__lista_opciones);
        volver=(ImageView)findViewById(R.id.toolbar_boton_volver30);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(C2_ListaOpciones.this,C1_ListaPostulantes.class);
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    public void prueba_fisica(View view){

        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {

                        Intent intent = new Intent(C2_ListaOpciones.this,B_A4_1_PruebaFisica.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        C2_ListaOpciones.this.startActivity(intent);


                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(C2_ListaOpciones.this);
                        builder.setMessage("Ya Realizo Evaluacion Fisica")
                                .setNegativeButton("Salir", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        VFisicaServer pe= new VFisicaServer(id1,id2,responseListener);
        RequestQueue queue = Volley.newRequestQueue(C2_ListaOpciones.this);
        queue.add(pe);
    }
    public void prueba_tecnica(View view){
        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Intent intent = new Intent(C2_ListaOpciones.this,B_A4_1_PruebaTecnico.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        C2_ListaOpciones.this.startActivity(intent);

                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(C2_ListaOpciones.this);
                        builder.setMessage("Ya Realizo Evaluacion Tecnica")
                                .setNegativeButton("Salir", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        VTecnicaServer pe= new VTecnicaServer(id1,id2,responseListener);
        RequestQueue queue = Volley.newRequestQueue(C2_ListaOpciones.this);
        queue.add(pe);

    }
    public void prueba_diagnostico(View view){

        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {

                        Intent intent = new Intent(C2_ListaOpciones.this,B_A4_Diagnostico.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        C2_ListaOpciones.this.startActivity(intent);

                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(C2_ListaOpciones.this);
                        builder.setMessage("Ya Realizo Diagnostico")
                                .setNegativeButton("Salir", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        VDiagServer pe= new VDiagServer(id1,id2,responseListener);
        RequestQueue queue = Volley.newRequestQueue(C2_ListaOpciones.this);
        queue.add(pe);

    }
    public void resultados(View view){

        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {

                        Intent intent = new Intent(C2_ListaOpciones.this,B_A4_1_Resultados.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        C2_ListaOpciones.this.startActivity(intent);

                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(C2_ListaOpciones.this);
                        builder.setMessage("No realizo Evaluaciones...")
                                .setNegativeButton("Salir", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        ValidarPuntajeServer pe= new ValidarPuntajeServer(id1,id2,responseListener);
        RequestQueue queue = Volley.newRequestQueue(C2_ListaOpciones.this);
        queue.add(pe);
    }
    public void onBackPressed() {
        Intent intent = new Intent(C2_ListaOpciones.this,C1_ListaPostulantes.class);
        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
        C2_ListaOpciones.this.startActivity(intent);
    }
}
