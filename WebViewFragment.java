package com.example.ucm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFragment extends Fragment {

    private WebView mWebView;
    public static String mURL = "https://kingcounty.gov/depts/transportation/metro.aspx";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.web_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            mURL = savedInstanceState.getString("currentURL", "");
        }

        if(!mURL.equals("")) {
            mWebView = getView().findViewById(R.id.pageInfo);
            mWebView.setWebViewClient(new WebViewClient());
            WebSettings websettings = mWebView.getSettings();
            websettings.setJavaScriptEnabled(true);
            mWebView.loadUrl(mURL);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentURL", mURL);
    }


    public void setURLContent(String URL) {
        mURL = URL;
    }

    public void updateURLContent(String URL) {
        mURL = URL;
        WebView webView = getView().findViewById(R.id.pageInfo);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(mURL.trim());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false; // Let our WebView to load the page.
        }
    }
}
