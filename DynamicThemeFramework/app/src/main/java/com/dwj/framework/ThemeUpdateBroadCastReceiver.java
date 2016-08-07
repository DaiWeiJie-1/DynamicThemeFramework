package com.dwj.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dwj.dytheme.DynamicThemeInter;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ThemeUpdateBroadCastReceiver extends BroadcastReceiver{
    public static final String ACTION_THEME_UPDATE = "action_theme_update";

    private DynamicThemeInter inter;

    public ThemeUpdateBroadCastReceiver(DynamicThemeInter dyThemeInter){
        inter = dyThemeInter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null && ACTION_THEME_UPDATE.equals(intent.getAction())){
            if(inter != null){
                inter.updateRes();
            }
        }
    }
}
