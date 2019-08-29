package com.example.itauchallenge.adapter;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.itauchallenge.R;

public class OrderViewHolder extends RecyclerView.ViewHolder{
    public TextView tvNome;

    public OrderViewHolder(View itemView) {
        super(itemView);
        tvNome = (TextView)itemView.findViewById(R.id.nome);

    }
}