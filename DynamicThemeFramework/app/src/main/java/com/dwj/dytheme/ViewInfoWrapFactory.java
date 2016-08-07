package com.dwj.dytheme;


import com.dwj.ResourceType;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ViewInfoWrapFactory {

    public static ViewInfo wrapViewInfo(ViewInfo info, ViewType viewType, ResourceType resType){
        switch (viewType){
            case TEXTVIEW:
                return new TextViewInfo(info,resType);

            default:
                info.setResourceType(resType);
                return info;

        }

    }
}
