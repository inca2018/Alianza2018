package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Detalle;
import inca.jesus.alianza17.Clases.Gestion_detalle;
import inca.jesus.alianza17.R;


public class AdapterDetalle2 extends RecyclerView.Adapter<AdapterDetalle2.ViewHolder> {
    private Context context;
    private List<Detalle> my_Data;
    AlertDialog da;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;



    public AdapterDetalle2(Context context, List<Detalle> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView t1,t2;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            t1=(TextView)itemView.findViewById(R.id.card_detalle_nom);
            t2=(TextView)itemView.findViewById(R.id.card_detalle_ptos);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public AdapterDetalle2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_detalle_ges2,parent,false);
        return new AdapterDetalle2.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final AdapterDetalle2.ViewHolder holder, final int position) {

        holder.t1.setText(my_Data.get(position).getNombre());
        holder.t2.setText(String.valueOf(my_Data.get(position).getPtos()));


    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
