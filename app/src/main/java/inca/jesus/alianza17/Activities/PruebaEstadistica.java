package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import inca.jesus.alianza17.Adapters.AdapterCampo;
import inca.jesus.alianza17.Adapters.AdapterCampoEstadistico;
import inca.jesus.alianza17.Adapters.AdapterDetalle;
import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.Clases.Campo_Estadistico;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Gestion_detalle;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Estadistico_Insertar;
import inca.jesus.alianza17.ServerConexion.Estadistico_Insertar2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PruebaEstadistica extends AppCompatActivity {
    private RecyclerView recyclerCampo;
    private GridLayoutManager grid;
    private AdapterCampoEstadistico adapterCampo;
    public EditText g1,g2,g3,g4;
    public Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    public TextView t1,t2,t3,t4,t5,t6,t7,t8;
    public TextView card1,card2,card3,card4,card5,card6,card7,card8;
    int c1,c2,c3,c4,c5,c6,c7,c8;
    private  Button guardar;
    private  RecyclerView recycler_detalle;
    private LinearLayoutManager linear;
    private AdapterDetalle adapter_detalle;
    List<Gestion_detalle> LISTA_DETALLE=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_estadistica);
        variables();
        System.out.println("Inca : Cod_evento:"+Campo_Estadistico.COD_EVENTO+"Cod_ Equipo:"+Campo_Estadistico.COD_EQUIPO_SE+" cod_fecha: "+Campo_Estadistico.COD_FECHA);
        recycler_data();
        recycler_detalle();
        if(Campo_Estadistico.LISTACAMPO.size()==0){
            listar_card();
        }
        Listar_Detalles();
        adapter_gestion();
        boton_guardar();
    }
    private void boton_guardar() {

    guardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            System.out.println("Inca : Cod_evento:"+ Campo_Estadistico.COD_EVENTO+
                    "Cod_ Equipo:"+Campo_Estadistico.COD_EQUIPO_SE+
                    " cod_fecha: "+Campo_Estadistico.COD_FECHA);
              for(int i=0;i<LISTA_DETALLE.size();i++){
                  Guardar_en_BD(
                          Campo_Estadistico.COD_EVENTO,
                          Campo_Estadistico.COD_FECHA,
                          LISTA_DETALLE.get(i).getId_jugador(),
                          LISTA_DETALLE.get(i).getC1(),
                          LISTA_DETALLE.get(i).getC2(),
                          LISTA_DETALLE.get(i).getC3(),
                          LISTA_DETALLE.get(i).getC4(),
                          LISTA_DETALLE.get(i).getC5(),
                          LISTA_DETALLE.get(i).getC6(),
                          LISTA_DETALLE.get(i).getC7(),
                          LISTA_DETALLE.get(i).getC8(),
                          LISTA_DETALLE.get(i).getC9(),
                          LISTA_DETALLE.get(i).getC10(),
                          LISTA_DETALLE.get(i).getC11(),
                          LISTA_DETALLE.get(i).getC12(),
                          LISTA_DETALLE.get(i).getC13(),
                          LISTA_DETALLE.get(i).getC14());
              }

            for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    Campo_Estadistico.LISTACAMPO.get(i).setDato("");
            }

            Guardar_detalle(Campo_Estadistico.COD_EVENTO,Campo_Estadistico.COD_FECHA,
                    g1.getText().toString(),
                    g2.getText().toString(),
                    g3.getText().toString(),
                    g4.getText().toString(),
                    t1.getText().toString(),
                    t2.getText().toString(),
                    t3.getText().toString(),
                    t4.getText().toString(),
                    t5.getText().toString(),
                    t6.getText().toString(),
                    t7.getText().toString(),
                    t8.getText().toString()
                    );

            Toast.makeText(PruebaEstadistica.this, "Evaluacion Guardada!", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(PruebaEstadistica.this,Activity_Principal.class);
            intent.putExtra("o","o3");
            startActivity(intent);
        }
    });
    }
    private void Guardar_detalle(int codEvento, int codFecha, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11) {

        String cod1=String.valueOf(codEvento);
        String cod2=String.valueOf(codFecha);
        String d1=String.valueOf(s);
        String d2=String.valueOf(s1);
        String d3=String.valueOf(s2);
        String d4=String.valueOf(s3);
        String d5=String.valueOf(s4);
        String d6=String.valueOf(s5);
        String d7=String.valueOf(s6);
        String d8=String.valueOf(s7);
        String d9=String.valueOf(s8);
        String d10=String.valueOf(s9);
        String d11=String.valueOf(s10);
        String d12=String.valueOf(s11);
        String d13=card1.getText().toString();
        String d14=card2.getText().toString();
        String d15=card3.getText().toString();
        String d16=card4.getText().toString();
        String d17=card5.getText().toString();
        String d18=card6.getText().toString();
        String d19=card7.getText().toString();
        String d20=card8.getText().toString();
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Eva2 Insertado");
                    } else {
                        System.out.println("Inca: eva2 no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error eva 2 JSON  "+ e);
                }
            }
        };
        Estadistico_Insertar2 Server = new Estadistico_Insertar2(cod1,cod2,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20, responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(Server);
    }
    private void Guardar_en_BD(int codEvento, int codFecha, int id_jugador, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int c10, int c11, int c12, int c13, int c14) {

        String cod1=String.valueOf(codEvento);
        String cod2=String.valueOf(codFecha);
        String cod3=String.valueOf(id_jugador);
        //usuario;
        String user="82";
        String d1=String.valueOf(c1);
        String d2=String.valueOf(c2);
        String d3=String.valueOf(c3);
        String d4=String.valueOf(c4);
        String d5=String.valueOf(c5);
        String d6=String.valueOf(c6);
        String d7=String.valueOf(c7);
        String d8=String.valueOf(c8);
        String d9=String.valueOf(c9);
        String d10=String.valueOf(c10);
        String d11=String.valueOf(c11);
        String d12=String.valueOf(c12);
        String d13=String.valueOf(c13);
        String d14=String.valueOf(c14);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Evaluacion Insertado");
                    } else {
                        System.out.println("Inca: evaluacion no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error JSON  "+ e);
                }
            }
        };
        Estadistico_Insertar Server = new Estadistico_Insertar(cod1,cod2,cod3,user,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14, responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(Server);

    }
    private void adapter_gestion() {
        adapterCampo.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==2){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==2){
                            c1=c1+1;
                            card1.setText(String.valueOf(c1));
                        }
                    }
                }
                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==2){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==1){
                            c2=c2+1;
                            card2.setText(String.valueOf(c2));
                        }
                    }
                }
                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==6){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==3){
                            c3=c3+1;
                            card3.setText(String.valueOf(c3));
                        }
                    }
                }

                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==2){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==4){
                            c4=c4+1;
                            card4.setText(String.valueOf(c4));
                        }
                    }
                }

                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==5){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==3){
                            c5=c5+1;
                            card5.setText(String.valueOf(c5));
                        }
                    }
                }
                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==5){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==4){
                            c6=c6+1;
                            card6.setText(String.valueOf(c6));
                        }
                    }
                }

                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==8){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==2){
                            c7=c7+1;
                            card7.setText(String.valueOf(c7));
                        }
                    }
                }

                for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
                    if(Campo_Estadistico.LISTACAMPO.get(i).getUbicacion()==8){
                        if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==1){
                            c8=c8+1;
                            card8.setText(String.valueOf(c8));
                        }
                    }
                }

                c1=0;
                c2=0;
                c3=0;
                c4=0;
                c5=0;
                c6=0;
                c7=0;
                c8=0;

                for(int i=0;i<LISTA_DETALLE.size();i++){
                    int con=Recu_canti1(LISTA_DETALLE.get(i).getId_jugador());
                    int con2=Recu_canti2(LISTA_DETALLE.get(i).getId_jugador());
                    int con3=Recu_canti3(LISTA_DETALLE.get(i).getId_jugador());
                    int con4=Recu_canti4(LISTA_DETALLE.get(i).getId_jugador());
                    int con5=Recu_canti5(LISTA_DETALLE.get(i).getId_jugador());
                    int con6=Recu_canti6(LISTA_DETALLE.get(i).getId_jugador());
                    int con7=Recu_canti7(LISTA_DETALLE.get(i).getId_jugador());
                    int con8=Recu_canti8(LISTA_DETALLE.get(i).getId_jugador());
                    int con9=Recu_canti9(LISTA_DETALLE.get(i).getId_jugador());
                    int con10=Recu_canti10(LISTA_DETALLE.get(i).getId_jugador());
                    int con11=Recu_canti11(LISTA_DETALLE.get(i).getId_jugador());
                    int con12=Recu_canti12(LISTA_DETALLE.get(i).getId_jugador());
                    LISTA_DETALLE.get(i).setC1(con);
                    LISTA_DETALLE.get(i).setC1(con);
                    LISTA_DETALLE.get(i).setC2(con2);
                    LISTA_DETALLE.get(i).setC3(con3);
                    LISTA_DETALLE.get(i).setC4(con4);
                    LISTA_DETALLE.get(i).setC5(con5);
                    LISTA_DETALLE.get(i).setC6(con6);
                    LISTA_DETALLE.get(i).setC7(con7);
                    LISTA_DETALLE.get(i).setC8(con8);
                    LISTA_DETALLE.get(i).setC9(con9);
                    LISTA_DETALLE.get(i).setC10(con10);
                    LISTA_DETALLE.get(i).setC11(con11);
                    LISTA_DETALLE.get(i).setC12(con12);

                    adapter_detalle.notifyDataSetChanged();
                }

                for(int j=0;j<LISTA_DETALLE.size();j++){
                    if(LISTA_DETALLE.get(j).getC13()==0){

                    }else{
                        int resu=(5+((
                                LISTA_DETALLE.get(j).getC12()+
                                        LISTA_DETALLE.get(j).getC8()+
                                        LISTA_DETALLE.get(j).getC5()+
                                        LISTA_DETALLE.get(j).getC3()+
                                        LISTA_DETALLE.get(j).getC4()+
                                        LISTA_DETALLE.get(j).getC1()+
                                        LISTA_DETALLE.get(j).getC2())/7)-
                                ((LISTA_DETALLE.get(j).getC6()+LISTA_DETALLE.get(j).getC7()+
                                        LISTA_DETALLE.get(j).getC9()+
                                        LISTA_DETALLE.get(j).getC10()+
                                        LISTA_DETALLE.get(j).getC11())/5))+LISTA_DETALLE.get(j).getC5();
                        LISTA_DETALLE.get(j).setC14(resu);
                        adapter_detalle.notifyDataSetChanged();
                    }
                }
            }
        });
    }
    private int Recu_canti1(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==1){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                   co++;
                 }
            }
        }
     return co;
    }
    private int Recu_canti2(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==2){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti3(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==3){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti4(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==4){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti5(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==5){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti6(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==6){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti7(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==7){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti8(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==8){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti9(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==9){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti10(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==10){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti11(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==11){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private int Recu_canti12(int id_jugador) {
        int co=0;
        for(int i=0;i<Campo_Estadistico.LISTACAMPO.size();i++){
            if(Campo_Estadistico.LISTACAMPO.get(i).getOpcion()==12){
                if(Campo_Estadistico.LISTACAMPO.get(i).getJugador()==id_jugador){
                    co++;
                }
            }
        }
        return co;
    }
    private void recycler_detalle() {
        linear = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
        adapter_detalle = new AdapterDetalle(this,LISTA_DETALLE, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler_detalle.setAdapter(adapter_detalle);
        recycler_detalle.setLayoutManager(linear);
    }
    private void recycler_data() {
        grid = new GridLayoutManager(this,getResources().getInteger(R.integer.colum));
        adapterCampo = new AdapterCampoEstadistico(this, Campo_Estadistico.LISTACAMPO, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recyclerCampo.setAdapter(adapterCampo);
        recyclerCampo.setLayoutManager(grid);

    }
    private void variables() {
        recyclerCampo=(RecyclerView)findViewById(R.id.campo_recycler);
        recycler_detalle=(RecyclerView)findViewById(R.id.recycler_detalle_gestion);
        g1=(EditText)findViewById(R.id.g_l1);
        g2=(EditText)findViewById(R.id.g_l2);
        g3=(EditText)findViewById(R.id.g_r1);
        g4=(EditText)findViewById(R.id.g_r2);

        guardar=(Button)findViewById(R.id.boton_guardar_evalua);

        b1=(Button)findViewById(R.id.btn_1a);
        b2=(Button)findViewById(R.id.btn_2a);
        b3=(Button)findViewById(R.id.btn_1b);
        b4=(Button)findViewById(R.id.btn_2b);
        b5=(Button)findViewById(R.id.btn_1c);
        b6=(Button)findViewById(R.id.btn_2c);
        b7=(Button)findViewById(R.id.btn_1d);
        b8=(Button)findViewById(R.id.btn_2d);
        b9=(Button)findViewById(R.id.btn_1e);
        b10=(Button)findViewById(R.id.btn_2e);
        b11=(Button)findViewById(R.id.btn_1f);
        b12=(Button)findViewById(R.id.btn_2f);
        b13=(Button)findViewById(R.id.btn_g1);
        b14=(Button)findViewById(R.id.btn_g2);
        b15=(Button)findViewById(R.id.btn_h1);
        b16=(Button)findViewById(R.id.btn_h2);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);

        card1=(TextView) findViewById(R.id.izq_1);
        card2=(TextView)findViewById(R.id.izq_2);
        card3=(TextView)findViewById(R.id.zf_1);
        card4=(TextView)findViewById(R.id.zf_2);
        card5=(TextView)findViewById(R.id.cen_1);
        card6=(TextView)findViewById(R.id.cen_2);
        card7=(TextView)findViewById(R.id.der_1);
        card8=(TextView)findViewById(R.id.der_2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t1.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t1.setText(String.valueOf(resu));
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t1.getText().toString());
                int resu=res+1;
                t1.setText(String.valueOf(resu));
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t2.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t2.setText(String.valueOf(resu));
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t2.getText().toString());
                int resu=res+1;
                t2.setText(String.valueOf(resu));
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t3.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t3.setText(String.valueOf(resu));
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t3.getText().toString());
                int resu=res+1;
                t3.setText(String.valueOf(resu));
            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t4.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t4.setText(String.valueOf(resu));
                }

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t4.getText().toString());
                int resu=res+1;
                t4.setText(String.valueOf(resu));
            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t5.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t5.setText(String.valueOf(resu));
                }

            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t5.getText().toString());
                int resu=res+1;
                t5.setText(String.valueOf(resu));
            }
        });


        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t6.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t6.setText(String.valueOf(resu));
                }

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t6.getText().toString());
                int resu=res+1;
                t6.setText(String.valueOf(resu));
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t7.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t7.setText(String.valueOf(resu));
                }

            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t7.getText().toString());
                int resu=res+1;
                t7.setText(String.valueOf(resu));
            }
        });


        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res=Integer.parseInt(t8.getText().toString());
                if(res==0){
                }else{
                    int resu=res-1;
                    t8.setText(String.valueOf(resu));
                }

            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int res=Integer.parseInt(t8.getText().toString());
                int resu=res+1;
                t8.setText(String.valueOf(resu));
            }
        });



    }
    private void listar_card() {
        for(int i=0;i<getResources().getInteger(R.integer.items);i++){
            if(i<=11){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,1,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>11&&i<=23){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,2,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>23&&i<=35){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,1,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>35&&i<=47){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,2,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }

            if(i>47&&i<=51){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>51&&i<=59){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }

            if(i>59&&i<=67){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>67&&i<=71){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>71&&i<=75){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>75&&i<=83){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>83&&i<=91){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>91&&i<=95){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>95&&i<=99){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>99&&i<=107){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>107&&i<=115){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>115&&i<=119){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>119&&i<=123){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>123&&i<=131){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>131&&i<=139){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>139&&i<=143){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>143&&i<=147){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>147&&i<=155){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>155&&i<=163){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>163&&i<=167){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>167&&i<=171){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>171&&i<=179){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>179&&i<=187){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>187&&i<=191){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>191&&i<=195){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,3,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>195&&i<=203){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,4,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>203&&i<=211){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,5,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>211&&i<=215){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,6,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>215&&i<=227){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,7,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>227&&i<=239){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,8,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>239&&i<=251){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,7,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }
            if(i>251&&i<=263){
                Campo_Estadistico temp=new Campo_Estadistico(i,"",0,0,8,0);
                Campo_Estadistico.LISTACAMPO.add(temp);
            }


        }
    }
    private void Listar_Detalles() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LIST_GES_EQUIPO+Campo_Estadistico.COD_EVENTO+"&&id2="+Campo_Estadistico.COD_EQUIPO_SE)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Gestion_detalle data=new Gestion_detalle (i,
                                object.getInt("ID"),
                                object.getString("OP_NOMBRES"),
                                object.getInt("ID_POS"),
                                object.getInt("NUM_JUGADOR"),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
                        LISTA_DETALLE.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Inca ERROR IO:"+e);
                }catch (JSONException e){
                    System.out.println("Inca JSON:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            protected void onPostExecute(Void aVoid){
                for(int i=0;i<LISTA_DETALLE.size();i++){
                    System.out.println("Inca : jugadore: N°:"+i+" "+LISTA_DETALLE.get(i).getId_jugador());
                }
            }
        };
        task.execute();
    }
}
