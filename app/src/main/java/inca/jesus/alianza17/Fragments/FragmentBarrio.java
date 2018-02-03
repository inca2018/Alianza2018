package inca.jesus.alianza17.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.C1_ListaPostulantes;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.Adapters.AdapterEventos;
import inca.jesus.alianza17.Clases.Eventos;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FragmentBarrio extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    private RecyclerView recyclerEvento;
    private LinearLayoutManager linearLayout;
    private AdapterEventos adapterEvento;
    private ArrayList<Eventos> data_list;
    public Context mContext;
    ProgressDialog progressDialog;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v= inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerEvento=(RecyclerView)v.findViewById(R.id.lista_eventos);

        data_list = new ArrayList<>();
        linearLayout = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        adapterEvento = new AdapterEventos(mContext, data_list, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

                if(data_list.get(position).getStatus()==1){
                    Intent intent= new Intent(getActivity(),C1_ListaPostulantes.class);
                    intent.putExtra("id_eventos",String.valueOf(data_list.get(position).getId_evento()));
                    System.out.println("Dato id_evento:"+String.valueOf(data_list.get(position).getId_evento()));
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext, "Solicitar Habilitacion del evento al administrador!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        recyclerEvento.setAdapter(adapterEvento);
        recyclerEvento.setLayoutManager(linearLayout);

        System.out.println(" Paso ---- Frag!!! ");

        listar_eventos();
        return v;
    }
    private void listar_eventos() {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.LISTAR_EVENTOS)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);

                        Eventos data=new Eventos ( object.getInt("ID_EVENTO"),
                                object.getString("NOM_EVENTO"),
                                object.getString("FECHA_CREACION"),
                                object.getString("FECHA_EJECUCION"),
                                object.getInt("STATUS"),
                                object.getString("NOMBRE"));
                        data_list.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("ERROR IO:"+e);
                }catch (JSONException e){
                    System.out.println("ERROR:"+e);
                }
                return null;
            }
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Eventos");
                progressDialog.setMessage("Listando Eventos....");
                progressDialog.show();
            }
            protected void onPostExecute(Void aVoid)
            {
                progressDialog.dismiss();
                for(int i=0;i<data_list.size();i++){
                    System.out.println(" Paso ---- for!!! "+data_list.get(i).getTitulo_evento());
                }
                adapterEvento.notifyDataSetChanged();
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
        searchView.setQueryHint("Search");

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
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

        List<Eventos> filteredValues = new ArrayList<Eventos>(data_list);
        for (Eventos value : data_list) {
            if (!value.getTitulo_evento().toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        linearLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapterEvento = new AdapterEventos(getActivity(),filteredValues, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerEvento.setAdapter(adapterEvento);
        recyclerEvento.setLayoutManager(linearLayout);

        return false;
    }
    public void resetSearch() {
        linearLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        adapterEvento = new AdapterEventos(getActivity(),data_list, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerEvento.setAdapter(adapterEvento);
        recyclerEvento.setLayoutManager(linearLayout);
    }

}
