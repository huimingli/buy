package com.huiming.li.buy.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.huiming.li.buy.app.Latte;

/**
 * @author huimingli
 * @date 2017-09-03 17:21:27
 * @description
 */

public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
