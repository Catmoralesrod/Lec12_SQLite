package com.example.catalinamorales.lec12_sqlite.Utility;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.support.compat.BuildConfig;

import com.facebook.stetho.Stetho;

/**
 * Created by catalinamorales on 3/1/17.
 */

public class Utility {
    public static void  setStethoWatch(Context c){
        if(BuildConfig.DEBUG){
            Stetho.initialize(
                 Stetho.newInitializerBuilder(c)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(c))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(c))
                    .build()
            );

        }

    }
}
