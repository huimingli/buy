package com.huiming.li.buy.ui.refresh;

/**
 * @author huimingli
 * @date 2017-09-17 10:14:36
 * @description
 */

public class PagingBean  {
    private int mPageIndex;
    private int mTotal;
    private int mPageSize;
    private int current;
    private int mDelayed;

    public int getPageIndex() {
        return mPageIndex;
    }

    public PagingBean setPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int mTotal) {
        this.mTotal = mTotal;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
        return this;
    }

    public int getCurrent() {
        return current;
    }

    public PagingBean setCurrent(int current) {
        this.current = current;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int mDelayed) {
        this.mDelayed = mDelayed;
        return this;
    }

    PagingBean addIndex(){
        mPageIndex ++;
        return this;
    }
}
