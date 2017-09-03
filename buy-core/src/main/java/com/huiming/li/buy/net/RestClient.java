package com.huiming.li.buy.net;

import android.content.Context;

import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.net.callback.IError;
import com.huiming.li.buy.net.callback.IFailure;
import com.huiming.li.buy.net.callback.IRequest;
import com.huiming.li.buy.net.callback.ISuccess;
import com.huiming.li.buy.net.callback.RequestCallbacks;
import com.huiming.li.buy.ui.LatteLoader;
import com.huiming.li.buy.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author huimingli
 * @date 2017-09-03 14:39:23
 * @description
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;


    public RestClient(String url, Map<String, Object> params,
                             IRequest request, ISuccess success,
                             IFailure failure, IError error,
                             RequestBody body,Context context,LoaderStyle loaderStyle) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.LOADER_STYLE = loaderStyle;
        this.CONTEXT = context;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    private void request(HttpMethod method){
        final  RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null){
            REQUEST.onRequestStart();
        }

        if (LOADER_STYLE != null){
            LatteLoader.showLoading(CONTEXT,LOADER_STYLE);
        }
        switch (method){
            case  GET:
                call = service.get(this.URL,PARAMS);
                break;
            case POST:
                call = service.post(this.URL,PARAMS);
                break;
            case PUT:
                call = service.put(this.URL,PARAMS);
                break;
            case DELETE:
                call = service.delete(this.URL,PARAMS);
                break;
            default:
                break;
        }
        if (call != null){
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(REQUEST,SUCCESS,FAILURE, ERROR,LOADER_STYLE);
    }

    public final void get(){
        request(HttpMethod.GET);
    }

    public final void post(){
        request(HttpMethod.POST);
    }

    public final void put(){
        request(HttpMethod.PUT);
    }

    public final void delete(){
        request(HttpMethod.DELETE);
    }
}
