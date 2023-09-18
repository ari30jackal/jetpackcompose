package com.programtest.tryj.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programtest.tryj.data.remote.dto.GetPromoResponse
import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.domain.usecases.promo.PromoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPromoUseCase: PromoUseCases
) : ViewModel() {
    private val _res = MutableLiveData<List<PromosItem>>()

    val res: LiveData<List<PromosItem>>
        get() = _res

    var state = mutableStateOf(HomeState(GetPromoResponse()))
        private set

   fun getPromoState() {
        viewModelScope.launch {
        _res.value = GetPromoResponse()
            state.value =  HomeState(promoList = getPromoUseCase())
            Log.d("fuwa",getPromoUseCase.toString())
        }
    }


}