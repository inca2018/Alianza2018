package inca.jesus.alianza17.Fragments;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Calendar;
import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Adapters.AdapterGestionBarrio;
import inca.jesus.alianza17.Adapters.AdapterPostulante2;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Eventos2;
import inca.jesus.alianza17.Clases.Posicion;
import inca.jesus.alianza17.Clases.Postulante;
import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Eliminar_Evento_Barrio;
import inca.jesus.alianza17.ServerConexion.Evento_Barrio_Insertar;
import inca.jesus.alianza17.ServerConexion.Postulante_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentGestionBarrio extends Fragment implements  MenuItem.OnActionExpandListener{

    public Context mContext;
    LinearLayout l1,l2,l3,l4;
    LinearLayout v1,v2;
    RecyclerView recycler_barrio;
    LinearLayoutManager linear,linear2;
    AdapterGestionBarrio adapter;
    List<Eventos2> LISTA_BARRIO;
    ProgressDialog progressDialog;
    int cod_evento=0;

    MenuItem add,buscar;
    Button regreso;

    ImageView Calendario,Calendario2;
    DatePickerDialog.OnDateSetListener d1,d2;
    Calendar dateTime = Calendar.getInstance();
    TextView fecha_barrio;
    Button guardar_evento,mostrar_eventos;
    TextView nom_eve;

    List<Postulante> LISTA_POSTULANTES;
    RecyclerView recycler_postulantes;
    AdapterPostulante2 adapterPos;
    Button agregar_pos;

    int naci=0;


    Spinner sp_pos;
    ArrayList<Posicion> LISTA_POS;
    String[] TEMP;

    Button Regresar_de_Pos,guardar_pos;

    TextView p1,p2,p3,p4,p5,p6,p7,p8;
    String cod_pos="";


    public FragmentGestionBarrio() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LISTA_BARRIO=new ArrayList<>();
        LISTA_POSTULANTES=new ArrayList<>();
        LISTA_POS=new ArrayList<>();
        listar_Pos();
        listar_barrio();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_gestion_barrio, container, false);

        variables(v);

        agregar_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l4.setVisibility(View.VISIBLE);
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
            }
        });
        boton_mostrar_eventos();
        visibilidad_paneles();
        boton_guardar_evento();
        calendario_gestion();
        calendario_gestion2();
        boton_regreso();
        gestion_recycler();
        opciones();
        boton_regreso_de_agregar();

        sp_pos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cod_pos=String.valueOf(LISTA_POS.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        boton_guardar_pos();
        return v;
    }

    private void boton_guardar_pos() {

    guardar_pos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(p1.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Numero de Inscripcion!", Toast.LENGTH_SHORT).show();
            }else if(p2.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Nombres del Postulante!", Toast.LENGTH_SHORT).show();
            }else if(p3.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Apellidos del Postulante!", Toast.LENGTH_SHORT).show();
            }else if(p4.getText().length()==0){
                Toast.makeText(mContext, "Seleccion Fecha de Nacimiento!", Toast.LENGTH_SHORT).show();
            }else if(p5.getText().length()==0){
                Toast.makeText(mContext, "Ingrese  Domicilio del Postulante!", Toast.LENGTH_SHORT).show();
            }else if(p6.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Localidad del Postulante!", Toast.LENGTH_SHORT).show();
            }else if(p7.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Telefono del Postulante!", Toast.LENGTH_SHORT).show();
            }else if(p8.getText().length()==0){
                Toast.makeText(mContext, "Ingrese Email del Postulante!", Toast.LENGTH_SHORT).show();
            }else{

                String d1=p1.getText().toString();//insc
                String d2=Recu_Fecha();//fecha_ins
                String d3=p2.getText().toString();//nom
                String d4=p3.getText().toString();//ape
                String d5=p4.getText().toString();//f_naci

                Time today = new Time(Time.getCurrentTimezone());
                today.setToNow();
                int edad=today.year-naci;
                System.out.println("Inca : año:"+today.year+" naci: "+naci);
                String d6= String.valueOf(edad);//edad
                String d7=String.valueOf(naci);
                String d8=p5.getText().toString();
                String d9=p6.getText().toString();
                String d10=String.valueOf(p7.getText().toString());
                String d11=p8.getText().toString();


                com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                System.out.println("Inca: Postulante Insertado");
                                LISTA_POSTULANTES.clear();
                                //Extraer_Postulantes_de_Equipo(cod_evento);
                                l3.setVisibility(View.VISIBLE);
                                l4.setVisibility(View.GONE);
                                vaciar_var();
                            } else {
                                System.out.println("Inca: Postulante no Insertado");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("Inca: error insertar Postulante "+ e);
                        }
                    }
                };
                Postulante_Insertar Server = new Postulante_Insertar(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,cod_pos,String.valueOf(cod_evento), responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(Server);

            }

        }
    });

    }
    private void calendario_gestion2() {

        Calendario2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate2();
            }
        });

        d2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel2(dayOfMonth,monthOfYear,year);
            }
        };
    }
    private void calendario_gestion() {
        Calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });

        d1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel1(dayOfMonth,monthOfYear,year);
            }
        };
    }
    private void boton_regreso_de_agregar() {

    Regresar_de_Pos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            l1.setVisibility(View.GONE);
            l2.setVisibility(View.GONE);
            l3.setVisibility(View.VISIBLE);
            l4.setVisibility(View.GONE);
            vaciar_var();
        }
    });
    }
    private void vaciar_var() {
        p1.setText("");
        p2.setText("");
        p3.setText("");
        p4.setText("");
        p5.setText("");
        p6.setText("");
        p7.setText("");
        p8.setText("");

    }
    private void variables(View v) {
        recycler_barrio=(RecyclerView)v.findViewById(R.id.recycler_lista_barrio);
        recycler_postulantes=(RecyclerView)v.findViewById(R.id.recycler_barrio_postulantes);
        l1=(LinearLayout)v.findViewById(R.id.panel_barrio_recycler);
        l2=(LinearLayout)v.findViewById(R.id.panel_barrio_agregar);
        l3=(LinearLayout)v.findViewById(R.id.panel_barrio_postulantes);
        l4=(LinearLayout)v.findViewById(R.id.panel_barrio_agregar_pos);
        v1=(LinearLayout)v.findViewById(R.id.panel_vacio_barrio_postulante);
        v2=(LinearLayout)v.findViewById(R.id.panel_vacio_barrio);
        regreso=(Button)v.findViewById(R.id.regresar_barrio);
        agregar_pos=(Button)v.findViewById(R.id.agregar_postulante_barrio);
        Calendario=(ImageView)v.findViewById(R.id.calendario_barrio);
        Calendario2=(ImageView)v.findViewById(R.id.fecha_naci_barrio_image);
        fecha_barrio=(TextView)v.findViewById(R.id.fecha_realizar_barrio);
        guardar_evento=(Button)v.findViewById(R.id.guardar_barrio_nuevo);
        nom_eve=(TextView)v.findViewById(R.id.nom_barrio);
        mostrar_eventos=(Button)v.findViewById(R.id.mostrar_eventos);
        sp_pos=(Spinner)v.findViewById(R.id.barrio_pos);
        Regresar_de_Pos=(Button)v.findViewById(R.id.boton_regresar);
        p1=(TextView)v.findViewById(R.id.barrio_insc);
        p2=(TextView)v.findViewById(R.id.barrio_nom);
        p3=(TextView)v.findViewById(R.id.barrio_ape);
        p4=(TextView)v.findViewById(R.id.barrio_fecha_nac);
        p5=(TextView)v.findViewById(R.id.barrio_domi);
        p6=(TextView)v.findViewById(R.id.barrio_loca);
        p7=(TextView)v.findViewById(R.id.barrio_tele);
        p8=(TextView)v.findViewById(R.id.barrio_email);
        guardar_pos=(Button)v.findViewById(R.id.boton_guardar_postulante);

    }
    private void opciones() {
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter.getItemCount()==0){
                    l1.setVisibility(View.GONE);
                    v2.setVisibility(View.VISIBLE);
                }else{
                    v2.setVisibility(View.GONE);
                    opcion_postulantes();
                    opcion_eliminar();
                }
            }
        });
    }
    private void listar_Pos() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.POSICIONES_LISTAR)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Posicion data=new Posicion (
                                object.getInt("ID_POSICION"),
                                object.getString("NOMBRE_POS")
                        );
                        LISTA_POS.add(data);
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
                TEMP=new String[LISTA_POS.size()];
                for(int i=0;i<LISTA_POS.size();i++){
                    TEMP[i]=LISTA_POS.get(i).getNombre();
                }
                ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_dropdown_item,TEMP);
                sp_pos.setAdapter(adapter_arr);
            }
        };
        task.execute();

    }
    private void boton_regreso() {
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
            }
        });
    }
    private void visibilidad_paneles() {
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);

    }
    private void boton_mostrar_eventos() {
        mostrar_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                LISTA_POSTULANTES.clear();
                adapterPos.notifyDataSetChanged();
            }
        });
    }
    private void boton_guardar_evento() {
        guardar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nom_eve.getText().length()==0){
                    Toast.makeText(mContext, "Falta Ingresar el Nombre del evento!", Toast.LENGTH_SHORT).show();
                }else if(fecha_barrio.getText().length()==0){
                    Toast.makeText(mContext, "Falta Ingresar el Nombre del evento!", Toast.LENGTH_SHORT).show();
                }else {
                    String fecha_creacion=Recu_Fecha() ;
                    Agregar_Evento(nom_eve.getText().toString(),fecha_barrio.getText().toString(),fecha_creacion);
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                }

            }
        });
    }
    private void Agregar_Evento(String nom, String fecha_rea, String fecha_creacion) {
        fecha_barrio.setText("");
        nom_eve.setText("");
        LISTA_BARRIO.clear();
        String d1=nom;
        String d2=fecha_creacion;
        String d3=fecha_rea;
        String d4= String.valueOf(Usuario_Sesion.SESION.getCodigo());
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Evento Insertado");
                    } else {
                        System.out.println("Inca: Evento no Insertado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        Evento_Barrio_Insertar Server = new Evento_Barrio_Insertar(d1,d2,d3,d4, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
        listar_barrio();
    }
    private void updateTextLabel1(int dia,int mes3,int ano) {

        String dia2,mes;
        int mes2=mes3+1;
        if(dia<10){
            dia2="0"+dia;
        }else {
            dia2=String.valueOf(dia);
        }
        if(mes2<10){
            mes="0"+mes2;
        }else {
            mes=String.valueOf(mes2);
        }
        fecha_barrio.setText(dia2+"/"+mes+"/"+ano);
    }
    private void updateTextLabel2(int dia,int mes3,int ano) {

        String dia2,mes;
        int mes2=mes3+1;
        if(dia<10){
            dia2="0"+dia;
        }else {
            dia2=String.valueOf(dia);
        }
        if(mes2<10){
            mes="0"+mes2;
        }else {
            mes=String.valueOf(mes2);
        }
         naci=ano;
         p4.setText(dia2+"/"+mes+"/"+ano);
        System.out.println("Inca : f_nac"+p4.getText());
    }
    private void updateDate(){
        new DatePickerDialog(getActivity(),d1, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateDate2(){
        new DatePickerDialog(getActivity(),d2, 1999,0,1).show();
    }
    private void opcion_eliminar() {
        //eliminar
        if(adapter.isD2()==true){
            cod_evento=adapter.RecuSelect();
            //Toast.makeText(mContext, "opcion 2:"+cod_evento, Toast.LENGTH_SHORT).show();


            final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
            builder.setTitle("Eliminar")
                    .setMessage("¿Desea Eliminar Evento ?")
                    .setPositiveButton("SI",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Eliminar_Evento(cod_evento);
                                    LISTA_BARRIO.clear();
                                    listar_barrio();
                                    Toast.makeText(mContext, "Evento Eliminado con Exito!", Toast.LENGTH_SHORT).show();
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


            adapter.setD2(false);
        }
    }
    private void Eliminar_Evento(int cod) {

        String id=String.valueOf(cod);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Evento Eliminado BD");
                    } else {
                        System.out.println("Inca: Evento no Eliminado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);
                }
            }
        };
        Eliminar_Evento_Barrio Server = new Eliminar_Evento_Barrio(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);


    }
    private void opcion_postulantes() {

        //postulantes
        if(adapter.isD1()==true){

            cod_evento=adapter.RecuSelect();
            //Toast.makeText(mContext, "opcion 1:"+cod_evento, Toast.LENGTH_SHORT).show();
            DataServer.COD_EVENTO=cod_evento;

            l1.setVisibility(View.GONE);
            l2.setVisibility(View.GONE);
            l3.setVisibility(View.VISIBLE);

            linear2 = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);

            adapterPos = new AdapterPostulante2(mContext,LISTA_POSTULANTES, new RecyclerViewOnItemClickListener2() {
                public void onClick(View v, int position) {
                }
            });
            recycler_postulantes.setAdapter(adapterPos);
            recycler_postulantes.setLayoutManager(linear2);

            //Extraer_Postulantes_de_Equipo(cod_evento);

            adapterPos.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onChanged() {
                    super.onChanged();

                    if(adapterPos.getItemCount()==0){
                        recycler_postulantes.setVisibility(View.GONE);
                        v1.setVisibility(View.VISIBLE);
                    }else{
                        v1.setVisibility(View.GONE);
                        recycler_postulantes.setVisibility(View.VISIBLE);
                    }
                }
            });

            adapter.setD1(false);

        }
    }
    private void gestion_recycler() {

        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterGestionBarrio(mContext,LISTA_BARRIO, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler_barrio.setAdapter(adapter);
        recycler_barrio.setLayoutManager(linear);

    }
    private void listar_barrio() {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_BARRIO)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Eventos2 data=new Eventos2 ( object.getInt("ID_EVENTO"),
                                object.getString("NOM_EVENTO"),
                                object.getString("CANT_POSTULANTES"),
                                object.getString("FECHA_CREACION"),
                                object.getString("FECHA_EJECUCION"),
                                object.getInt("STATUS"),
                                object.getInt("SS"),
                                object.getString("NOMBRE"));
                        LISTA_BARRIO.add(data);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        buscar = menu.findItem(R.id.action_search);
        buscar.setVisible(false);

        add=menu.findItem(R.id.action_add);
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                l2.setVisibility(View.VISIBLE);
                l1.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
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
    /*
    private void Extraer_Postulantes_de_Equipo(final int id) {

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_POSTULANTES+id)
                        .build();

                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());

                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        ;
                        Postulante data=new Postulante(object.getInt("ID"),
                                object.getString("NUM_INSCRIPCION"),
                                object.getString("APELLIDOS"),
                                object.getString("NOMBRES"),
                                object.getString("F_NACIM"),
                                object.getInt("EDAD"),
                                object.getString("CATEGORIA"),
                                object.getString("DOMICILIO"),

                                object.getInt("TELEFONOS"),
                                object.getString("EMAIL"),
                                object.getString("NOMBRE_POS")
                        );
                        LISTA_POSTULANTES.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println(e);
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
                progressDialog.dismiss();
                adapterPos.notifyDataSetChanged();
            }
        };
        task.execute();
    }*/
}
