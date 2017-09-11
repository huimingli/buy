package com.huiming.li.buy.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;


import com.huiming.li.buy.delegate.LatteDelegate;
import com.huiming.li.buy.ec.R;
import com.huiming.li.buy.ec.R2;
import com.huiming.li.buy.ec.sign.SignUpDelegate;
import com.huiming.li.buy.ui.launcher.ScrollLauncherTag;
import com.huiming.li.buy.utils.storage.LattePreference;
import com.huiming.li.buy.utils.timer.BaseTimerTask;
import com.huiming.li.buy.utils.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author huimingli
 * @date 2017-09-04 15:20:43
 * @description
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private int count = 5;
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView tvLauncherTimer = null;

    private Timer timer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            checkIsScroll();
        }
    }

    @OnClick(R2.id.tv_signup)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private void initTimer() {

        timer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        timer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {
        initTimer();
    }

    private void checkIsScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登录了
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (tvLauncherTimer != null) {
                    tvLauncherTimer.setText(MessageFormat.format("跳过\n{0}s", count));
                    count--;
                    if (count < 0) {
                        if (timer != null) {
                            timer.cancel();
                            timer = null;
                            checkIsScroll();
                        }
                    }
                }
            }
        });
    }
}
