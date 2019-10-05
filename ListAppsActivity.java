package com.example.ucm;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListAppsActivity extends AppCompatActivity {

    private static ArrayList<AppModel> data;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView.LayoutManager layoutManager;
    private static View.OnClickListener myOnClickListener;
    private static RecyclerView mAppListRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_apps_list);

        //myOnClickListener = new myOnClickListener(this);
        mAppListRecycleView = findViewById(R.id.app_list_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        mAppListRecycleView.setLayoutManager(layoutManager);

        data = new ArrayList<AppModel>();

        for(int i = 0; i < AppData.nameArray.length; i++) {
            data.add(new AppModel(
                    AppData.nameArray[i],
                    AppData.id[i],
                    AppData.drawable[i]
            ));
        }

        adapter = new ListAppsFragment(data);
        mAppListRecycleView.setAdapter(adapter);
    }

    private static class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }
}
