package inca.jesus.alianza17.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import inca.jesus.alianza17.DialogAptitudes.S_dialog_capacidad;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_fisico;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_psicologico;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_social;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_tecnico;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;
public class A1_Evaluacion extends AppCompatActivity {
    int res1,res2,res3,res4,res5,res6,res7;
    int resc1,resc2,resc3,resc4;
    int respsi1,respsi2,respsi3,respsi4;
    int so1,so2,so3,so4;
    int tec1,tec2,tec3,tec4,tec5,tec6;
    TextView p1,p2,p3,p4,p5,ptotal;
    Button btn_evaluar;
    CardView card_continuar;
    ImageView volver,vaciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_evaluacion);
        btn_evaluar=(Button)findViewById(R.id.EvaluarID);
        card_continuar=(CardView)findViewById(R.id.card_continuar);
        card_continuar.setVisibility(View.GONE);
        volver=(ImageView)findViewById(R.id.toolbar_boton_volver);
        vaciar=(ImageView)findViewById(R.id.toolbar_boton_vaciar);
        DataServer.CORTE=false;

        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vaciar_variables();
                p1.setText("0");
                p2.setText("0");
                p3.setText("0");
                p4.setText("0");
                p5.setText("0");
                ptotal.setText("0");

                DataServer.CORTE=true;
                Snackbar.make(v,"Resultados Totales vaciados..", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(A1_Evaluacion.this, Activity_Principal.class);
                intent.putExtra("o","o1");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        hab_fisica();
        hab_capacidad();
        hab_social();
        hab_tecnico();
        hab_psicologico();
        setR();
        mostrar_p();
    }
    public void vaciar_variables(){
        res1=0;
        res2=0;
        res3=0;
        res4=0;
        res5=0;
        res6=0;
        res7=0;
        resc1=0;
        resc2=0;
        resc3=0;
        resc4=0;
        respsi1=0;
        respsi2=0;
        respsi3=0;
        respsi4=0;
        so1=0;
        so2=0;
        so3=0;
        so4=0;
        tec1=0;
        tec2=0;
        tec3=0;
        tec4=0;
        tec5=0;
        tec6=0;
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

        int da=Integer.parseInt(ptotal.getText().toString());
        if(da>=50){
          card_continuar.setVisibility(View.VISIBLE);
        }else{
            card_continuar.setVisibility(View.GONE);
        }
    }
    private void hab_fisica() {

        Button btnFisico = (Button) findViewById(R.id.btn_fisico2);
        btnFisico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A1_Evaluacion.this,S_dialog_fisico.class);
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

                startActivity(intent);
            }
        });

    }
    private void hab_capacidad() {


        Button btnCapa = (Button) findViewById(R.id.btn_capacidad2);
        btnCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Paso boton..");

                Intent intent = new Intent(A1_Evaluacion.this,S_dialog_capacidad.class);
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

                startActivity(intent);
            }
        });

    }
    private void hab_social() {
        Button btnSocial = (Button) findViewById(R.id.btn_social2);
        btnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(A1_Evaluacion.this,S_dialog_social.class);
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

                startActivity(intent);
            }
        });
    }
    private void hab_tecnico() {
        Button btnTecnico = (Button) findViewById(R.id.btn_tecnico2);
        btnTecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(A1_Evaluacion.this,S_dialog_tecnico.class);
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

               // intent.putExtra("nombre",getIntent().getStringExtra("nombre").toString());

                startActivity(intent);
            }
        });
    }
    private void hab_psicologico() {
        Button btnPsico = (Button) findViewById(R.id.btn_psicologico2);
        btnPsico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(A1_Evaluacion.this,S_dialog_psicologico.class);
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


               // intent.putExtra("nombre",getIntent().getStringExtra("nombre").toString());

                startActivity(intent);
            }
        });
    }
    public void evaluar_jugador(View view){

       if(Integer.parseInt(ptotal.getText().toString())>=50){

           Intent intent= new Intent(A1_Evaluacion.this,A2_RegistroDeportista.class);
           System.out.println("Inca : ir a Registro" );

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
          // intent.putExtra("nombre",getIntent().getStringExtra("nombre").toString());
           startActivity(intent);
       }else{
           Toast.makeText(this, "Evaluacion debe ser mayor de 50 puntos!...", Toast.LENGTH_SHORT).show();
       }
    }
    public void onBackPressed() {
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(A1_Evaluacion.this);
        builder.setTitle("SESIÓN")
                .setMessage("¿Desea salir de Evaluacion?")
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(A1_Evaluacion.this, Activity_Principal.class);
                                intent.putExtra("o","o1");
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        builder.show();
    }
}



