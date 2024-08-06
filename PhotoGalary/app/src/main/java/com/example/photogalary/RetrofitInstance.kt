package com.example.photogalary
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL= "https://www.flickr.com/services/rest/?method=flickr.photos.getPopular&api_key=fcdc6461987a148869dd741e26b42b38&user_id=200565979%40N06&format=rest"


    private val retrofit by lazy {
        val gson = GsonBuilder().setLenient().create() // Set JsonReader to lenient mode
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }


}