package com.huiming.li.buymeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.huiming.li.buy.delegate.LatteDelegate;
import com.huiming.li.buy.net.RestClient;
import com.huiming.li.buy.net.callback.IError;
import com.huiming.li.buy.net.callback.IFailure;
import com.huiming.li.buy.net.callback.ISuccess;

/**
 * @author huimingli
 * @date 2017-09-02 20:46:55
 * @description
 */

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {
testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(),"fail",Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
                    }
                })
                .build()
        .get();
    }
}
