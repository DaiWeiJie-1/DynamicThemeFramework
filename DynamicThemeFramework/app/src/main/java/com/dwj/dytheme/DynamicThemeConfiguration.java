package com.dwj.dytheme;

/**
 * Created by Administrator on 2016/8/14.
 */
public class DynamicThemeConfiguration {

    private static volatile DynamicThemeConfiguration instance;
    private String mDynamicThemeDexPath = null;

    private DynamicThemeConfiguration(){};

    public static DynamicThemeConfiguration getInstance(){
        if(instance == null){
            synchronized (DynamicThemeConfiguration.class){
                if(instance == null){
                    instance = new DynamicThemeConfiguration();
                }
            }
        }

        return instance;
    }

    public void setDynamicThemeDexPath(String absolutePath){
        this.mDynamicThemeDexPath = absolutePath;
    }

    public String getDynamicThemeDexPath(){
        return mDynamicThemeDexPath;
    }
}
