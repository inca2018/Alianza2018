package inca.jesus.alianza17.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.Activity_Principal;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Adapters.AdapterCreacionCategoria;
import inca.jesus.alianza17.Adapters.AdapterMantCate_Juga;
import inca.jesus.alianza17.Adapters.AdapterMantCategorias;
import inca.jesus.alianza17.Adapters.AdapterMantJugadores;
import inca.jesus.alianza17.Adapters.AdapterMantUsuarios;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.MantenimientoCategoria;
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Categoria_Eliminar_Jugador;
import inca.jesus.alianza17.ServerConexion.Categoria_Insertar;
import inca.jesus.alianza17.ServerConexion.Categoria_Insertar_Jugador;
import inca.jesus.alianza17.ServerConexion.Perfil_Insertar;
import inca.jesus.alianza17.ServerConexion.Plantel_Eliminar;
import inca.jesus.alianza17.ServerConexion.Usuario_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategorias extends Fragment implements  SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{

    RecyclerView recycler,recycler2,recycler3;
    AdapterMantCategorias adapter;
    AdapterMantCate_Juga adapter2;
    AdapterCreacionCategoria adapter3;
    LinearLayoutManager linear;
    public Context mContext;
    List<MantenimientoCategoria> LIST_TEMP;
    List<Plantel> LIST_JUGADORES,TOTAL_JUGA;
    ProgressDialog progressDialog;
    LinearLayout l1,l2,l3,l4;
    EditText nom_categ;
    Button guardar_nueva_categ;
    Button btn_regre_Cat;
    MenuItem add,buscar;

    Button card_2;

    int cod=0;
    String titulo="";
    CardView c1,c2;
    CardView z1,z2;
    int cod_jug=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LIST_TEMP=new ArrayList<>();
        LIST_JUGADORES=new ArrayList<Plantel>();
        TOTAL_JUGA=new ArrayList<>();
        Listar_Categorias();
    }
    public FragmentCategorias() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_categorias, container, false);
        variables(v);
        recycler_lista();
        Registrar_Nueva_Categoria();
        regreso_a_categ();
        Opciones();
        return v;
    }


    private void regreso_a_categ() {

        btn_regre_Cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                add.setVisible(true);
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Categorias");
            }
        });
    }
    private void variables(View v) {
        recycler=(RecyclerView)v.findViewById(R.id.recycler_mant_cate);
        recycler2=(RecyclerView)v.findViewById(R.id.recycler_lista_jugadores_x_categorias);
        recycler3=(RecyclerView)v.findViewById(R.id.recycler_seleccion);

        l1=(LinearLayout)v.findViewById(R.id.modulo_recycler_categorias);
        l2=(LinearLayout)v.findViewById(R.id.modulo_recycler_jugadores);
        l3=(LinearLayout)v.findViewById(R.id.modulo_nueva_categoria);
        l4=(LinearLayout)v.findViewById(R.id.modulo_agregar_jugadores_a_lista);
        nom_categ=(EditText)v.findViewById(R.id.categoria_nuevo);
        guardar_nueva_categ=(Button)v.findViewById(R.id.categoria_nuevo_guardar);

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        btn_regre_Cat=(Button)v.findViewById(R.id.btn_regreso_categoria);

        c1=(CardView)v.findViewById(R.id.card_agregar_jugador);
        c2=(CardView)v.findViewById(R.id.card_reg_jugador);
        z1=(CardView)v.findViewById(R.id.regreso_lista_juga);
        z2=(CardView)v.findViewById(R.id.card_jesus);
        card_2=(Button)v.findViewById(R.id.card_jesus2);
        card_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca Ingreso a BOTON_ GUARDAR:");

                add.setVisible(false);
                buscar.setVisible(false);
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                List<Plantel> TEMP=new ArrayList<Plantel>();

                for(int i=0;i<TOTAL_JUGA.size();i++){
                    if(TOTAL_JUGA.get(i).getSelect()==1){
                        TEMP.add(TOTAL_JUGA.get(i));
                    }
                }
                for(int i=0;i<TEMP.size();i++){
                    Agregar_Jugador_Categoria(TEMP.get(i).getId());
                }
                LIST_JUGADORES.clear();
                System.out.println("Inca COD: CATE: "+cod);
                Listar_Categorias_Jugadores(cod);

            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setVisible(false);
                buscar.setVisible(true);
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.VISIBLE);
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Agregar Jugadores");

                linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
                adapter3 = new AdapterCreacionCategoria(mContext,TOTAL_JUGA, new RecyclerViewOnItemClickListener2() {
                    @Override
                    public void onClick(View v, int position) {
                    }
                });
                recycler3.setAdapter(adapter3);
                recycler3.setLayoutManager(linear);
                listar_jugadores();
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getActivity(), Activity_Principal.class);
                inten.putExtra("o","o8");
                startActivity(inten);
            }
        });

        z1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setVisible(false);
                buscar.setVisible(false);
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
            }
        });
    }
    private void Agregar_Jugador_Categoria(int cod_juga) {

        String d1=String.valueOf(cod);
        String d2=String.valueOf(cod_juga);
        System.out.println("Inca : cod: "+cod+ "  cod jugad : "+ cod_juga);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Usuario Insertado");
                    } else {
                        System.out.println("Inca: Usuario no Insertado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };
        Categoria_Insertar_Jugador Server = new Categoria_Insertar_Jugador(d1,d2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
    private void listar_jugadores() {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.PLANTEL_LISTA)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Plantel data=new Plantel (
                                object.getInt("ID"),
                                object.getInt("OP_ORIGEN"),
                                object.getString("OP_NOMBRES"),
                                object.getString("OP_F_NACI"),
                                object.getInt("OP_EDAD"),
                                object.getInt("OP_DNI"),
                                object.getString("OP_NACIONALIDAD"),
                                object.getString("OP_DOMICILIO"),
                                object.getString("OP_LOCALIDAD"),
                                object.getInt("OP_TELEFONO"),
                                object.getString("OP_EMAIL"),
                                object.getString("OP_FECHA_INGRESO"),
                                object.getInt("OP_SS"),
                                object.getInt("NUM"));
                        TOTAL_JUGA.add(data);
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
                progressDialog.setTitle("Jugadores");
                progressDialog.setMessage("Listando Jugadores....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter3.notifyDataSetChanged();

                for(int i=0;i<TOTAL_JUGA.size();i++){
                    for(int j=0;j<LIST_JUGADORES.size();j++){
                        if(TOTAL_JUGA.get(i).getId()==LIST_JUGADORES.get(j).getId()){
                            TOTAL_JUGA.remove(i);
                        }
                    }
                }
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    private void Opciones() {
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onChanged() {
                    super.onChanged();

                    if(adapter.isSelect()==true){
                        LIST_JUGADORES.clear();
                        cod=adapter.RecuSelect();
                        add.setVisible(false);
                        l1.setVisibility(View.GONE);
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.GONE);

                        for(int i=0;i<LIST_TEMP.size();i++){
                            if(LIST_TEMP.get(i).getId()==cod){
                                titulo=LIST_TEMP.get(i).getNombre();
                            }
                        }
                        //Extraer titulo desde fragment y cambiar tu toolbar.
                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);

                        System.out.println("Inca: codigo="+cod);
                        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
                        adapter2 = new AdapterMantCate_Juga(mContext,LIST_JUGADORES, new RecyclerViewOnItemClickListener2() {
                            @Override
                            public void onClick(View v, int position) {
                            }
                        });
                        recycler2.setAdapter(adapter2);
                        recycler2.setLayoutManager(linear);
                        Listar_Categorias_Jugadores(cod);
                        for(int i=0;i<LIST_JUGADORES.size();i++){
                            System.out.println("Inca: Jugador= "+LIST_JUGADORES.get(i).getNom_completo());
                        }

                        adapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                            @Override
                            public void onChanged() {
                                super.onChanged();
                                if(adapter2.isSelecto()==true){
                                    cod_jug=adapter2.recu_Codigo();

                                    final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                                    builder.setTitle("Eliminar")
                                            .setMessage("¿Desea Eliminar Jugador de Categoria?")
                                            .setPositiveButton("SI",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Eliminar_Jugador(cod_jug);
                                                            LIST_JUGADORES.clear();
                                                            Listar_Categorias_Jugadores(cod);
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
                                    adapter2.setSelecto(false);
                            }
                        });

                        adapter.setSelect(false);
                    }
                }
            });
    }
    private void Registrar_Nueva_Categoria() {

        guardar_nueva_categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nom_categ.getText().toString().length()==0){
                    Toast.makeText(getActivity(),"Ingrese Nombre de Categoria, para continuar!", Toast.LENGTH_SHORT).show();
                }else{
                    String fecha_Actual=Recu_Fecha();
                    //Recuperar codigo y guardar nombre usuario!!!!!!!!!!!!!!!!!!!!!!
                    MantenimientoCategoria temp=new MantenimientoCategoria(111,nom_categ.getText().toString(),1,fecha_Actual,"82");
                    //Modulos.LISTA_MODULOS.add(mo);
                    Insert_Categoria_Bd(temp);
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    nom_categ.setText("");
                }

            }
        });
    }
    private void Insert_Categoria_Bd(MantenimientoCategoria temp) {
        LIST_TEMP.clear();
        String d1=temp.getNombre().toString().toUpperCase();
        String d2=String.valueOf(temp.getStatus());
        String d3=temp.getF_creacion().toString();
        String d4=temp.getUsuario().toString();

        System.out.println("Inca : datos: "+d1+"  "+d2+"  "+d3+" "+d4);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Categoria Insertado");
                    } else {
                        System.out.println("Inca: Categoria no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error JSON  "+ e);
                }
            }
        };
        Categoria_Insertar Server = new Categoria_Insertar(d1,d2,d3,d4, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
        Listar_Categorias();
    }
    private void recycler_lista() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantCategorias(mContext,LIST_TEMP, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
    }
    private void Listar_Categorias() {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.CATEGORIA_LISTA)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        MantenimientoCategoria data=new MantenimientoCategoria (
                                object.getInt("ID"),
                                object.getString("NOM_CATEGORIA"),
                                object.getInt("SS"),
                                object.getString("FECHA_CREACION"),
                                object.getString("NOMBRE"));
                        LIST_TEMP.add(data);
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
                progressDialog.setTitle("Categorias");
                progressDialog.setMessage("Listando Categorias....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();

    }
    private void Listar_Categorias_Jugadores(final int cod) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.CATEGORIA_LISTA_JUGADOR+cod)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Plantel data=new Plantel (
                                object.getInt("ID"),
                                object.getInt("OP_ORIGEN"),
                                object.getString("OP_NOMBRES"),
                                object.getString("OP_F_NACI"),
                                object.getInt("OP_EDAD"),
                                object.getInt("OP_DNI"),
                                object.getString("OP_NACIONALIDAD"),
                                object.getString("OP_DOMICILIO"),
                                object.getString("OP_LOCALIDAD"),
                                object.getInt("OP_TELEFONO"),
                                object.getString("OP_EMAIL"),
                                object.getString("OP_FECHA_INGRESO"),
                                object.getInt("OP_SS"),
                                object.getInt("NUM"));
                        LIST_JUGADORES.add(data);
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
                progressDialog.setTitle("Jugadores");
                progressDialog.setMessage("Listando Jugadores....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter2.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        buscar = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) buscar.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Buscar");
        buscar.setVisible(false);

        add=menu.findItem(R.id.action_add);
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.VISIBLE);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }
    private String Recu_Fecha() {
        String ec;
        int dia2;
        int mes2;
        int hora2;
        int minuto2;
        String am;
        String d1,d2,d3,d4;
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int dia_of = today.monthDay;
        int mes_m = today.month;
        int year=today.year;
        int hora_of=today.hour;
        int min_of=today.minute;
        int mes_of=mes_m+1;

        if(dia_of<10){
            d1="0"+dia_of;

        }else{
            d1=String.valueOf(dia_of);
        }
        if(mes_of<10){
            d2="0"+mes_of;
        }else{
            d2=String.valueOf(mes_of);
        }
        if(hora_of<10){
            d3="0"+hora_of;

        }else{
            d3=String.valueOf(hora_of);
        }
        if(min_of<10){
            d4="0"+min_of;
        }else{
            d4=String.valueOf(min_of);
        }
        if(hora_of>=1 && hora_of<12){
            am="a.m.";
        }else{
            am="p.m.";
        }
        ec=d3+":"+d4+" "+am+"  "+d1+"/"+d2+"/"+year;
        return ec;
    }
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.VISIBLE);
        List<Plantel> filteredValues = new ArrayList<Plantel>(TOTAL_JUGA);
        for (Plantel value : TOTAL_JUGA) {
            if (!value.getNom_completo().toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter3 = new AdapterCreacionCategoria(mContext,filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler3.setAdapter(adapter3);
        recycler3.setLayoutManager(linear);

        return false;
    }
    public void resetSearch() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter3 = new AdapterCreacionCategoria(mContext, TOTAL_JUGA, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler3.setAdapter(adapter3);
        recycler3.setLayoutManager(linear);
    }
    private void Eliminar_Jugador(int i) {
        String id=String.valueOf(cod);
        String id2=String.valueOf(i);

        System.out.println("Inca : Cate: "+cod+"  Juga_: "+i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Jugador Eliminado BD");
                    } else {
                        System.out.println("Inca: Jugador no Eliminado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);
                }
            }
        };
        Categoria_Eliminar_Jugador Server = new Categoria_Eliminar_Jugador(id,id2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
}
