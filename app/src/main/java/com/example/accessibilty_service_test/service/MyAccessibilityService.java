package com.example.accessibilty_service_test.service;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;

import com.example.accessibilty_service_test.PrintUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MyAccessibilityService extends AccessibilityService implements  GoogleMap.OnCameraMoveStartedListener,
        GoogleMap.OnCameraMoveListener,
        GoogleMap.OnCameraMoveCanceledListener,
        GoogleMap.OnCameraIdleListener,
        OnMapReadyCallback {
    private String currentApplicationPackage = "";


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final String sourcePackageName = (String) event.getPackageName();
        currentApplicationPackage = sourcePackageName;

        Log.d("App Name", "sourcePackageName:" + sourcePackageName);
        Log.d("App Name", "parcelable:" + event.getText().toString());
    }


    @Override
    protected boolean onKeyEvent(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP || event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.d("SUCCESSFULLY", "onKeyEvent: Volume");
            performGlobalAction(GESTURE_2_FINGER_DOUBLE_TAP);
//            performGlobalAction(GESTURE_2_FINGER_SWIPE_LEFT);
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {
            Log.d("SUCCESSFULLY", "onKeyEvent: Left Right");
        }
        return super.onKeyEvent(event);
    }

    @Override
    public void onInterrupt() {
        PrintUtils.log("onInterrupt");
    }

    @Override
    protected boolean onGesture(int gestureId) {
        PrintUtils.log("onGesture");
        return super.onGesture(gestureId);
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        PrintUtils.log("onServiceConnected");
//        //可用代码配置当前Service的信息
//        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
//        info.packageNames = new String[]{"com.android.packageinstaller", "com.tencent.mobileqq", "com.trs.gygdapp"}; //监听过滤的包名
//        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK; //监听哪些行为
//        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN; //反馈
//        info.notificationTimeout = 100; //通知的时间
//        setServiceInfo(info);


    }


    @Override
    public void onCameraIdle() {

    }

    @Override
    public void onCameraMoveCanceled() {

    }

    @Override
    public void onCameraMove() {

    }

    @Override
    public void onCameraMoveStarted(int i) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}

