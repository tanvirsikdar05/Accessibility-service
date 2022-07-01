package com.proficient.proficientworkers;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;

import androidx.annotation.RequiresApi;

import com.google.firebase.database.core.view.Event;

import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        Log.i("event type", "ACC::onAccessibilityEvent: " + event.getEventType());

        //TYPE_WINDOW_STATE_CHANGED == 32
        if (AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED == event.getEventType()) {
            AccessibilityNodeInfo nodeInfo = event.getSource();
            Log.i("node info", "ACC::onAccessibilityEvent: nodeInfo=" + nodeInfo);
            if (nodeInfo == null) {
                return;
            }


           /* List<AccessibilityNodeInfo> list = nodeInfo
                    .findAccessibilityNodeInfosByViewId("com.android.settings:id/left_button");
            for (AccessibilityNodeInfo node : list) {
                Log.i("node", "ACC::onAccessibilityEvent: left_button " + node);

            }*/

        }

    }


    @Override
    public void onInterrupt() {


    }
    @Override
    public void onServiceConnected() {
        // Set the type of events that this service wants to listen to. Others
        // won't be passed to this service.
        AccessibilityServiceInfo info=new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED |
                AccessibilityEvent.TYPE_VIEW_FOCUSED;

        // If you only want this service to work with specific applications, set their
        // package names here. Otherwise, when the service is activated, it will listen
        // to events from all applications.
       /* info.packageNames = new String[]
                {"com.example.android.myFirstApp", "com.example.android.mySecondApp"};*/

        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;

        // Default services are invoked only if no package-specific ones are present
        // for the type of AccessibilityEvent generated. This service *is*
        // application-specific, so the flag isn't necessary. If this was a
        // general-purpose service, it would be worth considering setting the
        // DEFAULT flag.

        // info.flags = AccessibilityServiceInfo.DEFAULT;

        info.notificationTimeout = 100;

        this.setServiceInfo(info);

    }
}
