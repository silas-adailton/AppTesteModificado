package com.example.autodoc.appteste.presentation.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.autodoc.appteste.R;
import com.example.autodoc.appteste.domain.message.Home;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRowAdapter extends RecyclerView.Adapter<HomeRowAdapter.ViewHolder> {
    List<Home> lista;

    public HomeRowAdapter(List<Home> lista) {
        this.lista = lista;
    }

    @Override
    public HomeRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_message, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeRowAdapter.ViewHolder holder, int position) {

        Object message = lista.get(position);

        holder.textViewMessage.setText(message.toString());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textViewItem)
        TextView textViewMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(itemView.getContext(), "Posição: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
