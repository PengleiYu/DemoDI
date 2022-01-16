package com.utopia.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Inject

interface AnalyticsService {
  fun analyticsMethods()
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
  override fun analyticsMethods() {
  }
}

class AnalyticsAdapter @Inject constructor(val service: AnalyticsService)

//@Module
//@InstallIn(ActivityComponent::class)
//abstract class AnalyticsModule {
//  // binds是为了绑定接口和实现类
//  @Binds
//  abstract fun bindAnalyticsService(
//    analyticsServiceImpl: AnalyticsServiceImpl
//  ): AnalyticsService
//}

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule2 {
  // provides用于为接口提供第三方实现类
  @Provides
  fun provideAnalyticsService(
    //
  ): AnalyticsService {
    return Retrofit.Builder()
      .baseUrl("https://example.com")
      .build()
      .create(AnalyticsService::class.java)
  }
}