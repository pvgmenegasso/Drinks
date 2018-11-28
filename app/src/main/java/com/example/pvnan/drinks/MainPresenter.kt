package com.example.pvnan.drinks

import com.example.pvnan.drinks.Network.RetrofitInicializer
import com.example.pvnan.drinks.Entities.Drink
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.view) : MainContract.presenter {

    override fun onLoadDrink()
    {
        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getRandomDrink()

        call.enqueue(object : Callback<Drink> {
            override fun onFailure(call: Call<Drink>, t: Throwable) {
                view.showMessage("Falha na conexão")
            }

            override fun onResponse(call: Call<Drink>, response: Response<Drink>) {
                if(response.body() != null){

                    view.ListaDrinks(response.body())
                }
                else

                    view.showMessage("sem drinks")

            }
        })
    }
}