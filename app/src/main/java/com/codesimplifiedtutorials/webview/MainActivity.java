package com.codesimplifiedtutorials.webview;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Button b1;
    EditText ed1;

    private WebView wv1;
    String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());

        wv1.loadUrl("https://google.com");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ed1.getText().toString().equals("")) {

                    if (!ed1.getText().toString().contains("http")){
                        url = "https://"+ed1.getText().toString();
                    }
                    else {
                        url = ed1.getText().toString();
                    }
                        wv1.getSettings().setLoadsImagesAutomatically(true);
                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        wv1.loadUrl(url);


                }
                else
                    Toast.makeText(MainActivity.this, "Enter url", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}