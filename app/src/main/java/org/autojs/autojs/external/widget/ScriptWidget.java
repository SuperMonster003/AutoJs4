package org.autojs.autojs.external.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import com.stardust.pio.PFiles;
import org.autojs.autojs4.R;
import org.autojs.autojs.external.ScriptIntents;
import org.autojs.autojs.external.open.RunIntentActivity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stardust on 2017/7/11.
 */

public class ScriptWidget extends AppWidgetProvider {

    private static final String TAG = "ScriptWidget";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Set<Integer> appWidgetIdSet = new HashSet<>();
        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetId, ScriptWidgets.getPathForAppWidgetId(appWidgetId));
            appWidgetIdSet.add(appWidgetId);
        }
        if (appWidgetIdSet.size() > 1)
            ScriptWidgets.removeAllNotIn(appWidgetIdSet);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "onReceive");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(TAG, "onEnabled");
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.d(TAG, "onAppWidgetOptionsChanged");
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Log.d(TAG, "onRestored");
    }

    static boolean updateWidget(Context context, int widgetId, String path) {
        if (TextUtils.isEmpty(path) || widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            return false;
        }
        String name = PFiles.getNameWithoutExtension(path);
        int requestCode = ScriptWidgets.getRequestCodeForAppWidgetId(widgetId);
        Log.d(TAG, "updateWidget: id = " + widgetId + ", requestCode = " + requestCode + ", path = " + path);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_script_shortcut);
        views.setOnClickPendingIntent(R.id.widget, PendingIntent.getActivity(context, requestCode,
                new Intent(context, RunIntentActivity.class)
                        .putExtra(ScriptIntents.EXTRA_KEY_PATH, path)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), PendingIntent.FLAG_UPDATE_CURRENT));
        views.setTextViewText(R.id.name, name);
        appWidgetManager.updateAppWidget(widgetId, views);
        ScriptWidgets.setPathForAppWidgetId(widgetId, path);
        return true;
    }
}
