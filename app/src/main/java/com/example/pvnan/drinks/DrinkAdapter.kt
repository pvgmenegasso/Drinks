package com.example.pvnan.drinks
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pvnan.drinks.Entities.Drink
import kotlinx.android.synthetic.main.drink_item.view.*

class DrinkAdapter(val context: Context, val articles: List<Drink>)
    : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, articles[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.DrinkTitle.text = drink.drink


            GlideApp.with(context)
                .load(drink.thumb)
               .centerCrop()
               .into(itemView.imgDrink)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}