package `fun`.dooit.paging.net

import `fun`.dooit.paging.model.Hero
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    companion object Factory {

        const val BASE_URL = "http://gateway.marvel.com/v1/"
        const val API_KEY = "5eda49895a80e8cefe95725007ddf068"
        const val HASH = "22965f54c4b581b740d27f9fa5889998"

        fun create(): MarvelService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(MarvelService::class.java)
        }
    }


    @GET("public/characters")
    fun getCharacter(
            @Query("apikey") apikey: String = API_KEY,
            @Query("ts") ts: String = "1",
            @Query("hash") hash: String = HASH,
            @Query("nameStartsWith") nameStartsWith: String):
            Observable<Hero>

}