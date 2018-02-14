
package com.clausasd.alarm;

import android.app.Notification;
import android.os.SystemClock;
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import static android.R.attr.type;

public class RNScheduleAlarmModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNScheduleAlarmModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @ReactMethod
    public void schedule(String scheduleAt, String title, String description, String soundUri) {
        Long time = Long.parseLong(scheduleAt);
        Intent notificationIntent = this.createNotificationIntent(title, description, soundUri);
        final int _id = (int) System.currentTimeMillis();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(reactContext, _id, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) reactContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
    }

    private Intent createNotificationIntent(String title, String description, String soundUri) {
        Intent notificationIntent = new Intent(reactContext, RNScheduleAlarmReceiver.class);
        Notification.Builder builder = new Notification.Builder(reactContext);
        builder.setContentTitle(title);
        builder.setContentText(description);
        builder.setSmallIcon(android.R.drawable.sym_def_app_icon);
        Notification notification = builder.build();
        notificationIntent.putExtra("notification-id", 1);
        notificationIntent.putExtra("fileName", soundUri);
        notificationIntent.putExtra("notification", notification);
        return notificationIntent;
    }


    @Override
    public String getName() {
        return "RNScheduleAlarm";
    }
}