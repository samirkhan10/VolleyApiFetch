package com.example.myapitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class githubAdaptor extends RecyclerView.Adapter<githubAdaptor.GithubViewHolder> {

    private Context context;
    private User[] data;
    public githubAdaptor ( Context context , User[] data )
    {

        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user_layout,parent,false);

        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        User user = data[position];
        holder.Utxt.setText(user.getLogin());
        Glide.with(holder.Uimg.getContext()).load(user.getAvatarUrl()).into(holder.Uimg);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class GithubViewHolder extends RecyclerView.ViewHolder {

        ImageView Uimg;
        TextView Utxt;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);

            Uimg = itemView.findViewById(R.id.imgUser);
            Utxt = itemView.findViewById(R.id.userText);
        }
    }
}
