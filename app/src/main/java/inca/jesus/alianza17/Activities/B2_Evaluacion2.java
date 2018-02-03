package inca.jesus.alianza17.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import inca.jesus.alianza17.Adapters.AdapterCampo;
import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_psicologico2;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_social;
import inca.jesus.alianza17.DialogAptitudes.S_dialog_social2;
import inca.jesus.alianza17.R;
public class B2_Evaluacion2 extends AppCompatActivity {
    private RecyclerView recyclerCampo;
    private GridLayoutManager grid;
    private AdapterCampo adapterCampo;
    private TextView torneo,rival,goles,t_jugado,pt1,pt2;
    private int p1,p2,p3,p4,p5,p6,p7,p8;
    private CheckBox cb1,cb2;
    int titu=0,capitan=0,gol=0,jugado=0;
    Deportista Depor;
    Button bt1,bt2;
    ImageView vaciar;
    int respsi1,respsi2,respsi3,respsi4;
    int so1,so2,so3,so4;
    LinearLayout linea_campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_campo);


        bt1=(Button)findViewById(R.id.btn_eva2_soc);
        bt2=(Button)findViewById(R.id.btn_eva2_psico);
        vaciar=(ImageView)findViewById(R.id.btn_vaciar);
        pt1=(TextView)findViewById(R.id.pto_total1);
        pt2=(TextView)findViewById(R.id.pto_total2);
        recyclerCampo=(RecyclerView)findViewById(R.id.ev2_campo);
        DataServer.CORTE2=false;
        setR();
        mostrar_p();
        botones();
        extraer_info();
        recyclercampoooo();
        if(Campo.LISTACAMPO.size()==0){listar_card();}

        adapterCampo.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                int goles2=0;
                for(int i=0;i<Campo.LISTACAMPO.size();i++){
                    if(Campo.LISTACAMPO.get(i).getDato().equalsIgnoreCase("G")){
                        goles2=goles2+1;
                    }
                }
                goles.setText(String.valueOf(goles2));

            }
        });

       SetDatos();
    }

    private void SetDatos() {
        torneo.setText(DataServer.COMPETENCIA);
        rival.setText(DataServer.RIVAL);
        goles.setText(String.valueOf(DataServer.GOLES));
        t_jugado.setText(String.valueOf(DataServer.TIEM_JUG));
        cb1.setChecked(DataServer.TITULAR);
        cb2.setChecked(DataServer.CAPITAN);
    }

    private void extraer_info() {
        torneo=(TextView)findViewById(R.id.torneo);
        rival=(TextView)findViewById(R.id.rival);
        goles=(TextView)findViewById(R.id.goles);
        t_jugado=(TextView)findViewById(R.id.t_jugado);
        cb1=(CheckBox)findViewById(R.id.titular);
        cb2=(CheckBox)findViewById(R.id.capitan);

        torneo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                      DataServer.COMPETENCIA=String.valueOf(s).toUpperCase();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rival.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DataServer.RIVAL=String.valueOf(s).toUpperCase();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        goles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DataServer.GOLES=Integer.parseInt(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t_jugado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                 if(s.length()==0){
                     DataServer.TIEM_JUG=0;
                 }else{
                     DataServer.TIEM_JUG=Integer.parseInt(String.valueOf(s));
                 }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DataServer.TITULAR=isChecked;
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DataServer.CAPITAN=isChecked;
            }
        });
    }
    private void recyclercampoooo() {
        grid = new GridLayoutManager(this,getResources().getInteger(R.integer.colum));
        adapterCampo = new AdapterCampo(this,Campo.LISTACAMPO, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recyclerCampo.setAdapter(adapterCampo);
        recyclerCampo.setLayoutManager(grid);
    }
    private void botones() {

        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pt1.setText("0");
                pt2.setText("0");
                vaciar_variables();
                DataServer.CORTE2=true;
                Snackbar.make(v,"Resultados Totales vaciados..", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(B2_Evaluacion2.this,S_dialog_social2.class);


                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B2_Evaluacion2.this,S_dialog_psicologico2.class);

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

                startActivity(intent);
            }
        });
    }
    public void vaciar_variables(){

        respsi1=0;
        respsi2=0;
        respsi3=0;
        respsi4=0;
        so1=0;
        so2=0;
        so3=0;
        so4=0;

    }
    public void setR(){

        if(getIntent().getStringExtra("s1")!=null) {
            so1 = Integer.parseInt(getIntent().getStringExtra("s1"));
            so2 = Integer.parseInt(getIntent().getStringExtra("s2"));
            so3 = Integer.parseInt(getIntent().getStringExtra("s3"));
            so4 = Integer.parseInt(getIntent().getStringExtra("s4"));

        }

        if(getIntent().getStringExtra("p1")!=null) {

            respsi1 = Integer.parseInt(getIntent().getStringExtra("p1"));
            respsi2 = Integer.parseInt(getIntent().getStringExtra("p2"));
            respsi3 = Integer.parseInt(getIntent().getStringExtra("p3"));
            respsi4 = Integer.parseInt(getIntent().getStringExtra("p4"));
        }
    }
    private void mostrar_p() {
        int sumasocial=so1+so2+so3+so4;
        int sumapsico=respsi1+respsi2+respsi3+respsi4;
        pt1.setText(String.valueOf(sumasocial).toString());
        pt2.setText(String.valueOf(sumapsico).toString());

        if(getIntent().getStringExtra("s1")!=null) {
            p1 = Integer.parseInt(getIntent().getStringExtra("s1"));
            p2 = Integer.parseInt(getIntent().getStringExtra("s2"));
            p3 = Integer.parseInt(getIntent().getStringExtra("s3"));
            p4 = Integer.parseInt(getIntent().getStringExtra("s4"));

        }

        if(getIntent().getStringExtra("p1")!=null) {

            p5 = Integer.parseInt(getIntent().getStringExtra("p1"));
            p6 = Integer.parseInt(getIntent().getStringExtra("p2"));
            p7 = Integer.parseInt(getIntent().getStringExtra("p3"));
            p8 = Integer.parseInt(getIntent().getStringExtra("p4"));
        }


    }
    private void listar_card() {
        for(int i=0;i<getResources().getInteger(R.integer.items);i++){
            Campo temp=new Campo(i,"",0);
            Campo.LISTACAMPO.add(temp);
        }
    }
    public void calcular_puntos(View view){
        String comp=torneo.getText().toString();
        String riv=rival.getText().toString();
        int r1;

        if(p1==0){
            r1=0;
        }else{
            r1=p1;
        }
        int r2;

        if(p2==0){
            r2=0;
        }else{
            r2=p2;
        }
        int r3;
        if(p3==0){
            r3=0;
        }else{
            r3=p3;
        }
        int r4;

        if(p4==0){
            r4=0;
        }else{
            r4=p4;
        }
        int r5;

        if(p5==0){
            r5=0;
        }else{
            r5=p5;
        }
        int r6;

        if(p6==0){
            r6=0;
        }else{
            r6=p6;
        }
        int r7;

        if(p7==0){
            r7=0;
        }else{
            r7=p7;
        }
        int r8;

        if(p8==0){
            r8=0;
        }else{
            r8=p8;
        }

        String temp=goles.getText().toString();
        if(temp.isEmpty()){
            gol=0;
        }else{
            gol= Integer.parseInt(temp);
        }

        String tem2=t_jugado.getText().toString();
        if(tem2.isEmpty()){
            jugado=0;
        }else{
            jugado=Integer.parseInt(tem2);
        }

        if(cb1.isChecked()){
            titu=2;
        }else{
            titu=0;
        }
        if(cb2.isChecked()){
            capitan=2;
        }else{
            capitan=0;
        }

        int total=r1+r2+r3+r4+r5+r6+r7+r8+(gol*3)+(jugado/2)+titu+capitan;

        DataServer.COMPETENCIA="";
        DataServer.RIVAL="";
        DataServer.GOLES=0;
        DataServer.TIEM_JUG=0;
        DataServer.TITULAR=false;
        DataServer.CAPITAN=false;

        Intent intent = new Intent(B2_Evaluacion2.this,B3_ResultadosEvaluacion2.class);
        intent.putExtra("torneo",comp.toUpperCase());
        intent.putExtra("rival",riv.toUpperCase());
        intent.putExtra("gol",String.valueOf(gol).toString());
        intent.putExtra("jugado",String.valueOf(jugado).toString());
        intent.putExtra("total",String.valueOf(total).toString());


        System.out.println(String.valueOf("torneo "+comp));
        System.out.println(String.valueOf("rival "+riv));
        System.out.println(String.valueOf("gol "+String.valueOf(gol).toString()));
        System.out.println(String.valueOf("jugado "+String.valueOf(jugado).toString()));
        System.out.println(String.valueOf("total"+String.valueOf(total).toString()));

        B2_Evaluacion2.this.startActivity(intent);
    }
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(B2_Evaluacion2.this);
        builder.setTitle("EVALUACION")
                .setMessage("¿Desea Cancelar evaluación?")
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Campo.LISTACAMPO.clear();

                                Intent intent= new Intent(B2_Evaluacion2.this,B1_ListaSeguimiento.class);
                                intent.putExtra("Deportista",Depor);
                                startActivity(intent);
                                finish();
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
