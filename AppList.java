package com.example.ucm;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AppList {
    private static AppList sAppList;
    private Context mContext;
    private List<AppModel> mAppLists;

    public static AppList get(Context context) {
        if(sAppList == null) {
            sAppList = new AppList(context);
        }

        return sAppList;
    }

    private AppList(Context context) {
        mContext = context.getApplicationContext();
        mAppLists = new ArrayList<>();
        for(int i = 0; i < AppData.nameArray.length; i++) {
            mAppLists.add(new AppModel(
                    AppData.nameArray[i],
                    AppData.URLS[i],
                    AppData.id[i],
                    AppData.drawable[i]
            ));
        }
    }

    public List<AppModel> getApps() {
        return new ArrayList<>(mAppLists);
    }

    public AppModel getApp(int id) {
        return mAppLists.get(id);
    }
}
