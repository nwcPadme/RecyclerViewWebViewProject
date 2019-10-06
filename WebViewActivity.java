package com.example.ucm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class WebViewActivity extends SingleFragmentActivity {

    private static final String EXTRA_APP_ID = "com.example.ucm.app_id";

    @Override
    protected Fragment createFragment() {
        return new WebViewFragment();
    }

    public static Intent newIntent(Context packageContext, int appID) {
        Intent intent = new Intent(packageContext, WebViewActivity.class);
        intent.putExtra(EXTRA_APP_ID, appID);
        return intent;
    }
}
