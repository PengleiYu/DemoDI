package com.utopia.demohilt.container

import com.utopia.demohilt.data.*
import retrofit2.Retrofit

class AppContainer {
  private val loginService = Retrofit.Builder()
    .baseUrl("https://example.com")
    .build()
    .create(LoginRetrofitService::class.java)

  private val remoteDataSource = UserRemoteDataSource(loginService)
  private val localDataSource = UserLocalDataSource()

  val userRepository = UserRepository(localDataSource, remoteDataSource)

  // FlowContainer，仅存在于登录流程中
  var loginContainer: LoginContainer? = null
}

class LoginContainer(userRepository: UserRepository) {
  val loginData = LoginUserData()
  val loginViewModelFactory = LoginViewModelFactory(userRepository)
}

interface Factory<T> {
  fun create(): T
}

class LoginViewModelFactory(private val userRepository: UserRepository) : Factory<LoginViewModel> {
  override fun create(): LoginViewModel {
    return LoginViewModel(userRepository)
  }
}