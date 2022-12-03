package com.gads.crowdfunding.network

import com.gads.crowdfunding.network.auth.AuthRepositoryImplementation
import com.gads.crowdfunding.repository.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModules {

    @Binds
    fun bindAuthRepository(authRepositoryImplementation: AuthRepositoryImplementation): AuthRepository

}