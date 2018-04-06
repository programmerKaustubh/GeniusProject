package com.kmema.android.geniusproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kmema.android.geniusproject.R;

public class UserViewHolder extends RecyclerView.ViewHolder{

    final TextView tvFirstName;
    TextView tvSurName;
    ImageView imAvatar;

    UserViewHolder(View itemView) {
        super(itemView);
        tvFirstName = itemView.findViewById(R.id.textViewFirstName);
        tvSurName = itemView.findViewById(R.id.textViewSurname);
        imAvatar = itemView.findViewById(R.id.imageViewAvatar);
    }
}
