package inca.jesus.alianza17.Fragments;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Adapters.AdapterPerfiles;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Modulos;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Modulo_Mostrar;
import inca.jesus.alianza17.ServerConexion.Perfil_Insertar;
import inca.jesus.alianza17.ServerConexion.Perfil_SetModulos;
import inca.jesus.alianza17.ServerConexion.Permiso_Mostrar;
import inca.jesus.alianza17.ServerConexion.Usuario_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class FragmentPerfiles extends Fragment implements  MenuItem.OnActionExpandListener  {
    AdapterPerfiles adapter;
    RecyclerView recycler;
    LinearLayoutManager linear;
    LinearLayout l1,l2,l3;
    int cod=0;
    Usuarios_Perfiles Temp;
    public Context mContext;
    TextView nom_perfil;
    CheckBox c1,c2,c3,c4,c5;
    Button btn_guardar;
    EditText nuevo_perfil;
    Button btn_nuevo;
    List<Usuarios_Perfiles> TEMP_LISTA;
    ProgressDialog progressDialog;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);

        TEMP_LISTA=new ArrayList<>();
        listar_perfiles();

    }
    public FragmentPerfiles() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfiles, container, false);
        variables(v);
        recycler_perfiles();
        gestion_modulos();
        guardar_perfil();
        registro_perfil();
        return v;
    }

    private void registro_perfil() {
        btn_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nuevo_perfil.getText().toString().length()==0){
                    Toast.makeText(getActivity(),"Ingrese Nombre de Perfil, para continuar!", Toast.LENGTH_SHORT).show();
                }else{
                    String fecha_Actual=Recu_Fecha();
                    Usuarios_Perfiles temp=new Usuarios_Perfiles(144,nuevo_perfil.getText().toString(),1,fecha_Actual);
                    //Modulos.LISTA_MODULOS.add(mo);
                    Insert_Perfil_Bd(temp);
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    nuevo_perfil.setText("");
                }
            }
        });
    }
    private void Insert_Perfil_Bd(Usuarios_Perfiles temp) {
           TEMP_LISTA.clear();
           String d1=temp.getNom_tipo().toString();
           String d2=String.valueOf(temp.getStatus());
           String d3=temp.getCreacion().toString();

        System.out.println("Inca : datos: "+d1+"  "+d2+"  "+d3+" ");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Perfil Insertado");
                    } else {
                        System.out.println("Inca: Perfil no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error JSON  "+ e);
                }
            }
        };
        Perfil_Insertar Server = new Perfil_Insertar(d1,d2,d3, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
        listar_perfiles();
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
    private void variables(View v) {
        recycler=(RecyclerView)v.findViewById(R.id.recycler_perfiles);
        l1=(LinearLayout)v.findViewById(R.id.panel_lista);
        l2=(LinearLayout)v.findViewById(R.id.panel_modulos);
        l3=(LinearLayout)v.findViewById(R.id.panel_nuevo_perfil);
        nom_perfil=(TextView)v.findViewById(R.id.perfil_nom);
        c1=(CheckBox)v.findViewById(R.id.p_opcion1);
        c2=(CheckBox)v.findViewById(R.id.p_opcion2);
        c3=(CheckBox)v.findViewById(R.id.p_opcion3);
        c4=(CheckBox)v.findViewById(R.id.p_opcion4);
        c5=(CheckBox)v.findViewById(R.id.p_opcion5);
        nuevo_perfil=(EditText)v.findViewById(R.id.perfil_nuevo);
        btn_nuevo=(Button)v.findViewById(R.id.perfil_nuevo_guardar);
        btn_guardar=(Button)v.findViewById(R.id.perfil_btn_guardar);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
    }
    private void recycler_perfiles() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterPerfiles(mContext,TEMP_LISTA, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);

    }
    private void gestion_modulos() {
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter.isMov()==true){
                cod=adapter.recu_perfil();
                if(cod==0){
                    System.out.println("Inca : entro if - gestion");
                }else{
                    System.out.println("Inca : NO entro if-gestion");
                    for(int i=0;i<TEMP_LISTA.size();i++){
                        if(TEMP_LISTA.get(i).getId()==cod){
                            Temp=TEMP_LISTA.get(i);
                        }
                    }
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.GONE);

                    if(Temp.getId()!=0){
                        nom_perfil.setText(Temp.getNom_tipo());
                        Setear_modulos_in_Chek(cod);
                    }
                }
              }
              adapter.setMov(false);
            }
        });

    }
    private void guardar_perfil() {
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Guardar_modulo_in(cod);
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                Toast.makeText(getActivity(),"Perfil Actualizado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Guardar_modulo_in(int cod2) {
        String d1,d2,d3,d4,d5;
        String cod=String.valueOf(cod2);

        if(c1.isChecked()){
            d1="1";
        }else{
            d1="0";
        }
        if(c2.isChecked()){
            d2="1";
        }else{
            d2="0";
        }
        if(c3.isChecked()){
            d3="1";
        }else{
            d3="0";
        }
        if(c4.isChecked()){
            d4="1";
        }else{
            d4="0";
        }
        if(c5.isChecked()){
            d5="1";
        }else{
            d5="0";
        }

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Modulos");
        progressDialog.setMessage("Guardando Modulos!");
        progressDialog.show();

        System.out.println("Inca: Entro setear_modulos");
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Modulos Insertado");
                        progressDialog.dismiss();
                    } else {
                        System.out.println("Inca: Modulo no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error JSON  "+ e);
                }
            }
        };
        Perfil_SetModulos Server = new Perfil_SetModulos(cod,d1,d2,d3,d4,d5, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);

    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu, menu);
        MenuItem add=menu.findItem(R.id.action_add);
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
    private void listar_perfiles() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.PERFIL_LISTA)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Usuarios_Perfiles data=new Usuarios_Perfiles (
                                object.getInt("ID_TIPO_USUARIO"),
                                object.getString("NOMBRE_TIPO"),
                                object.getInt("STATUS"),
                                object.getString("FECHA_CREACION"));
                        TEMP_LISTA.add(data);
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
                progressDialog.setTitle("Perfiles");
                progressDialog.setMessage("Listando Perfiles....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
               adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    private void Setear_modulos_in_Chek(int i) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Modulos");
        progressDialog.setMessage("Extrayendo Modulos!");
        progressDialog.show();
        String cod=String.valueOf(i);
        System.out.println("Inca: Entro setear_modulos");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        int p1 = Integer.parseInt(jsonResponse.getString("m1"));
                        int p2 = Integer.parseInt(jsonResponse.getString("m2"));
                        int p3 = Integer.parseInt(jsonResponse.getString("m3"));
                        int p4 = Integer.parseInt(jsonResponse.getString("m4"));
                        int p5 = Integer.parseInt(jsonResponse.getString("m5"));
                        System.out.println("Inca: P1 "+p1+" P2 "+p2+" P3 "+p3+" P4 "+p4
                                +" P5 "+p5);
                        if(p1==1){
                            c1.setChecked(true);
                        }else{
                            c1.setChecked(false);
                        }
                        if(p2==1){
                            c2.setChecked(true);
                        }else{
                            c2.setChecked(false);
                        }
                        if(p3==1){
                            c3.setChecked(true);
                        }else{
                            c3.setChecked(false);
                        }

                        if(p4==1){
                            c4.setChecked(true);
                        }else{
                            c4.setChecked(false);
                        }

                        if(p5==1){
                            c5.setChecked(true);
                        }else{
                            c5.setChecked(false);
                        }

                        progressDialog.dismiss();
                        System.out.println("Inca: Modulos Seteados");
                    } else {
                        System.out.println("Inca: Modulos no Seteados");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);
                }
            }
        };
        Modulo_Mostrar Server = new Modulo_Mostrar(cod, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }

}
