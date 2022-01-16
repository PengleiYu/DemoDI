package com.utopia.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient

class AuthInterceptor @Inject constructor() : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    return Response.Builder().build()
  }
}

class OtherInterceptor @Inject constructor() : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    return Response.Builder().build()
  }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @AuthInterceptorOkHttpClient
  @Provides
  fun provideAuthInterceptorOkHttpClient(
    authInterceptor: AuthInterceptor
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(authInterceptor)
      .build()
  }

  @OtherInterceptorOkHttpClient
  @Provides
  fun provideOtherInterceptorOkHttpClient(
    otherInterceptor: OtherInterceptor
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(otherInterceptor)
      .build()
  }

//  @Provides
//  fun provideOtherInterceptor(): OtherInterceptor {
//    return OtherInterceptor()
//  }
}