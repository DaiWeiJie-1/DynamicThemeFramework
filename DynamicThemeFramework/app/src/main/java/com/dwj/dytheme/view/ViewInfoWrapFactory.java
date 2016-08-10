package com.dwj.dytheme.view;


import com.dwj.dytheme.resource.ResourceType;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ViewInfoWrapFactory {

    public static ViewInfo wrapViewInfo(ViewInfo info, ViewType viewType, ResourceType resType){
        info.setResourceType(resType);
        switch (viewType){
            case TEXTVIEW:
                return new TextViewInfo(info);

            case IMAGEVIEW:
                return new ImageViewInfo(info);

            default:
                return info;

        }

    }
}
