package com.example.ucm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends SingleFragmentActivity implements ListAppsFragment.OnURLSelectedListener{

    @Override
    protected Fragment createFragment() {
        return new ListAppsFragment();
    }

    @Override
    public void onURLSelected(String URL) {
        if(webPage) {
            WebViewFragment webViewFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_web_container);
            webViewFragment.updateURLContent(URL);
        } else {
            WebViewFragment webViewFragment = new WebViewFragment();
            webViewFragment.setURLContent(URL);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_list_container, webViewFragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
