
package com.clausasd.alarm;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNScheduleAlarmModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNScheduleAlarmModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }
  @ReactMethod
  public void clearAlarm(){
      SharedPreferences sharedPreferences = reactContext.getSharedPreferences(getName(),Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.clear();
  }


  @Override
  public String getName() {
    return "RNScheduleAlarm";
  }
}