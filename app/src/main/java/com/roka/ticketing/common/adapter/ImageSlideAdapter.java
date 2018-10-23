package com.roka.ticketing.common.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.roka.ticketing.R;
import com.roka.ticketing.home.interfaces.HomeInterface;

import java.util.List;

/**
 * Created by roka on 22/12/17.
 */

public class ImageSlideAdapter extends PagerAdapter {
    private HomeInterface mInterface = null;
    private List<String> mData = null;
    private ImageView mIvItem = null;

    public ImageSlideAdapter(List<String> images, HomeInterface callback) {
        mInterface = callback;
        mData = images;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View v = inflater.inflate(R.layout.item_image_slider,container, false);

        mIvItem = v.findViewById(R.id.iv_item_image);

        if(mData == null) {
            Glide.with(container.getContext())
                    .load(R.mipmap.ic_launcher_round)
                    .into(mIvItem);

            container.addView(v);
            return v;
        }

        if(mData.size() > 0) {
            Glide.with(container.getContext()).load(mData.get(position))
                    .into(mIvItem);
        } else {
            Glide.with(container.getContext())
                    .load(R.mipmap.ic_launcher_round)
                    .into(mIvItem);
        }
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if(mData == null) return 1;
        if(mData.size() > 0) return mData.size();
        else return 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
