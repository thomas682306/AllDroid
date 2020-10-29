package com.example.alldroid.AdisPackage;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.alldroid.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class WebViewFragment extends Fragment {
    WebView webView;
    ProgressBar progressBar;
    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    // added a comment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String url = getArguments().getString("url");

        webView = view.findViewById(R.id.webView);
        progressBar=view.findViewById(R.id.progress_circular);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        webView.setWebViewClient(new WebViewClient(){
            @Override public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webView.setVisibility(View.INVISIBLE);
            }

            @Override public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progressBar.setVisibility(ProgressBar.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

}




