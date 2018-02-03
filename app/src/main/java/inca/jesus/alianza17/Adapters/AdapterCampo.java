package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.R;


public class AdapterCampo extends RecyclerView.Adapter<AdapterCampo.ViewHolder> {
    private Context context;
    private List<Campo> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    int Puntostotal=0;
    AlertDialog da;

    public AdapterCampo(Context context, List<Campo> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Button dato;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            dato=(Button)itemView.findViewById(R.id.btn_campo);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public AdapterCampo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_campo,parent,false);
        return new AdapterCampo.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterCampo.ViewHolder holder, final int position) {
        holder.dato.setText(my_Data.get(position).getDato());
        holder.dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                final View dialoglayout4 = inflater.inflate(R.layout.gestion_campo, null);
                final CardView fab1=(CardView) dialoglayout4.findViewById(R.id.op1);
                final CardView fab2=(CardView) dialoglayout4.findViewById(R.id.op2);
                final CardView fab3=(CardView) dialoglayout4.findViewById(R.id.op3);
                final CardView fab4=(CardView) dialoglayout4.findViewById(R.id.op4);
                final CardView fab5=(CardView) dialoglayout4.findViewById(R.id.op5);

                final AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                da=builder4.show();

                fab1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("P");
                        my_Data.get(position).setCant(-1);
                        Puntostotal=Puntostotal-1;
                        notifyDataSetChanged();
                        da.dismiss();

                    }
                });
                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("R");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });

                fab3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("PG");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
                fab4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("DR");
                        my_Data.get(position).setCant(1);
                        Puntostotal=Puntostotal+1;
                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
                fab5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        my_Data.get(position).setDato("G");
                        my_Data.get(position).setCant(3);
                        Puntostotal=Puntostotal+1;
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
    public int getPuntostotal() {
        return Puntostotal;
    }
    public int getP(){
        int sum=0;
        for(int i=0;i<getItemCount();i++){
            if(my_Data.get(i).getCant()==1){
                sum=sum+1;
            }else{
                sum=0;
            }
        }
        return sum;
    }
    public int getR(){
        int sum=0;
        for(int i=0;i<getItemCount();i++){
            if(my_Data.get(i).getDato().equalsIgnoreCase("R")){
                sum=sum+1;
            }else{
                sum=0;
            }

        }
        return sum;
    }
    public int getPG(){
        int sum=0;
        for(int i=0;i<getItemCount();i++){
            if(my_Data.get(i).getDato().equalsIgnoreCase("PG")){
                sum=sum+1;
            }else{
                sum=0;
            }

        }
        return sum;
    }
    public int getDR(){
        int sum=0;
        for(int i=0;i<getItemCount();i++){
            if(my_Data.get(i).getDato().equalsIgnoreCase("DR")){
                sum=sum+1;
            }else{
                sum=0;
            }

        }
        return sum;
    }

}
