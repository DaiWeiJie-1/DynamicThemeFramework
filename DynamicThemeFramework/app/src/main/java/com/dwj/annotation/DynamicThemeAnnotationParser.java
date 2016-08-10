package com.dwj.annotation;

import android.view.View;

import com.dwj.dytheme.DynamicThemeInter;
import com.dwj.dytheme.view.ViewInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DynamicThemeAnnotationParser {

    public static List<ViewInfo> parse(DynamicThemeInter inter){
        List<ViewInfo> list = new ArrayList<ViewInfo>();
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
                        return list;
                    }
                    list.add(info);
                }
            }
        }
        return list;
    }
}
