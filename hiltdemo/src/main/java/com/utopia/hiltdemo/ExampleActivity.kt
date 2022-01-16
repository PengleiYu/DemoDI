package com.utopia.hiltdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import javax.inject.Inject

@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {
  @Inject
  lateinit var adapter: AnalyticsAdapter

  @Inject
  lateinit var service: AnalyticsService

  @OtherInterceptorOkHttpClient
  @Inject
  lateinit var okHttpClient: OkHttpClient

  companion object {
    private const val TAG = "ExampleActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_example)

    Log.d(TAG, "onCreate: adapter=$adapter, adapter.service=${adapter.service}")
    Log.d(TAG, "onCreate: adapter.context=${adapter.context}, activity=$this")
    Log.d(TAG, "onCreate: service=$service")
    val interceptors = okHttpClient.interceptors().joinToString { it.javaClass.name }
    Log.d(TAG, "interceptors=$interceptors")
  }
}