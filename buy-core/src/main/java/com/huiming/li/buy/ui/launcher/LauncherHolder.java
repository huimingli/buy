package com.huiming.li.buy.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * @author huimingli
 * @date 2017-09-05 09:18:27
 * @description
 */

public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView imageView = null;
    @Override
    public View createView(Context context) {
        imageView = new AppCompatImageView(context);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        imageView.setBackgroundResource(data);
    }
}
