package com.dwj.framework;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;

import com.dwj.dytheme.DynamicThemeConfiguration;
import com.dwj.dytheme.DynamicThemeInter;
import com.dwj.dytheme.DynamicThemeProcesser;

import java.io.File;

/**
 * Created by Administrator on 2016/8/14.
 */
public class DynamicThemeActivity extends Activity implements DynamicThemeInter{
    private DynamicThemeProcesser dyThemeProcesser;
    private ThemeUpdateBroadCastReceiver themeUpdateReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dyThemeProcesser = new DynamicThemeProcesser(this);
        themeUpdateReceiver = new ThemeUpdateBroadCastReceiver(this);
        registerReceiver(themeUpdateReceiver,new IntentFilter(ThemeUpdateBroadCastReceiver.ACTION_THEME_UPDATE));
    }

    @Override
    protected void onResume() {
        super.onResume();
        dyThemeProcesser.process(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(themeUpdateReceiver);
    }

    @Override
    public void updateRes() {
        DynamicThemeConfiguration.getInstance().setDynamicThemeDexPath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "dytheme1.apk");
        if(dyThemeProcesser != null){
            dyThemeProcesser.process(this);
        }
    }

    public void notifyThemeUpdate(){
        if(dyThemeProcesser != null){
            dyThemeProcesser.notifyUpate();
        }
    }
}
