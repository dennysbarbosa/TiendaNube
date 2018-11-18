package com.tiendanube.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.tiendanube.R;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.holder.DogViewHolder;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogViewHolder> {

    private View view;
    public List<DogModel> listDog;

    public DogAdapter(List<DogModel> listDog) {
        this.listDog = listDog;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, null);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {

        Picasso.with(view.getRootView().getContext()).load(listDog.get(position).getImageUrl()).into(holder.imageView);
        String name = listDog.get(position).getListBreesds().get(0).name != null ? listDog.get(position).getListBreesds().get(0).name : "";
        holder.txtName.setText(name);
        String temperament = listDog.get(position).getListBreesds().get(0).temperament != null ? listDog.get(position).getListBreesds().get(0).temperament : "";

        if(!temperament.isEmpty()) {
            holder.txtTemperament.setText(temperament);
        }else{
            holder.txtTemperament.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listDog != null ? listDog.size() : 0;
    }

}
