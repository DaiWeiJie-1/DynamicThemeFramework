package com.dwj.dytheme;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.dwj.ResourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ViewInfoProcesser {

    private Resources mOriginResources;
    private String mNewResPackageName;
    private Resources mNewResources;
    private List<ViewInfo> mViewInfoList = new ArrayList<ViewInfo>();

    public ViewInfoProcesser(Resources originResources){
        mOriginResources = originResources;
    }

    public void setNewResources(String packageName,Resources resources){
        mNewResources = resources;
        mNewResPackageName = packageName;
    }

    public void addViewInfo(ViewInfo viewInfo){
        if(viewInfo != null){
            viewInfo.setResources(mOriginResources);
            mViewInfoList.add(viewInfo);
        }
    }

    public void process(){
        if(mViewInfoList != null){
            for(ViewInfo info : mViewInfoList){
                updateRes(info);
            }
        }
    }

    private void updateRes(ViewInfo info) {
        ViewType viewType = getViewType(info.view);
        ResourceType resType = getResType(info.resouceId);
        chooseResourcesAndUpdateResId(info);
        ViewInfo wrapInfo = ViewInfoWrapFactory.wrapViewInfo(info,viewType,resType);
        wrapInfo.updateResource();
    }

    private ResourceType getResType(int resId){
        return ResourceType.getResourceType(mOriginResources.getResourceTypeName(resId));
    }

    private ViewType getViewType(View view){
        if(view instanceof TextView){
            return ViewType.TEXTVIEW;
        }
        return null;
    }

    private void chooseResourcesAndUpdateResId(ViewInfo info){
        if(mNewResources == null || TextUtils.isEmpty(mNewResPackageName)){
            return;
        }
        String typeName = mOriginResources.getResourceTypeName(info.resouceId);
        String entryName = mOriginResources.getResourceEntryName(info.resouceId);
        int newResId = mNewResources.getIdentifier(entryName,typeName,mNewResPackageName);
        if(newResId > 0){
            info.setResources(mNewResources);
            info.setResouceId(newResId);
        }else {
            info.setResources(mOriginResources);
            info.setResouceId(info.resouceId);
        }
    }
}
