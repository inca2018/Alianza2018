package inca.jesus.alianza17.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.TecnicoServer;

public class B_A4_1_PruebaTecnico extends AppCompatActivity {

    EditText oo1,oo2,oo3,oo4,oo5,oo6,oo7,oo8,oo9,oo10,
            oo11,oo12,oo13,oo14,oo15,oo16,oo17,oo18,oo19,oo20,
            oo21,oo22,oo23,oo24,oo25,oo26;
    TextView tt1,tt2,tt3,tt4,gg1,gg2,gg3,gg4,gg5,total;
    int oper1,oper2,oper3,oper4,oper5,oper6,oper7,oper8,oper9,oper10,oper11,oper12,oper13,oper14,
            oper15,oper16,oper17,oper18,oper19,oper20,oper21,oper22,oper23,oper24,oper25,oper26;
    int resu1,resu2,resu3,resu4,resu5,resu6,resu7,resu8,resu9,resu10;
    ProgressDialog progressDialog;
    String id1,id2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__a4_1__prueba_tecnico);


        oo1=(EditText)findViewById(R.id.o1);
        oo2=(EditText)findViewById(R.id.o2);
        oo3=(EditText)findViewById(R.id.o3);
        oo4=(EditText)findViewById(R.id.o4);
        oo5=(EditText)findViewById(R.id.o5);
        oo6=(EditText)findViewById(R.id.o6);
        oo7=(EditText)findViewById(R.id.o7);
        oo8=(EditText)findViewById(R.id.o8);
        oo9=(EditText)findViewById(R.id.o9);
        oo10=(EditText)findViewById(R.id.o10);
        oo11=(EditText)findViewById(R.id.o11);
        oo12=(EditText)findViewById(R.id.o12);
        oo13=(EditText)findViewById(R.id.o13);
        oo14=(EditText)findViewById(R.id.o14);
        oo15=(EditText)findViewById(R.id.o15);
        oo16=(EditText)findViewById(R.id.o16);
        oo17=(EditText)findViewById(R.id.o17);
        oo18=(EditText)findViewById(R.id.o18);
        oo19=(EditText)findViewById(R.id.o19);
        oo20=(EditText)findViewById(R.id.o20);
        oo21=(EditText)findViewById(R.id.o21);
        oo22=(EditText)findViewById(R.id.o22);
        oo23=(EditText)findViewById(R.id.o23);
        oo24=(EditText)findViewById(R.id.o24);
        oo25=(EditText)findViewById(R.id.o25);
        oo26=(EditText)findViewById(R.id.o26);

        tt1=(TextView) findViewById(R.id.t1);
        tt2=(TextView) findViewById(R.id.t2);
        tt3=(TextView) findViewById(R.id.t3);
        tt4=(TextView) findViewById(R.id.t4);
        gg1=(TextView) findViewById(R.id.g1);
        gg2=(TextView) findViewById(R.id.g2);
        gg3=(TextView) findViewById(R.id.g3);
        gg4=(TextView) findViewById(R.id.g4);
        gg5=(TextView) findViewById(R.id.g5);
        total=(TextView)findViewById(R.id.re_total);

        setearDato(oo1);
        setearDato(oo2);
        setearDato(oo3);
        setearDato(oo4);
        setearDato(oo5);
        setearDato(oo6);
        setearDato(oo7);
        setearDato(oo8);
        setearDato(oo9);
        setearDato(oo10);
        setearDato(oo11);
        setearDato(oo12);
        setearDato(oo13);
        setearDato(oo14);
        setearDato(oo15);
        setearDato(oo16);
        setearDato(oo17);
        setearDato(oo18);
        setearDato(oo19);
        setearDato(oo20);
        setearDato(oo21);
        setearDato(oo22);
        setearDato(oo23);
        setearDato(oo24);
        setearDato(oo25);
        setearDato(oo26);
    }

    private void setearDato(EditText x) {
        x.setText("0");
    }

    public void calcularDatos2(View view){
        extraerVariables();
        //Respuesta 1
        resu1=(oper2+oper4)*20;
        tt1.setText(String.valueOf(resu1));
        //Respuesta 2
        resu2=(oper6+oper8)*20;
        tt2.setText(String.valueOf(resu2));
        //Respuesta 3
        resu3=(oper1+oper3+oper9+oper13)*10;
        tt3.setText(String.valueOf(resu3));
        //Respuesta 4
        resu4=(oper5+oper7+oper11+oper15)*10;
        tt4.setText(String.valueOf(resu4));
        //Respuesta 5
        resu5=(resu1+resu2)/2;
        gg1.setText(String.valueOf(resu5));
        //Respuesta 6
        resu6=(resu3+resu4)/2;
        gg2.setText(String.valueOf(resu6));
        //Respuesta 7
        resu7=(oper10+oper12+oper14+oper16)*10;
        gg3.setText(String.valueOf(resu7));
        //Respuesta 8
        resu8=((oper17+oper18+oper19+oper20+oper21)*7)+(20-oper22);
        gg4.setText(String.valueOf(resu8));
        //Respuesta 9
        resu9=(oper23+oper24+oper25+oper26)*10;
        gg5.setText(String.valueOf(resu9));
        //Respuesta 10
        resu10=(resu1+resu2+resu3+resu4+resu5+resu6+resu7+resu8+resu9)/9;
        total.setText(String.valueOf(resu10));

    }

    private void extraerVariables() {
        oper1=Integer.parseInt(oo1.getText().toString());
        oper2=Integer.parseInt(oo2.getText().toString());
        oper3=Integer.parseInt(oo3.getText().toString());
        oper4=Integer.parseInt(oo4.getText().toString());
        oper5=Integer.parseInt(oo5.getText().toString());
        oper6=Integer.parseInt(oo6.getText().toString());
        oper7=Integer.parseInt(oo7.getText().toString());
        oper8=Integer.parseInt(oo8.getText().toString());
        oper9=Integer.parseInt(oo9.getText().toString());
        oper10=Integer.parseInt(oo10.getText().toString());
        oper11=Integer.parseInt(oo11.getText().toString());
        oper12=Integer.parseInt(oo12.getText().toString());
        oper13=Integer.parseInt(oo13.getText().toString());
        oper14=Integer.parseInt(oo14.getText().toString());
        oper15=Integer.parseInt(oo15.getText().toString());
        oper16=Integer.parseInt(oo16.getText().toString());
        oper17=Integer.parseInt(oo17.getText().toString());
        oper18=Integer.parseInt(oo18.getText().toString());
        oper19=Integer.parseInt(oo19.getText().toString());
        oper20=Integer.parseInt(oo20.getText().toString());
        oper21=Integer.parseInt(oo21.getText().toString());
        oper22=Integer.parseInt(oo22.getText().toString());
        oper23=Integer.parseInt(oo23.getText().toString());
        oper24=Integer.parseInt(oo24.getText().toString());
        oper25=Integer.parseInt(oo25.getText().toString());
        oper26=Integer.parseInt(oo26.getText().toString());

    }

    public void guardar_datos2(View view){

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Guardando Prueba Tecnica...");
        progressDialog.setMessage("Cargando.....");
        progressDialog.show();

        id1=getIntent().getStringExtra("id_eventos");
        id2=getIntent().getStringExtra("id_postulante");
        String dato1=gg1.getText().toString();
        String dato2=gg2.getText().toString();
        String dato3=gg3.getText().toString();
        String dato4=gg4.getText().toString();
        String dato5=gg5.getText().toString();
        String dato6=total.getText().toString();




        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    progressDialog.dismiss();
                    if (success) {
                        Toast.makeText(B_A4_1_PruebaTecnico.this, "Registro Guardado con exito!", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(B_A4_1_PruebaTecnico.this,C2_ListaOpciones.class);
                        intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                        intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));
                        startActivity(intent);
                    } else {
                        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(B_A4_1_PruebaTecnico.this);
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
        TecnicoServer pe= new TecnicoServer(id1,id2,dato1,dato2,dato3,dato4,dato5,dato6,responseListener);
        RequestQueue queue = Volley.newRequestQueue(B_A4_1_PruebaTecnico.this);
        queue.add(pe);
    }
}
