package org.autojs.autojs.tool

import android.accessibilityservice.AccessibilityService
import android.content.ActivityNotFoundException
import android.content.Context
import android.text.TextUtils
import com.stardust.app.GlobalAppContext
import com.stardust.autojs.core.accessibility.AccessibilityServiceUsher
import com.stardust.autojs.core.util.ProcessShell
import com.stardust.view.accessibility.AccessibilityServiceUtils.goToAccessibilitySetting
import com.stardust.view.accessibility.AccessibilityServiceUtils.isAccessibilityServiceEnabled
import org.autojs.autojs.Pref
import org.autojs.autojs4.R
import java.util.Locale

/**
 * Created by Stardust on 2017/1/26.
 */
object AccessibilityServiceTool {
    private val sAccessibilityServiceClass: Class<AccessibilityServiceUsher> = AccessibilityServiceUsher::class.java
    @JvmStatic
    fun enableAccessibilityService() {
        if (Pref.shouldEnableAccessibilityServiceByRoot()) {
            if (!enableAccessibilityServiceByRoot(sAccessibilityServiceClass)) {
                goToAccessibilitySetting()
            }
        } else {
            goToAccessibilitySetting()
        }
    }

    @JvmStatic
    fun goToAccessibilitySetting() {
        val context = GlobalAppContext.get()
        if (Pref.isFirstGoToAccessibilitySetting()) {
            GlobalAppContext.toast(context.getString(R.string.text_please_choose) + context.getString(R.string.app_name))
        }
        try {
            goToAccessibilitySetting(context)
        } catch (e: ActivityNotFoundException) {
            GlobalAppContext.toast(context.getString(R.string.go_to_accessibility_settings) + context.getString(R.string.app_name))
        }
    }

    private const val cmd = "enabled=$(settings get secure enabled_accessibility_services)\n" +
            "pkg=%s\n" +
            "if [[ \$enabled == *\$pkg* ]]\n" +
            "then\n" +
            "echo already_enabled\n" +
            "else\n" +
            "enabled=\$pkg:\$enabled\n" +
            "settings put secure enabled_accessibility_services \$enabled\n" +
            "fi\n" +
            "settings put secure accessibility_enabled 1"

    fun enableAccessibilityServiceByRoot(accessibilityService: Class<out AccessibilityService?>): Boolean {
        val serviceName = GlobalAppContext.get().packageName + "/" + accessibilityService.name
        return try {
            TextUtils.isEmpty(ProcessShell.execCommand(String.format(Locale.getDefault(), cmd, serviceName), true).error)
        } catch (e: Exception) {
            false
        }
    }

    @JvmStatic
    fun enableAccessibilityServiceByRootAndWaitFor(timeOut: Long): Boolean {
        return if (enableAccessibilityServiceByRoot(sAccessibilityServiceClass)) {
            com.stardust.view.accessibility.AccessibilityService.waitForEnabled(timeOut)
        } else false
    }

    fun enableAccessibilityServiceByRootIfNeeded() {
        if (com.stardust.view.accessibility.AccessibilityService.instance == null) if (Pref.shouldEnableAccessibilityServiceByRoot()) {
            enableAccessibilityServiceByRoot(sAccessibilityServiceClass)
        }
    }

    @JvmStatic
    fun isAccessibilityServiceEnabled(context: Context?): Boolean {
        return isAccessibilityServiceEnabled(context!!, sAccessibilityServiceClass)
    }
}
