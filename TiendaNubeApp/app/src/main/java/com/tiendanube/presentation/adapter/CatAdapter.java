package com.tiendanube.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.tiendanube.R;
import com.tiendanube.model.CatModel;
import com.tiendanube.presentation.holder.CatViewHolder;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder> {

    private List<CatModel> listCats;
    private View view;

    public CatAdapter(List<CatModel> listCats) {
        this.listCats = listCats;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, null);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {

        Picasso.with(view.getRootView().getContext()).load(listCats.get(position).getImageUrl()).into(holder.circularImageView);
    }

    @Override
    public int getItemCount() {
        return listCats != null ? listCats.size() : 0;
    }

}
