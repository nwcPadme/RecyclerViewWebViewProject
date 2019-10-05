package com.example.ucm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ListAppsFragment extends RecyclerView.Adapter<ListAppsFragment.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view);
            imageView    = itemView.findViewById(R.id.image_view);
        }
    }

    private ArrayList<AppModel> dataset;

    public ListAppsFragment(ArrayList<AppModel> data) {
        dataset = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apps_layout, parent, false);

        //view.setOnClickListener(ListAppsActivity.myOnClickListener);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textViewName;
        ImageView imageView   = holder.imageView;

        textViewName.setText(dataset.get(listPosition).getName());
        imageView.setImageResource(dataset.get(listPosition).getImage());
    }

    public int getItemCount() {
        return dataset.size();
    }
}
