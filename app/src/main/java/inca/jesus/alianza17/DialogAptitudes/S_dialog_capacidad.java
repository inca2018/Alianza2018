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


public class S_dialog_capacidad extends AppCompatActivity {


    int resc1,resc2,resc3,resc4;
    ImageView regresar2,vaciar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dialog_capacidad);
        regresar2=(ImageView)findViewById(R.id.toolbar_boton_volver_capa);
        vaciar2=(ImageView)findViewById(R.id.toolbar_boton_vaciar_capa);


        mostrar_hab();

        regresar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(S_dialog_capacidad.this,A1_Evaluacion.class);
                startActivity(intent);

            }
        });
    }

    private void mostrar_hab() {
        final RadioButton rc10=(RadioButton)findViewById(R.id.rcapa10);
        final RadioButton rc11=(RadioButton)findViewById(R.id.rcapa11);
        final RadioButton rc12=(RadioButton)findViewById(R.id.rcapa12);
        final RadioButton rc13=(RadioButton)findViewById(R.id.rcapa13);
        final RadioButton rc20=(RadioButton)findViewById(R.id.r2capa0);
        final RadioButton rc21=(RadioButton)findViewById(R.id.r2capa1);
        final RadioButton rc22=(RadioButton)findViewById(R.id.r2capa2);
        final RadioButton rc23=(RadioButton)findViewById(R.id.r2capa3);
        final RadioButton rc30=(RadioButton)findViewById(R.id.rcapa30);
        final RadioButton rc31=(RadioButton)findViewById(R.id.rcapa31);
        final RadioButton rc32=(RadioButton)findViewById(R.id.rcapa32);
        final RadioButton rc33=(RadioButton)findViewById(R.id.rcapa33);
        final RadioButton rc40=(RadioButton)findViewById(R.id.rcapa40);
        final RadioButton rc41=(RadioButton)findViewById(R.id.rcapa41);
        final RadioButton rc42=(RadioButton)findViewById(R.id.rcapa42);
        final RadioButton rc43=(RadioButton)findViewById(R.id.rcapa43);

        final RadioGroup rgc1=(RadioGroup)findViewById(R.id.rg1capa);
        final RadioGroup rgc2=(RadioGroup)findViewById(R.id.rg2capa);
        final RadioGroup rgc3=(RadioGroup)findViewById(R.id.rg3capa);
        final RadioGroup rgc4=(RadioGroup)findViewById(R.id.rg4capa);

        final Button btncapa=(Button)findViewById(R.id.btncapa);

        rgc1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rc10.isChecked()){
                    resc1=0;
                    System.out.println("puntaje = 0");
                }

                if(rc11.isChecked()){
                    resc1=1;
                    System.out.println("puntaje = 1");
                }
                if(rc12.isChecked()){
                    resc1=2;
                    System.out.println("puntaje = 2");
                }
                if(rc13.isChecked()){
                    resc1=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgc2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rc20.isChecked()){
                    resc2=0;
                    System.out.println("puntaje = 0");
                }

                if(rc21.isChecked()){
                    resc2=1;
                    System.out.println("puntaje = 1");
                }
                if(rc22.isChecked()){
                    resc2=2;
                    System.out.println("puntaje = 2");
                }
                if(rc23.isChecked()){
                    resc2=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgc3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rc30.isChecked()){
                    resc3=0;
                    System.out.println("puntaje = 0");
                }

                if(rc31.isChecked()){
                    resc3=1;
                    System.out.println("puntaje = 1");
                }
                if(rc32.isChecked()){
                    resc3=2;
                    System.out.println("puntaje = 2");
                }
                if(rc33.isChecked()){
                    resc3=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        rgc4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rc40.isChecked()){
                    resc4=0;
                    System.out.println("puntaje = 0");
                }

                if(rc41.isChecked()){
                    resc4=1;
                    System.out.println("puntaje = 1");
                }
                if(rc42.isChecked()){
                    resc4=2;
                    System.out.println("puntaje = 2");
                }
                if(rc43.isChecked()){
                    resc4=3;
                    System.out.println("puntaje = 3");
                }
            }
        });

        if(DataServer.CORTE==false){
        if(getIntent().getStringExtra("c1")!=null) {
            check_variables(Integer.parseInt(getIntent().getStringExtra("c1")), rc10, rc11, rc12, rc13);
            check_variables(Integer.parseInt(getIntent().getStringExtra("c2")), rc20, rc21, rc22, rc23);
            check_variables(Integer.parseInt(getIntent().getStringExtra("c3")), rc30, rc31, rc32, rc33);
            check_variables(Integer.parseInt(getIntent().getStringExtra("c4")), rc40, rc41, rc42, rc43);
            }
        }else{
            check_variables(resc1, rc10, rc11, rc12, rc13);
            check_variables(resc2, rc20, rc21, rc22, rc23);
            check_variables(resc3, rc30, rc31, rc32, rc33);
            check_variables(resc4, rc40, rc41, rc42, rc43);
        }


        vaciar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_variables(0, rc10, rc11, rc12, rc13);
                check_variables(0, rc20, rc21, rc22, rc23);
                check_variables(0, rc30, rc31, rc32, rc33);
                check_variables(0, rc40, rc41, rc42, rc43);
                Snackbar.make(v,"Opciones de capacidad deseleccionadas", Snackbar.LENGTH_LONG)
                        .show();
            }
        });


        btncapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(S_dialog_capacidad.this,A1_Evaluacion.class);

                intent.putExtra("c1",String.valueOf(resc1));
                intent.putExtra("c2",String.valueOf(resc2));
                intent.putExtra("c3",String.valueOf(resc3));
                intent.putExtra("c4",String.valueOf(resc4));

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
