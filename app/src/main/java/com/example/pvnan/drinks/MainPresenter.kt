package com.example.pvnan.drinks

import com.example.pvnan.drinks.Network.RetrofitInicializer
import com.example.pvnan.drinks.Entities.Drinks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.view) : MainContract.presenter {

    override fun onLoadDrink()
    {

        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getalcoolicdrinks()

        call.enqueue(object : Callback<Drinks> {
            override fun onFailure(call: Call<Drinks>, t: Throwable) {
                view.showMessage("Falha na conexão")
            }

            override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                if(response.body() != null){

                   view.mostradrinks(response.body()!!.drinks)
                }
                else
                    view.showMessage("sem drinkslist")

            }
        })



    }
    override fun onLoadDrinkb()
    {

        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getnalcoolicdrinks()

        call.enqueue(object : Callback<Drinks> {
            override fun onFailure(call: Call<Drinks>, t: Throwable) {
                view.showMessage("Falha na conexão")
            }

            override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                if(response.body() != null){

                    view.mostradrinks(response.body()!!.drinks)
                }
                else
                    view.showMessage("sem drinkslist")

            }
        })



    }

    override fun onLoadDrinkc()
    {

        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getranddrink()

        call.enqueue(object : Callback<Drinks> {
            override fun onFailure(call: Call<Drinks>, t: Throwable) {
                view.showMessage("Falha na conexão")
            }

            override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                if(response.body() != null){

                    view.mostradrinks(response.body()!!.drinks)
                }
                else
                    view.showMessage("sem drinkslist")

            }
        })



    }

    override fun onLoadDrinkd(drinkId : String) {

        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getDrinkById(drinkId)

        call.enqueue(object : Callback<Drinks> {
            override fun onFailure(call: Call<Drinks>, t: Throwable) {
                view.showMessage("Falha na conexão")
            }

            override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                if(response.body() != null){

                    view.mostradrink(response.body()!!.drinks)
                }
                else
                    view.showMessage("sem drinkslist")

            }
        })


    }


}