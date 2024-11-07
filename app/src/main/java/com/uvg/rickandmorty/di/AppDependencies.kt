package com.uvg.rickandmorty.di

import android.content.Context
import com.uvg.rickandmorty.data.local.AppDatabase
import com.uvg.rickandmorty.data.local.AppDatabaseFactory

object AppDependencies {
    private var database: AppDatabase? = null

    fun provideDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            database ?: AppDatabaseFactory.create(context).also { database = it }
        }
    }
}