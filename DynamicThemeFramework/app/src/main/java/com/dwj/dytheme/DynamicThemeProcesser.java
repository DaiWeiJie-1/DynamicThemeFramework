package com.dwj.dytheme;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.dwj.annotation.DynamicTheme;
import com.dwj.framework.ThemeUpdateBroadCastReceiver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class DynamicThemeProcesser {

    private List<ViewInfo> viewInfoList = new ArrayList<ViewInfo>();

    private Context mContext;

    private String mDexPath;

    public DynamicThemeProcesser(Context context){
        mContext = context;
    }

    public void setDynamicThemeDexPath(String path){
        mDexPath = path;
    }

    public void process(DynamicThemeInter inter){
        analysis(inter);
        handlerViewInfos(viewInfoList);
    }

    private void analysis(DynamicThemeInter inter){
        Field[] fields = inter.getClass().getDeclaredFields();
        if(fields != null){
            for(Field field : fields){
               if(field.isAnnotationPresent(DynamicTheme.class)){
                   DynamicTheme annotation = field.getAnnotation(DynamicTheme.class);
                   int resourceId = annotation.resouceId();
                   ViewInfo info = new ViewInfo();
                   info.setResouceId(resourceId);
                   try {
                       field.setAccessible(true);
                       info.setView((View) field.get(inter));
                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                       return;
                   }
                   viewInfoList.add(info);
               }
            }
        }
    }

    private void handlerViewInfos(List<ViewInfo> viewInfos){
        ViewInfoProcesser viewInfoProcesser = new ViewInfoProcesser(mContext.getResources());
        CustomResourceHelper customResHelper = new CustomResourceHelper(mContext,mDexPath);
        CustomResource customRes = customResHelper.getCustomResource();
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
