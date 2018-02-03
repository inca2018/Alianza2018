package inca.jesus.alianza17.DialogAptitudes;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import inca.jesus.alianza17.Activities.A1_Evaluacion;
import inca.jesus.alianza17.Activities.B2_Evaluacion2;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;

public class S_dialog_psicologico2 extends AppCompatActivity {
    int respsi1,respsi2,respsi3,respsi4;
    ImageView regresar5,vaciar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_dialog_psicologico2);
        regresar5=(ImageView)findViewById(R.id.toolbar_boton_volver_psico2);
        vaciar5=(ImageView)findViewById(R.id.toolbar_boton_vaciar_psico2);

        regresar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(S_dialog_psicologico2.this,A1_Evaluacion.class);
                startActivity(intent);
            }
        });
        mostrar_hab();
    }

    private void mostrar_hab() {

        final RadioButton rps10=(RadioButton)findViewById(R.id.rpsi10x);
        final RadioButton rps11=(RadioButton)findViewById(R.id.rpsi11x);
        final RadioButton rps12=(RadioButton)findViewById(R.id.rpsi12x);
        final RadioButton rps13=(RadioButton)findViewById(R.id.rpsi13x);
        final RadioButton rps20=(RadioButton)findViewById(R.id.rpsi20x);
        final RadioButton rps21=(RadioButton)findViewById(R.id.rpsi21x);
        final RadioButton rps22=(RadioButton)findViewById(R.id.rpsi22x);
        final RadioButton rps23=(RadioButton)findViewById(R.id.rpsi23x);
        final RadioButton rps30=(RadioButton)findViewById(R.id.rpsi30x);
        final RadioButton rps31=(RadioButton)findViewById(R.id.rpsi31x);
        final RadioButton rps32=(RadioButton)findViewById(R.id.rpsi32x);
        final RadioButton rps33=(RadioButton)findViewById(R.id.rpsi33x);
        final RadioButton rps40=(RadioButton)findViewById(R.id.rpsi40x);
        final RadioButton rps41=(RadioButton)findViewById(R.id.rpsi41x);
        final RadioButton rps42=(RadioButton)findViewById(R.id.rpsi42x);
        final RadioButton rps43=(RadioButton)findViewById(R.id.rpsi43x);
        final RadioGroup rgps1=(RadioGroup)findViewById(R.id.rgpsi1x);
        final RadioGroup rgps2=(RadioGroup)findViewById(R.id.rgpsi2x);
        final RadioGroup rgps3=(RadioGroup)findViewById(R.id.rgpsi3x);
        final RadioGroup rgps4=(RadioGroup)findViewById(R.id.rgpsi4x);
        final Button btnpsi=(Button)findViewById(R.id.btnpsicox);

        rgps1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rps10.isChecked()){
                    respsi1=0;
                    System.out.println("puntaje = 0");
                }
                if(rps11.isChecked()){
                    respsi1=1;
                    System.out.println("puntaje = 1");
                }
                if(rps12.isChecked()){
                    respsi1=2;
                    System.out.println("puntaje = 2");
                }
                if(rps13.isChecked()){
                    respsi1=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgps2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rps20.isChecked()){
                    respsi2=0;
                    System.out.println("puntaje = 0");
                }

                if(rps21.isChecked()){
                    respsi2=1;
                    System.out.println("puntaje = 1");
                }
                if(rps22.isChecked()){
                    respsi2=2;
                    System.out.println("puntaje = 2");
                }
                if(rps23.isChecked()){
                    respsi2=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgps3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rps30.isChecked()){
                    respsi3=0;
                    System.out.println("puntaje = 0");
                }

                if(rps31.isChecked()){
                    respsi3=1;
                    System.out.println("puntaje = 1");
                }
                if(rps32.isChecked()){
                    respsi3=2;
                    System.out.println("puntaje = 2");
                }
                if(rps33.isChecked()){
                    respsi3=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgps4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rps40.isChecked()){
                    respsi4=0;
                    System.out.println("puntaje = 0");
                }

                if(rps41.isChecked()){
                    respsi4=1;
                    System.out.println("puntaje = 1");
                }
                if(rps42.isChecked()){
                    respsi4=2;
                    System.out.println("puntaje = 2");
                }
                if(rps43.isChecked()){
                    respsi4=3;
                    System.out.println("puntaje = 3");
                }
            }
        });
        if(DataServer.CORTE2==false){
            if(getIntent().getStringExtra("p1")!=null) {
                check_variables(Integer.parseInt(getIntent().getStringExtra("p1")), rps10, rps11, rps12, rps13);
                check_variables(Integer.parseInt(getIntent().getStringExtra("p2")), rps20, rps21, rps22, rps23);
                check_variables(Integer.parseInt(getIntent().getStringExtra("p3")), rps30, rps31, rps32, rps33);
                check_variables(Integer.parseInt(getIntent().getStringExtra("p4")), rps40, rps41, rps42, rps43);
            }

        }else{
            check_variables(respsi1, rps10, rps11, rps12, rps13);
            check_variables(respsi2, rps20, rps21, rps22, rps23);
            check_variables(respsi3, rps30, rps31, rps32, rps33);
            check_variables(respsi4, rps40, rps41, rps42, rps43);
        }


        vaciar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_variables(0, rps10, rps11, rps12, rps13);
                check_variables(0, rps20, rps21, rps22, rps23);
                check_variables(0, rps30, rps31, rps32, rps33);
                check_variables(0, rps40, rps41, rps42, rps43);
                Snackbar.make(v,"Opciones Psicologicas deseleccionadas", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btnpsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(S_dialog_psicologico2.this,B2_Evaluacion2.class);

                intent.putExtra("p1",String.valueOf(respsi1));
                intent.putExtra("p2",String.valueOf(respsi2));
                intent.putExtra("p3",String.valueOf(respsi3));
                intent.putExtra("p4",String.valueOf(respsi4));

                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

                intent.putExtra("r1",getIntent().getStringExtra("r1"));
                intent.putExtra("r2",getIntent().getStringExtra("r2"));
                intent.putExtra("r3",getIntent().getStringExtra("r3"));
                intent.putExtra("r4",getIntent().getStringExtra("r4"));
                intent.putExtra("r5",getIntent().getStringExtra("r5"));
                intent.putExtra("r6",getIntent().getStringExtra("r6"));
                intent.putExtra("r7",getIntent().getStringExtra("r7"));

                intent.putExtra("s1",getIntent().getStringExtra("s1"));
                intent.putExtra("s2",getIntent().getStringExtra("s2"));
                intent.putExtra("s3",getIntent().getStringExtra("s3"));
                intent.putExtra("s4",getIntent().getStringExtra("s4"));

                intent.putExtra("t1",getIntent().getStringExtra("t1"));
                intent.putExtra("t2",getIntent().getStringExtra("t2"));
                intent.putExtra("t3",getIntent().getStringExtra("t3"));
                intent.putExtra("t4",getIntent().getStringExtra("t4"));
                intent.putExtra("t5",getIntent().getStringExtra("t5"));
                intent.putExtra("t6",getIntent().getStringExtra("t6"));

                startActivity(intent);

            }
        });
    }

    private void check_variables(int r,RadioButton r10, RadioButton r11, RadioButton r12, RadioButton r13) {

        switch (r){
            case 0:
                r10.setChecked(true);
                break;
            case 1:
                r11.setChecked(true);
                break;
            case 2:
                r12.setChecked(true);
                break;
            case 3:
                r13.setChecked(true);
                break;
        }
    }

}
