package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Adapters.AdapterPostulante;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Postulante;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class C1_ListaPostulantes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;
    private AdapterPostulante adapterPostulante;
    private List<Postulante> data_list;
    LinearLayout linea;
    ImageView volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1__lista_postulantes);
        volver=(ImageView)findViewById(R.id.toolbar_boton_volver10);
        linea=(LinearLayout)findViewById(R.id.panel_vacio_lista);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(C1_ListaPostulantes.this,Activity_Principal.class);
                intent.putExtra("o","o20");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        linea.setVisibility(View.GONE);
        recyclerView=(RecyclerView)findViewById(R.id.lista_Equipo_Detalle);
        data_list = new ArrayList<>();
        linearLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        Extraer_Jugadores_de_Equipo(getIntent().getStringExtra("id_eventos"));

        adapterPostulante = new AdapterPostulante(this, data_list, new RecyclerViewOnItemClickListener2() {
            public void onClick(View v, int position) {

                Intent intent= new Intent(C1_ListaPostulantes.this,C2_ListaOpciones.class);
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",String.valueOf(data_list.get(position).getId()));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapterPostulante);
        recyclerView.setLayoutManager(linearLayout);
        adapterPostulante.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                if(adapterPostulante.getItemCount()==0){
                    linea.setVisibility(View.VISIBLE);
                }else{
                    recyclerView.setVisibility(View.VISIBLE);
                    linea.setVisibility(View.GONE);
                }
            }
        });
    }
    private void Extraer_Jugadores_de_Equipo(final String id) {

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
                                object.getString("FOTO"),
                                object.getString("NOMBRE_POS")
                        );
                        data_list.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println(e);
                }
                return null;
            }
            protected void onPostExecute(Void aVoid){
                adapterPostulante.notifyDataSetChanged();
            }
        };
        task.execute();
    }
    public void onBackPressed() {
        Intent intent= new Intent(C1_ListaPostulantes.this,Activity_Principal.class);
        intent.putExtra("o","o2");
        //intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
        startActivity(intent);
    }
}
