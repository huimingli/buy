package com.huiming.li.buy.net;

import com.huiming.li.buy.app.ConfigKeys;
import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.net.rx.RxRestService;

import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author huimingli
 * @date 2017-09-03 14:54:15
 * @description
 */

public class RestCreator {

    public static final class ParamsHolder{
        public static final WeakHashMap<String,Object> PARAMS = new WeakHashMap<>();

    }

    public static WeakHashMap<String,Object> getParams(){
        return ParamsHolder.PARAMS;
    }


    private static final class RetrofitHolder{
        private static final String BASE_URL = (String) Latte.getConfiguration(ConfigKeys.API_HOST.name());
        private static  final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static final class OKHttpHolder{
        private static final int TIME_OUT = 60;
        private static OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
        private static final List<Interceptor> INTERCEPTORS = Latte.getConfiguration(ConfigKeys.INTERCEPTOR.name());
        private static OkHttpClient.Builder addInterceptor(){
            if (INTERCEPTORS != null &&! INTERCEPTORS.isEmpty()){
                for (Interceptor interceptor:INTERCEPTORS){
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }
        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder{
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RxRestServiceHolder{
        private static final RxRestService RXREST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RxRestService.class);
    }

    public static RxRestService getRxRestService(){
        return RxRestServiceHolder.RXREST_SERVICE;
    }

}
