package com.example.pvnan.drinks.Network

import com.example.pvnan.drinks.Entities.Drink
import retrofit2.http.GET

interface DrinkService {

        @GET("lookup.php?i=13060")
        fun getRandomDrink(): retrofit2.Call<Drink>
}