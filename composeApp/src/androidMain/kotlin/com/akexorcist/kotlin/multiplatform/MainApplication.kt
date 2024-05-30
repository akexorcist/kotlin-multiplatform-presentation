package com.akexorcist.kotlin.multiplatform

import android.app.Application
import com.markodevcic.peko.PermissionRequester

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PermissionRequester.initialize(applicationContext)
    }
}
