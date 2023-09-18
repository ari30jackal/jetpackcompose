package com.programtest.tryj.domain.mngr

import kotlinx.coroutines.flow.Flow


interface LocalUserMngr {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}