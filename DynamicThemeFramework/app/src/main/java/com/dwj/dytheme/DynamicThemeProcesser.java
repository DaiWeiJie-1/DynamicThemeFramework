package com.dwj.dytheme;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.dwj.annotation.DynamicTheme;
import com.dwj.annotation.DynamicThemeAnnotationParser;
import com.dwj.dytheme.resource.CustomResource;
import com.dwj.dytheme.resource.CustomResourceHelper;
import com.dwj.dytheme.view.ViewInfo;
import com.dwj.dytheme.view.ViewInfoProcesser;
import com.dwj.framework.ThemeUpdateBroadCastReceiver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class DynamicThemeProcesser {

    private List<ViewInfo> viewInfoList;

    private Context mContext;

    private String mDexPath;

    public DynamicThemeProcesser(Context context){
        mContext = context;
    }

    public void setDynamicThemeDexPath(String path){
        mDexPath = path;
    }

    public void process(DynamicThemeInter inter){
        viewInfoList =  DynamicThemeAnnotationParser.parse(inter);
        handlerViewInfos(viewInfoList);
    }

    private void handlerViewInfos(List<ViewInfo> viewInfos){
        ViewInfoProcesser viewInfoProcesser = new ViewInfoProcesser(mContext.getResources());
        CustomResource customRes = CustomResourceHelper.getCustomResource(mContext,mDexPath);
        if(customRes != null){
            viewInfoProcesser.setNewResources(customRes.getPackageName(),customRes.getResources());
        }
        for(ViewInfo info : viewInfos){
            viewInfoProcesser.addViewInfo(info);
        }
        viewInfoProcesser.process();
    }

    public void notifyUpate(){
        Intent intent = new Intent(ThemeUpdateBroadCastReceiver.ACTION_THEME_UPDATE);
        mContext.sendBroadcast(intent);
    }

}
