package com.example.pvnan.drinks

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.pvnan.drinks.Entities.Drink
import com.example.pvnan.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.activity_drink_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drink_item.view.*

class DrinkDetails : AppCompatActivity(), MainContract.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details)

        var idDrink = intent.getSerializableExtra("x")

        val presenter: MainContract.presenter = MainPresenter(this)
        if (idDrink != null) {
            presenter.onLoadDrinkd(idDrink.toString())
        }

    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()

    }

    override fun mostradrinks(list: List<Drink>)
    {

    }

    override fun addDrink(drink: Drink) {

    }

    override fun mostradrink(list: List<Drink>) {
        ing1.setText(list[0].strIngredient1)
        ing2.setText(list[0].strIngredient2)
        ing3.setText(list[0].strIngredient3)
        ing4.setText(list[0].strIngredient4)
        GlideApp.with(this)
            .load(list[0].strDrinkThumb)
            .centerCrop()
            .into(imgDrink)
        qtd1.setText(list[0].strMeasure1)
        qtd2.setText(list[0].strMeasure2)
        qtd3.setText(list[0].strMeasure3)
        qtd4.setText(list[0].strMeasure4)
        instructions.setText(list[0].strInstructions)
        nomeDrink.setText(list[0].strDrink)

    }
}

