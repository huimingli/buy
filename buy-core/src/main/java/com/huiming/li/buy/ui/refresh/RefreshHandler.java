package com.huiming.li.buy.ui.refresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.net.RestClient;
import com.huiming.li.buy.net.callback.ISuccess;
import com.huiming.li.buy.ui.recycler.DataConverter;
import com.huiming.li.buy.ui.recycler.MultipleRecyclerViewAdapter;

/**
 * @author huimingli
 * @date 2017-09-12 19:25:14
 * @description
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener ,BaseQuickAdapter.RequestLoadMoreListener{
    private final SwipeRefreshLayout REFRESHLAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerViewAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout,RecyclerView recyclerView,DataConverter converter,PagingBean bean){
        this.REFRESHLAYOUT = swipeRefreshLayout;
        this.RECYCLERVIEW = recyclerView;
        this.CONVERTER = converter;
        this.BEAN = bean;
        REFRESHLAYOUT.setOnRefreshListener(this);
    }

    public static  RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,
                                         RecyclerView recyclerView,
                                         DataConverter converter,
                                         PagingBean bean){
        return new RefreshHandler(swipeRefreshLayout,recyclerView,converter,new PagingBean());
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
        BEAN.setDelayed(1000);
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        mAdapter = MultipleRecyclerViewAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this,RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();

                    }
                })
                .build().get();
    }
    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
