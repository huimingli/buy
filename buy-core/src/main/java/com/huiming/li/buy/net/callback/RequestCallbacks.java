package com.huiming.li.buy.net.callback;

import android.os.Handler;

import com.huiming.li.buy.ui.LatteLoader;
import com.huiming.li.buy.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author huimingli
 * @date 2017-09-03 16:26:25
 * @description
 */

public class RequestCallbacks implements Callback<String>{
    private final IRequest REQUEST;
    private final  ISuccess SUCCESS;
    private final  IFailure FAILURE;
    private final  IError ERROR;
    private final LoaderStyle LOADERSTYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error,LoaderStyle loaderstyle) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADERSTYLE = loaderstyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()){
            if (call.isExecuted()){
                if (SUCCESS != null){
                    SUCCESS.onSuccess(response.body());
                }
            }
        }else {
            if (ERROR != null){
                ERROR.onError(response.code(),response.message());
            }
        }

        stopLoading();
    }

    private void stopLoading() {
        if (LOADERSTYLE != null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            },1000);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null){
            FAILURE.onFailure();
        }
        if (REQUEST != null){
            REQUEST.onRequestEnd();
        }
        stopLoading();
    }
}
