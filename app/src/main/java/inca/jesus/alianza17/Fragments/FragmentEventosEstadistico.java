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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
import inca.jesus.alianza17.Adapters.AdapterEdicionEquipo;
import inca.jesus.alianza17.Adapters.AdapterEventos_Camp;
import inca.jesus.alianza17.Adapters.AdapterFechas;
import inca.jesus.alianza17.Adapters.AdapterPerfiles;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Eventos_Camp;
import inca.jesus.alianza17.Clases.Fechas;
import inca.jesus.alianza17.Clases.MisEquipos;
import inca.jesus.alianza17.Clases.MisEquipos2;
import inca.jesus.alianza17.Clases.Oponente;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Categoria_Eliminar;
import inca.jesus.alianza17.ServerConexion.Evento_Camp_Eliminar;
import inca.jesus.alianza17.ServerConexion.Evento_Camp_Insertar;
import inca.jesus.alianza17.ServerConexion.Evento_Camp_Registro_Equi;
import inca.jesus.alianza17.ServerConexion.Evento_Camp_Update;
import inca.jesus.alianza17.ServerConexion.Fecha_Insertar;
import inca.jesus.alianza17.ServerConexion.MiEquipo_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEventosEstadistico extends Fragment implements  MenuItem.OnActionExpandListener  {

    RecyclerView recycler_eventos,recycler_editar,recycler_fechas;
    AdapterEventos_Camp adapter;
    AdapterEdicionEquipo adapter2;
    AdapterFechas adapter3;
    LinearLayoutManager linear;
    List<Eventos_Camp> LISTA_EVENTOS;
    List<Oponente> LISTA_OPO;
    List<Fechas> LISTA_FECHAS;
    public Context mContext;
    ProgressDialog progressDialog;
    LinearLayout l1,l2,l3,l4,l5;
    Spinner s_add,s_opo;
    List<MisEquipos2> LISTA_MISEQUIPOS;
    List<Plantel> LISTA_JUGADORES;
    String[] TEMP2,TEMP3;
    Button ev_continuar,ev_guardar;
    EditText e1,e2,e3,e4;
    ImageView cal1,cal2;
    int dia,mes,ano;
    String Nom_Seleccionado;
    int Cod_Seleccion,Cod_opo;
    int Cod_Evento_Seleccion;
    Button nueva_fecha;
    Button guardar_fecha;
    EditText ee1,ee2;
    ImageView cale1;
    int Cod_MIequ;
    Button regre_eventos;

    String Nom_Miequi="";

    DatePickerDialog.OnDateSetListener d1,d2,d3;
    Calendar dateTime = Calendar.getInstance();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LISTA_EVENTOS=new ArrayList<>();
        LISTA_MISEQUIPOS=new ArrayList<>();
        LISTA_JUGADORES=new ArrayList<>();
        LISTA_OPO=new ArrayList<>();
        LISTA_FECHAS=new ArrayList<>();
        listar_eventos();
    }
    public FragmentEventosEstadistico() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_eventos_estadistico, container, false);
        variables(v);
        Activar_recycler();
        listar_misEquipos();
        listar_oponente();
        Btn_Continuar();
        Opciones();

        return v;
    }
    private void listar_oponente() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.OPONENTES_LISTAR)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Oponente data=new Oponente (
                                object.getInt("ID"),
                                object.getString("NOMBRES"),
                                object.getString("DISTRITO"),
                                object.getInt("SS"),
                                object.getInt("ID_CREADOR"),
                                object.getString("F_CREACION")
                                );
                        LISTA_OPO.add(data);
                    }
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
            }
            protected void onPostExecute(Void aVoid){
                TEMP3=new String[LISTA_OPO.size()];
                for(int i=0;i<LISTA_OPO.size();i++){
                    TEMP3[i]=LISTA_OPO.get(i).getNombres();
                }
                ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,TEMP3);
                s_opo.setAdapter(adapter_arr);
            }
        };
        task.execute();

    }
    private void Opciones() {

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                if (adapter.isSelect() == true) {
                    LISTA_FECHAS.clear();
                    Opcion_Fechas();

                    adapter.setSelect(false);
                }
                if (adapter.isSelect2() == true) {

                    Opcion_Eliminar();
                    adapter.setSelect2(false);
                }
            }
        });
    }
    private void Opcion_Eliminar() {
        Cod_Evento_Seleccion = adapter.RecuSelect();

        for(int i=0;i<LISTA_EVENTOS.size();i++){
            if(LISTA_EVENTOS.get(i).getId()==Cod_Evento_Seleccion){
                Nom_Miequi=LISTA_EVENTOS.get(i).getEquipo_asignado();
                System.out.println("Inca: Encontrado cod evento :equipo : "+Nom_Miequi);
            }
        }
        for(int j=0;j<LISTA_MISEQUIPOS.size();j++){
            if(LISTA_MISEQUIPOS.get(j).getNombre().equalsIgnoreCase(Nom_Miequi)){
                Cod_MIequ=LISTA_MISEQUIPOS.get(j).getId();
                System.out.println("Inca: Encontrado cod equipo:"+Cod_MIequ);
            }
            System.out.println("Inca: Equipo :"+LISTA_MISEQUIPOS.get(j).getId());
        }


        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Eliminar")
                .setMessage("Eliminara todos los Registros agregados al Evento.\n" +
                        "¿Desea Eliminar Evento?")
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Eliminar_Evento_BD(Cod_Evento_Seleccion,Cod_MIequ);
                                for (int i = 0; i < LISTA_EVENTOS.size(); i++) {
                                    if (LISTA_EVENTOS.get(i).getId() == Cod_Evento_Seleccion) {
                                        LISTA_EVENTOS.remove(i);
                                        adapter.notifyDataSetChanged();
                                        Toast.makeText(mContext, "Evento Eliminado!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                //my_Data.remove(position);
                                //notifyDataSetChanged();
                                //Toast.makeText(context, "Categoria Eliminada", Toast.LENGTH_SHORT).show();
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
    private void Opcion_Fechas() {
        Cod_Evento_Seleccion = adapter.RecuSelect();
        //Toast.makeText(mContext, "FECHAS " + Cod_Evento_Seleccion, Toast.LENGTH_SHORT).show();

        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.VISIBLE);
        l5.setVisibility(View.GONE);


        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapter3 = new AdapterFechas(mContext, LISTA_FECHAS, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler_fechas.setAdapter(adapter3);
        recycler_fechas.setLayoutManager(linear);

        listar_fechas_evento(Cod_Evento_Seleccion);

        adapter3.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapter3.isSelect()==true){

                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                l5.setVisibility(View.VISIBLE);

                adapter3.setSelect(false);
                }
            }
        });
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
    private void Eliminar_Evento_BD(int cod_evento_seleccion,int codMi) {
        String id=String.valueOf(cod_evento_seleccion);
        String id2=String.valueOf(codMi);
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
                    System.out.println("Inca: error eliminar evento JSON "+ e);
                }
            }
        };
        Evento_Camp_Eliminar Server = new Evento_Camp_Eliminar(id,id2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);

    }
    private void variables(View v) {
        recycler_eventos=(RecyclerView)v.findViewById(R.id.recycler_evento_campeonatos);
        recycler_editar=(RecyclerView)v.findViewById(R.id.recycler_editar_equipo);
        recycler_fechas=(RecyclerView)v.findViewById(R.id.recycler_Fechas);

        regre_eventos=(Button)v.findViewById(R.id.bn_mostrar_eventos);
        ee1=(EditText)v.findViewById(R.id.fecha_realizar);
        ee2=(EditText)v.findViewById(R.id.num_fecha);
        cale1=(ImageView)v.findViewById(R.id.fecha_calendar);

        l1=(LinearLayout)v.findViewById(R.id.recycler_eventos);
        l2=(LinearLayout)v.findViewById(R.id.panel_nuevo_evento);
        l3=(LinearLayout)v.findViewById(R.id.panel_edit_equipos);
        l4=(LinearLayout)v.findViewById(R.id.panel_gestion_Fechas);
        l5=(LinearLayout)v.findViewById(R.id.panel_nueva_fecha);

        nueva_fecha=(Button)v.findViewById(R.id.bn_nueva_fecha);
        guardar_fecha=(Button)v.findViewById(R.id.guardar_fecha);


        s_add=(Spinner)v.findViewById(R.id.spinner_mis_equipos);
        s_opo=(Spinner)v.findViewById(R.id.spinner_oponente);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
        ev_guardar=(Button)v.findViewById(R.id.ev_guardar_datos);
        ev_continuar=(Button)v.findViewById(R.id.ev_continuar);
        e1=(EditText)v.findViewById(R.id.nuevo_ev_1);
        e2=(EditText)v.findViewById(R.id.nuevo_ev_2);
        e3=(EditText)v.findViewById(R.id.nuevo_ev_3);
        e4=(EditText)v.findViewById(R.id.nuevo_ev_4);
        cal1=(ImageView)v.findViewById(R.id.ev_calendario1);
        cal2=(ImageView)v.findViewById(R.id.ev_calendario2);

        boton_regreso_eventos();


        d1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel2(dayOfMonth,monthOfYear,year);
            }
        };
        d2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel10(dayOfMonth,monthOfYear,year);
            }
        };
        d3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel11(dayOfMonth,monthOfYear,year);
            }
        };
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* final Calendar c=Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);
                DatePickerDialog de=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dia,mes;
                        int mes2=month+1;
                        if(dayOfMonth<10){
                            dia="0"+dayOfMonth;
                        }else {
                            dia=String.valueOf(dayOfMonth);
                        }
                        if(mes2<10){
                            mes="0"+mes2;
                        }else {
                            mes=String.valueOf(mes2);
                        }
                        e2.setText(dia+"/"+mes+"/"+year);
                    }
                } ,dia,mes,ano);
                de.show();*/

                updateDate10();
            }
        });

        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Calendar c=Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);
                DatePickerDialog de=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dia,mes;
                        int mes2=month+1;
                        if(dayOfMonth<10){
                            dia="0"+dayOfMonth;
                        }else {
                            dia=String.valueOf(dayOfMonth);
                        }
                        if(mes2<10){
                            mes="0"+mes2;
                        }else {
                            mes=String.valueOf(mes2);
                        }
                        e3.setText(dia+"/"+mes+"/"+year);
                    }
                } ,dia,mes,ano);
                de.show();*/
                updateDate11();
            }
        });
        cale1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Calendar c=Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);
                DatePickerDialog de=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dia,mes;
                        int mes2=month+1;
                        if(dayOfMonth<10){
                            dia="0"+dayOfMonth;
                        }else {
                            dia=String.valueOf(dayOfMonth);
                        }
                        if(mes2<10){
                            mes="0"+mes2;
                        }else {
                            mes=String.valueOf(mes2);
                        }
                        ee1.setText(dia+"/"+mes+"/"+year);
                        System.out.println("fecha seleccionada : "+ee1.getText());
                    }
                } ,dia,mes,ano);
                de.show();*/
                updateDate2();
            }
        });

        s_add.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Inca extra: "+LISTA_MISEQUIPOS.get(position).getId()+" "+LISTA_MISEQUIPOS.get(position).getNombre());
                Nom_Seleccionado=LISTA_MISEQUIPOS.get(position).getNombre();
                Cod_Seleccion=LISTA_MISEQUIPOS.get(position).getId();
                System.out.println("Inca: Nombre"+Nom_Seleccionado+"  cod: "+Cod_Seleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s_opo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cod_opo=LISTA_OPO.get(position).getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
         boton_nueva_fecha();
         boton_guardar_fecha();
    }
    private void boton_guardar_fecha() {
        guardar_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LISTA_FECHAS.clear();

                System.out.println("Inca : cod_evento : "+Cod_Evento_Seleccion+" cod_opo: "+Cod_opo +"Cod _fecha:"
                        +Fechas.COD_FECHA+"   fecha realizar: "+ee1.getText().toString());

                String cod=String.valueOf(Cod_Evento_Seleccion);
                String d1=String.valueOf(Fechas.COD_FECHA);
                String d2=String.valueOf(Cod_opo);
                String d3=ee1.getText().toString();
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.VISIBLE);
                l5.setVisibility(View.GONE);
                com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                System.out.println("Inca: FECHA Insertado");
                            } else {
                                System.out.println("Inca: FECHA no Insertado");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("Inca: error 2 JSON  "+ e);
                        }
                    }
                };
                Fecha_Insertar Server = new Fecha_Insertar(cod,d1,d2,d3, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(Server);
                ee1.setText("");
                ee2.setText("");
                s_opo.setSelection(0);
                listar_fechas_evento(Cod_Evento_Seleccion);
            }
        });
    }
    private void boton_nueva_fecha() {
        nueva_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                l1.setVisibility(View.GONE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                l5.setVisibility(View.VISIBLE);
            }
        });
    }
    private void boton_regreso_eventos() {
        regre_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
                l4.setVisibility(View.GONE);
                l5.setVisibility(View.GONE);
            }
        });
    }
    private void Btn_Continuar() {

    ev_continuar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            l1.setVisibility(View.GONE);
            l2.setVisibility(View.GONE);
            l3.setVisibility(View.VISIBLE);
            // lista de equipo - para editar su posicion ------
            linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
            adapter2 = new AdapterEdicionEquipo(mContext,LISTA_JUGADORES , new RecyclerViewOnItemClickListener2() {
                @Override
                public void onClick(View v, int position) {
                }
            });
            recycler_editar.setAdapter(adapter2);
            recycler_editar.setLayoutManager(linear);
            Listar_Categorias_Jugadores(Cod_Seleccion);
        }
    });

     ev_guardar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             LISTA_EVENTOS.clear();
             guardar_evento();
             actualizar_pos();
             //Registrar_DD();
             l1.setVisibility(View.VISIBLE);
             l2.setVisibility(View.GONE);
             l3.setVisibility(View.GONE);
             listar_eventos();
         }
     });
    }
    private void actualizar_pos() {

        for(int i=0;i<LISTA_JUGADORES.size();i++){
            System.out.println("Inca: Codigo juga: "+LISTA_JUGADORES.get(i).getId()+
                    "  Cod:POs "+LISTA_JUGADORES.get(i).getSelect()+
                    "   num:"+LISTA_JUGADORES.get(i).getNum());
            Actualizar_Posiciones(
                    Cod_Seleccion,LISTA_JUGADORES.get(i).getId(),
                    LISTA_JUGADORES.get(i).getSelect(),
                    LISTA_JUGADORES.get(i).getNum());
        }
    }
    private void guardar_evento() {
        String fecha=Recu_Fecha();

        String d1= e1.getText().toString().toUpperCase();
        String d2 =e2.getText().toString();
        String d3= e3.getText().toString();
        String d4= e4.getText().toString();
        String d5=String.valueOf(82);//creador
        String d6=String.valueOf(Cod_Seleccion);
        String d7=fecha;

        String r2=String.valueOf(Cod_Seleccion);


        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: EVENTO Insertado");
                    } else {
                        System.out.println("Inca: evento no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error INSER JSON  "+ e);
                }
            }
        };
        Evento_Camp_Insertar Server = new Evento_Camp_Insertar(d1,d2,d3,d4,d5,d6,d7,r2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
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
                progressDialog.setTitle("Campeonatos");
                progressDialog.setMessage("Listando Campeonatos....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();


    }
    private void Actualizar_Posiciones(int dd1, int dd2, int dd3,int dd4) {
        String d1=String.valueOf(dd1);//cod_ equipo
        String d2=String.valueOf(dd2);// cod:_futb
        String d3=String.valueOf(dd3);// pos
        String d4=String.valueOf(dd4);//num

        String r1= e1.getText().toString().toUpperCase();
        String r2=String.valueOf(Cod_Seleccion);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: EVENTO Insertado");
                    } else {
                        System.out.println("Inca: evento no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error ACTUALIAR POS JSON  "+ e);
                }
            }
        };
        Evento_Camp_Update Server = new Evento_Camp_Update(d1,d2,d3,d4,r1,r2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
    private void Registrar_DD() {

        String r1= e1.getText().toString().toUpperCase();
        String r2=String.valueOf(Cod_Seleccion);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: EVENTO Insertado");
                    } else {
                        System.out.println("Inca: evento no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: ERROR "+ e);
                }
            }
        };
        Evento_Camp_Registro_Equi Server = new Evento_Camp_Registro_Equi(r1,r2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
    }
    private void Listar_Categorias_Jugadores(final int cod) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.MIEQUIPO_LISTA_JUGADOR+cod)
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
                        LISTA_JUGADORES.add(data);
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
                        LISTA_MISEQUIPOS.add(data);
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
                TEMP2=new String[LISTA_MISEQUIPOS.size()];
                for(int i=0;i<LISTA_MISEQUIPOS.size();i++){
                    TEMP2[i]=LISTA_MISEQUIPOS.get(i).getNombre();
                }
                ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,TEMP2);
                s_add.setAdapter(adapter_arr);
            }
        };
        task.execute();
    }
    private void Activar_recycler() {

        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterEventos_Camp(mContext,LISTA_EVENTOS, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler_eventos.setAdapter(adapter);
        recycler_eventos.setLayoutManager(linear);
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu, menu);
        MenuItem add=menu.findItem(R.id.action_add);
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                l1.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
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
    private void updateDate2(){
        new DatePickerDialog(getActivity(),d1,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateDate10(){
        new DatePickerDialog(getActivity(),d2,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateDate11(){
        new DatePickerDialog(getActivity(),d3,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateTextLabel2(int dia,int mes3,int ano){
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
        ee1.setText(dia2+"/"+mes+"/"+ano);
    }
    private void updateTextLabel10(int dia,int mes3,int ano){
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
        e2.setText(dia2+"/"+mes+"/"+ano);
    }
    private void updateTextLabel11(int dia,int mes3,int ano){
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
        e3.setText(dia2+"/"+mes+"/"+ano);
    }
}
