package com.utopia.demohilt.data

import androidx.lifecycle.ViewModel

class UserRepository(
  private val localDataSource: UserLocalDataSource,
  private val remoteDataSource: UserRemoteDataSource
)

class LoginUserData

class UserLocalDataSource
class UserRemoteDataSource(
  private val loginService: LoginRetrofitService
)

interface LoginRetrofitService

class LoginViewModel(private val repository: UserRepository) : ViewModel()