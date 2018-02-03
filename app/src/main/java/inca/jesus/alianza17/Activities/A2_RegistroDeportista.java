package inca.jesus.alianza17.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;

import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.ServerConexion.PuntosServer;
import inca.jesus.alianza17.R;

public class A2_RegistroDeportista extends AppCompatActivity {
    public ImageButton btn1;
    public TextView f_naci;
    public  EditText d_nom,d_ape,d_nacio,d_lug,d_telef,d_email,d_club,d_apoder,d_liga,d_cat;
    DateFormat formatDateTime = DateFormat.getDateInstance();
    Calendar dateTime = Calendar.getInstance();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_a2_registro_deportista);

        btn1=(ImageButton)findViewById(R.id.d_fecha_nacimiento);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });

        d_nom=(EditText)findViewById(R.id.d_nom);
        d_ape=(EditText)findViewById(R.id.d_ape);
        d_nacio=(EditText)findViewById(R.id.d_nacionalidad);
        f_naci=(TextView)findViewById(R.id.d_fecha_nac);
        d_lug=(EditText)findViewById(R.id.d_residencia);
        d_telef=(EditText)findViewById(R.id.d_telefono);
        d_email=(EditText)findViewById(R.id.d_email);
        d_club=(EditText)findViewById(R.id.d_CLub_Proc);
        d_apoder=(EditText)findViewById(R.id.d_apoderado);
        d_liga=(EditText)findViewById(R.id.d_Liga);
        d_cat=(EditText)findViewById(R.id.d_categoria);

    }
    private void updateDate(){
        new DatePickerDialog(this, d1,1999,0,1).show();
    }

    DatePickerDialog.OnDateSetListener d1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTextLabel1();
        }
    };
    private void updateTextLabel1(){
        int mes =dateTime.get(Calendar.MONTH)+1;
        f_naci.setText(dateTime.get(Calendar.YEAR)+"-"+mes+"-"+dateTime.get(Calendar.DAY_OF_MONTH));
    }
    public void guardar_deportista (View view) {

        if(d_nom.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Nombres del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_ape.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Apellidos del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_nacio.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Nacionalidad del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(f_naci.getText().length()==0){
            Toast.makeText(this, "Debe Seleccionar Fecha de Nacimiento del Aspirante!", Toast.LENGTH_SHORT).show();
        }
        else if(d_lug.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Lugar de Residencia del Aspirante!", Toast.LENGTH_SHORT).show();
        }
        else if(d_telef.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Telefono del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_email.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Correo del Aspirante!", Toast.LENGTH_SHORT).show();
        }
        else if(d_club.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Club del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_apoder.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Nombre del Apoderado del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_liga.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Liga Actual del Aspirante!", Toast.LENGTH_SHORT).show();
        }else if(d_cat.getText().length()==0){
            Toast.makeText(this, "Debe Ingresar Categoria del Aspirante!", Toast.LENGTH_SHORT).show();
        }else{

            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Evaluando Jugador");
            progressDialog.setMessage("Cargando.....");
            progressDialog.show();

            String nombre=d_nom.getText().toString().toUpperCase();
            String apellido=d_ape.getText().toString().toUpperCase();
            String fecha_naci=f_naci.getText().toString().toUpperCase();
            String nacionalidad=d_nacio.getText().toString().toUpperCase();
            String lug_res=d_lug.getText().toString().toUpperCase();
            String telf=d_telef.getText().toString();
            String email=d_email.getText().toString().toUpperCase();
            String club=d_club.getText().toString().toUpperCase();
            String apoderado=d_apoder.getText().toString().toUpperCase();
            String liga=d_liga.getText().toString().toUpperCase();
            String categoria=d_cat.getText().toString().toUpperCase();
            String r1=getIntent().getStringExtra("r1");
            String r2=getIntent().getStringExtra("r2");
            String r3=getIntent().getStringExtra("r3");
            String r4=getIntent().getStringExtra("r4");
            String r5=getIntent().getStringExtra("r5");
            String r6=getIntent().getStringExtra("r6");
            String r7=getIntent().getStringExtra("r7");

            String c1=getIntent().getStringExtra("c1");
            String c2=getIntent().getStringExtra("c2");
            String c3=getIntent().getStringExtra("c3");
            String c4=getIntent().getStringExtra("c4");

            String s1=getIntent().getStringExtra("s1");
            String s2=getIntent().getStringExtra("s2");
            String s3=getIntent().getStringExtra("s3");
            String s4=getIntent().getStringExtra("s4");

            String t1=getIntent().getStringExtra("t1");
            String t2=getIntent().getStringExtra("t2");
            String t3=getIntent().getStringExtra("t3");
            String t4=getIntent().getStringExtra("t4");
            String t5=getIntent().getStringExtra("t5");
            String t6=getIntent().getStringExtra("t6");

            String p1=getIntent().getStringExtra("p1");
            String p2=getIntent().getStringExtra("p2");
            String p3=getIntent().getStringExtra("p3");
            String p4=getIntent().getStringExtra("p4");
            String cod= String.valueOf(Usuario_Sesion.SESION.getCodigo());


            System.out.println("Inca : Sesion:"+Usuario_Sesion.SESION.getCodigo());

            com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        progressDialog.dismiss();
                        if (success) {
                            Toast.makeText(A2_RegistroDeportista.this, "Registro Guardado con exito!", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(A2_RegistroDeportista.this,Activity_Principal.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.putExtra("o","o1");
                            startActivity(intent);

                            System.out.println("Inca : Registro");

                        } else {
                            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(A2_RegistroDeportista.this);
                            builder.setMessage("Informacion no encontrada")
                                    .setNegativeButton("Reintentar", null)
                                    .create()
                                    .show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        System.out.println("Inca : Error JSON: "+e);

                    }
                }
            };
            PuntosServer pe= new PuntosServer(nombre,apellido,fecha_naci,nacionalidad,lug_res,
                    telf,email,club,apoderado,liga,categoria,r1,r2,r3,r4,r5,r6,r7,c1,c2,c3,c4,s1,s2,s3,s4,
                    t1,t2,t3,t4,t5,t6,p1,p2,p3,p4,cod,responseListener);
            RequestQueue queue = Volley.newRequestQueue(A2_RegistroDeportista.this);
            queue.add(pe);
        }
    }

}


