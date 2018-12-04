package com.example.pvnan.drinks.Network


import com.example.pvnan.drinks.Entities.Drinks
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface DrinkService {

        @GET("filter.php?a=Alcoholic")
        fun getalcoolicdrinks(): Call<Drinks>

        @GET("filter.php?a=Non_Alcoholic")
        fun getnalcoolicdrinks(): Call<Drinks>

        @GET("random.php")
        fun getranddrink(): Call<Drinks>

        @GET("lookup.php?")
        fun getDrinkById(@Query("i") DrinkId : String) : Call<Drinks>
}