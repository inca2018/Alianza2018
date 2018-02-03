package inca.jesus.alianza17.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.Dialog.B_dialog_capacidad;
import inca.jesus.alianza17.Dialog.B_dialog_fisico;
import inca.jesus.alianza17.Dialog.B_dialog_psicologico;
import inca.jesus.alianza17.Dialog.B_dialog_social;
import inca.jesus.alianza17.Dialog.B_dialog_tecnico;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.DiagnosticoServer;

public class B_A4_Diagnostico extends AppCompatActivity {


    int res1,res2,res3,res4,res5,res6,res7;
    int resc1,resc2,resc3,resc4;
    int respsi1,respsi2,respsi3,respsi4;
    int so1,so2,so3,so4;
    int tec1,tec2,tec3,tec4,tec5,tec6;
    TextView p1,p2,p3,p4,p5,ptotal;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__a4__diagnostico);

        hab_fisica();
        hab_capacidad();
        hab_social();
        hab_tecnico();
        hab_psicologico();
        setR();
        mostrar_p();
    }

    public void setR(){

        if(getIntent().getStringExtra("r1")!=null) {

            res1 = Integer.parseInt(getIntent().getStringExtra("r1"));
            res2 = Integer.parseInt(getIntent().getStringExtra("r2"));
            res3 = Integer.parseInt(getIntent().getStringExtra("r3"));
            res4 = Integer.parseInt(getIntent().getStringExtra("r4"));
            res5 = Integer.parseInt(getIntent().getStringExtra("r5"));
            res6 = Integer.parseInt(getIntent().getStringExtra("r6"));
            res7 = Integer.parseInt(getIntent().getStringExtra("r7"));

        }
        if(getIntent().getStringExtra("c1")!=null) {

            resc1 = Integer.parseInt(getIntent().getStringExtra("c1"));
            resc2 = Integer.parseInt(getIntent().getStringExtra("c2"));
            resc3 = Integer.parseInt(getIntent().getStringExtra("c3"));
            resc4 = Integer.parseInt(getIntent().getStringExtra("c4"));

        }
        if(getIntent().getStringExtra("s1")!=null) {
            so1 = Integer.parseInt(getIntent().getStringExtra("s1"));
            so2 = Integer.parseInt(getIntent().getStringExtra("s2"));
            so3 = Integer.parseInt(getIntent().getStringExtra("s3"));
            so4 = Integer.parseInt(getIntent().getStringExtra("s4"));

        }
        if(getIntent().getStringExtra("t1")!=null) {
            tec1 = Integer.parseInt(getIntent().getStringExtra("t1"));
            tec2= Integer.parseInt(getIntent().getStringExtra("t2"));
            tec3 = Integer.parseInt(getIntent().getStringExtra("t3"));
            tec4 = Integer.parseInt(getIntent().getStringExtra("t4"));
            tec5 = Integer.parseInt(getIntent().getStringExtra("t5"));
            tec6 = Integer.parseInt(getIntent().getStringExtra("t6"));
        }

        if(getIntent().getStringExtra("p1")!=null) {

            respsi1 = Integer.parseInt(getIntent().getStringExtra("p1"));
            respsi2 = Integer.parseInt(getIntent().getStringExtra("p2"));
            respsi3 = Integer.parseInt(getIntent().getStringExtra("p3"));
            respsi4 = Integer.parseInt(getIntent().getStringExtra("p4"));
        }
    }
    private void mostrar_p() {
        int sumafisico=res1+res2+res3+res4+res5+res6+res7;
        int sumacapacidad=resc1+resc2+resc3+resc4;
        int sumasocial=so1+so2+so3+so4;
        int sumatecnico=tec1+tec2+tec3+tec4+tec5+tec6;
        int sumapsico=respsi1+respsi2+respsi3+respsi4;
        int total=sumafisico+sumacapacidad+sumasocial+sumatecnico+sumapsico;
        p1=(TextView)findViewById(R.id.pto_fisico);
        p2=(TextView)findViewById(R.id.pto_capacidad);
        p3=(TextView)findViewById(R.id.pto_social);
        p4=(TextView)findViewById(R.id.pto_tecnico);
        p5=(TextView)findViewById(R.id.pto_psicolo);
        ptotal=(TextView)findViewById(R.id.total_ptos);
        p1.setText(String.valueOf(sumafisico).toString());
        p2.setText(String.valueOf(sumacapacidad).toString());
        p3.setText(String.valueOf(sumasocial).toString());
        p4.setText(String.valueOf(sumatecnico).toString());
        p5.setText(String.valueOf(sumapsico).toString());
        ptotal.setText(String.valueOf(total).toString());

    }
    private void hab_fisica() {

        Button btnFisico = (Button) findViewById(R.id.btn_fisico2);

        btnFisico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(B_A4_Diagnostico.this,B_dialog_fisico.class);
                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));

                startActivity(intent);

            }
        });

    }
    private void hab_capacidad() {


        Button btnCapa = (Button) findViewById(R.id.btn_capacidad2);
        btnCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B_A4_Diagnostico.this,B_dialog_capacidad.class);
                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                startActivity(intent);
            }
        });

    }
    private void hab_social() {
        Button btnSocial = (Button) findViewById(R.id.btn_social2);
        btnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B_A4_Diagnostico.this,B_dialog_social.class);
                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));

                startActivity(intent);
            }
        });
    }
    private void hab_tecnico() {
        Button btnTecnico = (Button) findViewById(R.id.btn_tecnico2);
        btnTecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B_A4_Diagnostico.this,B_dialog_tecnico.class);
                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));

                startActivity(intent);
            }
        });
    }
    private void hab_psicologico() {
        Button btnPsico = (Button) findViewById(R.id.btn_psicologico2);
        btnPsico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B_A4_Diagnostico.this,B_dialog_psicologico.class);
                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));

                startActivity(intent);
            }
        });
    }
    public void guardar_diagnostico(View view){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Diagnosticando Postulante...");
        progressDialog.setMessage("Cargando.....");
        progressDialog.show();

        String id1=getIntent().getStringExtra("id_eventos");
        String id2=getIntent().getStringExtra("id_postulante");

        String resR1=getIntent().getStringExtra("r1");
        String resR2=getIntent().getStringExtra("r2");
        String resR3=getIntent().getStringExtra("r3");
        String resR4=getIntent().getStringExtra("r4");
        String resR5=getIntent().getStringExtra("r5");
        String resR6=getIntent().getStringExtra("r6");
        String resR7=getIntent().getStringExtra("r7");

        String resC1=getIntent().getStringExtra("c1");
        String resC2=getIntent().getStringExtra("c2");
        String resC3=getIntent().getStringExtra("c3");
        String resC4=getIntent().getStringExtra("c4");

        String resS1=getIntent().getStringExtra("s1");
        String resS2=getIntent().getStringExtra("s2");
        String resS3=getIntent().getStringExtra("s3");
        String resS4=getIntent().getStringExtra("s4");

        String resT1=getIntent().getStringExtra("t1");
        String resT2=getIntent().getStringExtra("t2");
        String resT3=getIntent().getStringExtra("t3");
        String resT4=getIntent().getStringExtra("t4");
        String resT5=getIntent().getStringExtra("t5");
        String resT6=getIntent().getStringExtra("t6");

        String resP1=getIntent().getStringExtra("p1");
        String resP2=getIntent().getStringExtra("p2");
        String resP3=getIntent().getStringExtra("p3");
        String resP4=getIntent().getStringExtra("p4");
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {
                        Toast.makeText(B_A4_Diagnostico.this, "Registro Guardado con exito!", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(B_A4_Diagnostico.this,C2_ListaOpciones.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        startActivity(intent);
                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(B_A4_Diagnostico.this);
                        builder.setMessage("Informacion no encontrada")
                                .setNegativeButton("Reintentar", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        DiagnosticoServer pe= new DiagnosticoServer(id1,id2,resR1,resR2,resR3,resR4,resR5,resR6,resR7,resC1,resC2,resC3,
                resC4,resS1,resS2,resS3,resS4,resT1,resT2,resT3,resT4,resT5,resT6,resP1,resP2,resP3,resP4,responseListener);
        RequestQueue queue = Volley.newRequestQueue(B_A4_Diagnostico.this);
        queue.add(pe);
    }
}
