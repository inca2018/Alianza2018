package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.R;


public class AdapterCreacionCategoria extends RecyclerView.Adapter<AdapterCreacionCategoria.ViewHolder> {
    private Context context;
    private List<Plantel> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;


    public AdapterCreacionCategoria(Context context, List<Plantel> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_dep;
        public CheckBox check;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_dep=(TextView)itemView.findViewById(R.id.card_creacion_nombre);
            check=(CheckBox)itemView.findViewById(R.id.card_creacion_chek);
            this.setIsRecyclable (false);

         }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }



    }

    public AdapterCreacionCategoria.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_creacion_equipo,parent,false);
        return new AdapterCreacionCategoria.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterCreacionCategoria.ViewHolder holder, final int position) {
        final ViewHolder itemHolder = (ViewHolder)holder;
        holder.nom_dep.setText(my_Data.get(position).getNom_completo().toString());


        holder.check.setOnCheckedChangeListener(null);

        if(my_Data.get(position).getSelect()==1){
            holder.check.setChecked(true);
        }else{
            holder.check.setChecked(false);
        }

        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    my_Data.get(holder.getAdapterPosition()).setSelect(1);
                    notifyDataSetChanged();
                }
                if(isChecked==false){
                    my_Data.get(holder.getAdapterPosition()).setSelect(0);
                    notifyDataSetChanged();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }

    public int getCheke(){
        int cont=0;
        for (int i=0;i<getItemCount();i++){
            if(my_Data.get(i).getSelect()==1){
                cont=cont+1;
            }
        }
        return cont;
    }
    public void bloquear(){

    }

}
