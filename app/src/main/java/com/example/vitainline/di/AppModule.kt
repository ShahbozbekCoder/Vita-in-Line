package com.example.vitainline.di

import android.content.Context
import com.example.vitainline.data.Repository
import com.example.vitainline.data.local.SharedPref
import com.example.vitainline.data.local.SharedPrefListener
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
    fun provideRemoteRepository(
        sharedPrefRepository: SharedPrefListener
    ): Repository {
        return Repository(sharedPrefListener = sharedPrefRepository)
    }

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPrefListener {
        return SharedPref(context)
    }
}