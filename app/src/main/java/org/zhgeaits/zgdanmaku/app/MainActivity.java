package org.zhgeaits.zgdanmaku.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import org.zhgeaits.zgdanmaku.ZGDanmakuView;

public class MainActivity extends Activity {

    private ZGDanmakuView danmakuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //设置为竖屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

        danmakuView = (ZGDanmakuView) findViewById(R.id.danmaku);
        danmakuView.setSpeed(150);
        danmakuView.setLines(10);
        danmakuView.setLineSpace(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 100; i ++) {
                        danmakuView.shotDanmamku("hello world!");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

//        for (int i = 0; i < 100; i ++) {
//            danmakuView.shotDanmamku("hello world!");
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        danmakuView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        danmakuView.onPause();
    }
}
