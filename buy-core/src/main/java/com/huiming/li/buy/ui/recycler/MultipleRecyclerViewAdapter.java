package com.huiming.li.buy.ui.recycler;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huiming.li.buy.R;
import com.huiming.li.buy.ui.banner.BannerCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimingli
 * @date 2017-09-16 18:19:36
 * @description
 */

public class MultipleRecyclerViewAdapter extends BaseMultiItemQuickAdapter<MutltipleItemEntity,MultipleViewHolder>
implements BaseQuickAdapter.SpanSizeLookup,OnItemClickListener{
    private boolean isInitBanner = false;

    protected MultipleRecyclerViewAdapter(List<MutltipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecyclerViewAdapter create(List<MutltipleItemEntity> data){
        return new MultipleRecyclerViewAdapter(data);
    }

    public static MultipleRecyclerViewAdapter create(DataConverter converter){
        return new MultipleRecyclerViewAdapter(converter.convert());
    }

    private void init(){
        //不同的item布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);

        //宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MutltipleItemEntity entity) {
        final String text;
        final String imageUrl;
        final ArrayList<String> bannerImages;
        switch (holder.getItemViewType()){
            case ItemType.TEXT:
                text = entity.getField(MultipleField.TEXT);
                holder.setText(R.id.text_single,text);
                break;
            case ItemType.IMAGE:
                imageUrl = entity.getField(MultipleField.IMAGE_URL);
                Glide.with(mContext).load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .centerCrop()
                        .into((ImageView) holder.getView(R.id.img_single));
                break;
            case ItemType.TEXT_IMAGE:
                text = entity.getField(MultipleField.TEXT);
                imageUrl = entity.getField(MultipleField.IMAGE_URL);
                Glide.with(mContext).load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .centerCrop()
                        .into((ImageView) holder.getView(R.id.img_multiple));
                holder.setText(R.id.tv_multiple,text);
                break;
            case ItemType.BANNER:
                if (!isInitBanner){
                    bannerImages = entity.getField(MultipleField.BANNERS);
                    final ConvenientBanner<String> convenientBanner = holder.getView(R.id.banner_recycler_item);
                    BannerCreator.setDefault(convenientBanner,bannerImages,this);
                    isInitBanner = true;
                }
                break;
            default:
                break;
        }


    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleField.SPAN_SIZE);
    }

    @Override
    public void onItemClick(int position) {

    }
}
