package com.huiming.li.buy.ui.refresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.net.RestClient;
import com.huiming.li.buy.net.callback.ISuccess;

/**
 * @author huimingli
 * @date 2017-09-12 19:25:14
 * @description
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {
    private final SwipeRefreshLayout REFRESHLAYOUT;

    public RefreshHandler(SwipeRefreshLayout refreshLayout){
        this.REFRESHLAYOUT = refreshLayout;
        REFRESHLAYOUT.setOnRefreshListener(this);
    }

    private void refresh(){
        REFRESHLAYOUT.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESHLAYOUT.setRefreshing(false);
            }
        },2000);
    }

    public void firstPage(String url){
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {


                    }
                })
                .build().get();
    }
    @Override
    public void onRefresh() {
        refresh();
    }
}
