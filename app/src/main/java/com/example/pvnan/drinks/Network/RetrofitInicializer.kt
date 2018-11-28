package com.example.pvnan.drinks.Network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetrofitInicializer {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createDrinkService() : DrinkService
    {
        return retrofit.create(DrinkService::class.java)
    }

}