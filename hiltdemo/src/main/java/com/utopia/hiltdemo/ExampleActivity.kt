package com.utopia.hiltdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {
  @Inject
  lateinit var adapter: AnalyticsAdapter

  @Inject
  lateinit var service: AnalyticsService

  companion object {
    private const val TAG = "ExampleActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_example)

    Log.d(TAG, "onCreate: adapter=$adapter, adapter.service=${adapter.service}")
    Log.d(TAG, "onCreate: service=$service")
  }
}