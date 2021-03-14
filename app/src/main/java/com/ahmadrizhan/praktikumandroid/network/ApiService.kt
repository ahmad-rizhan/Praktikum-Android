 package com.ahmadrizhan.praktikumandroid.network

import com.ahmadrizhan.praktikumandroid.model.Jenisbarang
import com.ahmadrizhan.praktikumandroid.model.JenisbarangData
import com.ahmadrizhan.praktikumandroid.model.JenisbarangResponse
import com.ahmadrizhan.praktikumandroid.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

 private  const val BASE_URL = "http://10.0.2.2/praktikum-penjualan-api-starter/api/"

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()


        interface ApiService {
            @GET("users?page=1")
            suspend fun getUsers(): User

            @GET("jenisbarang/read.php")
            suspend fun getJenisbarang(): Jenisbarang

            @POST("jenisbarang/create.php")
            suspend fun create(@Body jenisbarangData: JenisbarangData): Response<JenisbarangResponse>
        }

        object Api {
            val retrofitService : ApiService by lazy {
                retrofit.create(ApiService::class.java) }
        }