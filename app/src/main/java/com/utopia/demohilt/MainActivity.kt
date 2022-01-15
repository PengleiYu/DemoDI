package com.utopia.demohilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utopia.demohilt.data.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
  private lateinit var loginViewModel: LoginViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val loginService = Retrofit.Builder()
      .baseUrl("https://example.com")
      .build()
      .create(LoginRetrofitService::class.java)

    val remoteDataSource = UserRemoteDataSource(loginService)
    val localDataSource = UserLocalDataSource()

    val userRepository = UserRepository(localDataSource, remoteDataSource)

    loginViewModel = LoginViewModel(userRepository)
  }
}