package com.utopia.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ExampleContentProviderEntryPoint {
  fun analyticsService(): Analytics3Service
}

interface Analytics3Service

@Module
@InstallIn(SingletonComponent::class)
object Analytics3ServiceModule {
  @Provides
  fun provideService(): Analytics3Service {
    return Retrofit.Builder()
      .baseUrl("https://example.com")
      .build()
      .create(Analytics3Service::class.java)
  }
}