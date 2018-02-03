package inca.jesus.alianza17.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.FisicaServer;

public class B_A4_1_PruebaFisica extends AppCompatActivity {
    EditText ed_peso,ed_talla,ed_rj,ed_cmj,ed_abk,ed_fms,ed_velo,ed_yo;
    TextView t_vel1,t_pot1,t_res1,t_vel2,t_pot2,t_res2,ptotal;
    Double peso,talla,rj,cmj,abk,velo,yo;
    Double res1,res2,res3,res4,res5,res6,res7;
    String ed_1,ed_2,ed_3,ed_4,ed_5,ed_6,ed_7,ed_8,id1,id2;
    int fms;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__a4_1__prueba_fisica);

        crearVariables();
    }

    private void crearVariables() {

        ed_peso=(EditText)findViewById(R.id.e_Peso);
        ed_talla=(EditText)findViewById(R.id.e_talla);
        ed_rj=(EditText)findViewById(R.id.e_RJ);
        ed_cmj=(EditText)findViewById(R.id.e_CMJ);
        ed_abk=(EditText)findViewById(R.id.e_ABK);
        ed_fms=(EditText)findViewById(R.id.e_FMS);
        ed_velo=(EditText)findViewById(R.id.e_vel_s);
        ed_yo=(EditText)findViewById(R.id.e_yo);

        t_vel1=(TextView)findViewById(R.id.re_velo1);
        t_pot1=(TextView)findViewById(R.id.re_pot1);
        t_res1=(TextView)findViewById(R.id.re_resis1);
        t_vel2=(TextView)findViewById(R.id.re_velo2);
        t_pot2=(TextView)findViewById(R.id.re_pot2);
        t_res2=(TextView)findViewById(R.id.re_resis2);
        ptotal=(TextView)findViewById(R.id.re_total);

    }
    public void calcularDatos1(View view){

        ed_1=ed_peso.getText().toString();
        if(ed_1.isEmpty()){
            Toast.makeText(this, "Completar Campo Peso", Toast.LENGTH_SHORT).show();
        }else{
            peso=Double.parseDouble(ed_1);
        }
        ed_2=ed_talla.getText().toString();
        if(ed_2.isEmpty()){
            Toast.makeText(this, "Completar Campo Talla", Toast.LENGTH_SHORT).show();
        }else{
            talla=Double.parseDouble(ed_2);;
        }

        ed_3=ed_rj.getText().toString();

        if(ed_3.isEmpty()){
            Toast.makeText(this, "Completar Campo RJ", Toast.LENGTH_SHORT).show();
        }else{
            rj=Double.parseDouble(ed_3);
        }
        ed_4=ed_cmj.getText().toString();
        if(ed_4.isEmpty()){
            Toast.makeText(this, "Completar Campo CMJ", Toast.LENGTH_SHORT).show();
        }else{
            cmj=Double.parseDouble(ed_4);
        }
        ed_5=ed_abk.getText().toString();
        if(ed_5.isEmpty()){
            Toast.makeText(this, "Completar Campo ABK", Toast.LENGTH_SHORT).show();
        }else{
            abk=Double.parseDouble(ed_5);
        }
        ed_6=ed_fms.getText().toString();
        if(ed_6.isEmpty()){
            Toast.makeText(this, "Completar Campo FMS", Toast.LENGTH_SHORT).show();
        }else{
            fms=Integer.parseInt(ed_6);
        }
        ed_7=ed_velo.getText().toString();
        if(ed_7.isEmpty()){
            Toast.makeText(this, "Completar Campo Velocidad", Toast.LENGTH_SHORT).show();
        }else{
            velo=Double.parseDouble(ed_7);
        }
        ed_8=ed_yo.getText().toString();
        if(ed_8.isEmpty()){
            Toast.makeText(this, "Completar Campo Yo-Yo", Toast.LENGTH_SHORT).show();
        }else{
            yo=Double.parseDouble(ed_8);
        }

        if(peso!=null&&talla!=null&&rj!=null&&cmj!=null&&abk!=null&&fms!=0&&velo!=null&&yo!=null){
            res1=(27*1000/(velo*60));
            t_vel1.setText(String.format("%.2f",res1));
            res2=(((51.9*cmj)+(48.9*peso))-2007);
            t_pot1.setText(String.format("%.2f",res2));
            res3=yo*4.025;
            t_res1.setText(String.format("%.2f",res3));
            res4=res1+(( (rj+fms)/2)-20);
            t_vel2.setText(String.format("%.2f",res4));
            res5=res2/52.5;
            t_pot2.setText(String.format("%.2f",res5));
            res6=res3-12.6;
            t_res2.setText(String.format("%.2f",res6));
            res7=(res4+res5+res6)/3;
            ptotal.setText(String.format("%.2f",res7));

        }else{
            Toast.makeText(this, "vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void guardar_datos(View view){

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Guardando Prueba Fisica...");
        progressDialog.setMessage("Cargando.....");
        progressDialog.show();

        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");

        String dato1=String.valueOf(ed_1);
        String dato2=String.valueOf(ed_2);
        String dato3=String.valueOf(ed_3);
        String dato4=String.valueOf(ed_4);
        String dato5=String.valueOf(ed_5);
        String dato6=String.valueOf(ed_6);
        String dato7=String.valueOf(ed_7);
        String dato8=String.valueOf(ed_8);
        String dato9=String.valueOf(res1);
        String dato10=String.valueOf(res2);
        String dato11=String.valueOf(res3);
        String dato12=String.valueOf(res4);
        String dato13=String.valueOf(res5);
        String dato14=String.valueOf(res6);
        String dato15=String.valueOf(res7);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {
                        Toast.makeText(B_A4_1_PruebaFisica.this, "Registro Guardado con exito!", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(B_A4_1_PruebaFisica.this,C2_ListaOpciones.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        startActivity(intent);
                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(B_A4_1_PruebaFisica.this);
                        builder.setMessage("Informacion no encontrada")
                                .setNegativeButton("Reintentar", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("error:"+e);
                }
            }
        };
        FisicaServer pe= new FisicaServer(id1,id2,dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8,dato9,dato10
                ,dato11,dato12,dato13,dato14,dato15,responseListener);
        RequestQueue queue = Volley.newRequestQueue(B_A4_1_PruebaFisica.this);
        queue.add(pe);

    }
}
