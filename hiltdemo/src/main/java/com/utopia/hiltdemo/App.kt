package com.utopia.hiltdemo

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
  @Inject
  lateinit var analytics2Service: Analytics2Service
  override fun onCreate() {
    super.onCreate()
    Log.d(TAG, "onCreate: analytics2Service=$analytics2Service")
  }

  companion object {
    private const val TAG = "App"
  }
}