package com.programtest.tryj.di

import android.app.Application
import com.programtest.tryj.data.mngr.LocalUserMngrImpl
import com.programtest.tryj.data.remote.PromoApi
import com.programtest.tryj.data.repository.PromoRepositoryImpl
import com.programtest.tryj.domain.mngr.LocalUserMngr
import com.programtest.tryj.domain.repository.PromoRepository
import com.programtest.tryj.domain.usecases.app_entry.AppEntryUseCases
import com.programtest.tryj.domain.usecases.app_entry.ReadAppEntry
import com.programtest.tryj.domain.usecases.app_entry.SaveAppEntry
import com.programtest.tryj.domain.usecases.promo.PromoUseCases
import com.programtest.tryj.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    var client: OkHttpClient = OkHttpClient().newBuilder()
//        .connectTimeout(100, TimeUnit.SECONDS)
//        .readTimeout(100, TimeUnit.SECONDS).build()
    @Provides
    @Singleton
    fun provideApiInstance(): PromoApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PromoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalUserMngr(
        application: Application
    ): LocalUserMngr = LocalUserMngrImpl(context = application)




    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserMngr: LocalUserMngr
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserMngr),
        saveAppEntry = SaveAppEntry(localUserMngr)
    )


    @Provides
    @Singleton
    fun providePromoRepository(
        promoApi: PromoApi
    ): PromoRepository {
        return PromoRepositoryImpl(promoApi)
    }
    @Provides
    @Singleton
    fun providePromoUseCases(
        promoRepository: PromoRepository
    ): PromoUseCases {
        return PromoUseCases(
            promoRepository
        )
    }

}