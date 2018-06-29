package com.example.antoine.examapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StackExchangeService {

    @GET("questions")
    fun questions(@Query("order") order: String,
                  @Query("sort") sort: String = "activity",
                  @Query("site") site : String = "stackoverflow") : Call<Question>

    @GET("users")
    fun users(@Query("order") order: String = "desc",
              @Query("sort") sort: String = "reputation",
              @Query("site") site: String = "stackoverflow") : Call<Users>
}