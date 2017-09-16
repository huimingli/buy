package com.huiming.li.buy.ui.recycler;

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * @author huimingli
 * @date 2017-09-16 15:54:11
 * @description
 */

public class MutltipleItemEntityBuilder {
    private static final LinkedHashMap<Object,Object> FILEDS = new LinkedHashMap<>();

    public MutltipleItemEntityBuilder(){
        FILEDS.clear();
    }

    public final MutltipleItemEntityBuilder setItemType(int itemType){
        FILEDS.put(MultipleField.ITEM_TYPE,itemType);
        return this;
    }

    public final MutltipleItemEntityBuilder setField(Object key,Object value){
        FILEDS.put(key,value);
        return this;
    }

    public final MutltipleItemEntityBuilder setFields(LinkedHashMap<?,?> map){
        FILEDS.putAll(map);
        return this;
    }

    public final MutltipleItemEntity build(){
        return new MutltipleItemEntity(FILEDS);
    }
}
