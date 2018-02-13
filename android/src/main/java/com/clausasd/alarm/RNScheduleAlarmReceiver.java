
package com.clausasd.alarm;

import android.content.BroadcastReceiver;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.net.Uri;
import android.widget.Toast;

public class RNScheduleAlarmReceiver extends BroadcastReceiver
{
    static MediaPlayer player = new MediaPlayer();

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();
        Toast.makeText(context, "Alarm Started", Toast.LENGTH_LONG).show();   
    }
}