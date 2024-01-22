package com.example.money_exchange;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



    public class DivisaAdapter extends RecyclerView.Adapter<DivisaAdapter.MyViewHolder> {
        Context context;
        ArrayList<DivisaM> divisaM;
        private int itemSeleccionado = -1;
        private AdapterView.OnItemClickListener onItemClickListener;


        public DivisaAdapter(Context context, ArrayList<DivisaM> divisaM) {
            this.context = context;
            this.divisaM = divisaM;
        }

        @NonNull
        @Override
        public DivisaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.dv_row, parent,false);
            return  new DivisaAdapter.MyViewHolder(view);
        }

        @Override


        public void onBindViewHolder(@NonNull DivisaAdapter.MyViewHolder holder,  int position) {
            holder.Name.setText(divisaM.get(position).getDivisaName());
            holder.Cambio.setText(divisaM.get(position).getChange());
            holder.ivLogo.setImageDrawable(divisaM.get(position).getDivisaLogo());


            int backgroundColor = (position == itemSeleccionado) ? Color.parseColor("#5c0099") : Color.WHITE;
            holder.itemView.setBackgroundColor(backgroundColor);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSeleccionado = position;
                    notifyDataSetChanged();
                    MainActivity.CALCULO = Double.parseDouble(holder.Cambio.getText().toString());
                    if (onItemClickListener != null) {
                        //onItemClickListener.onItemClick(position);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return divisaM.size();
        }

        public void setOnItemClickListener(DivisaAdapter.OnItemClickListener onItemClickListener) {
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            TextView Name, Cambio;
            ImageView ivLogo;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                Name = itemView.findViewById(R.id.TV_Moneda);
                Cambio = itemView.findViewById(R.id.TV_cambioMoneda);
                ivLogo = itemView.findViewById(R.id.img_Logo);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), Cambio.getText(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        }


        public class OnItemClickListener {
        }
    }

