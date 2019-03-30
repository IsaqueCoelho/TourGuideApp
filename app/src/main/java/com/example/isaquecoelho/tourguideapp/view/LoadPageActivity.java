package com.example.isaquecoelho.tourguideapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.isaquecoelho.tourguideapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadPageActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LoadPageActivity";

    @BindView(R.id.toolbar_loadpage)
    Toolbar toolbarLoadPage;

    @BindView(R.id.framelayout_loadpage)
    FrameLayout frameLayoutLoadPage;

    @BindView(R.id.progress_loadpage)
    ProgressBar progressBarLoadPage;

    @BindView(R.id.webview_loadpage)
    WebView webViewLoadPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page);

        ButterKnife.bind(this);
        
        settingToolbar();

        loadPage();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void settingToolbar() {
        setSupportActionBar(toolbarLoadPage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void loadPage() {
        String EXTRA_LINK = "LINK";
        String link = getIntent().getStringExtra(EXTRA_LINK);

        frameLayoutLoadPage.setVisibility(View.VISIBLE);
        progressBarLoadPage.setVisibility(View.VISIBLE);

        webViewLoadPage.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if(newProgress == 100){
                    frameLayoutLoadPage.setVisibility(View.GONE);
                    progressBarLoadPage.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });

        webViewLoadPage.loadUrl(link);

        WebSettings webSettings = webViewLoadPage.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
