package inca.jesus.alianza17.DialogAptitudes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import inca.jesus.alianza17.Activities.A1_Evaluacion;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;


public class S_dialog_tecnico extends AppCompatActivity {

    int tec1,tec2,tec3,tec4,tec5,tec6;
    ImageView regresar4,vaciar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dialog_tecnico);


        regresar4=(ImageView)findViewById(R.id.toolbar_boton_volver_tec);
        vaciar4=(ImageView)findViewById(R.id.toolbar_boton_vaciar_tec);
        regresar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(S_dialog_tecnico.this,A1_Evaluacion.class);
                startActivity(intent);

            }
        });

        mostrar_hab();
    }

    private void mostrar_hab() {

        final RadioButton rt10=(RadioButton)findViewById(R.id.r10);
        final RadioButton rt11=(RadioButton)findViewById(R.id.r11);
        final RadioButton rt12=(RadioButton)findViewById(R.id.r12);
        final RadioButton rt13=(RadioButton)findViewById(R.id.r13);
        final RadioButton rt20=(RadioButton)findViewById(R.id.r20);
        final RadioButton rt21=(RadioButton)findViewById(R.id.r21);
        final RadioButton rt22=(RadioButton)findViewById(R.id.r22);
        final RadioButton rt23=(RadioButton)findViewById(R.id.r23);
        final RadioButton rt30=(RadioButton)findViewById(R.id.r30);
        final RadioButton rt31=(RadioButton)findViewById(R.id.r31);
        final RadioButton rt32=(RadioButton)findViewById(R.id.r32);
        final RadioButton rt33=(RadioButton)findViewById(R.id.r33);
        final RadioButton rt40=(RadioButton)findViewById(R.id.r40);
        final RadioButton rt41=(RadioButton)findViewById(R.id.r41);
        final RadioButton rt42=(RadioButton)findViewById(R.id.r42);
        final RadioButton rt43=(RadioButton)findViewById(R.id.r43);
        final RadioButton rt50=(RadioButton)findViewById(R.id.r50);
        final RadioButton rt51=(RadioButton)findViewById(R.id.r51);
        final RadioButton rt52=(RadioButton)findViewById(R.id.r52);
        final RadioButton rt53=(RadioButton)findViewById(R.id.r53);
        final RadioButton rt60=(RadioButton)findViewById(R.id.r60);
        final RadioButton rt61=(RadioButton)findViewById(R.id.r61);
        final RadioButton rt62=(RadioButton)findViewById(R.id.r62);
        final RadioButton rt63=(RadioButton)findViewById(R.id.r63);

        final RadioGroup rgt1=(RadioGroup)findViewById(R.id.rgtec1);
        final RadioGroup rgt2=(RadioGroup)findViewById(R.id.rgtec2);
        final RadioGroup rgt3=(RadioGroup)findViewById(R.id.rgtec3);
        final RadioGroup rgt4=(RadioGroup)findViewById(R.id.rgtec4);
        final RadioGroup rgt5=(RadioGroup)findViewById(R.id.rgtec5);
        final RadioGroup rgt6=(RadioGroup)findViewById(R.id.rgtec6);
        final Button btntec=(Button)findViewById(R.id.btnTec);

        rgt1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt10.isChecked()){
                    tec1=0;
                    System.out.println("puntaje = 0");
                }

                if(rt11.isChecked()){
                    tec1=1;
                    System.out.println("puntaje = 1");
                }
                if(rt12.isChecked()){
                    tec1=2;
                    System.out.println("puntaje = 2");
                }
                if(rt13.isChecked()){
                    tec1=3;
                    System.out.println("puntaje = 3");
                }
            }
        });
        rgt2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt20.isChecked()){
                    tec2=0;
                    System.out.println("puntaje = 0");
                }

                if(rt21.isChecked()){
                    tec2=1;
                    System.out.println("puntaje = 1");
                }
                if(rt22.isChecked()){
                    tec2=2;
                    System.out.println("puntaje = 2");
                }
                if(rt23.isChecked()){
                    tec2=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgt3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt30.isChecked()){
                    tec3=0;
                    System.out.println("puntaje = 0");
                }

                if(rt31.isChecked()){
                    tec3=1;
                    System.out.println("puntaje = 1");
                }
                if(rt32.isChecked()){
                    tec3=2;
                    System.out.println("puntaje = 2");
                }
                if(rt33.isChecked()){
                    tec3=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgt4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt40.isChecked()){
                    tec4=0;
                    System.out.println("puntaje = 0");
                }

                if(rt41.isChecked()){
                    tec4=1;
                    System.out.println("puntaje = 1");
                }
                if(rt42.isChecked()){
                    tec4=2;
                    System.out.println("puntaje = 2");
                }
                if(rt43.isChecked()){
                    tec4=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgt5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt50.isChecked()){
                    tec5=0;
                    System.out.println("puntaje = 0");
                }

                if(rt51.isChecked()){
                    tec5=1;
                    System.out.println("puntaje = 1");
                }
                if(rt52.isChecked()){
                    tec5=2;
                    System.out.println("puntaje = 2");
                }
                if(rt53.isChecked()){
                    tec5=3;
                    System.out.println("puntaje = 3");
                }
            }
        });
        rgt6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rt60.isChecked()){
                    tec6=0;
                    System.out.println("puntaje = 0");
                }

                if(rt61.isChecked()){
                    tec6=1;
                    System.out.println("puntaje = 1");
                }
                if(rt62.isChecked()){
                    tec6=2;
                    System.out.println("puntaje = 2");
                }
                if(rt63.isChecked()){
                    tec6=3;
                    System.out.println("puntaje = 3");
                }
            }
        });
        if(DataServer.CORTE==false){
        if(getIntent().getStringExtra("t1")!=null) {
            check_variables(Integer.parseInt(getIntent().getStringExtra("t1")), rt10, rt11, rt12, rt13);
            check_variables(Integer.parseInt(getIntent().getStringExtra("t2")), rt20, rt21, rt22, rt23);
            check_variables(Integer.parseInt(getIntent().getStringExtra("t3")), rt30, rt31, rt32, rt33);
            check_variables(Integer.parseInt(getIntent().getStringExtra("t4")), rt40, rt41, rt42, rt43);
            check_variables(Integer.parseInt(getIntent().getStringExtra("t5")), rt50, rt51, rt52, rt53);
            check_variables(Integer.parseInt(getIntent().getStringExtra("t6")), rt60, rt61, rt62, rt63);
            }
        }else{
            check_variables(tec1, rt10, rt11, rt12, rt13);
            check_variables(tec2, rt20, rt21, rt22, rt23);
            check_variables(tec3, rt30, rt31, rt32, rt33);
            check_variables(tec4, rt40, rt41, rt42, rt43);
            check_variables(tec5, rt50, rt51, rt52, rt53);
            check_variables(tec6, rt60, rt61, rt62, rt63);
        }

        vaciar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_variables(0, rt10, rt11, rt12, rt13);
                check_variables(0, rt20, rt21, rt22, rt23);
                check_variables(0, rt30, rt31, rt32, rt33);
                check_variables(0, rt40, rt41, rt42, rt43);
                check_variables(0, rt50, rt51, rt52, rt53);
                check_variables(0, rt60, rt61, rt62, rt63);
                Snackbar.make(v,"Opciones Tecnicas deseleccionadas", Snackbar.LENGTH_LONG)
                        .show();

            }
        });



        btntec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(S_dialog_tecnico.this,A1_Evaluacion.class);

                intent.putExtra("t1",String.valueOf(tec1));
                intent.putExtra("t2",String.valueOf(tec2));
                intent.putExtra("t3",String.valueOf(tec3));
                intent.putExtra("t4",String.valueOf(tec4));
                intent.putExtra("t5",String.valueOf(tec5));
                intent.putExtra("t6",String.valueOf(tec6));

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

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

                //intent.putExtra("nombre",getIntent().getStringExtra("nombre").toString());
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
