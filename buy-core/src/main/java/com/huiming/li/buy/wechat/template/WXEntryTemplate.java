package com.huiming.li.buy.wechat.template;

import com.huiming.li.buy.wechat.BaseWXEntryActivity;
import com.huiming.li.buy.wechat.LatteWeChat;

/**
 * @author huimingli
 * @date 2017-09-10 21:39:05
 * @description
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getmSignInCallback().onSignInSuccess(userInfo);

    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }
}
