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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
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
import inca.jesus.alianza17.Adapters.AdapterMantUsuarios;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Permiso_Guardar;
import inca.jesus.alianza17.ServerConexion.Permiso_Mostrar;
import inca.jesus.alianza17.ServerConexion.Usuario_Actualizar;
import inca.jesus.alianza17.ServerConexion.Usuario_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class FragmentUsuarios extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {
    RecyclerView recycler;
    public AdapterMantUsuarios adapter;
    LinearLayoutManager linear;
    public Context mContext;
    LinearLayout l1,l2,l3,l4;
    TextView o1;
    EditText o2,o4,o5,o6;
    EditText o3;
    Button guardad_usuario;
    MantenimientoUsuarios Temp;
    int cod=0,cod2=0;
    EditText oo1,oo2,oo3,oo4,oo5;
    Button guardad_usuario2;
    MantenimientoUsuarios Temp2;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    TextView text_nom;
    Button grabar;
    ProgressDialog progressDialog;
    ProgressDialog progressDialog2;
    ArrayList<MantenimientoUsuarios> LISTA_TEMP;
    Spinner s_edit,s_add;
    String Nombre_perfil="";
    int Pos_Perfil=0;
    ArrayList<Usuarios_Perfiles> LIST_PERFIL;
    ArrayList<String> TEMP;
    String[] TEMP2;
    ImageView b1,b2,b3;
    public FragmentUsuarios() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_usuarios, container, false);
        variables(v);
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantUsuarios(mContext, LISTA_TEMP, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
        registro_usuario();
        Opciones(adapter);
        return v;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LIST_PERFIL=new ArrayList<>();
        TEMP=new ArrayList<>();
        listar_perfiles();
        LISTA_TEMP = new ArrayList<>();
        listar_usuarios();
    }
    private void registro_usuario() {
        guardad_usuario2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inca: Click_Guardar_Usuario");
                int id_perfil_nuevo=0;
                for(int i = 0; i<LIST_PERFIL.size(); i++){
                    if(LIST_PERFIL.get(i).getNom_tipo().equalsIgnoreCase(s_add.getSelectedItem().toString())){
                        id_perfil_nuevo=LIST_PERFIL.get(i).getId();
                    }
                }
                System.out.println("Inca: id_perfil_nuevo : "+id_perfil_nuevo);
                String fe=Recu_Fecha();
                MantenimientoUsuarios Temp=new MantenimientoUsuarios(999,oo1.getText().toString(),id_perfil_nuevo,
                        oo4.getText().toString(),oo3.getText().toString(),oo5.getText().toString(),0,0,fe);
                //LISTA_TEMP.add(Temp);
                Insertar_usuario_BD(Temp);
                adapter.notifyDataSetChanged();
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                oo1.setText("");
                oo2.setText("");
                oo3.setText("");
                oo4.setText("");
                oo5.setText("");
                Toast.makeText(getActivity(), "Usuario Creado con Exito!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void listar_usuarios() {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTA_USER)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);

                        MantenimientoUsuarios data=new MantenimientoUsuarios (
                                object.getInt("ID_USUARIOS"),
                                object.getString("NOMBRE"),
                                object.getInt("TIPO"),
                                object.getString("PASS"),
                                object.getString("CORREO"),
                                object.getString("USUARIO"),
                                object.getInt("SE"),
                                object.getInt("SEE"),
                                object.getString("FECHA_CREACION"));
                        LISTA_TEMP.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("ERROR:"+e);
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Usuarios");
                progressDialog.setMessage("Listando Usuarios....");
                progressDialog.show();

            }

            protected void onPostExecute(Void aVoid){
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
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
                        LIST_PERFIL.add(data);
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
                TEMP2=new String[LIST_PERFIL.size()];
                for(int i=0;i<LIST_PERFIL.size();i++){
                    TEMP2[i]=LIST_PERFIL.get(i).getNom_tipo();
                    TEMP.add(LIST_PERFIL.get(i).getNom_tipo());
                }
                ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,TEMP2);
                s_edit.setAdapter(adapter_arr);
                s_add.setAdapter(adapter_arr);
            }
        };
        task.execute();
    }
    private void Insertar_usuario_BD(MantenimientoUsuarios u){
        LISTA_TEMP.clear();

          String d1=u.getNombre_usuario();
          String d2=String.valueOf(u.getTipo_usuario());
          String d3=u.getPass_usuario();
          String d4=u.getCorreo_usuario();
          String d5=u.getFecha();
          String d6=u.getUsuario();


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

        Usuario_Insertar Server = new Usuario_Insertar(d1,d2,d3,d4,d5,d6, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
        listar_usuarios();

    }
    private void variables(View v) {
        recycler=(RecyclerView)v.findViewById(R.id.recycler_lista_usuarios);

        Temp=new MantenimientoUsuarios();
        Temp2=new MantenimientoUsuarios();
        s_edit=(Spinner)v.findViewById(R.id.sp_usuario_edit);
        s_add=(Spinner)v.findViewById(R.id.sp_usuario_add);
        o1=(TextView)v.findViewById(R.id.edit_usuario_codigo);
        o2=(EditText)v.findViewById(R.id.edit_usuario_nombre);
        o3=(EditText) v.findViewById(R.id.edit_usuario_tipo);
        o4=(EditText)v.findViewById(R.id.edit_usuario_correo);
        o5=(EditText)v.findViewById(R.id.edit_usuario_user);
        o6=(EditText)v.findViewById(R.id.edit_usuario_pass);
        l1=(LinearLayout)v.findViewById(R.id.panel_user_recycler);
        l2=(LinearLayout)v.findViewById(R.id.panel_user_edit);
        l3=(LinearLayout)v.findViewById(R.id.panel_user_add);
        l4=(LinearLayout)v.findViewById(R.id.panel_user_perm);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        guardad_usuario=(Button)v.findViewById(R.id.edit_usuario_guardar2);
        oo1=(EditText)v.findViewById(R.id.add_usuario_nombre);
        oo2=(EditText)v.findViewById(R.id.add_usuario_tipo);
        oo3=(EditText)v.findViewById(R.id.add_usuario_correo);
        oo4=(EditText)v.findViewById(R.id.add_usuario_user);
        oo5=(EditText)v.findViewById(R.id.add_usuario_pass);
        guardad_usuario2=(Button)v.findViewById(R.id.add_usuario_guardar2);
        text_nom=(TextView)v.findViewById(R.id.permiso_nom_usuario);
        c1=(CheckBox)v.findViewById(R.id.c_opcion1);
        c2=(CheckBox)v.findViewById(R.id.c_opcion2);
        c3=(CheckBox)v.findViewById(R.id.c_opcion3);
        c4=(CheckBox)v.findViewById(R.id.c_opcion4);
        c5=(CheckBox)v.findViewById(R.id.c_opcion5);
        c6=(CheckBox)v.findViewById(R.id.c_opcion6);
        c7=(CheckBox)v.findViewById(R.id.c_opcion7);
        c8=(CheckBox)v.findViewById(R.id.c_opcion8);
        grabar=(Button)v.findViewById(R.id.permiso_btn_guardar);
        b1=(ImageView)v.findViewById(R.id.add_btn_regreso);
        b2=(ImageView)v.findViewById(R.id.edit_btn_regreso);
        b3=(ImageView)v.findViewById(R.id.permiso_btn_regreso);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
            }
        });
    }
    private void Opciones(final AdapterMantUsuarios adapterG) {
        adapterG.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapterG.isD1()==true){
                    cod=adapterG.RecuSelect();
                    System.out.println("Inca: Opcion_editar  Cod:"+cod);
                    if(cod!=0){
                        System.out.println("Inca: op_editar_ paso cod");
                        l1.setVisibility(View.GONE);
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.GONE);
                        l4.setVisibility(View.GONE);
                        Temp=RecuUser(cod);
                        o1.setText(String.valueOf(Temp.getId()));
                        o2.setText(Temp.getNombre_usuario().toString());
                        o3.setText(String.valueOf(Temp.getTipo_usuario()));

                        Buscar_Tipo(Temp.getTipo_usuario());

                        o4.setText(Temp.getCorreo_usuario().toString());
                        o5.setText(Temp.getUsuario().toString());
                        o6.setText(Temp.getPass_usuario());

                        System.out.println("Inka nom guardado:"+Nombre_perfil);
                        System.out.println("Inka cod guardado:"+Pos_Perfil);


                        guardad_usuario.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Actualizar_Usuario(cod);
                                Actualizar_Usuario_BD(cod);
                                l1.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.GONE);
                                l3.setVisibility(View.GONE);
                                l4.setVisibility(View.GONE);
                                cod=0;
                                Toast.makeText(mContext, "Usuario Actualizado con exito!", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                  adapterG.setD1(false);

                }
                if(adapterG.isD2()==true){

                    cod2=adapterG.RecuSelect2();
                    System.out.println("Inca: adapter opciones_ permisos  Cod:"+cod2);
                    if(cod2!=0){
                        System.out.println("Inca: op_permiso_ paso cod");
                        l1.setVisibility(View.GONE);
                        l2.setVisibility(View.GONE);
                        l3.setVisibility(View.GONE);
                        l4.setVisibility(View.VISIBLE);
                        text_nom.setText(adapterG.RecuNombre());
                        Setear_permisos_in_Chek(cod2);
                        grabar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                System.out.println("Inca: guardar Permisos ");
                                Actualizar_Permisos(cod2);
                                l1.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.GONE);
                                l3.setVisibility(View.GONE);
                                l4.setVisibility(View.GONE);
                                c1.setChecked(false);
                                c2.setChecked(false);
                                c3.setChecked(false);
                                c4.setChecked(false);
                                c5.setChecked(false);
                                c6.setChecked(false);
                                c7.setChecked(false);
                                c8.setChecked(false);
                                cod2=0;
                                Toast.makeText(getActivity(), "Permisos Actualizados!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                     adapterG.setD2(false);
                }
            }
        });

    }
    private void Buscar_Tipo(final int tipo_usuario) {


        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.PERFIL_BUSCAR+tipo_usuario)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONObject dato=new JSONObject(response.body().string());
                          Nombre_perfil=dato.getString("NOMBRE");
                    System.out.println("Inka JSON:"+dato.getString("NOMBRE"));

                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("Inka ERROR:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Usuario:");
                progressDialog.setMessage("Buscando Usuario....");
                progressDialog.show();

            }
            protected void onPostExecute(Void aVoid){
                for(int i=0;i<LIST_PERFIL.size();i++){
                    if(Nombre_perfil.equalsIgnoreCase(LIST_PERFIL.get(i).getNom_tipo())){
                        Pos_Perfil=i;
                    }
                }
                s_edit.setSelection(Pos_Perfil);
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    private void Actualizar_Usuario_BD(int codd) {

        MantenimientoUsuarios t=RecuUser(codd);

        String cod=String.valueOf(t.getId());
        String d1=t.getNombre_usuario();
        String d2=String.valueOf(t.getTipo_usuario());
        String d3=t.getPass_usuario();
        String d4=t.getCorreo_usuario();
        String d5=t.getUsuario();

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Usuario Actualizado en BD");
                    } else {
                        System.out.println("Inca: Usuario no Actualizado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        Usuario_Actualizar Server = new Usuario_Actualizar(cod,d1,d2,d3,d4,d5, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);

    }
    private MantenimientoUsuarios RecuUser(int cod) {

        System.out.println("Inca: entro RecuUser");
        MantenimientoUsuarios t=new MantenimientoUsuarios();

        for(int i=0;i<LISTA_TEMP.size();i++){
            if(LISTA_TEMP.get(i).getId()==cod){
                t=LISTA_TEMP.get(i);
            }
        }
        return t;


    }
    private void Actualizar_Usuario(int cod) {
        System.out.println("Inca: Actualizo usuario_en lista");
        int id_perfil_nuevo=0;

        for(int i = 0; i<LIST_PERFIL.size(); i++){
            if(LIST_PERFIL.get(i).getNom_tipo().equalsIgnoreCase(s_edit.getSelectedItem().toString())){
               id_perfil_nuevo=LIST_PERFIL.get(i).getId();
            }

        }
        for(int i = 0; i< LISTA_TEMP.size(); i++){
            if(LISTA_TEMP.get(i).getId()==cod){
                LISTA_TEMP.get(i).setNombre_usuario(o2.getText().toString());
                LISTA_TEMP.get(i).setTipo_usuario(id_perfil_nuevo);
                LISTA_TEMP.get(i).setCorreo_usuario(o4.getText().toString());
                LISTA_TEMP.get(i).setUsuario(o5.getText().toString());
                LISTA_TEMP.get(i).setPass_usuario(o6.getText().toString());
            }
        }
    }
    private void Setear_permisos_in_Chek(int i) {
        progressDialog2 = new ProgressDialog(getActivity());
        progressDialog2.setTitle("Permisos");
        progressDialog2.setMessage("Extrayendo Permisos!");
        progressDialog2.show();


        String in=String.valueOf(i);
        System.out.println("Inca: Entro setear_permisos");

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        int p1 = Integer.parseInt(jsonResponse.getString("p1"));
                        int p2 = Integer.parseInt(jsonResponse.getString("p2"));
                        int p3 = Integer.parseInt(jsonResponse.getString("p3"));
                        int p4 = Integer.parseInt(jsonResponse.getString("p4"));
                        int p5 = Integer.parseInt(jsonResponse.getString("p5"));
                        int p6 = Integer.parseInt(jsonResponse.getString("p6"));
                        int p7 = Integer.parseInt(jsonResponse.getString("p7"));
                        int p8 = Integer.parseInt(jsonResponse.getString("p8"));

                        System.out.println("Inca: P1 "+p1+" P2 "+p2+" P3 "+p3+" P4 "+p4
                                +" P5 "+p5+" P6 "+p6+" P7 "+p7+" P8 "+p8);
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
                        if(p6==1){
                            c6.setChecked(true);
                        }else{
                            c6.setChecked(false);
                        }

                        if(p7==1){
                            c7.setChecked(true);
                        }else{
                            c7.setChecked(false);
                        }

                        if(p8==1){
                            c8.setChecked(true);
                        }else{
                            c8.setChecked(false);
                        }
                        progressDialog2.dismiss();
                        System.out.println("Inca: Permisos Seteados");
                    } else {
                        System.out.println("Inca: Permisos no Seteados");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        Permiso_Mostrar Server = new Permiso_Mostrar(in, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
    private void Actualizar_Permisos(int co) {

        progressDialog2 = new ProgressDialog(getActivity());
        progressDialog2.setTitle("Permisos");
        progressDialog2.setMessage("Guardando Permisos!");
        progressDialog2.show();
        String in=String.valueOf(co);
        String p1,p2,p3,p4,p5,p6,p7,p8;
        System.out.println("Inca: Entro Actualizar_permisos");

        if(c1.isChecked()==true){
            p1="1";
        }else{
            p1="0";
        }
        if(c2.isChecked()==true){
            p2="1";
        }else{
            p2="0";
        }
        if(c3.isChecked()==true){
            p3="1";
        }else{
            p3="0";
        }
        if(c4.isChecked()==true){
            p4="1";
        }else{
            p4="0";
        }
        if(c5.isChecked()==true){
            p5="1";
        }else{
            p5="0";
        }
        if(c6.isChecked()==true){
            p6="1";
        }else{
            p6="0";
        }
        if(c7.isChecked()==true){
            p7="1";
        }else{
            p7="0";
        }
        if(c8.isChecked()==true){
            p8="1";
        }else{
            p8="0";
        }


        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        progressDialog2.dismiss();
                        System.out.println("Inca: Permisos Guardados");
                    } else {
                        System.out.println("Inca: Permisos no Guardados");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };
        Permiso_Guardar Server = new Permiso_Guardar(in,p1,p2,p3,p4,p5,p6,p7,p8, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);

    }
    public void onDetach() {
        super.onDetach();
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Buscar");
        MenuItem add=menu.findItem(R.id.action_add);
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                System.out.println("Inca: Ingreso a Registrar Usuario");
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.VISIBLE);
                l4.setVisibility(View.GONE);

                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }
    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        List<MantenimientoUsuarios> filteredValues = new ArrayList<MantenimientoUsuarios>(LISTA_TEMP);
        for (MantenimientoUsuarios value : LISTA_TEMP) {
            if (!value.getNombre_usuario().toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantUsuarios(mContext,filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
         Opciones(adapter);
        return false;
    }
    public void resetSearch() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantUsuarios(mContext, LISTA_TEMP, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
        Opciones(adapter);
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
}
