package com.tiendanube.presentation.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tiendanube.R;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.fragment.DogFragment;

public class DogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;
    public TextView txtName;
    public TextView txtTemperament;
    public RelativeLayout relativeLayout;

    public DogViewHolder(View itemView) {

        super(itemView);
        imageView = itemView.findViewById(R.id.image_view);
        relativeLayout = itemView.findViewById(R.id.relative_layout);
        relativeLayout.setOnClickListener(this);
        txtName = itemView.findViewById(R.id.txt_name);
        txtTemperament = itemView.findViewById(R.id.txt_temperament);
    }

    /*
     * exibe o nome do cachorro apos click do item.
     */
    @Override
    public void onClick(View v) {

        HomeActivity homeActivity = ((HomeActivity) itemView.getContext());
        homeActivity.animationView(v);
        DogFragment dogFragment = (DogFragment) homeActivity.animalsFragmentAdapter.getItem(1);
        homeActivity.showToast(dogFragment.listDogs.get(getAdapterPosition()).getListBreesds().get(0).getName());
    }
}
