package com.tiendanube.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tiendanube.R;
import com.tiendanube.presentation.holder.CommonViewHolder;

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ID_CAT = 0;
    private static final int ID_DOG = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new CommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
