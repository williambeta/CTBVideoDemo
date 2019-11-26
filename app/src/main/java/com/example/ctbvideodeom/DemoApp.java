package com.example.ctbvideodeom;

import android.app.Application;

import com.coolpush.ctbusinesslibcore.CTGlobalAdConfig;
import com.coolpush.ctbusinesslibcore.bean.request.AdInitParam;

public class DemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CTGlobalAdConfig.init(this, new AdInitParam("1023", "妈妈帮", "com.mmbang.main", "mmbang.com", "5.1.0"));
    }
}
