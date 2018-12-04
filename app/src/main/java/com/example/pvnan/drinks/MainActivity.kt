package com.example.pvnan.drinks

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.pvnan.drinks.Entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.view  {

    //val listadrinks = listOf<Drinks>()


    var drinkslist: MutableList<Drink> = mutableListOf()

    var random = 0









    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.presenter = MainPresenter(this)

        if (random == 0) {
            presenter.onLoadDrink()
        }
        else
        {
            if (random == 1)
            {
                presenter.onLoadDrinkb()
            }
            else
            {
                presenter.onLoadDrinkc()
            }
        }

        alcool.setOnClickListener()
        {
            random = 0
            presenter.onLoadDrink()
        }

        nalcool.setOnClickListener()
        {
            random = 1
            presenter.onLoadDrinkb()
        }

        randomb.setOnClickListener()
        {
            random = 2
            presenter.onLoadDrinkc()
        }







    }





    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()

    }

    override fun mostradrinks(list: List<Drink>)
    {
        val adapter = DrinkAdapter(this, list)
        adapter.setOnItemClickListener { position ->
            val query = list.get(position).idDrink

            val DetalheDrinks = Intent(this, DrinkDetails::class.java)
            DetalheDrinks.putExtra("x", query)
            startActivity(DetalheDrinks)



        }
        rvmain.adapter = adapter
        rvmain.layoutManager = LinearLayoutManager(this)
    }

    override fun addDrink(drink: Drink) {
       drinkslist.add(drink)
    }

    override fun mostradrink(list: List<Drink>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
