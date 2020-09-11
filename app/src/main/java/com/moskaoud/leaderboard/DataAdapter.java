package com.moskaoud.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private final ArrayList<Data> dataList;
    private LayoutInflater mInflater;

    public DataAdapter(@NonNull Context context, ArrayList<Data> data) {
        mInflater = LayoutInflater.from(context);
        dataList = data;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.data_row, parent, false);
        return new DataViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        int score = dataList.get(position).getScore();
        int hours = dataList.get(position).getHours();
        String country = dataList.get(position).getCountry();
        String name = dataList.get(position).getName();
        String imgUrl = dataList.get(position).getBadgeUrl();

        if(score >0)
            holder.data.setText(score+" skill IQ Score,"+country);
        else
            holder.data.setText(hours+" learning hours,"+country);

        holder.name.setText(name);
        Picasso.get().load(imgUrl).into( holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image;
        public final TextView name;
        public final TextView data;
        final DataAdapter mAdapter;

        public DataViewHolder(@NonNull View itemView, DataAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            image = itemView.findViewById(R.id.iv_image);
            name = itemView.findViewById(R.id.tv_name);
            data = itemView.findViewById(R.id.tv_value);

        }
    }
}
















