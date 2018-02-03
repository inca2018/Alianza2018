package inca.jesus.alianza17.Dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import inca.jesus.alianza17.Activities.B_A4_Diagnostico;
import inca.jesus.alianza17.R;

public class B_dialog_social extends AppCompatActivity {
    int so1,so2,so3,so4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_dialog_social);
        mostrar_hab();
    }


    private void mostrar_hab() {

        final RadioButton rso10=(RadioButton)findViewById(R.id.rso10);
        final RadioButton rso11=(RadioButton)findViewById(R.id.rso11);
        final RadioButton rso12=(RadioButton)findViewById(R.id.rso12);
        final RadioButton rso13=(RadioButton)findViewById(R.id.rso13);
        final RadioButton rso20=(RadioButton)findViewById(R.id.rso20);
        final RadioButton rso21=(RadioButton)findViewById(R.id.rso21);
        final RadioButton rso22=(RadioButton)findViewById(R.id.rso22);
        final RadioButton rso23=(RadioButton)findViewById(R.id.rso23);
        final RadioButton rso30=(RadioButton)findViewById(R.id.rso30);
        final RadioButton rso31=(RadioButton)findViewById(R.id.rso31);
        final RadioButton rso32=(RadioButton)findViewById(R.id.rso32);
        final RadioButton rso33=(RadioButton)findViewById(R.id.rso33);
        final RadioButton rso40=(RadioButton)findViewById(R.id.rso40);
        final RadioButton rso41=(RadioButton)findViewById(R.id.rso41);
        final RadioButton rso42=(RadioButton)findViewById(R.id.rso42);
        final RadioButton rso43=(RadioButton)findViewById(R.id.rso43);

        final RadioGroup rgso1=(RadioGroup)findViewById(R.id.rgso1);
        final RadioGroup rgso2=(RadioGroup)findViewById(R.id.rgso2);
        final RadioGroup rgso3=(RadioGroup)findViewById(R.id.rgso3);
        final RadioGroup rgso4=(RadioGroup)findViewById(R.id.rgso4);

        final Button btn3=(Button)findViewById(R.id.btnSoc);

        rgso1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rso10.isChecked()){
                    so1=0;
                    System.out.println("puntaje = 0");
                }

                if(rso11.isChecked()){
                    so1=1;
                    System.out.println("puntaje = 1");
                }
                if(rso12.isChecked()){
                    so1=2;
                    System.out.println("puntaje = 2");
                }
                if(rso13.isChecked()){
                    so1=3;
                    System.out.println("puntaje = 3");
                }
            }
        });
        rgso2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rso20.isChecked()){
                    so2=0;
                    System.out.println("puntaje = 0");
                }

                if(rso21.isChecked()){
                    so2=1;
                    System.out.println("puntaje = 1");
                }
                if(rso22.isChecked()){
                    so2=2;
                    System.out.println("puntaje = 2");
                }
                if(rso23.isChecked()){
                    so2=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgso3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rso30.isChecked()){
                    so3=0;
                    System.out.println("puntaje = 0");
                }

                if(rso31.isChecked()){
                    so3=1;
                    System.out.println("puntaje = 1");
                }
                if(rso32.isChecked()){
                    so3=2;
                    System.out.println("puntaje = 2");
                }
                if(rso33.isChecked()){
                    so3=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgso4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rso40.isChecked()){
                    so4=0;
                    System.out.println("puntaje = 0");
                }

                if(rso41.isChecked()){
                    so4=1;
                    System.out.println("puntaje = 1");
                }
                if(rso42.isChecked()){
                    so4=2;
                    System.out.println("puntaje = 2");
                }
                if(rso43.isChecked()){
                    so4=3;
                    System.out.println("puntaje = 3");
                }
            }
        });


        if(getIntent().getStringExtra("s1")!=null) {
            check_variables(Integer.parseInt(getIntent().getStringExtra("s1")), rso10, rso11, rso12, rso13);
            check_variables(Integer.parseInt(getIntent().getStringExtra("s2")), rso20, rso21, rso22, rso23);
            check_variables(Integer.parseInt(getIntent().getStringExtra("s3")), rso30, rso31, rso32, rso33);
            check_variables(Integer.parseInt(getIntent().getStringExtra("s4")), rso40, rso41, rso42, rso43);
        }else{
            check_variables(so1, rso10, rso11, rso12, rso13);
            check_variables(so2, rso20, rso21, rso22, rso23);
            check_variables(so3, rso30, rso31, rso32, rso33);
            check_variables(so4, rso40, rso41, rso42, rso43);

        }

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(B_dialog_social.this,B_A4_Diagnostico.class);

                intent.putExtra("s1",String.valueOf(so1));
                intent.putExtra("s2",String.valueOf(so2));
                intent.putExtra("s3",String.valueOf(so3));
                intent.putExtra("s4",String.valueOf(so4));

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
                intent.putExtra("id_eventos",getIntent().getStringExtra("id_eventos"));
                intent.putExtra("id_postulante",getIntent().getStringExtra("id_postulante"));


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
