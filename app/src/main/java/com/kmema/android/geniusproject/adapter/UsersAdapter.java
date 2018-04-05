package com.kmema.android.geniusproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmema.android.geniusproject.R;
import com.kmema.android.geniusproject.model.UpdatedUserData;
import com.kmema.android.geniusproject.model.UserData;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private List<Object> mUserList;
    private Picasso mPicasso;
    private final int USER = 0, NEW_USER = 1;
    public UsersAdapter(List<Object> mUserList) {
        this.mUserList = mUserList;
        mPicasso = Picasso.get();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case USER:
                View viewUser = inflater.inflate(R.layout.user, parent, false);
                viewHolder = new UserViewHolder(viewUser);
                break;
            case NEW_USER:
                break;
            default:
                View view = inflater.inflate(null, parent, false);
                viewHolder = new UserViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case USER:
                UserViewHolder userView = (UserViewHolder) holder;
                configureUserViewHolder(userView, position);
                break;
            case NEW_USER:
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (mUserList.get(position) instanceof UserData) {
            return USER;
        } else if (mUserList.get(position) instanceof UpdatedUserData) {
            return NEW_USER;
        } else {
            return -1;
        }
    }

    private void configureUserViewHolder(UserViewHolder userView, int position) {
        UserData userData = (UserData) mUserList.get(position);
        userView.tvFirstName.setText(userData.getFirst_name());
        userView.tvSurName.setText(userData.getLast_name());
        mPicasso.load(userData.getAvatar()).transform(new CropCircleTransformation()).into(userView.imAvatar);
    }

}
