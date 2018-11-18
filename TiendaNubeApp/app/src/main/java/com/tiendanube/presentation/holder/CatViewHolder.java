package com.tiendanube.presentation.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.tiendanube.R;

public class CatViewHolder extends RecyclerView.ViewHolder {

    public CircularImageView circularImageView;

    public CatViewHolder(View itemView) {

        super(itemView);
        circularImageView = itemView.findViewById(R.id.circular_image_view);
    }
}

