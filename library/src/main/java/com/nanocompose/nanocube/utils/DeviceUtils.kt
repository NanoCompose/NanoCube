package com.nanocompose.nanocube.utils

import android.content.Context

object DeviceUtils {

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.smallestScreenWidthDp >= 600
    }
}