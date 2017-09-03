package com.huiming.li.buy.net;

import android.content.Context;

import com.huiming.li.buy.net.callback.IError;
import com.huiming.li.buy.net.callback.IFailure;
import com.huiming.li.buy.net.callback.IRequest;
import com.huiming.li.buy.net.callback.ISuccess;
import com.huiming.li.buy.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author huimingli
 * @date 2017-09-03 15:25:51
 * @description
 */

public class RestClientBuilder {
    private  String mUrl;
    private  static final Map<String,Object> PARAMS = RestCreator.getParams();
    private  IRequest mRequest;
    private  ISuccess mSuccess;
    private  IFailure mFailure;
    private  IError mError;
    private  RequestBody mBody;
    private LoaderStyle loader_style;
    private Context context;

    public RestClientBuilder() {
    }

    public final  RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final  RestClientBuilder params(WeakHashMap<String,Object> mParams){
        PARAMS.putAll(mParams);
        return this;
    }

    public final  RestClientBuilder params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mRequest = iRequest;
        return this;
    }


    public final RestClientBuilder loader(Context context,LoaderStyle loaderStyle){
        this.context = context;
        this.loader_style = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.context = context;
        this.loader_style = LoaderStyle.BallRotateIndicator;
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl,PARAMS,mRequest,mSuccess,mFailure,mError,mBody,context,loader_style);
    }
}
