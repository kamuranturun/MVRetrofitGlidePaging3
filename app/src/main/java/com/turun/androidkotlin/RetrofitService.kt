package com.turun.androidkotlin

import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key:String,
        @Query("language") language: String,
        @Query("page") page:Int
    ):Response<MovieResponse> //tüm data modeli burda

    /*
    Bu satırda, GET isteği yapılan RESTful API'nin endpoint'ine (movie/top_rated)
    bir fonksiyon ekliyorsunuz. Fonksiyon, verilen API anahtarı, dil ve sayfa numarasını kullanarak,
    top_rated film verilerini çağırır. Sonuç olarak, bir "Response" türünde "MovieResponse" verileri döndürür.
     */

    companion object{
        var retrofitService:RetrofitService?=null

        fun getInstance():RetrofitService{
            if(retrofitService==null){
                val retrofit=Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
    /*
    Bu blok, Retrofit servis sınıfının bir companion object'i oluşturur.
    Companion object, bir sınıf içinde tek bir nesne oluşturmak için kullanılan bir
     yapıdır. Burada, bir Retrofit servisi oluşturmak için kullanılan bir
     instance'ı saklamak için kullanılıyor. getInstance() fonksiyonu, Retrofit servisi için bir
     instance döndürür ve daha önce oluşturulmamışsa, Retrofit'in Builder sınıfından bir
      nesne oluşturur ve Retrofit servisi
    sınıfının bir instance'ını oluşturur. Oluşturulmuş bir instance varsa,
    daha önce oluşturulan instance döndürülür.
     */
}