package com.example.ucm;

import android.app.Activity;
import android.content.Context;
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
import java.util.List;

public class ListAppsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ListAppsAdapter mAdapter;
    OnURLSelectedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps_list, container, false);

        mRecyclerView = view.findViewById(R.id.app_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //displayRecyclerView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity) {
            /*
            try {
                mListener = (OnURLSelectedListener) context;
            } catch (ClassCastException e) {
                throw new ClassCastException(context.toString() + " must implement OnURLSelectedListener");
            }
            */
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        AppList appList = AppList.get(getActivity());
        List<AppModel> appModel = appList.getApps();

        if(mAdapter == null) {
            mAdapter = new ListAppsAdapter(appModel);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class AppListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AppModel mApp;
        private TextView mTextView;
        private ImageView mImageView;

        public void bind(AppModel app) {
            mApp = app;
            mTextView.setText(mApp.getName());
            mImageView.setImageResource(mApp.getImage());
        }

        public AppListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.apps_layout, parent, false));
            itemView.setOnClickListener(this);

            mTextView  = itemView.findViewById(R.id.text_view);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        @Override
        public void onClick(View view) {
            Intent intent = WebViewActivity.newIntent(getActivity(), mApp.getID());
            startActivity(intent);
        }
    }

    private class ListAppsAdapter extends RecyclerView.Adapter<AppListHolder> {

        public List<AppModel> data;

        public ListAppsAdapter(List<AppModel> apps) {
            data = apps;
        }

        @Override
        public AppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new AppListHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(AppListHolder holder, int position) {
            AppModel app = data.get(position);
            holder.bind(app);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    public interface OnURLSelectedListener {
        public void onURLSelected(String URL);
    }
}
