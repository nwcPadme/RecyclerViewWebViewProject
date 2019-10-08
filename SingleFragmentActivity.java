package com.example.ucm;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();
    boolean webPage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(findViewById(R.id.fragment_list_container) != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ListAppsFragment fragmentRecycler = new ListAppsFragment();
                ft.add(R.id.fragment_list_container, fragmentRecycler);
                ft.commit();
            }

            if(findViewById(R.id.fragment_web_container) != null) {
                webPage = true;
                getSupportFragmentManager().popBackStack();

                WebViewFragment webFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_web_container);

                if(webFragment == null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    webFragment = new WebViewFragment();
                    ft.replace(R.id.fragment_web_container, webFragment);
                    ft.commit();
                }
            }
        } else {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            if(fragment == null) {
                fragment = createFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        }
    }
}
