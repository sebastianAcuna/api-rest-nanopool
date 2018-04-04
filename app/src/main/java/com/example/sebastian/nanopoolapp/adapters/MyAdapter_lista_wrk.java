package com.example.sebastian.nanopoolapp.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.sebastian.nanopoolapp.R;
import com.example.sebastian.nanopoolapp.clases.Worker;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MyAdapter_lista_wrk extends RecyclerView.Adapter<MyAdapter_lista_wrk.ViewHolder> {

    private List<Worker> items;
    Context contexto;


    public interface OnItemClickListener { void onItemClick(Worker item); }

    public MyAdapter_lista_wrk(Context contexto, ArrayList<Worker> items) {
        this.contexto = contexto;
        this.items = items;
    }



    @Override
    public MyAdapter_lista_wrk.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_workers, parent,false);
        return new MyAdapter_lista_wrk.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter_lista_wrk.ViewHolder holder, int position) {
        holder.bind(contexto, items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView worker, hs ,h1,h3,h6,h12,h24;

        public ViewHolder(View itemView) {
            super(itemView);
            h1 = itemView.findViewById(R.id.tv_h1);
            h3= itemView.findViewById(R.id.tv_h3);
            h6= itemView.findViewById(R.id.tv_h6);
            h12 = itemView.findViewById(R.id.tv_h12);
            h24 = itemView.findViewById(R.id.tv_h24);
            worker = itemView.findViewById(R.id.tv_worker);
            hs = itemView.findViewById(R.id.tv_hs);
        }

        public void bind(Context contexto, final Worker item){
            worker.setText(item.getId());
            hs.setText(item.getHashrate());
            h1.setText(item.getH1());
            h3.setText(item.getH3());
            h6.setText(item.getH6());
            h12.setText(item.getH12());
            h24.setText(item.getH24());
        }
    }
}
