package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.JugadorMiEquipo;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.R;


public class AdapterEditarEquipo extends RecyclerView.Adapter<AdapterEditarEquipo.ViewHolder> {
    private Context context;
    private List<JugadorMiEquipo> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;


    public AdapterEditarEquipo(Context context, List<JugadorMiEquipo> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_dep;
        public Spinner sp1,sp2;
        public EditText edit;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_dep=(TextView)itemView.findViewById(R.id.card_creacion_nombre);
            sp1=(Spinner)itemView.findViewById(R.id.spinner);
            sp2=(Spinner)itemView.findViewById(R.id.spinner2);
            edit=(EditText)itemView.findViewById(R.id.num_camiseta);


         }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }



    }

    public AdapterEditarEquipo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_editar_equipo,parent,false);
        return new AdapterEditarEquipo.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterEditarEquipo.ViewHolder holder, final int position) {
        final ViewHolder itemHolder = (ViewHolder)holder;
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Titular");
        categories2.add("Banca");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.sp1.setAdapter(dataAdapter2);

        List<String> categories = new ArrayList<String>();
        categories.add("ARQ");
        categories.add("DFC");
        categories.add("DFD");
        categories.add("DFI");
        categories.add("MC");
        categories.add("MCD");
        categories.add("MO");
        categories.add("MLD");
        categories.add("MLI");
        categories.add("SD");
        categories.add("EXD");
        categories.add("EXI");
        categories.add("DC");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.sp2.setAdapter(dataAdapter);


        if(holder.edit.getText().toString().equalsIgnoreCase("")){

        }else{
            holder.edit.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    my_Data.get(position).setCamiseta(Integer.parseInt(s.toString()));
                    notifyDataSetChanged();
                }
            });

        }

        holder.nom_dep.setText(my_Data.get(position).getNombres().toString());


        holder.sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String selected = parent.getItemAtPosition(pos).toString();
                my_Data.get(position).setTitular(selected);
                notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String selected = parent.getItemAtPosition(pos).toString();
                my_Data.get(position).setPosicion(selected);
                notifyDataSetChanged();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }


}
