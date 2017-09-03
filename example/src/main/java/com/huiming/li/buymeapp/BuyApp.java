package com.huiming.li.buymeapp;

import android.app.Application;

import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


/**
 * @author huimingli
 * @date 2017-09-02 16:08:09
 * @description
 */

public class BuyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .configure();
    }
}
