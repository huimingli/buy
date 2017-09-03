package com.huiming.li.buymeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.huiming.li.buy.delegate.LatteDelegate;

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

    }
}
