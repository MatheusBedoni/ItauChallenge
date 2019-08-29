package com.example.itauchallenge.adapter;

import com.example.itauchallenge.domain.User;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

public class OrderAdapter extends FirebaseRecyclerAdapter<User,OrderViewHolder> {


    public OrderAdapter(Class<User> modelClass, int modelLayout, Class<OrderViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(OrderViewHolder orderViewHolder, User user, int i) {

    }
}