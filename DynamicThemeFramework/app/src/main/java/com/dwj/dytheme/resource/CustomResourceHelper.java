package com.dwj.dytheme.resource;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/7.
 */
public class CustomResourceHelper {
    private static final String SHARE_USER_ID_MATCH = "com.dwj";

    public static CustomResource getCustomResource(Context context , String dexPath){
        CustomResource customRes = null;
        if(dexPath == null){
            return customRes;
        }

        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(dexPath, PackageManager.GET_ACTIVITIES);
        if(packageArchiveInfo != null){
            if(packageArchiveInfo.sharedUserId.contains(SHARE_USER_ID_MATCH)){
                customRes = new CustomResource();
                customRes.setPackageName(packageArchiveInfo.packageName);
                customRes.setResources(newResourceByPath(context,dexPath));
            }
        }

        return customRes;
    }

    private static Resources newResourceByPath(Context context,String path){
        Resources res = null;
        try {
            AssetManager am = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            addAssetPath.setAccessible(true);
            addAssetPath.invoke(am,path);
            res = new Resources(am,context.getResources().getDisplayMetrics(),context.getResources().getConfiguration());
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }
}
