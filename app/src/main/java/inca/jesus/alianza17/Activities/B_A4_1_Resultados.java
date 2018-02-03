package inca.jesus.alianza17.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.PuntajeFinalServer;

public class B_A4_1_Resultados extends AppCompatActivity {

    TextView re1,re2,re3,re4;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__a4_1__resultados);
        re1=(TextView)findViewById(R.id.result_fisico);
        re2=(TextView)findViewById(R.id.result_tecnico);
        re3=(TextView)findViewById(R.id.result_diagnostico);
        re4=(TextView)findViewById(R.id.result_total);
        mostrar_Resultado();
    }

    private void mostrar_Resultado() {
        String id1=getIntent().getStringExtra("id_eventos");
        String id2=getIntent().getStringExtra("id_postulante");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando Puntajes...");
        progressDialog.show();

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {

                        String fisico = jsonResponse.getString("r1");
                        String tecnico = jsonResponse.getString("r2");
                        String diag = jsonResponse.getString("r3");
                        mostrar_puntaje(fisico,tecnico,diag);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(B_A4_1_Resultados.this);
                        builder.setMessage("Informacion no encontrada")
                                .setNegativeButton("Reintentar", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        };

        PuntajeFinalServer Server = new PuntajeFinalServer(id1,id2,responseListener);
        RequestQueue queue = Volley.newRequestQueue(B_A4_1_Resultados.this);
        queue.add(Server);

    }

    private void mostrar_puntaje(String fisico, String tecnico, String diag) {
        int fis=Integer.parseInt(fisico);
        int tec=Integer.parseInt(tecnico);
        int dia=Integer.parseInt(diag);
        int total=fis+tec+dia;
        re1.setText(String.valueOf(fis));
        re2.setText(String.valueOf(tec));
        re3.setText(String.valueOf(dia));
        re4.setText(String.valueOf(total));
    }


}
