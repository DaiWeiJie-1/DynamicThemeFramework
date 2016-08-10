package com.dwj.dytheme.resource;

import android.content.res.Resources;

/**
 * Created by Administrator on 2016/8/7.
 */
public class CustomResource {
    private Resources resources;
    private String packageName;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
