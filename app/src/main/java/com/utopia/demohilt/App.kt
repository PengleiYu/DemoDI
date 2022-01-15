package com.utopia.demohilt

import android.app.Application
import com.utopia.demohilt.container.AppContainer

class App : Application() {
  val appContainer = AppContainer()
}