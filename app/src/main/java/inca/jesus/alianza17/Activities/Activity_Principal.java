package inca.jesus.alianza17.Activities;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.Fragments.FragmentCategorias;
import inca.jesus.alianza17.Fragments.FragmentEstadistico;
import inca.jesus.alianza17.Fragments.FragmentEventosEstadistico;
import inca.jesus.alianza17.Fragments.FragmentGestionBarrio;
import inca.jesus.alianza17.Fragments.FragmentJugadores;
import inca.jesus.alianza17.Fragments.FragmentMain;
import inca.jesus.alianza17.Fragments.FragmentMisEquipos;
import inca.jesus.alianza17.Fragments.FragmentCaptacion;
import inca.jesus.alianza17.Fragments.FragmentBarrio;
import inca.jesus.alianza17.Fragments.FragmentPerfiles;
import inca.jesus.alianza17.Fragments.FragmentReporteCaptacion;
import inca.jesus.alianza17.Fragments.FragmentSeguimiento;
import inca.jesus.alianza17.Fragments.FragmentUsuarios;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity_Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private Fragment fragment = null;
    private FragmentManager fragmentManager;
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    List<Usuarios_Perfiles> TEMP;
    String Perfil;
    TextView usuario,tipo;
    ImageView foto;
    Menu captacion,estadistico,mantenimiento;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        captacion=(Menu)findViewById(R.id.menu_modulo_captacion);
        estadistico=(Menu)findViewById(R.id.menu_modulo_estadistico);
        //mantenimiento=(Menu)findViewById(R.id.menu_modulo_mantenimiento);
        mostrar_vistas() ;
        Toolbar_iniz();
        MetodoDrawer();
        navigation_init();
        TEMP=new ArrayList<>();
        Listar_perfile();
        gestion_Modulos();
    }
    private void gestion_Modulos() {

        if(Usuario_Sesion.SESION.getM1()==0){
            navigationView.getMenu().findItem(R.id.menu_modulo_captacion).setVisible(false);
        }else{
            navigationView.getMenu().findItem(R.id.menu_modulo_captacion).setVisible(true);
        }

        if(Usuario_Sesion.SESION.getM2()==0){
            navigationView.getMenu().findItem(R.id.menu_modulo_estadistico).setVisible(false);
        }else{
            navigationView.getMenu().findItem(R.id.menu_modulo_estadistico).setVisible(true);
        }
        /*if(Usuario_Sesion.SESION.getM3()==0){
            navigationView.getMenu().findItem(R.id.menu_modulo_mantenimiento).setVisible(false);
        }else{
            navigationView.getMenu().findItem(R.id.menu_modulo_mantenimiento).setVisible(true);
        }*/

    }
    private void Setear_usuario() {
        System.out.println("Inca usuario sesion: "+Usuario_Sesion.SESION.getNombre()+" Perfil: "+Perfil);
        usuario.setText(Usuario_Sesion.SESION.getNombre());
        tipo.setText(Perfil);
        String ruta="http://alianza2.esy.es/alianza/imagenes/"+ Usuario_Sesion.SESION.getFoto();
        Glide.with(this).load(ruta).into(foto);



    }
    private void navigation_init() {

        navigationView=(NavigationView) findViewById(R.id.nav_view);
        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);
        usuario = (TextView) headerView.findViewById(R.id.username_principal);
        tipo = (TextView) headerView.findViewById(R.id.tipo_principal);
        foto=(ImageView)headerView.findViewById(R.id.profile_image);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void mostrar_vistas() {
        if(getIntent().getStringExtra("o")==null){
            displayView(0);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o1")){
            displayView(1);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o2")){
            displayView(2);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o5")){
            displayView(5);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o8")){
            displayView(8);
    }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o9")){
        displayView(11);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o3")){
            displayView(3);
        }else if(getIntent().getStringExtra("o").equalsIgnoreCase("o20")){
            displayView(20);
        }

    }
    private void Toolbar_iniz() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void MetodoDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        ;
        toggle.syncState();
    }

    public void onBackPressed() {
        /**DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_1) {
            displayView(0);
            toolbar.setTitle("Inicio");
        }
        else if (id == R.id.nav_3) {
            displayView(1);
            toolbar.setTitle("Postulantes");
        }
        else if (id == R.id.nav_4) {
            displayView(2);
            toolbar.setTitle("Barrio Intimo");

        }
        else if (id == R.id.nav_seg_pos) {
            displayView(11);
            toolbar.setTitle("Seguimiento");

        }
        else if (id == R.id.nav_5) {
            displayView(3);
            toolbar.setTitle("Estadistico");

        }

       /* else if (id == R.id.mant_usuario) {
            displayView(5);
            toolbar.setTitle("Usuarios");
        }
        else if (id == R.id.mant_perfiles) {
            displayView(6);
            toolbar.setTitle("Perfiles");
        }*/
        else if (id == R.id.nav_reporte_cap) {
            displayView(23);
            toolbar.setTitle("Reporte Captación");
        }
       /* else if (id == R.id.mant_categorias) {
            displayView(7);
            toolbar.setTitle("Categorias");
        }
        else if (id == R.id.mant_jugadores) {
            displayView(8);
            toolbar.setTitle("Jugadores");
        }
        else if (id == R.id.mant_eventos_barrio) {
            displayView(9);
            toolbar.setTitle("Campeonatos");
        }
        else if (id == R.id.mant_barrio) {
            displayView(21);
            toolbar.setTitle("Barrio Intimo -Mant");
        }
        else if (id == R.id.mant_mis_equipos) {
            displayView(10);
            toolbar.setTitle("Mis Equipos");

        }*/

       if (id == R.id.nav_salir) {

            final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(Activity_Principal.this);
            builder.setTitle("SALIR")
                    .setMessage("¿Desea Cerrar Sesión?")
                    .setPositiveButton("SI",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent=new Intent(Activity_Principal.this,Activity_Login.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
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
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }
    private void displayView(int position) {
        fragment = null;
        //String fragmentTags = "";
        switch (position) {
            case 0:
                fragment = new FragmentMain();
                break;
            case 1:
                fragment = new FragmentCaptacion();
                break;
            case 2:
                fragment = new FragmentBarrio();
                break;
            case 3:
                fragment = new FragmentEstadistico();
                break;
            case 4:
                Intent intent=new Intent(this, ListaCategoriasPlantel.class);
                startActivity(intent);
                break;
            case 5:
                fragment = new FragmentUsuarios();
                break;
            case 6:
                fragment = new FragmentPerfiles();
                break;
            case 7:
                fragment = new FragmentCategorias();
                break;
            case 8:
                fragment = new FragmentJugadores();
                break;
            case 9:
                fragment = new FragmentEventosEstadistico();
                break;
            case 10:
                fragment = new FragmentMisEquipos();
                break;
            case 11:
                fragment = new FragmentSeguimiento();
                break;

            case 20:
                fragment = new FragmentBarrio();
                break;
            case 21:
                fragment = new FragmentGestionBarrio();
                break;
            case 23:
                fragment = new FragmentReporteCaptacion();
                break;

            default:
                break;
        }

        if (fragment != null) {
            fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
    }
    public void Listar_perfile(){
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
                        TEMP.add(data);
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

                for(int i=0;i<TEMP.size();i++){
                    if(TEMP.get(i).getId()==Usuario_Sesion.SESION.getPerfil()){
                        Perfil=TEMP.get(i).getNom_tipo();
                    }
                    System.out.println("Inca: "+TEMP.get(i).getNom_tipo());
                }

                Setear_usuario();
            }
        };
        task.execute();
    }
}
