package com.programtest.tryj.domain.usecases.app_entry

import com.programtest.tryj.domain.mngr.LocalUserMngr
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserMngr: LocalUserMngr
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserMngr.readAppEntry()
    }

}