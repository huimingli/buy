package com.huiming.li.buy.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.huiming.li.buy.delegate.bottom.BottomItemDelegate;
import com.huiming.li.buy.ec.R;

/**
 * @author huimingli
 * @date 2017-09-12 16:10:48
 * @description
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {

    }
}
