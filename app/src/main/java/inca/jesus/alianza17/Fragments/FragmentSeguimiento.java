package inca.jesus.alianza17.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.Activity_Principal;
import inca.jesus.alianza17.Activities.B1_ListaSeguimiento;
import inca.jesus.alianza17.Activities.B2_Evaluacion2;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Adapters.AdapterDeportistas;
import inca.jesus.alianza17.Adapters.AdapterDeportistas2;
import inca.jesus.alianza17.Adapters.AdapterEva2;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.Clases.Eva2;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FragmentSeguimiento extends Fragment implements SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener {

    private RecyclerView recyclerDepor;
    private LinearLayoutManager linearLayout;
    private AdapterDeportistas2 adapterDepor;
    List<Deportista> LISTA_DEP;
    Context mContext;
    public int cod=0;
    LinearLayout l1,l2;
    Deportista TEMP_DE;
    MenuItem add;
    MenuItem searchItem;
    Button ant;
    ProgressDialog progressDialog;
    LinearLayout l3,l4;

    public List<Eva2> dataEV2;
    private RecyclerView recyclerEV2;
    private AdapterEva2 adapterEquipo_EV2;
    public FragmentSeguimiento() {
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        LISTA_DEP=new ArrayList<>();
        TEMP_DE=new Deportista();
        dataEV2=new ArrayList<>();
        listar_depor();
        System.out.println("Inca : listar ");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_seguimiento, container, false);
        l3=(LinearLayout)v.findViewById(R.id.panel_vacio_k);
        l4=(LinearLayout)v.findViewById(R.id.panel_vacio_kk);
        variables(v);

        modulo_recycler();
        modulos();
        return v;
    }
    private void variables(View v) {
        recyclerDepor=(RecyclerView)v.findViewById(R.id.recycler_deportistas);
        recyclerEV2=(RecyclerView)v.findViewById(R.id.recycler_evaluaciones2);
        l1=(LinearLayout)v.findViewById(R.id.linea_lista_postulantes);
        l2=(LinearLayout)v.findViewById(R.id.linea_lista_evaluaciones2);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        ant=(Button)v.findViewById(R.id.anterior_boton);

        ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
                add.setVisible(false);
                searchItem.setVisible(true);
            }
        });


    }
    private void modulos() {
    adapterDepor.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();

            if(adapterDepor.getItemCount()==0){
                l4.setVisibility(View.VISIBLE);
                l1.setVisibility(View.GONE);
            }else{
                l4.setVisibility(View.GONE);
                l1.setVisibility(View.VISIBLE);

                if(adapterDepor.isO1()==true){
                    cod=adapterDepor.RecuSelect();
                    System.out.println("Inca : modulo 1 ");
                    modulo_informacion();
                    adapterDepor.setO1(false);
                }
                if(adapterDepor.isO2()==true){
                    cod=adapterDepor.RecuSelect();
                    System.out.println("Inca : modulo 2 ");
                    modulo_evaluaciones();
                    adapterDepor.setO2(false);
                }
            }
        }
    });

    }
    private void modulo_evaluaciones() {
        dataEV2.clear();

        l1.setVisibility(View.GONE);
        l2.setVisibility(View.VISIBLE);
        add.setVisible(true);
        searchItem.setVisible(false);

        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterEquipo_EV2=new AdapterEva2(mContext,dataEV2, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });
        recyclerEV2.setAdapter( adapterEquipo_EV2);
        recyclerEV2.setLayoutManager(linearLayout);
        listar_eva2(String.valueOf(cod));

        adapterEquipo_EV2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(adapterEquipo_EV2.getItemCount()==0){
                    l3.setVisibility(View.VISIBLE);
                    recyclerEV2.setVisibility(View.GONE);
                }else{
                    l3.setVisibility(View.GONE);
                    recyclerEV2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void modulo_informacion() {
       System.out.println("Inca: modulo informacion");
        TEMP_DE=Encontrar_De(cod);
        System.out.println("Inca: TEMP DEPORTISTA:"+TEMP_DE.getNom()+" "+TEMP_DE.getApe());
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View dialoglayout4 = inflater.inflate(R.layout.info_deportista2, null);

        final TextView d1=(TextView)dialoglayout4.findViewById(R.id.de_1);
        final TextView d2=(TextView)dialoglayout4.findViewById(R.id.de_2);
        final TextView d3=(TextView)dialoglayout4.findViewById(R.id.de_3);
        final TextView d4=(TextView)dialoglayout4.findViewById(R.id.de_4);
        final TextView d5=(TextView)dialoglayout4.findViewById(R.id.de_5);
        final TextView d6=(TextView)dialoglayout4.findViewById(R.id.de_6);
        final TextView d7=(TextView)dialoglayout4.findViewById(R.id.de_7);
        final TextView d8=(TextView)dialoglayout4.findViewById(R.id.de_8);
        final TextView d9=(TextView)dialoglayout4.findViewById(R.id.de_9);

        d1.setText(TEMP_DE.getNom()+" "+TEMP_DE.getApe());
        d2.setText(TEMP_DE.getF_nac());
        d3.setText(TEMP_DE.getNaciona());
        d4.setText(TEMP_DE.getLug());
        d5.setText(String.valueOf(TEMP_DE.getTelf()));
        d6.setText(TEMP_DE.getEmail());
        d7.setText(TEMP_DE.getLiga());
        d8.setText(TEMP_DE.getCate());
        d9.setText(TEMP_DE.getCreador());
        AlertDialog.Builder builder4 = new AlertDialog.Builder(mContext);
        builder4.setView(dialoglayout4);
        builder4.show();

    }
    private Deportista Encontrar_De(int cod2) {
    Deportista tem=new Deportista();

        for(int i=0;i<LISTA_DEP.size();i++){
            if(LISTA_DEP.get(i).getId()==cod2){
                tem=LISTA_DEP.get(i);
                System.out.println("Inca : Deortista Encontrado!!");
            }
        }
        return tem;
    }
    private void modulo_recycler() {
        System.out.println("Inca : recycler ");
        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterDepor = new AdapterDeportistas2(mContext,LISTA_DEP, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });

        recyclerDepor.setAdapter(adapterDepor);
        recyclerDepor.setLayoutManager(linearLayout);

    }
    private void listar_depor() {

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
                        LISTA_DEP.add(data);
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
                progressDialog.dismiss();
                System.out.println("Inca : Listado correcto" );
                adapterDepor.notifyDataSetChanged();
            }
        };
        task.execute();
    }
    private void listar_eva2(final String id) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_EVALUACION2+id)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);

                        Eva2 dat=new Eva2(
                                object.getInt("ID_VALORACION2"),
                                object.getString("COMPETENCIA"),
                                object.getString("RIVAL"),
                                object.getInt("GOLES"),
                                object.getInt("T_JUGADO"),
                                object.getInt("TOTAL"));

                        dataEV2.add(dat);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Inca: Error IO: "+e);
                }catch (JSONException e){
                    System.out.println("Inca: Error: "+e);
                }
                return null;
            }
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Evaluaciones:");
                progressDialog.setMessage("Buscando Evaluaciones....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid){
                adapterEquipo_EV2.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        };
        task.execute();
    }
    public void onDetach() {
        super.onDetach();
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Buscar");

        add=menu.findItem(R.id.action_add);
        add.setVisible(false);
        add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent = new Intent(mContext,B2_Evaluacion2.class);
                DataServer.COD=cod;
                mContext.startActivity(intent);

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
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        List<Deportista> filteredValues = new ArrayList<Deportista>(LISTA_DEP);
        for (Deportista value : LISTA_DEP) {
            if (!value.getNom().toLowerCase().startsWith(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterDepor = new AdapterDeportistas2(mContext,filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerDepor.setAdapter(adapterDepor);
        recyclerDepor.setLayoutManager(linearLayout);

        return false;
    }
    public void resetSearch() {
        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterDepor = new AdapterDeportistas2(mContext,LISTA_DEP, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerDepor.setAdapter(adapterDepor);
        recyclerDepor.setLayoutManager(linearLayout);
        modulos();
    }


}
