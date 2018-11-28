package com.example.pvnan.drinks

import com.example.pvnan.drinks.Entities.Drink

interface MainContract {

    interface view
    {
        fun showMessage(s: String)
        fun ListaDrinks(body: Drink?)

    }

    interface presenter
    {
        fun onLoadDrink()

    }
}