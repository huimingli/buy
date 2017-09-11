package com.huiming.li.buy.net.interceptor;

import java.io.IOException;
import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author huimingli
 * @date 2017-09-04 09:34:02
 * @description
 */

public abstract class BaseInterceptor implements Interceptor {

    protected LinkedHashMap<String,String> getUrlParamters(Chain chain){
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        final LinkedHashMap<String,String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i),url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParamters(Chain chain,String key){
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String,String> getBodyParamter(Chain chain){
        final FormBody formBody = (FormBody) chain.request().body();
        final LinkedHashMap<String,String> params = new LinkedHashMap<>();
        int size = formBody.size();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i),formBody.value(i));
        }
        return params;
    }

    protected String getBodyParamter(Chain chain,String key){
        return getBodyParamter(chain).get(key);
    }
}
