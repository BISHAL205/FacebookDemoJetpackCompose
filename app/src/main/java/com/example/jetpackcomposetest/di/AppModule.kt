package com.example.jetpackcomposetest.di

import android.content.Context
import com.example.jetpackcomposetest.utils.EncryptedUserCheckingManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun createEncryptedManagerInstance(@ApplicationContext context: Context): EncryptedUserCheckingManager {
        return EncryptedUserCheckingManager(context)
    }
}