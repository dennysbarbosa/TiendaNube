package com.tiendanube.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.tiendanube.R;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.holder.CommonViewHolder;

import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ID_CAT = 0;
    private static final int ID_DOG = 1;
    private View view;
    public List<DogModel> listDog;

    public CommonAdapter(List<DogModel> listDog) {
        this.listDog = listDog;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new CommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CommonViewHolder commonViewHolder = (CommonViewHolder) holder;

        Picasso.with(view.getRootView().getContext()).load(listDog.get(position).getImageUrl()).into(commonViewHolder.imageView);
        String name = listDog.get(position).getListBreesds().get(0).name != null ? listDog.get(position).getListBreesds().get(0).name : "";
        commonViewHolder.txtName.setText(name);
        String temperament = listDog.get(position).getListBreesds().get(0).temperament != null ? listDog.get(position).getListBreesds().get(0).temperament : "";

        if(!temperament.isEmpty()) {
            commonViewHolder.txtTemperament.setText(temperament);
        }else{
            commonViewHolder.txtTemperament.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listDog != null ? listDog.size() : 0;
    }

}
