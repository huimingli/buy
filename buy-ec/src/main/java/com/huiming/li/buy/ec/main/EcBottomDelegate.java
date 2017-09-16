package com.huiming.li.buy.ec.main;

import android.graphics.Color;

import com.huiming.li.buy.delegate.bottom.BaseBottomDelegate;
import com.huiming.li.buy.delegate.bottom.BottomItemDelegate;
import com.huiming.li.buy.delegate.bottom.BottomTabBean;
import com.huiming.li.buy.delegate.bottom.ItemBuilder;
import com.huiming.li.buy.ec.main.index.IndexDelegate;
import com.huiming.li.buy.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * @author huimingli
 * @date 2017-09-12 16:00:45
 * @description
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
