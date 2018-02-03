package inca.jesus.alianza17.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

import inca.jesus.alianza17.Adapters.AdapterEva2;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.Clases.Eva2;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class B1_ListaSeguimiento extends AppCompatActivity {

    private RecyclerView recyclerEV2;
    private LinearLayoutManager linearLayout;
    private AdapterEva2 adapterEquipo_EV2;
    public ArrayList<Eva2> dataEV2;
    TextView titulo_toolbar;
    ImageView agregar,retroceder;
    Deportista Depor;
    LinearLayout emptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b1_lista_seguimiento);

        Bundle extras=getIntent().getExtras();
        Depor=extras.getParcelable("Deportista");
        emptyView = (LinearLayout) findViewById(R.id.linear_vacio);
        recyclerEV2=(RecyclerView)findViewById(R.id.lista_ev2);
        dataEV2 = new ArrayList<>();

        titulo_toolbar=(TextView)findViewById(R.id.toolbar_titulo);
        titulo_toolbar.setText("LISTA DE SEGUIMIENTO");

        agregar=(ImageView)findViewById(R.id.toolbar_boton_agregar);
        retroceder=(ImageView)findViewById(R.id.toolbar_boton_volver);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(B1_ListaSeguimiento.this,B2_Evaluacion2.class);
                intent.putExtra("Deportista",Depor);
                B1_ListaSeguimiento.this.startActivity(intent);
            }
        });
        retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(B1_ListaSeguimiento.this,Activity_Principal.class);
                intent.putExtra("o","o1");
                B1_ListaSeguimiento.this.startActivity(intent);
            }
        });
        Listado_Eva2();
        listar_eva2(String.valueOf(Depor.getId()));


        adapterEquipo_EV2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                System.out.println("Paso Changed");
                System.out.println("total"+adapterEquipo_EV2.getItemCount());

                if (adapterEquipo_EV2.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    recyclerEV2.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    recyclerEV2.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    private void Listado_Eva2() {

        linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        adapterEquipo_EV2=new AdapterEva2(this,dataEV2, new RecyclerViewOnItemClickListener2() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recyclerEV2.setAdapter( adapterEquipo_EV2);
        recyclerEV2.setLayoutManager(linearLayout);
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
                }catch (JSONException e){
                    System.out.println("Fin de contenido");
                }


                return null;
            }

            protected void onPostExecute(Void aVoid){
                adapterEquipo_EV2.notifyDataSetChanged();
            }
        };
        task.execute();
    }
    public void onBackPressed() {
        Intent intent = new Intent(B1_ListaSeguimiento.this,Activity_Principal.class);
        B1_ListaSeguimiento.this.startActivity(intent);
    }

}
