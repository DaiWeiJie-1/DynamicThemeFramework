package com.dwj.dytheme.view;

import android.content.res.Resources;
import android.view.View;

import com.dwj.dytheme.resource.ResourceType;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ViewInfo {
    protected View view;
    protected int resouceId;
    protected Resources resources;
    protected ResourceType resourceType;

    public ViewInfo(){

    }

    public ViewInfo(ViewInfo info){
        this.resouceId = info.resouceId;
        this.view = info.view;
        this.resources = info.resources;
        this.resourceType = info.resourceType;
    }

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
        if(resourceType == ResourceType.DRAWABLE ){
            view.setBackgroundDrawable(resources.getDrawable(resouceId));
        }else if(resourceType == ResourceType.COLOR){
            view.setBackgroundColor(resources.getColor(resouceId));
        }
    }
}
