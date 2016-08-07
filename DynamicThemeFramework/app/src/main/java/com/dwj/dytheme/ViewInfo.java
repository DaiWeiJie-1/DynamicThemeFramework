package com.dwj.dytheme;

import android.content.res.Resources;
import android.view.View;

import com.dwj.ResourceType;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ViewInfo {
    protected View view;
    protected int resouceId;
    protected Resources resources;
    protected ResourceType resourceType;

    public View getView() {
        return view;
    }

    public int getResouceId() {
        return resouceId;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }

    public void setResources(Resources res){
        this.resources = res;
    }

    public Resources getResources(){
        return resources;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public void updateResource(){
        if(resourceType == ResourceType.DRAWABLE || resourceType == ResourceType.COLOR){
            view.setBackgroundResource(resouceId);
        }
    }
}
