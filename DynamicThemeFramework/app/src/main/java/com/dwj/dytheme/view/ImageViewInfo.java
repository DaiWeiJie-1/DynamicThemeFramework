package com.dwj.dytheme.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ImageViewInfo extends ViewInfo{

    public ImageViewInfo(ViewInfo info){
        super(info);
    }

    @Override
    public void updateResource() {
        switch (resourceType){
            case COLOR:
                ((ImageView)view).setBackgroundColor(resources.getColor(resouceId));
                break;

            case DRAWABLE:
                ((ImageView)view).setBackgroundDrawable(resources.getDrawable(resouceId));
                break;

            default:
                super.updateResource();
                break;
        }
    }
}
