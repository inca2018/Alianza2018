package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.Clases.Gestion_detalle;
import inca.jesus.alianza17.R;


public class AdapterDetalle extends RecyclerView.Adapter<AdapterDetalle.ViewHolder> {
    private Context context;
    private List<Gestion_detalle> my_Data;
    AlertDialog da;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;



    public AdapterDetalle(Context context, List<Gestion_detalle> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            t1=(TextView)itemView.findViewById(R.id.card_ge_nom);
            t2=(TextView)itemView.findViewById(R.id.card_ge_num);
            t3=(TextView)itemView.findViewById(R.id.card_ge_pos);

            t4=(TextView)itemView.findViewById(R.id.o1);
            t5=(TextView)itemView.findViewById(R.id.o2);
            t6=(TextView)itemView.findViewById(R.id.o3);
            t7=(TextView)itemView.findViewById(R.id.o4);
            t8=(TextView)itemView.findViewById(R.id.o5);
            t9=(TextView)itemView.findViewById(R.id.o6);
            t10=(TextView)itemView.findViewById(R.id.o7);
            t11=(TextView)itemView.findViewById(R.id.o8);
            t12=(TextView)itemView.findViewById(R.id.o9);
            t13=(TextView)itemView.findViewById(R.id.o10);
            t14=(TextView)itemView.findViewById(R.id.o11);
            t15=(TextView)itemView.findViewById(R.id.o12);
            t16=(TextView)itemView.findViewById(R.id.o13);
            t17=(TextView)itemView.findViewById(R.id.o14);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public AdapterDetalle.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_detalle_ges,parent,false);
        return new AdapterDetalle.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final AdapterDetalle.ViewHolder holder, final int position) {

        holder.t1.setText(my_Data.get(position).getNom_jugador());
        holder.t2.setText(String.valueOf(my_Data.get(position).getCo_jug()));
        holder.t3.setText(String.valueOf(my_Data.get(position).getCo_pos()));

        holder.t4.setText(String.valueOf(my_Data.get(position).getC1()));
        holder.t5.setText(String.valueOf(my_Data.get(position).getC2()));
        holder.t6.setText(String.valueOf(my_Data.get(position).getC3()));
        holder.t7.setText(String.valueOf(my_Data.get(position).getC4()));
        holder.t8.setText(String.valueOf(my_Data.get(position).getC5()));
        holder.t9.setText(String.valueOf(my_Data.get(position).getC6()));
        holder.t10.setText(String.valueOf(my_Data.get(position).getC7()));
        holder.t11.setText(String.valueOf(my_Data.get(position).getC8()));
        holder.t12.setText(String.valueOf(my_Data.get(position).getC9()));
        holder.t13.setText(String.valueOf(my_Data.get(position).getC10()));
        holder.t14.setText(String.valueOf(my_Data.get(position).getC11()));
        holder.t15.setText(String.valueOf(my_Data.get(position).getC12()));
        holder.t16.setText(String.valueOf(my_Data.get(position).getC13()));
        holder.t17.setText(String.valueOf(my_Data.get(position).getC14()));


        holder.t16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                final View dialoglayout4 = inflater.inflate(R.layout.tiempo_jugado, null);
                final EditText ed=(EditText)dialoglayout4.findViewById(R.id.tiempo_jugado);
                final Button btn=(Button)dialoglayout4.findViewById(R.id.guardar_tiempo);
                final AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                da=builder4.show();

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         int tie=Integer.parseInt(ed.getText().toString());
                        my_Data.get(position).setC13(tie);
                        holder.t13.setText(String.valueOf(tie));
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
            }
        });
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
