
package com.clausasd.alarm;

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
  public void schedule(String scheduleAt, String title, String soundUri) {      
    Long time = Long.parseLong(scheduleAt);
    AlarmManager alarmManager = (AlarmManager) reactContext.getSystemService(Context.ALARM_SERVICE);
    Intent alarmIntent = new Intent("REACT_NATIVE_ALARM");
    PendingIntent pendingIntent = PendingIntent.getBroadcast(reactContext, type, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent);
    Toast.makeText(reactContext, "Alarm Scheduled", Toast.LENGTH_LONG).show();   
  }


  @Override
  public String getName() {
    return "RNScheduleAlarm";
  }
}