package com.dwj.dytheme.view;

import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TextViewInfo extends ViewInfo {

    public TextViewInfo(ViewInfo info){
        super(info);
    }

    @Override
    public void updateResource(){
        switch (resourceType){
            case STRING:
                ((TextView)view).setText(resources.getString(resouceId));
                break;

            case COLOR:
                ((TextView)view).setTextColor(resources.getColor(resouceId));
                break;

            case DRAWABLE:
                ((TextView)view).setBackgroundDrawable(resources.getDrawable(resouceId));
                break;

            default:
                super.updateResource();
                break;
        }
    }


}
