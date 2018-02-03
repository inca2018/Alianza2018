package inca.jesus.alianza17.Fragments;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import inca.jesus.alianza17.Activities.NombreMiEquipo;
import inca.jesus.alianza17.Activities.PruebaEstadistica;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Adapters.AdapterDetalle2;
import inca.jesus.alianza17.Adapters.AdapterEventos_Camp;
import inca.jesus.alianza17.Adapters.AdapterEventos_Camp2;
import inca.jesus.alianza17.Adapters.AdapterFechas;
import inca.jesus.alianza17.Adapters.AdapterFechas2;
import inca.jesus.alianza17.Adapters.AdapterMiEquipo;
import inca.jesus.alianza17.Clases.Campo_Estadistico;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Detalle;
import inca.jesus.alianza17.Clases.Eventos_Camp;
import inca.jesus.alianza17.Clases.Fechas;
import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.Clases.MisEquipos2;
import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.LoginServer;
import inca.jesus.alianza17.ServerConexion.ResultadosServer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class FragmentEstadistico extends Fragment {
    LinearLayout linear2,linear3,linear4;
    LinearLayoutManager linear;
    RecyclerView recyclerEventos,recyclerFechas,recy;
    List<Eventos_Camp> LISTA_EVENTOS;
    List<Fechas> LISTA_FECHAS;
    List<MisEquipos2> LISTA_MISEQUIO;
    List<Detalle>LISTA_DETALLES;
    AdapterFechas2 adapter3;
    AdapterEventos_Camp2 adapter;
    AdapterDetalle2 adapterDetalle;
    int cod;
    Context mContext;
    ProgressDialog progressDialog;
    String nom_equi;

    TextView r1,r2,r3,r4,r5,r6,r7,r8,r9;
    TextView score;
    TextView nom_eve,nom_eq,nom_rival;

    TextView v1,v2,v3,v4,vv1,vv2,vv3,vv4,mm1,mm2,mm3,mm4;
    public FragmentEstadistico() {
        // Required empty public constructor
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LISTA_EVENTOS=new ArrayList<>();
        LISTA_FECHAS=new ArrayList<>();
        LISTA_MISEQUIO=new ArrayList<>();
        LISTA_DETALLES=new ArrayList<>();
        listar_eventos();
        listar_misEquipos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_estadistico, container, false);
        linear2=(LinearLayout)view.findViewById(R.id.linear_mis_equipos);
        linear3=(LinearLayout)view.findViewById(R.id.linear_mis_fechas);
        linear4=(LinearLayout)view.findViewById(R.id.panel_detalle_fecha);
        linear2.setVisibility(View.VISIBLE);
        linear3.setVisibility(View.GONE);
        linear4.setVisibility(View.GONE);
        recyclerEventos=(RecyclerView)view.findViewById(R.id.recycler_mis_equipos);
        recyclerFechas=(RecyclerView)view.findViewById(R.id.recycler_mis_fechas);
        recy=(RecyclerView)view.findViewById(R.id.recycler_detalle_2);

        r1=(TextView)view.findViewById(R.id.resu1);
        r2=(TextView)view.findViewById(R.id.resu2);
        r3=(TextView)view.findViewById(R.id.resu3);
        r4=(TextView)view.findViewById(R.id.resu4);
        r5=(TextView)view.findViewById(R.id.resu5);
        r6=(TextView)view.findViewById(R.id.resu6);
        r7=(TextView)view.findViewById(R.id.resu7);
        r8=(TextView)view.findViewById(R.id.resu8);
        r9=(TextView)view.findViewById(R.id.resu9);

        v1=(TextView)view.findViewById(R.id.v1);
        v2=(TextView)view.findViewById(R.id.v2);
        v3=(TextView)view.findViewById(R.id.v3);
        v4=(TextView)view.findViewById(R.id.v4);

        vv1=(TextView)view.findViewById(R.id.vv1);
        vv2=(TextView)view.findViewById(R.id.vv2);
        vv3=(TextView)view.findViewById(R.id.vv3);
        vv4=(TextView)view.findViewById(R.id.vv4);

        mm1=(TextView)view.findViewById(R.id.mm1);
        mm2=(TextView)view.findViewById(R.id.mm2);
        mm3=(TextView)view.findViewById(R.id.mm3);
        mm4=(TextView)view.findViewById(R.id.mm4);
        score=(TextView)view.findViewById(R.id.score);

        nom_eve=(TextView)view.findViewById(R.id.nombre_evento);
        nom_eq=(TextView)view.findViewById(R.id.nombre_equipo);
        nom_rival=(TextView)view.findViewById(R.id.nombre_Rival);

        Recycler_eventos();
        opciones();
        return view;
    }
    private void opciones() {
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter.getItemCount()==0){
                    //vacio
                }else{
                    if(adapter.isSelect()==true){
                        cod=adapter.RecuSelect();
                        Campo_Estadistico.COD_EVENTO=cod;
                        System.out.println("Inca: cod evento:"+cod);
                        linear3.setVisibility(View.VISIBLE);
                        linear2.setVisibility(View.GONE);
                        linear4.setVisibility(View.GONE);
                        Modulo_Fechas();
                        adapter.setSelect(false);
                    }
                }
            }
        });
    }
    private void Recycler_eventos() {

        linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapter= new AdapterEventos_Camp2(getActivity(),LISTA_EVENTOS, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerEventos.setAdapter(adapter);
        recyclerEventos.setLayoutManager(linear);
    }
    private void Modulo_Fechas() {
        linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapter3= new AdapterFechas2(getActivity(),LISTA_FECHAS, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerFechas.setAdapter(adapter3);
        recyclerFechas.setLayoutManager(linear);
        listar_fechas_evento(cod);

        adapter3.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                if(adapter3.isSelect()==true){
                    Campo_Estadistico.COD_FECHA=adapter3.Recu();
                    System.out.println("Inca: co_fecha: "+Campo_Estadistico.COD_FECHA);
                    BuscaR_nom_equipo();
                    System.out.println("Inca : LISTA MI EQUIPO SIZE: "+LISTA_MISEQUIO.size());
                    Buscar_Cod_evento();
                    System.out.println("Inca : cod: "+Campo_Estadistico.COD_EQUIPO_SE+" cod_fech: "+Campo_Estadistico.COD_FECHA);
                    Intent intent = new Intent(getActivity(),PruebaEstadistica.class);
                    startActivity(intent);

                    adapter3.setSelect(false);
                }
                if(adapter3.isSelect2()==true){
                    Campo_Estadistico.COD_FECHA=adapter3.Recu();
                    BuscaR_nom_equipo();
                    Buscar_Cod_evento();
                    System.out.println("Inca :cod_evento:"+cod+" cod equipo: "+Campo_Estadistico.COD_EQUIPO_SE+" cod_fech: "+Campo_Estadistico.COD_FECHA);
                    linear3.setVisibility(View.GONE);
                    linear2.setVisibility(View.GONE);
                    linear4.setVisibility(View.VISIBLE);

                    Extraccion_de_Datos_fecha(cod,Fechas.COD_FECHA);

                    linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
                    adapterDetalle= new AdapterDetalle2(getActivity(),LISTA_DETALLES, new RecyclerViewOnItemClickListener2() {
                        @Override
                        public void onClick(View v, int position) {

                        }
                    });
                    recy.setAdapter(adapterDetalle);
                    recy.setLayoutManager(linear);

                    Listar_Detalle(cod,Fechas.COD_FECHA);
                    adapter3.setSelect2(false);
                }
            }
        });

        }
    private void Listar_Detalle(final int cod1,final int cod2) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.DETALLE_2+cod1+"&&cod2="+cod2)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Detalle data=new Detalle (
                                object.getString("OP_NOMBRES"),
                                object.getInt("PUNTOS")
                        );
                        LISTA_DETALLES.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("Inca ERROR:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }
            protected void onPostExecute(Void aVoid){
                adapterDetalle.notifyDataSetChanged();

            }
        };
        task.execute();

    }
    private void Extraccion_de_Datos_fecha(final int codEvento, final int codFecha) {

        String cod1 = String.valueOf(codEvento);
        String cod2 =String.valueOf(codFecha);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Resusltados");
        progressDialog.setMessage("Verificando Resultados.....");
        progressDialog.show();

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    progressDialog.dismiss();
                    if (success) {
                        int res2,res;

                        String e1=jsonResponse.getString("nom_evento");
                        String e2=jsonResponse.getString("nom_equipo");
                        String e3=jsonResponse.getString("nom_opo");
                        int e4=jsonResponse.getInt("goles_local");
                        int e5=jsonResponse.getInt("goles_rival");
                        int e6=jsonResponse.getInt("pose1");
                        int e7=jsonResponse.getInt("pose2");
                        int e8=jsonResponse.getInt("suma_op_gol");
                        int e9=jsonResponse.getInt("suma_rem");
                        int e10=jsonResponse.getInt("total_of");
                        int e11=jsonResponse.getInt("total_f");
                        int e12=jsonResponse.getInt("total_amarilla");
                        int e13=jsonResponse.getInt("total_roja");

                        int f1=jsonResponse.getInt("r1");
                        int k2=jsonResponse.getInt("r2");
                        int f3=jsonResponse.getInt("r3");
                        int f4=jsonResponse.getInt("r4");
                        int f5=jsonResponse.getInt("r5");
                        int f6=jsonResponse.getInt("r6");
                        int f7=jsonResponse.getInt("r7");
                        int f8=jsonResponse.getInt("r8");

                        int m1=jsonResponse.getInt("m1");
                        int m2=jsonResponse.getInt("m2");
                        int m3=jsonResponse.getInt("m3");
                        int m4=jsonResponse.getInt("m4");
                        int m5=jsonResponse.getInt("m5");
                        int m6=jsonResponse.getInt("m6");
                        int m7=jsonResponse.getInt("m7");
                        int m8=jsonResponse.getInt("m8");

                        int resp1=m1+m2;
                        int resp2=m3+m4;
                        int resp3=m5+m6;
                        int resp4=m7+m8;

                        dar_color(resp1,mm1);
                        dar_color(resp2,mm2);
                        dar_color(resp3,mm3);
                        dar_color(resp4,mm4);


                        dar_color(f1,v1);
                        dar_color(f3,v2);
                        dar_color(f5,v3);
                        dar_color(f7,v4);

                        dar_color(k2,vv1);
                        dar_color(f4,vv2);
                        dar_color(f6,vv3);
                        dar_color(f8,vv4);

                        nom_eve.setText(e1);
                        nom_eq.setText(e2);
                        nom_rival.setText(e3);

                        score.setText(e4+" - "+e5);
                         if(e6==0 && e7==0){
                             res=0;
                         }else{
                             res=((e6+e7)/90)*100;
                         }

                        if(e4==0 && e8==0){
                             res2=0;
                        }else{
                             if(e4==0){
                                 res2=e8*100;
                             }else if(e8==0){
                                 res2=e4*100;
                             }else{
                                 res2=(e4/e8)*100;
                             }
                        }

                        r1.setText(String.valueOf(res)+"%");
                        r2.setText(String.valueOf(e4));
                        r3.setText(String.valueOf(e8));
                        r4.setText(String.valueOf(e9));
                        r5.setText(String.valueOf(res2));
                        r6.setText(String.valueOf(e10));
                        r7.setText(String.valueOf(e11));
                        r8.setText(String.valueOf(e12));
                        r9.setText(String.valueOf(e13));

                        System.out.println("Inca : "+e1+" "+e2+" "+e3+" "+e4+" "+e5+" "+e6+" "+e7+" "+e8+" "
                                +e9+" "+e10+" "+e11+" "+e12+" "+e13+" ");

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Resultados no Encontrados!")
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

        ResultadosServer Server = new ResultadosServer (cod1, cod2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
    private void dar_color(int f1, TextView txt) {

        switch (f1){
            case 0:
                txt.setBackgroundColor(getResources().getColor(R.color.col1));
                txt.setText(String.valueOf(f1));
                break;
            case 1:
                txt.setBackgroundColor(getResources().getColor(R.color.col2));
                txt.setText(String.valueOf(f1));
                break;
            case 2:
                txt.setBackgroundColor(getResources().getColor(R.color.col3));
                txt.setText(String.valueOf(f1));
                break;
            case 3:
                txt.setBackgroundColor(getResources().getColor(R.color.col4));
                txt.setText(String.valueOf(f1));
                break ;
            case 4:
                txt.setBackgroundColor(getResources().getColor(R.color.col5));
                txt.setText(String.valueOf(f1));
                break;
            case 5:
                txt.setBackgroundColor(getResources().getColor(R.color.col6));
                txt.setText(String.valueOf(f1));
                break;
            case 6:
                txt.setBackgroundColor(getResources().getColor(R.color.col7));
                txt.setText(String.valueOf(f1));
                break;
            case 7:
                txt.setBackgroundColor(getResources().getColor(R.color.col8));
                txt.setText(String.valueOf(f1));
                break;
            case 8:
                txt.setBackgroundColor(getResources().getColor(R.color.col9));
                txt.setText(String.valueOf(f1));
                break;
            case 9:
                txt.setBackgroundColor(getResources().getColor(R.color.col10));
                txt.setText(String.valueOf(f1));
                break;

        }

    }
    private void Buscar_Cod_evento() {
        for(int i=0;i<LISTA_MISEQUIO.size();i++){
            System.out.println("Inca : comp: "+LISTA_MISEQUIO.get(i).getNombre()+"  con: "+nom_equi);

            if(LISTA_MISEQUIO.get(i).getNombre().equalsIgnoreCase(nom_equi)){
                Campo_Estadistico.COD_EQUIPO_SE=LISTA_MISEQUIO.get(i).getId();
            }
        }
    }
    private void BuscaR_nom_equipo() {

        for(int i=0;i<LISTA_EVENTOS.size();i++){
            if(LISTA_EVENTOS.get(i).getId()==cod){
                nom_equi=LISTA_EVENTOS.get(i).getEquipo_asignado();
                System.out.println("Inca : nom: "+nom_equi);
            }
        }
    }
    private void listar_eventos() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.EVENTO_C_LISTAR)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Eventos_Camp data=new Eventos_Camp (
                                object.getInt("ID"),
                                object.getString("NOM_EVENTO"),
                                object.getString("F_INICIO"),
                                object.getString("F_FINAL"),

                                object.getString("NOMBRE"),
                                object.getString("NOM_MIEQUIPO"),
                                object.getString("F_CREACION"),
                                object.getString("FOTO"),
                                object.getInt("SS")
                        );
                        LISTA_EVENTOS.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("Inca ERROR:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Eventos");
                progressDialog.setMessage("Listando Eventos....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    private void listar_misEquipos() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.EVENTO_C_LISTAR_EQUIPOS)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        MisEquipos2 data=new MisEquipos2 (
                                object.getInt("ID"),
                                object.getString("NOM_MIEQUIPO"),
                                object.getInt("SS"),
                                object.getString("FECHA_CREACION"),
                                object.getInt("ID_CREADOR"));
                        LISTA_MISEQUIO.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("Inca ERROR JSON:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            protected void onPostExecute(Void aVoid){

            }
        };
        task.execute();
    }
    private void listar_fechas_evento(final int cod_evento_seleccion) {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_FECHA+cod_evento_seleccion)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Fechas data=new Fechas (
                                object.getInt("ID"),
                                object.getInt("ID_EVENTO"),
                                object.getInt("NUM_FECHA"),
                                object.getInt("ID_OPONENTE"),
                                object.getString("F_REALIZAR"),
                                object.getString("F_CREACION"),
                                object.getInt("SS"),
                                object.getInt("STATUS"),
                                object.getInt("ID_CREADOR"));
                        LISTA_FECHAS.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Inca ERROR IO:"+e);
                }catch (JSONException e){
                    System.out.println("Inca ERROR:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Fechas");
                progressDialog.setMessage("Listando Fechas....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter3.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();

    }

}
