package com.example.json_soccer_arnau;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<League> mLeague;

    public MyAdapter(Context mContext, List<League> mLeague) {
        this.mContext = mContext;
        this.mLeague = mLeague;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.league_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.strLeague.setText(mLeague.get(position).getStrLeague());
        holder.strDescriptionEN.setText(mLeague.get(position).getStrDescriptionEN() );
        Picasso.get().load(mLeague.get(position).getStrBadge())
                .fit()
                .centerCrop()
                .into(holder.strBadge);
        holder.buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ArrayList<String> images = new ArrayList<>();
        images.add(mLeague.get(position).getStrFanart1());
        images.add(mLeague.get(position).getStrFanart2());
        images.add(mLeague.get(position).getStrFanart3());
        images.add(mLeague.get(position).getStrFanart4());

        holder.buttonImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mLeague.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView strBadge;
        TextView strLeague;
        TextView strDescriptionEN;
        Button buttonWeb;
        Button buttonImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            strBadge = itemView.findViewById(R.id.flag);
            strLeague = itemView.findViewById(R.id.textTitle);
            strDescriptionEN = itemView.findViewById(R.id.textDescription);
            buttonWeb = itemView.findViewById(R.id.visitWeb);
            buttonImg = itemView.findViewById(R.id.images);
        }
    }
}
