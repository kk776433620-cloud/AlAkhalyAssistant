package com.alakhaly.assistant

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class AlAkhalyAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event ?: return

        // 1. Skip YouTube / App Ads automatically
        skipAdsIfPresent(rootInActiveWindow)

        // 2. Custom WhatsApp / App automation hooks can be processed here
    }

    private fun skipAdsIfPresent(node: AccessibilityNodeInfo?) {
        node ?: return

        val adKeywords = listOf("Skip", "Skip Ad", "تخطي", "تخطي الإعلان")
        for (keyword in adKeywords) {
            val nodes = node.findAccessibilityNodeInfosByText(keyword)
            for (n in nodes) {
                if (n.isClickable) {
                    n.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    return
                }
            }
        }

        for (i in 0 until node.childCount) {
            skipAdsIfPresent(node.getChild(i))
        }
    }

    override fun onInterrupt() {}
}
