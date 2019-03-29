package com.example.isaquecoelho.tourguideapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toolbar;

import com.example.isaquecoelho.tourguideapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadPageActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_loadpage)
    Toolbar toolbarLoadPage;

    @BindView(R.id.webview_loadpage)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page);

        ButterKnife.bind(this);


        loadPage();
    }

    private void loadPage() {
        String EXTRA_LINK = "LINK";
        String link = getIntent().getStringExtra(EXTRA_LINK);
        webView.loadUrl(link);
    }
}
