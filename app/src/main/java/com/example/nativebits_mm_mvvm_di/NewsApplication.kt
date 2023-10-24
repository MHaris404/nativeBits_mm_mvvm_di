package com.example.nativebits_mm_mvvm_di

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "coming inside oncreate APPLICATION")
    }

    companion object {
        const val TAG = "News Application"
    }
}