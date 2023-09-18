package com.programtest.tryj.domain.usecases.app_entry

import com.programtest.tryj.domain.mngr.LocalUserMngr
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserMngr: LocalUserMngr
) {

    suspend operator fun invoke(){
        localUserMngr.saveAppEntry()
    }

}