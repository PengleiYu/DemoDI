package com.utopia.demohilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utopia.demohilt.data.LoginViewModel

class MainActivity : AppCompatActivity() {
  private lateinit var loginViewModel: LoginViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val appContainer = (application as App).appContainer
    loginViewModel = appContainer.loginViewModelFactory.create()
  }
}