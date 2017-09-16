package com.huiming.li.buy.delegate.bottom;

/**
 * @author huimingli
 * @date 2017-09-12 14:57:21
 * @description
 */

public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}