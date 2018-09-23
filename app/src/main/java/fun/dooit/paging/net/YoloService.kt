package `fun`.dooit.paging.net

import `fun`.dooit.paging.model.Suggestion
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface YoloService {

    companion object Factory {

        const val BASE_URL = "https://apidev.yolota.com/api/v1/"
        const val TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjE1NzUsImxpZCI6MTd9.EHbW5F6nju2lk3F_sMMiUlp8Nk-RTFNUAilbaAiT3EE"

        fun create(): YoloService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(YoloService::class.java)
        }
    }


    @POST("hotel/suggestion")
    @FormUrlEncoded
    fun suggestion(@Field("token") token: String = TOKEN, @Field("q") q: String = "kyoto", @Field("locale") locale: String = "zh-tw"): Observable<Suggestion>

}