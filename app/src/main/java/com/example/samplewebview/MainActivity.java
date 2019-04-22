package com.example.samplewebview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private Button button;
    private WebView webView;
    private ImageButton up_btn;
    private ImageButton down_btn;
    private ConstraintLayout layout;
    private Animation down_anim;
    private Animation up_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input_addr);
        button = (Button) findViewById(R.id.go_button);
        webView = (WebView) findViewById(R.id.webView);
        up_btn = (ImageButton) findViewById(R.id.up_btn);
        down_btn = (ImageButton) findViewById(R.id.down_btn);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        down_anim = AnimationUtils.loadAnimation(this, R.anim.down_flow);
        up_anim = AnimationUtils.loadAnimation(this, R.anim.up_flow);

        up_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout.setVisibility(View.GONE);
                up_btn.setVisibility(View.GONE);
                down_btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new WebViewClient());  // 메소드 입력 안 하면 새 창에서 웹 열림
                webView.loadUrl("http://" + input.getText().toString());  // http 미리 입력해둠
            }
        });

        down_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_btn.setVisibility(View.VISIBLE);
                down_btn.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);
                layout.startAnimation(down_anim);
            }
        });

        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.startAnimation(up_anim);
            }
        });

    }
}
