package com.example.stas.oxforddictionary.di.app

import android.app.Application
import android.content.Context
import com.example.stas.oxforddictionary.presentation.view.base.BaseErrorHandler
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton
import com.example.stas.oxforddictionary.data.network.OxfordApi
import com.example.stas.oxforddictionary.di.main.MainComponent
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Singleton
@Component(modules = [ApplicationModule::class, ErrorHandlerModule::class, NetworkModule::class, NetworkModule.RxModule::class])
interface ApplicationComponent{
    fun addMainComponent(): MainComponent
}

@Module
class ApplicationModule constructor(private val application: Application){
    @Singleton
    @Provides
    fun provideContext(): Context {
        return application
    }
}

@Module
class ErrorHandlerModule{
    @Provides
    fun provideErrorHandler(context: Context): ErrorHandler{
        return BaseErrorHandler(context)
    }
}

@Module
class NetworkModule{
    private val API_BASE_URL = "https://od-api.oxforddictionaries.com/"
    private val APP_ID = "app_id"
    private val APP_ID_VALUE = "53974e4d"
    private val APP_KEY = "app_key"
    private val APP_KEY_VALUE = "5b849e1ae6cc825986f969ce9ec8c198"

    @Provides
    @Named("Logging")
    fun provideLogingInterceptor(): Interceptor{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Named("Query")
    fun provideQueryInterceptor(): Interceptor {
         return Interceptor { it: Interceptor.Chain ->
             var request = it.request()
               request = request.newBuilder()
                       .addHeader(APP_ID, APP_ID_VALUE)
                       .addHeader(APP_KEY, APP_KEY_VALUE)
                       .build()
             it.proceed(request)
           }
    }

    @Provides
    fun provideHttpClient(@Named("Logging") loggingInterceptor: Interceptor,
                          @Named("Query") queryInterceptor: Interceptor): OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(queryInterceptor)
                .build()
    }

    @Provides
    fun provideOxfordApi(httpClient : OkHttpClient): OxfordApi{
        return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(OxfordApi::class.java)
    }

    @Module
    class RxModule{
        @Provides
        fun provideCompositeDisposable(): CompositeDisposable{
            return CompositeDisposable()
        }
    }

}



