package com.dwj.dytheme;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import com.dwj.ResourceType;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TextViewInfo extends ViewInfo {

    public TextViewInfo(ViewInfo info,ResourceType resType){
        super();
        view = info.view;
        resouceId = info.resouceId;
        resources = info.resources;
        resourceType = resType;
    }

    @Override
    public void updateResource(){
        switch (resourceType){
            case STRING:
                ((TextView)view).setText(resources.getString(resouceId));
                break;

            default:
                super.updateResource();
                break;
        }
    }


}
