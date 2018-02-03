package inca.jesus.alianza17.Fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.Activity_Login;
import inca.jesus.alianza17.Activities.Activity_Principal;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.Clases.Postulante;
import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.LoginServer;
import inca.jesus.alianza17.ServerConexion.Resu1Server;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentReporteCaptacion extends Fragment {

    Spinner sp_postulante;
    String[] TEMP;
    ArrayList<Deportista> LIST_POSTULANTE;
    ProgressDialog progressDialog;
    Context mContext;
    TextView  r1,r2,r3,r4,r5,r6;
    int codigo_postulante=0;
    LinearLayout f1,f2,C1,C2,S1,S2,T1,T2,P1,P2;
    boolean ff1=false;
    boolean cc1=false;
    boolean ss1=false;
    boolean tt1=false;
    boolean pp1=false;
    TextView m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24,m25;

    ImageView im_fisico,im_capa,im_so,im_tec,im_psi;

    public FragmentReporteCaptacion() {}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LIST_POSTULANTE=new ArrayList<>();
        listar_Depor();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_reporte_captacion, container, false);
        sp_postulante=(Spinner)v.findViewById(R.id.sp_postulantes);
        f1=(LinearLayout)v.findViewById(R.id.op_fisico);
        f2=(LinearLayout)v.findViewById(R.id.op_fisico2);
        C1=(LinearLayout)v.findViewById(R.id.op_capa);
        C2=(LinearLayout)v.findViewById(R.id.op_capa2);
        S1=(LinearLayout)v.findViewById(R.id.op_so);
        S2=(LinearLayout)v.findViewById(R.id.op_so2);
        T1=(LinearLayout)v.findViewById(R.id.op_tec);
        T2=(LinearLayout)v.findViewById(R.id.op_tec2);
        P1=(LinearLayout)v.findViewById(R.id.op_psi);
        P2=(LinearLayout)v.findViewById(R.id.op_psi2);

        im_fisico=(ImageView)v.findViewById(R.id.im_fisico);
        im_capa=(ImageView)v.findViewById(R.id.im_capa);
        im_so=(ImageView)v.findViewById(R.id.im_so);
        im_tec=(ImageView)v.findViewById(R.id.im_tec);
        im_psi=(ImageView)v.findViewById(R.id.im_psi);

        m1=(TextView)v.findViewById(R.id.res1);
        m2=(TextView)v.findViewById(R.id.res2);
        m3=(TextView)v.findViewById(R.id.res3);
        m4=(TextView)v.findViewById(R.id.res4);
        m5=(TextView)v.findViewById(R.id.res5);
        m6=(TextView)v.findViewById(R.id.res6);
        m7=(TextView)v.findViewById(R.id.res7);
        m8=(TextView)v.findViewById(R.id.res8);
        m9=(TextView)v.findViewById(R.id.res9);
        m10=(TextView)v.findViewById(R.id.res10);
        m11=(TextView)v.findViewById(R.id.res11);
        m12=(TextView)v.findViewById(R.id.res12);
        m13=(TextView)v.findViewById(R.id.res13);
        m14=(TextView)v.findViewById(R.id.res14);
        m15=(TextView)v.findViewById(R.id.res15);
        m16=(TextView)v.findViewById(R.id.res16);
        m17=(TextView)v.findViewById(R.id.res17);
        m18=(TextView)v.findViewById(R.id.res18);
        m19=(TextView)v.findViewById(R.id.res19);
        m20=(TextView)v.findViewById(R.id.res20);
        m21=(TextView)v.findViewById(R.id.res21);
        m22=(TextView)v.findViewById(R.id.res22);
        m23=(TextView)v.findViewById(R.id.res23);
        m24=(TextView)v.findViewById(R.id.res24);
        m25=(TextView)v.findViewById(R.id.res25);

        r1=(TextView)v.findViewById(R.id.ted1);
        r2=(TextView)v.findViewById(R.id.ted2);
        r3=(TextView)v.findViewById(R.id.ted3);
        r4=(TextView)v.findViewById(R.id.ted4);
        r5=(TextView)v.findViewById(R.id.ted5);
        r6=(TextView)v.findViewById(R.id.ted6);

        f2.setVisibility(View.GONE);
        C2.setVisibility(View.GONE);
        S2.setVisibility(View.GONE);
        T2.setVisibility(View.GONE);
        P2.setVisibility(View.GONE);


       desliz();
        sp_postulante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codigo_postulante=LIST_POSTULANTE.get(position).getId();
                resultado1(codigo_postulante);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return v;
    }

    private void desliz() {
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca : click modulo!");
                if(ff1==false){
                    System.out.println("Inca : click se abre!");
                    ff1=true;
                    f2.setVisibility(View.VISIBLE);
                    im_fisico.setImageResource(R.mipmap.ic_op_arriba);
                }else
                if(ff1==true){
                    System.out.println("Inca : click se cierra!");
                    ff1=false;
                    f2.setVisibility(View.GONE);
                    im_fisico.setImageResource(R.mipmap.ic_op_abajo);
                }

            }
        });
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca : click modulo!");
                if(cc1==false){
                    System.out.println("Inca : click se abre!");
                    cc1=true;
                    C2.setVisibility(View.VISIBLE);
                    im_capa.setImageResource(R.mipmap.ic_op_arriba);
                }else
                if(cc1==true){
                    System.out.println("Inca : click se cierra!");
                    cc1=false;
                    C2.setVisibility(View.GONE);
                    im_capa.setImageResource(R.mipmap.ic_op_abajo);
                }

            }
        });

        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca : click modulo!");
                if(ss1==false){
                    System.out.println("Inca : click se abre!");
                    ss1=true;
                    S2.setVisibility(View.VISIBLE);
                    im_so.setImageResource(R.mipmap.ic_op_arriba);
                }else
                if(ss1==true){
                    System.out.println("Inca : click se cierra!");
                    ss1=false;
                    S2.setVisibility(View.GONE);
                    im_so.setImageResource(R.mipmap.ic_op_abajo);
                }

            }
        });


        T1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca : click modulo!");
                if(tt1==false){
                    System.out.println("Inca : click se abre!");
                    tt1=true;
                    T2.setVisibility(View.VISIBLE);
                    im_tec.setImageResource(R.mipmap.ic_op_arriba);
                }else
                if(tt1==true){
                    System.out.println("Inca : click se cierra!");
                    tt1=false;
                    T2.setVisibility(View.GONE);
                    im_tec.setImageResource(R.mipmap.ic_op_abajo);
                }

            }
        });

        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca : click modulo!");
                if(pp1==false){
                    System.out.println("Inca : click se abre!");
                    pp1=true;
                    P2.setVisibility(View.VISIBLE);
                    im_psi.setImageResource(R.mipmap.ic_op_arriba);
                }else
                if(pp1==true){
                    System.out.println("Inca : click se cierra!");
                    pp1=false;
                    P2.setVisibility(View.GONE);
                    im_psi.setImageResource(R.mipmap.ic_op_abajo);
                }

            }
        });

    }

    private void resultado1(final int cod2) {

        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Resultados:");
        progressDialog.setMessage("Recuperando Resultados.....");
        progressDialog.show();
        String cod=String.valueOf(cod2);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {
                        int g1 = jsonResponse.getInt("res1");
                        int g2 = jsonResponse.getInt("res2");
                        int g3 = jsonResponse.getInt("res3");
                        int g4 = jsonResponse.getInt("res4");
                        int g5 = jsonResponse.getInt("res5");

                        int total=g1+g2+g3+g4+g5;
                        r1.setText(String.valueOf(g1));
                        r2.setText(String.valueOf(g2));
                        r3.setText(String.valueOf(g3));
                        r4.setText(String.valueOf(g4));
                        r5.setText(String.valueOf(g5));
                        r6.setText(String.valueOf(total));

                        m1.setText(String.valueOf(jsonResponse.getInt("p1")));
                        m2.setText(String.valueOf(jsonResponse.getInt("p2")));
                        m3.setText(String.valueOf(jsonResponse.getInt("p3")));
                        m4.setText(String.valueOf(jsonResponse.getInt("p4")));
                        m5.setText(String.valueOf(jsonResponse.getInt("p5")));
                        m6.setText(String.valueOf(jsonResponse.getInt("p6")));
                        m7.setText(String.valueOf(jsonResponse.getInt("p7")));
                        m8.setText(String.valueOf(jsonResponse.getInt("p8")));
                        m9.setText(String.valueOf(jsonResponse.getInt("p9")));
                        m10.setText(String.valueOf(jsonResponse.getInt("p10")));
                        m11.setText(String.valueOf(jsonResponse.getInt("p11")));
                        m12.setText(String.valueOf(jsonResponse.getInt("p12")));
                        m13.setText(String.valueOf(jsonResponse.getInt("p13")));
                        m14.setText(String.valueOf(jsonResponse.getInt("p14")));
                        m15.setText(String.valueOf(jsonResponse.getInt("p15")));
                        m16.setText(String.valueOf(jsonResponse.getInt("p16")));
                        m17.setText(String.valueOf(jsonResponse.getInt("p17")));
                        m18.setText(String.valueOf(jsonResponse.getInt("p18")));
                        m19.setText(String.valueOf(jsonResponse.getInt("p19")));
                        m20.setText(String.valueOf(jsonResponse.getInt("p20")));
                        m21.setText(String.valueOf(jsonResponse.getInt("p21")));
                        m22.setText(String.valueOf(jsonResponse.getInt("p22")));
                        m23.setText(String.valueOf(jsonResponse.getInt("p23")));
                        m24.setText(String.valueOf(jsonResponse.getInt("p24")));
                        m25.setText(String.valueOf(jsonResponse.getInt("p25")));





                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Problemas de Conexión")
                                .setNegativeButton("Reintentar", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca  : Error JSON :"+e);
                }
            }
        };
        Resu1Server loginServer = new Resu1Server(cod, responseListener);
        RequestQueue queue = Volley.newRequestQueue(mContext);
        queue.add(loginServer);
    }
    private void listar_Depor() {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_DEPORTISTAS)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);

                        Deportista data=new Deportista ( object.getInt("ID_DEPO"),
                                object.getString("NOMBRES_D"),
                                object.getString("APELLIDOS_D"),
                                object.getString("F_NACIMIENTO"),
                                object.getString("NACIONALIDAD"),
                                object.getString("LUG_RESIDENCIA"),
                                object.getString("E_MAIL"),
                                object.getString("CLUB_PROCEDENCIA"),
                                object.getString("DATOS_APODERADO"),
                                object.getString("LIGA_JUEGO"),
                                object.getString("CATEGORIA_JUEGO"),
                                object.getString("ESTADO"),
                                object.getInt("TELEFONO"),
                                object.getInt("PUNTAJE"),
                                object.getString("NOMBRE"),
                                object.getInt("SS"));
                        LIST_POSTULANTE.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException ex){
                    System.out.println(ex);
                }
                return null;
            }
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Postulantes");
                progressDialog.setMessage("Listando Postulantes....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){

                TEMP=new String[LIST_POSTULANTE.size()];
                for(int i=0;i<LIST_POSTULANTE.size();i++){
                    TEMP[i]=LIST_POSTULANTE.get(i).getNom()+" "+LIST_POSTULANTE.get(i).getApe();
                }
                ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,TEMP);
                sp_postulante.setAdapter(adapter_arr);

                progressDialog.dismiss();

            }
        };
        task.execute();
    }
}
