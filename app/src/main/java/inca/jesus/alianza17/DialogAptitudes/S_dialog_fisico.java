package inca.jesus.alianza17.DialogAptitudes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import inca.jesus.alianza17.Activities.A1_Evaluacion;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.R;


public class S_dialog_fisico extends AppCompatActivity {
    int res1,res2,res3,res4,res5,res6,res7;
    ImageView regresar,vaciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dialog_fisico);
        regresar=(ImageView)findViewById(R.id.toolbar_boton_volver_fisico);
        vaciar=(ImageView)findViewById(R.id.toolbar_boton_vaciar_fisico);
        mostrar_hab();
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(S_dialog_fisico.this,A1_Evaluacion.class);
                startActivity(intent);
            }
        });


    }
    private void mostrar_hab() {
        final RadioButton r11=(RadioButton)findViewById(R.id.fis1g1);
        final RadioButton r12=(RadioButton)findViewById(R.id.fis1g2);
        final RadioButton r13=(RadioButton)findViewById(R.id.fis1g3);
        final RadioButton r21=(RadioButton)findViewById(R.id.fis2g1);
        final RadioButton r22=(RadioButton)findViewById(R.id.fis2g2);
        final RadioButton r23=(RadioButton)findViewById(R.id.fis2g3);
        final RadioButton r31=(RadioButton)findViewById(R.id.fis3g1);
        final RadioButton r32=(RadioButton)findViewById(R.id.fis3g2);
        final RadioButton r33=(RadioButton)findViewById(R.id.fis3g3);
        final RadioButton r41=(RadioButton)findViewById(R.id.fis4g1);
        final RadioButton r42=(RadioButton)findViewById(R.id.fis4g2);
        final RadioButton r43=(RadioButton)findViewById(R.id.fis4g3);
        final RadioButton r51=(RadioButton)findViewById(R.id.fis5g1);
        final RadioButton r52=(RadioButton)findViewById(R.id.fis5g2);
        final RadioButton r53=(RadioButton)findViewById(R.id.fis5g3);
        final RadioButton r61=(RadioButton)findViewById(R.id.fis6g1);
        final RadioButton r62=(RadioButton)findViewById(R.id.fis6g2);
        final RadioButton r63=(RadioButton)findViewById(R.id.fis6g3);
        final RadioButton r71=(RadioButton)findViewById(R.id.fis7g1);
        final RadioButton r72=(RadioButton)findViewById(R.id.fis7g2);
        final RadioButton r73=(RadioButton)findViewById(R.id.fis7g3);
        final RadioButton r10=(RadioButton)findViewById(R.id.fis1g0);
        final RadioButton r20=(RadioButton)findViewById(R.id.fis2g0);
        final RadioButton r30=(RadioButton)findViewById(R.id.fis3g0);
        final RadioButton r40=(RadioButton)findViewById(R.id.fis4g0);
        final RadioButton r50=(RadioButton)findViewById(R.id.fis5g0);
        final RadioButton r60=(RadioButton)findViewById(R.id.fis6g0);
        final RadioButton r70=(RadioButton)findViewById(R.id.fis7g0);


        final RadioGroup rg1=(RadioGroup)findViewById(R.id.fis1g);
        final RadioGroup rg2=(RadioGroup)findViewById(R.id.fis2g);
        final RadioGroup rg3=(RadioGroup)findViewById(R.id.fis3g);
        final RadioGroup rg4=(RadioGroup)findViewById(R.id.fis4g);
        final RadioGroup rg5=(RadioGroup)findViewById(R.id.fis5g);
        final RadioGroup rg6=(RadioGroup)findViewById(R.id.fis6g);
        final RadioGroup rg7=(RadioGroup)findViewById(R.id.fis7g);

        final Button btn=(Button)findViewById(R.id.btnfisicograbar);


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(r10.isChecked()){
                    res1=0;
                    System.out.println("puntaje ="+res1);
                }

                if(r11.isChecked()){
                    res1=1;
                    System.out.println("puntaje ="+res1);
                }
                if(r12.isChecked()){
                    res1=2;
                    System.out.println("puntaje ="+res1);
                }
                if(r13.isChecked()){
                    res1=3;
                    System.out.println("puntaje ="+res1);
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r20.isChecked()){
                    res2=0;
                    System.out.println("puntaje ="+res2);
                }

                if(r21.isChecked()){
                    res2=1;
                    System.out.println("puntaje ="+res2);
                }
                if(r22.isChecked()){
                    res2=2;
                    System.out.println("puntaje ="+res2);
                }
                if(r23.isChecked()){
                    res2=3;
                    System.out.println("puntaje ="+res2);
                }
            }
        });


        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r30.isChecked()){
                    res3=0;
                    System.out.println("puntaje ="+res3);
                }

                if(r31.isChecked()){
                    res3=1;
                    System.out.println("puntaje ="+res3);
                }
                if(r32.isChecked()){
                    res3=2;
                    System.out.println("puntaje ="+res3);
                }
                if(r33.isChecked()){
                    res3=3;
                    System.out.println("puntaje ="+res3);
                }
            }
        });


        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r40.isChecked()){
                    res4=0;
                    System.out.println("puntaje ="+res4);
                }

                if(r41.isChecked()){
                    res4=1;
                    System.out.println("puntaje ="+res4);
                }
                if(r42.isChecked()){
                    res4=2;
                    System.out.println("puntaje ="+res4);
                }
                if(r43.isChecked()){
                    res4=3;
                    System.out.println("puntaje ="+res4);
                }
            }
        });


        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r50.isChecked()){
                    res5=0;
                    System.out.println("puntaje ="+res5);
                }

                if(r51.isChecked()){
                    res5=1;
                    System.out.println("puntaje ="+res5);
                }
                if(r52.isChecked()){
                    res5=2;
                    System.out.println("puntaje ="+res5);
                }
                if(r53.isChecked()){
                    res5=3;
                    System.out.println("puntaje ="+res5);
                }
            }
        });


        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r60.isChecked()){
                    res6=0;
                    System.out.println("puntaje ="+res6);
                }

                if(r61.isChecked()){
                    res6=1;
                    System.out.println("puntaje ="+res6);
                }
                if(r62.isChecked()){
                    res6=2;
                    System.out.println("puntaje ="+res6);
                }
                if(r63.isChecked()){
                    res6=3;
                    System.out.println("puntaje ="+res6);
                }
            }
        });


        rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r70.isChecked()){

                    res7=0;
                    System.out.println("puntaje ="+res7);
                }

                if(r71.isChecked()){
                    res7=1;
                    System.out.println("puntaje ="+res7);
                }
                if(r72.isChecked()){
                    res7=2;
                    System.out.println("puntaje ="+res7);
                }
                if(r73.isChecked()){
                    res7=3;
                    System.out.println("puntaje ="+res7);
                }
            }
        });

        if(DataServer.CORTE==false){
            if(getIntent().getStringExtra("r1")!=null) {
                check_variables(Integer.parseInt(getIntent().getStringExtra("r1")), r10, r11, r12, r13);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r2")), r20, r21, r22, r23);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r3")), r30, r31, r32, r33);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r4")), r40, r41, r42, r43);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r5")), r50, r51, r52, r53);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r6")), r60, r61, r62, r63);
                check_variables(Integer.parseInt(getIntent().getStringExtra("r7")), r70, r71, r72, r73);
            }
        }else{

            check_variables(res1, r10, r11, r12, r13);
            check_variables(res2, r20, r21, r22, r23);
            check_variables(res3, r30, r31, r32, r33);
            check_variables(res4, r40, r41, r42, r43);
            check_variables(res5, r50, r51, r52, r53);
            check_variables(res6, r60, r61, r62, r63);
            check_variables(res7, r70, r71, r72, r73);
        }

        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_variables(0, r10, r11, r12, r13);
                check_variables(0, r20, r21, r22, r23);
                check_variables(0, r30, r31, r32, r33);
                check_variables(0, r40, r41, r42, r43);
                check_variables(0, r50, r51, r52, r53);
                check_variables(0, r60, r61, r62, r63);
                check_variables(0, r70, r71, r72, r73);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(S_dialog_fisico.this,A1_Evaluacion.class);
                intent.putExtra("r1",String.valueOf(res1));
                intent.putExtra("r2",String.valueOf(res2));
                intent.putExtra("r3",String.valueOf(res3));
                intent.putExtra("r4",String.valueOf(res4));
                intent.putExtra("r5",String.valueOf(res5));
                intent.putExtra("r6",String.valueOf(res6));
                intent.putExtra("r7",String.valueOf(res7));

                intent.putExtra("c1",getIntent().getStringExtra("c1"));
                intent.putExtra("c2",getIntent().getStringExtra("c2"));
                intent.putExtra("c3",getIntent().getStringExtra("c3"));
                intent.putExtra("c4",getIntent().getStringExtra("c4"));

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

                intent.putExtra("p1",getIntent().getStringExtra("p1"));
                intent.putExtra("p2",getIntent().getStringExtra("p2"));
                intent.putExtra("p3",getIntent().getStringExtra("p3"));
                intent.putExtra("p4",getIntent().getStringExtra("p4"));

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


