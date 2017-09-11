package com.huiming.li.buy.utils.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author huimingli
 * @date 2017-09-04 15:21:19
 * @description
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener timerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.timerListener = timerListener;
    }

    @Override
    public void run() {
        if (timerListener != null){
            timerListener.onTimer();
        }
    }
}
