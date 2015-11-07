package ru.dikpost.pavlovtest;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import ru.dikpost.pavlovtest.common.Constants;
import ru.dikpost.pavlovtest.service.DataService;

/**
 * Created by oracle on 11/6/15.
 */
public class UApplication extends Application {

    @Override
    public void onCreate() {
        if (Constants.Config.DEVELOPER_MODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }

        super.onCreate();

        initImageLoader(getApplicationContext());

        Intent intent = new Intent(this, DataService.class);
        startService(intent);
    }

    public static void initImageLoader(Context context) {

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(10 * 1024 * 1024); // 10 MiB // 50
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs() // Remove for release app
        ;

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }
}
