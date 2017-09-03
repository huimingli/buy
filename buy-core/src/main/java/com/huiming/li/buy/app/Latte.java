package com.huiming.li.buy.app;

import android.content.Context;

import java.util.HashMap;

/**
 * @author huimingli
 * @date 2017-09-02 15:43:05
 * @description
 */

public final class Latte {
     public static Configurator init(Context context){
         getConfigurations().put(ConfigType.APPLOCATION_CONTEXT.name(),context.getApplicationContext());
         return Configurator.getInstance();
     }

     private static HashMap<String,Object> getConfigurations(){
         return Configurator.getInstance().getLatteConfigs();
     }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLOCATION_CONTEXT.name());
    }
}
