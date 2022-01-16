package com.utopia.hiltdemo

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import dagger.hilt.android.EntryPointAccessors

class ExampleContentProvider : ContentProvider() {
  companion object {
    private const val TAG = "ExampleContentProvider"
  }

//  @Inject
//  lateinit var analyticsService: AnalyticsService

  override fun onCreate(): Boolean {
    Log.d(TAG, "onCreate() called")
//    Log.d(TAG, "onCreate: service=$analyticsService")

    testEntryPoint()
    testEntryPoint()
    return true
  }

  private fun testEntryPoint() {
    val context = context ?: throw IllegalStateException()
    val entryPoint = EntryPointAccessors.fromApplication<ExampleContentProviderEntryPoint>(context)
    // TODO: 2022/1/16 service实例每次都不一样
    val service: Analytics3Service = entryPoint.analyticsService()
    Log.d(TAG, "testEntryPoint: entryPoint service3=$service, app=${context.applicationContext}")
  }

  override fun query(
    uri: Uri,
    projection: Array<out String>?,
    selection: String?,
    selectionArgs: Array<out String>?,
    sortOrder: String?
  ): Cursor? = null

  override fun getType(uri: Uri): String? = null

  override fun insert(uri: Uri, values: ContentValues?): Uri? = null

  override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

  override fun update(
    uri: Uri,
    values: ContentValues?,
    selection: String?,
    selectionArgs: Array<out String>?
  ): Int = 0
}