package com.utopia.hiltdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import okhttp3.OkHttpClient
import javax.inject.Inject

@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {
  @Inject
  lateinit var adapter: AnalyticsAdapter

  @Inject
  lateinit var adapter2: AnalyticsAdapter

  @Inject
  lateinit var service: AnalyticsService

  @OtherInterceptorOkHttpClient
  @Inject
  lateinit var okHttpClient: OkHttpClient

  @Inject
  lateinit var analytics2Service: Analytics2Service

  companion object {
    private const val TAG = "ExampleActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_example)

    Log.d(TAG, "onCreate: adapter1=$adapter,adapter2=$adapter2")
    Log.d(TAG, "onCreate: adapter=$adapter, adapter.service=${adapter.service}")
    Log.d(TAG, "onCreate: adapter.context=${adapter.context}, activity=$this")
    Log.d(TAG, "onCreate: service=$service")
    val interceptors = okHttpClient.interceptors().joinToString { it.javaClass.name }
    Log.d(TAG, "interceptors=$interceptors")
    Log.d(TAG, "onCreate: analytics2Service=$analytics2Service")

    testEntryPoint()
    testEntryPoint()
  }

  private fun testEntryPoint() {
    val context = this
    val entryPoint =
      EntryPointAccessors.fromApplication<ExampleContentProviderEntryPoint>(context)
    val analytics3Service = entryPoint.analyticsService()
    Log.d(TAG, "testEntryPoint: service3=$analytics3Service, app=${context.applicationContext}")
  }
}