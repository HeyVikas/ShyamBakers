package com.vikas.shyambakers.di

import com.vikas.shyambakers.DomainLayer.ServerRepo
import com.vikas.shyambakers.DomainLayer.ServerRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideServerRepo() : ServerRepo {
            return ServerRepoImpl()
    }

}