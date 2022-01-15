package com.utopia.demohilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utopia.demohilt.container.AppContainer
import com.utopia.demohilt.container.LoginContainer
import com.utopia.demohilt.data.LoginUserData
import com.utopia.demohilt.data.LoginViewModel

class MainActivity : AppCompatActivity() {
  private lateinit var loginViewModel: LoginViewModel
  private lateinit var appContainer: AppContainer
  private lateinit var loginUserData: LoginUserData

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    appContainer = (application as App).appContainer

    val loginContainer = LoginContainer(appContainer.userRepository)
    appContainer.loginContainer = loginContainer

    loginViewModel = loginContainer.loginViewModelFactory.create()
    loginUserData = loginContainer.loginData
  }

  override fun onDestroy() {
    // activity管理该容器生命周期
    appContainer.loginContainer = null
    super.onDestroy()
  }
}