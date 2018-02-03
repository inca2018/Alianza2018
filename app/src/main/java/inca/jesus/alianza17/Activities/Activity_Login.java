package inca.jesus.alianza17.Activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.LoginServer;
public class Activity_Login extends AppCompatActivity {
        EditText usua, pass;
        ProgressDialog progressDialog;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            usua = (EditText) findViewById(R.id.etusu);
            pass = (EditText) findViewById(R.id.etpas);
        }
        public void ingresar(View view) {
            String usuario = usua.getText().toString();
            String password = pass.getText().toString();
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Verificando usuario");
            progressDialog.setMessage("Verificando.....");
            progressDialog.show();

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        limpiar();
                        progressDialog.dismiss();
                        if (success) {

                            int idusuario = jsonResponse.getInt("codigo");
                            String nombre = jsonResponse.getString("nombre");
                            int tipo = jsonResponse.getInt("tipo");
                            String Pass = jsonResponse.getString("pass");
                            String Correo = jsonResponse.getString("correo");
                            String usuario = jsonResponse.getString("usuario");
                            int m1 = jsonResponse.getInt("m1");
                            int m2 = jsonResponse.getInt("m2");
                            int m3 = jsonResponse.getInt("m3");
                            int m4 = jsonResponse.getInt("m4");
                            int m5 = jsonResponse.getInt("m5");
                            String foto = jsonResponse.getString("foto");


                            Usuario_Sesion.SESION.setCodigo(idusuario);
                            Usuario_Sesion.SESION.setNombre(nombre);
                            Usuario_Sesion.SESION.setPerfil(tipo);
                            Usuario_Sesion.SESION.setPass(Pass);
                            Usuario_Sesion.SESION.setCorreo(Correo);
                            Usuario_Sesion.SESION.setUsuario(usuario);
                            Usuario_Sesion.SESION.setM1(m1);
                            Usuario_Sesion.SESION.setM2(m2);
                            Usuario_Sesion.SESION.setM3(m3);
                            Usuario_Sesion.SESION.setM4(m4);
                            Usuario_Sesion.SESION.setM5(m5);
                            Usuario_Sesion.SESION.setFoto(foto);



                            Intent intent = new Intent(Activity_Login.this, Activity_Principal.class);
                            Activity_Login.this.startActivity(intent);
                            //Toast.makeText(LoginApp.this, "Logueado con exito...", Toast.LENGTH_SHORT).show();

                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Login.this);
                            builder.setMessage("Usuario o Contraseña erroneas")
                                    .setNegativeButton("Reintentar", null)
                                    .create()
                                    .show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        System.out.println("Inca  : Error JSON problema :"+e);
                    }
                }
            };

            LoginServer loginServer = new LoginServer(usuario, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(Activity_Login.this);
            queue.add(loginServer);
        }
        public void limpiar(){
            //usua.setText("");
            pass.setText("");
        }
        public void onBackPressed() {

            final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(Activity_Login.this);
            builder.setTitle("SALIR")
                    .setMessage("¿Desea Cerrar Aplicación?")
                    .setPositiveButton("SI",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    finish();
                                    Intent intent = new Intent(Intent.ACTION_MAIN);
                                    intent.addCategory(Intent.CATEGORY_HOME);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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

}
