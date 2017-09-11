package com.huiming.li.buy.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.huiming.li.buy.delegate.LatteDelegate;
import com.huiming.li.buy.ec.R;
import com.huiming.li.buy.ui.launcher.LauncherHolderCreator;
import com.huiming.li.buy.ui.launcher.ScrollLauncherTag;
import com.huiming.li.buy.utils.storage.LattePreference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimingli
 * @date 2017-09-05 09:11:47
 * @description
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener{
    private ConvenientBanner<Integer> convenientBanner = null;
    private List<Integer> INTEGERS = new ArrayList<>();

    private void initBanner(){
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        convenientBanner.setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(true);
    }
    @Override
    public Object setLayout() {
        convenientBanner = new ConvenientBanner<Integer>(getContext());
        return convenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {
        initBanner();

    }


    @Override
    public void onItemClick(int position) {

        //如果点击的是最后一个
        if (position == INTEGERS.size() - 1){
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(),true);

            //检查用户是否已经登录
        }
    }
}
