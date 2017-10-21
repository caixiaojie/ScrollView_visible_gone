package com.example.caixiaojie.test;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ObservableScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshScrollView pullToRefreshScrollView;
    private TextView tvTop;
    private TextView tvCenter;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        pullToRefreshScrollView = (PullToRefreshScrollView) findViewById(R.id.ptrScrollView);
        tvTop = (TextView) findViewById(R.id.tvTop);
        tvCenter = (TextView) findViewById(R.id.tvCenter);

        ObservableScrollView refreshableView = pullToRefreshScrollView.getRefreshableView();
        refreshableView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldX, int oldY) {
                Log.e("distance==",x + " " + y + " " + oldX + " " + oldY);
                if (y > Tools.dip2px(activity,100)) {
                    tvTop.setVisibility(View.VISIBLE);
                    tvCenter.setVisibility(View.GONE);
                }else {
                    tvTop.setVisibility(View.GONE);
                    tvCenter.setVisibility(View.VISIBLE);
                }
            }
        });

        pullToRefreshScrollView.setPullScrollViewListener(new PullToRefreshScrollView.PullScrollViewListener() {
            @Override
            public void onScrollChanged(PullToRefreshScrollView pullToRefreshScrollView, int x, int y, int oldX, int oldY) {
                Log.e("distance",x + " " + y + " " + oldX + " " + oldY);
            }
        });
    }
}
