package inca.jesus.alianza17.Fragments;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
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
import inca.jesus.alianza17.Adapters.AdapterMantJugadores;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.MantenimientoJugadores;
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Perfil_Insertar;
import inca.jesus.alianza17.ServerConexion.Plantel_Insertar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentJugadores extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {
    RecyclerView recycler;
    AdapterMantJugadores adapter;
    LinearLayoutManager linear;
    public Context mContext;
    TextView t1;
    EditText e1,e2,e3;
    Button b1;
    LinearLayout l1,l2,l3;
    int cod=0;
    MantenimientoJugadores temp;
    List<Plantel> LIST_JUGA;
    ProgressDialog  progressDialog;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;
    EditText ud1,ud2,ud3,ud4,ud5,ud6,ud7,ud8,ud9;
    Plantel Temp;
    ImageView Calendario,Calendario2;
    int dia,mes,ano;
    Button g1,g2;
    DatePickerDialog.OnDateSetListener d1,d2;

    Calendar dateTime = Calendar.getInstance();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LIST_JUGA=new ArrayList<>();
        listar_jugadores();


    }
    public FragmentJugadores() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_jugadores, container, false);
        recycler=(RecyclerView)v.findViewById(R.id.recycler_mant_juga);
        variables(v);
        recycler_jugadores();
        Opciones();
        Nuevo_jugador();

        Fecha_add();

        d1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel1(dayOfMonth,monthOfYear,year);
            }
        };

        d2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateTextLabel2(dayOfMonth,monthOfYear,year);
            }
        };

        return v;
    }
    private void Fecha_add() {
        Calendario2.setOnClickListener(new View.OnClickListener() {
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
                        ed2.setText(dia+"/"+mes+"/"+year);
                    }
                } ,dia,mes,ano);
                de.show();*/
                updateDate2();
            }

        });

    }
    private void Opciones() {
       adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
           @Override
           public void onChanged() {
               super.onChanged();

               if(adapter.isSelecto()==true){
                   l1.setVisibility(View.GONE);
                   l2.setVisibility(View.VISIBLE);
                   l3.setVisibility(View.GONE);

                   if(adapter.recu_Codigo()!=0){
                       cod=adapter.recu_Codigo();

                       for(int i=0;i<LIST_JUGA.size();i++){
                           if(LIST_JUGA.get(i).getId()==cod){
                               Temp=LIST_JUGA.get(i);
                           }
                       }

                       if(Temp.getId()!=0){
                           ud1.setText(Temp.getNom_completo());
                           ud2.setText(Temp.getF_naci());
                           ud3.setText(String.valueOf(Temp.getEdad()));
                           ud4.setText(String.valueOf(Temp.getDni()));
                           ud5.setText(Temp.getNacionalidad());
                           ud6.setText(Temp.getDomicilio());
                           ud7.setText(Temp.getLocalidad());
                           ud8.setText(String.valueOf(Temp.getTelef()));
                           ud9.setText(Temp.getEmail());
                       }

                       Calendario.setOnClickListener(new View.OnClickListener() {
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
                                        ud2.setText(dia+"/"+mes+"/"+year);
                                   }
                               } ,dia,mes,ano);
                               de.show();*/
                              updateDate();
                           }
                       });


                       g2.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               Actualizar_jugador(Temp);
                               l1.setVisibility(View.VISIBLE);
                               l2.setVisibility(View.GONE);
                               l3.setVisibility(View.GONE);
                           }
                       });
                   }else{
                       System.out.println("Inca no entro id recuCodigo ");
                   }
                   adapter.setSelecto(false);
               }
           }
       });

    }
    private void Nuevo_jugador() {

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fecha=Recu_Fecha();

                /*
                Plantel temp=new Plantel(
                        1,
                        1,
                        ed1.getText().toString(),
                        ed2.getText().toString(),
                        Integer.parseInt(ed3.getText().toString()),
                        Integer.parseInt(ed4.getText().toString()),
                        ed5.getText().toString(),
                        ed6.getText().toString(),
                        ed7.getText().toString(),
                        Integer.parseInt(ed8.getText().toString()),
                        ed9.getText().toString(),
                        fecha.toString(),
                        0);*/

                Plantel temp=new Plantel(
                        1,
                        1,
                        "Jesus Inca Cardenas",
                        "18 de mayo",
                        24,
                        47040087,
                        "Peruana",
                        "domicilio",
                        "localidad",
                        99999999,
                        "emal",
                        "fecha ",
                        1,0);

                Inser_Jugadro_BD(temp);
                adapter.notifyDataSetChanged();
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");
                ed7.setText("");
                ed8.setText("");
                ed9.setText("");

                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                l3.setVisibility(View.GONE);
            }
        });
    }
    private void Inser_Jugadro_BD(Plantel temp) {
        LIST_JUGA.clear();
        final String d1=String.valueOf(temp.getId_origen());
        final String d2=ed1.getText().toString();
        final String d3=ed2.getText().toString();
        final String d4=String.valueOf(ed3.getText().toString());
        final String d5=String.valueOf(ed4.getText().toString());
        final String d6=ed5.getText().toString();
        final String d7=ed6.getText().toString();
        final String d8=ed7.getText().toString();
        final String d9=String.valueOf(ed8.getText().toString());
        final String d10=ed9.getText().toString();
        final String d11=Recu_Fecha();
        final String d12=String.valueOf(0);

        System.out.println("Inca : datos: "+d1+"  "+d2+"  "+d3+" "+ d4 + "  "+d5+ "  "+d6+ "  "+d7+ "  "+d8+ "  "+d9+ "  "+d10+ "  "+d11+ "  "+d12);
      /*
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Jugador Insertado");
                    } else {
                        System.out.println("Inca: Jugador no Insertado");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error JSON  "+ e);
                }
            }
        };
        Plantel_Insertar Server = new Plantel_Insertar(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(Server);
        */
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.PLANTEL_INSERT +
                                "d1="+d1+"&&" +
                                "d2="+d2+"&&" +
                                "d3="+d3+"&&" +
                                "d4="+d4+"&&" +
                                "d5="+d5+"&&" +
                                "d6="+d6+"&&" +
                                "d7="+d7+"&&" +
                                "d8="+d8+"&&" +
                                "d9="+d9+"&&" +
                                "d10="+d10+"&&" +
                                "d11="+d11+"&&" +
                                "d12="+d12)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONObject dato=new JSONObject(response.body().string());

                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    Log.e("Inca JSON Parser", "Inca Error parsing data " + e.toString());
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
            }
            protected void onPostExecute(Void aVoid){
                Toast.makeText(mContext, "!Jugador Registrado con Exito!", Toast.LENGTH_SHORT).show();
            }
        };
        task.execute();
        listar_jugadores();
    }
    private void recycler_jugadores() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantJugadores(mContext,LIST_JUGA,new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
    }
    private void variables(View v) {

        l1=(LinearLayout)v.findViewById(R.id.panel_juga_recycler);
        l2=(LinearLayout)v.findViewById(R.id.panel_juga_edit);
        l3=(LinearLayout)v.findViewById(R.id.panel_juga_add);
        g1=(Button)v.findViewById(R.id.edit_juga_guardar2);
        g2=(Button)v.findViewById(R.id.edit2_juga_guardar2);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        temp=new MantenimientoJugadores();

        ed1=(EditText)v.findViewById(R.id.edit_jugador_1);
        ed2=(EditText)v.findViewById(R.id.edit_jugador_2);
        ed3=(EditText)v.findViewById(R.id.edit_jugador_3);
        ed4=(EditText)v.findViewById(R.id.edit_jugador_4);
        ed5=(EditText)v.findViewById(R.id.edit_jugador_5);
        ed6=(EditText)v.findViewById(R.id.edit_jugador_6);
        ed7=(EditText)v.findViewById(R.id.edit_jugador_7);
        ed8=(EditText)v.findViewById(R.id.edit_jugador_8);
        ed9=(EditText)v.findViewById(R.id.edit_jugador_9);

        ud1=(EditText)v.findViewById(R.id.edit2_jugador_1);
        ud2=(EditText)v.findViewById(R.id.edit2_jugador_2);
        ud3=(EditText)v.findViewById(R.id.edit2_jugador_3);
        ud4=(EditText)v.findViewById(R.id.edit2_jugador_4);
        ud5=(EditText)v.findViewById(R.id.edit2_jugador_5);
        ud6=(EditText)v.findViewById(R.id.edit2_jugador_6);
        ud7=(EditText)v.findViewById(R.id.edit2_jugador_7);
        ud8=(EditText)v.findViewById(R.id.edit2_jugador_8);
        ud9=(EditText)v.findViewById(R.id.edit2_jugador_9);
        Calendario=(ImageView)v.findViewById(R.id.calendario);
        Calendario2=(ImageView)v.findViewById(R.id.calendario2);
    }
    private void Actualizar_jugador(Plantel temp) {
        LIST_JUGA.clear();
        final String cod=String.valueOf(temp.getId());
        final String d1=String.valueOf(temp.getId_origen());
        final String d2=ud1.getText().toString();
        final String d3=ud2.getText().toString();
        final String d4=ud3.getText().toString();
        final String d5=ud4.getText().toString();
        final String d6=ud5.getText().toString();
        final String d7=ud6.getText().toString();
        final String d8=ud7.getText().toString();
        final String d9=ud8.getText().toString();
        final String d10=ud9.getText().toString();
        final String d11=temp.getF_ingreso();
        final String d12=String.valueOf(temp.getSelect());

        System.out.println("Inca : datos: "+d1+"  "+d2+"  "+d3+" "+ d4 + "  "+d5+ "  "+d6+ "  "+d7+ "  "+d8+ "  "+d9+ "  "+d10+ "  "+d11+ "  "+d12);

        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.PLANTEL_UPDATE +
                                "cod="+cod+"&&" +
                                "d1="+d1+"&&" +
                                "d2="+d2+"&&" +
                                "d3="+d3+"&&" +
                                "d4="+d4+"&&" +
                                "d5="+d5+"&&" +
                                "d6="+d6+"&&" +
                                "d7="+d7+"&&" +
                                "d8="+d8+"&&" +
                                "d9="+d9+"&&" +
                                "d10="+d10+"&&" +
                                "d11="+d11+"&&" +
                                "d12="+d12)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONObject dato=new JSONObject(response.body().string());

                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    Log.e("Inca JSON Parser", "Inca Error parsing data " + e.toString());
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
            }
            protected void onPostExecute(Void aVoid){
                Toast.makeText(mContext, "!Jugador Actualizado con Exito!", Toast.LENGTH_SHORT).show();
            }
        };
        task.execute();
        listar_jugadores();
    }
    private MantenimientoJugadores RecuJugador(int cod) {

           MantenimientoJugadores t=new MantenimientoJugadores();

        for(int i=0;i<MantenimientoJugadores.PLANTEL.size();i++){
            if(MantenimientoJugadores.PLANTEL.get(i).getId()==cod){
                t=MantenimientoJugadores.PLANTEL.get(i);
            }
        }
        return t;
    }
    public void onDetach() {
        super.onDetach();
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Buscar Jugador");
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
        List<Plantel> filteredValues = new ArrayList<Plantel>(LIST_JUGA);
        for (Plantel value : LIST_JUGA) {
            if (!value.getNom_completo().toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantJugadores(mContext,filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
        Opciones();
        return false;

    }
    public void resetSearch() {
        linear = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapter = new AdapterMantJugadores(mContext,LIST_JUGA, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linear);
        Opciones();
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
                        LIST_JUGA.add(data);
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
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
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
    private void updateDate(){
        new DatePickerDialog(getActivity(),d1,1999,0,1).show();
    }
    private void updateDate2(){
        new DatePickerDialog(getActivity(),d2,1999,0,1).show();
    }

    private void updateTextLabel1(int dia,int mes3,int ano){
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
        ud2.setText(dia2+"/"+mes+"/"+ano);
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
        ed2.setText(dia2+"/"+mes+"/"+ano);
    }
}
