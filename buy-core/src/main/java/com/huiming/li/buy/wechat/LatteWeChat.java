package com.huiming.li.buy.wechat;

import android.app.Activity;

import com.huiming.li.buy.app.ConfigKeys;
import com.huiming.li.buy.app.Latte;
import com.huiming.li.buy.wechat.callback.IWechatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * @author huimingli
 * @date 2017-09-11 20:48:32
 * @description
 */

public class LatteWeChat {
    static final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID.name());
    static final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET.name());
    private IWechatSignInCallback mSignInCallback = null;
    private final IWXAPI WXAPI;


    private static final class Holder{
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance(){
        return Holder.INSTANCE;
    }

    private LatteWeChat(){
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTIVITY.name());
        WXAPI = WXAPIFactory.createWXAPI(activity,APP_ID,true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI(){
        return WXAPI;
    }

    public LatteWeChat onSignInSuccess(IWechatSignInCallback callback){
        this.mSignInCallback = callback;
        return this;
    }
    public IWechatSignInCallback getmSignInCallback(){
        return mSignInCallback;
    }
    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";//微信登录规定的
        req.state = "random_state";
        WXAPI.sendReq(req);
    }

}
