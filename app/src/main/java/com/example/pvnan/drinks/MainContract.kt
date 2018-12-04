package com.example.pvnan.drinks

import com.example.pvnan.drinks.Entities.Drink
import com.example.pvnan.drinks.Entities.Drinks

interface MainContract {

    interface view
    {
        fun showMessage(s: String)
        fun addDrink(drink: Drink)
        fun mostradrinks(list: List<Drink>)
        fun mostradrink(list: List<Drink>)


    }


    interface presenter
    {
        fun onLoadDrink()
        fun onLoadDrinkb()
        fun onLoadDrinkc()
        fun onLoadDrinkd(drinkId : String)

    }
}