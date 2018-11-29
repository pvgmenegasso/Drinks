package com.example.pvnan.drinks.Network


import com.example.pvnan.drinks.Entities.Drinks
import retrofit2.http.GET
import retrofit2.Call

interface DrinkService {

        @GET("filter.php?a=Alcoholic")
        fun getalcoolicdrinks(): Call<Drinks>

        @GET("filter.php?a=Non_Alcoholic")
        fun getnalcoolicdrinks(): Call<Drinks>

        @GET("random.php")
        fun getranddrink(): Call<Drinks>
}