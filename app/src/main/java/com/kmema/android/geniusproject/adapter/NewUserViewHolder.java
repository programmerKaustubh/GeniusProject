package com.kmema.android.geniusproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kmema.android.geniusproject.R;

public class NewUserViewHolder extends RecyclerView.ViewHolder {


    TextView tvName, tvJob, tvTime, tvId;
    ImageView ivNewUser;

    NewUserViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        tvId = itemView.findViewById(R.id.tvId);
        tvJob = itemView.findViewById(R.id.tvJob);
        tvTime = itemView.findViewById(R.id.tvTime);
        ivNewUser = itemView.findViewById(R.id.ivAvater);
    }
}
