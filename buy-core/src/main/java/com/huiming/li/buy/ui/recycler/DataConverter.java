package com.huiming.li.buy.ui.recycler;

import java.util.ArrayList;

/**
 * @author huimingli
 * @date 2017-09-16 15:45:14
 * @description
 */

public abstract class DataConverter {

    protected final ArrayList<MutltipleItemEntity> ENTITIES = new ArrayList<>();

    private String mJsonData = null;

    public abstract ArrayList<MutltipleItemEntity> convert();

    public DataConverter setJsonData(String json){
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData(){
        if (mJsonData == null || mJsonData.isEmpty()){
            throw new NullPointerException("data is null");
        }
        return mJsonData;
    }
}
