package com.example.json_soccer_arnau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        holder.textTitle.setText(mLeague.get(position).getTextTitle());
        holder.textDescription.setText(mLeague.get(position).getTextDescription() );
        Picasso.get().load(mLeague.get(position).getFlag())
                .fit()
                .centerCrop()
                .into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return mLeague.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView flag;
        TextView textTitle;
        TextView textDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
