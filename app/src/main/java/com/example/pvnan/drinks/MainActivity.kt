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

    //val listadrinks = listOf<Drink>()

    val drink1 = Drink(
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa",
        "aaa"

    )


    var listadrinks = mutableListOf<Drink>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.presenter = MainPresenter(this)


        for (i in 0..50)
        {
            presenter.onLoadDrink()
        }

        exibeLista(listadrinks)






    }



    fun exibeLista(list: List<Drink>) {

        val adapter = DrinkAdapter(this, list)
        adapter.setOnItemClickListener { position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse("https://www.google.com.br/search?q=${list.get(position).strDrink}")
            startActivity(openBrowser)
        }

        rvmain.adapter = adapter
        rvmain.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()

    }

    override fun ListaDrinks(body: Drink?) {
        listadrinks.plus(body)

    }
}
