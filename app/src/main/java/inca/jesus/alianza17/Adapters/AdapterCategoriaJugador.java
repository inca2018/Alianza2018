package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.R;


public class AdapterCategoriaJugador extends RecyclerView.Adapter<AdapterCategoriaJugador.ViewHolder> {
    private Context context;
    private List<Jugadores_Plantel> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterCategoriaJugador(Context context, List<Jugadores_Plantel> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_jug;
        public TextView dni_jug;
        public TextView naci_jug;



        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_jug=(TextView)itemView.findViewById(R.id.card_cat_jug_nombre);
            dni_jug=(TextView) itemView.findViewById(R.id.card_cat_jug_dni);
            naci_jug=(TextView)itemView.findViewById(R.id.card_jug_fecha);


        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterCategoriaJugador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categoria_jugadores,parent,false);
        return new AdapterCategoriaJugador.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterCategoriaJugador.ViewHolder holder, final int position) {

        holder.nom_jug.setText(my_Data.get(position).getNombres());
        holder.dni_jug.setText("DNI: "+String.valueOf(my_Data.get(position).getDNI()));
        holder.naci_jug.setText("F.N:"+my_Data.get(position).getFecha_nacimiento());

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
