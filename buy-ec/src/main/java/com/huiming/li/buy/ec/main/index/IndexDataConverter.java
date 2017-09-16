package com.huiming.li.buy.ec.main.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huiming.li.buy.ui.recycler.DataConverter;
import com.huiming.li.buy.ui.recycler.ItemType;
import com.huiming.li.buy.ui.recycler.MultipleField;
import com.huiming.li.buy.ui.recycler.MutltipleItemEntity;

import java.util.ArrayList;

/**
 * @author huimingli
 * @date 2017-09-16 16:04:27
 * @description
 */

public class IndexDataConverter extends DataConverter {
    @Override
    public ArrayList<MutltipleItemEntity> convert() {
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i=0;i<size;i++){
            final JSONObject data = dataArray.getJSONObject(i);

            final String imageUrl = data.getString("imageUrl");
            final String text = data.getString("text");
            final int spanSize = data.getInteger("spanSize");
            final int id = data.getInteger("goodsId");
            final JSONArray banners = data.getJSONArray("banners");

            final ArrayList<String> bannerImages = new ArrayList<>();

            int type = 0;

            if (imageUrl == null && text != null){
                type = ItemType.TEXT;
            }else if(imageUrl != null && text == null){
                type = ItemType.IMAGE;
            }else if(imageUrl != null){
                type = ItemType.TEXT_IMAGE;
            }else if (banners != null){
                type = ItemType.BANNER;

                final int bannerSize = banners.size();
                for (int j = 0; j < bannerSize; j++) {
                    final String banner = banners.getString(j);
                    bannerImages.add(banner);
                }
            }
            final MutltipleItemEntity entity = MutltipleItemEntity.builder()
                    .setField(MultipleField.ITEM_TYPE,type)
                    .setField(MultipleField.SPAN_SIZE,spanSize)
                    .setField(MultipleField.ID,id)
                    .setField(MultipleField.TEXT,text)
                    .setField(MultipleField.IMAGE_URL,imageUrl)
                    .setField(MultipleField.BANNERS,bannerImages)
                    .build();
            ENTITIES.add(entity);

        }
        return ENTITIES;
    }
}
