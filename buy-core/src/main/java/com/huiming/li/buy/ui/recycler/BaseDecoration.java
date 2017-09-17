package com.huiming.li.buy.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * @author huimingli
 * @date 2017-09-17 10:42:06
 * @description
 */

public class BaseDecoration extends DividerItemDecoration {
    public BaseDecoration(@ColorInt int color, int size){
        setDividerLookup(new DividerLookupImpl(color,size));
    }

    public static BaseDecoration create(@ColorInt int color,int size){
        return new BaseDecoration(color, size);
    }
}
