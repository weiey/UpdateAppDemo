package com.renrenfenqi.updatedemo;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.renrenfenqi.update.UpdateDialog;
import com.renrenfenqi.update.UpdateManager;
import com.renrenfenqi.update.listener.UpdateListener;
import com.renrenfenqi.update.service.UpdateService;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://27.221.81.15/dd.myapp.com/16891/63C4DA61823B87026BBC8C22BBBE212F.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void doClick(View view){
        UpdateManager.create(this)
                .setDownloadUrl(URL)//设置下载apk网络连接
                .setStoreDir("dalong")//设置保存路径
                .setAppName("下载:新版好车库")
                .setDownloadSuccessNotificationFlag(Notification.DEFAULT_ALL)
                .setDownloadErrorNotificationFlag(Notification.DEFAULT_ALL)
                .setForceUpdate(true)//是否是强制
                .setAutoInstall(false)//是否自动安装 设置false会弹出安装对话框 但是如果是强制的 设置为true也会弹出对话框
                .build();

    }


    protected void onDestroy() {
        super.onDestroy();
        UpdateManager.create(this).unregisterReceiver();
    }
}
