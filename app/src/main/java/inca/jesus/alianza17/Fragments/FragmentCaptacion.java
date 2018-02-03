package inca.jesus.alianza17.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import inca.jesus.alianza17.Activities.A1_Evaluacion;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Activities.B1_ListaSeguimiento;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.Adapters.AdapterDeportistas;
import inca.jesus.alianza17.Clases.Deportista;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentCaptacion extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{
    private RecyclerView recyclerDepor;
    private LinearLayoutManager linearLayout;
    private AdapterDeportistas adapterDepor;
    ProgressDialog progressDialog;
    public ArrayList<Deportista> data2;
    public Context mContext;
    LinearLayout l1,l2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_opcion1, container, false);
        recyclerDepor=(RecyclerView)v.findViewById(R.id.lista_deportistas);
        l1=(LinearLayout)v.findViewById(R.id.panel_lista);
        l2=(LinearLayout)v.findViewById(R.id.panel_vacio);
        data2 = new ArrayList<>();

        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterDepor = new AdapterDeportistas(mContext,data2, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {
            }
        });

        recyclerDepor.setAdapter(adapterDepor);
        recyclerDepor.setLayoutManager(linearLayout);

        listar_Depor();

        adapterDepor.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                  System.out.println("Inca:"+adapterDepor.getItemCount());
                if(adapterDepor.getItemCount()==0){
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.VISIBLE);
                }else{
                    l2.setVisibility(View.GONE);
                    l1.setVisibility(View.VISIBLE);
                }
            }
        });



         return v;
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
                        data2.add(data);
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
                System.out.println("Inca:"+adapterDepor.getItemCount());
            }
        };
        task.execute();
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

                Intent intent = new Intent(getActivity(),A1_Evaluacion.class);
                System.out.println("Inca : nueva evaluacion" );
                startActivity(intent);
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

        List<Deportista> filteredValues = new ArrayList<Deportista>(data2);
        for (Deportista value : data2) {
            if (!value.getNom().toLowerCase().startsWith(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterDepor = new AdapterDeportistas(mContext,filteredValues, new RecyclerViewOnItemClickListener2() {
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
        adapterDepor = new AdapterDeportistas(mContext,data2, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerDepor.setAdapter(adapterDepor);
        recyclerDepor.setLayoutManager(linearLayout);
    }

}
