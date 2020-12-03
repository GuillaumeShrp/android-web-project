package com.ismin.projectapp

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TestCenterAdapter(
    private val centers: ArrayList<CovidTestCenter>
) : RecyclerView.Adapter<CentersViewHolder>() {

    private lateinit var eContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CentersViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.element_covid_test_center, parent, false)
        eContext = parent.context
        return CentersViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: CentersViewHolder, position: Int) {
        val (id, name, address) = centers[position]

        val prefs: SharedPreferences = eContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val favoriteList = prefs.getStringSet(SHARED_FAVORITE_LIST, setOf<String>()) as MutableSet<String>
        var isFavoriteVal = isFavorite(id, favoriteList)

        holder.txvCenterName.text = name
        holder.txvCenterAddress.text = address
        holder.setFavorite(isFavoriteVal) // display historical favorite


        /** Action to make a favorite */
        holder.imvFav.setOnClickListener {
            if (!isFavoriteVal) {
                holder.imvFav.setImageResource(android.R.drawable.btn_star_big_on)
                flipFavoriteValue(id, favoriteList, prefs, "add")
            } else {
                holder.imvFav.setImageResource(android.R.drawable.btn_star_big_off)
                flipFavoriteValue(id, favoriteList, prefs, "remove")
            }
            //Toast.makeText(eContext, "favList : ${prefs.getStringSet(SHARED_FAVORITE_LIST, setOf<String>())}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun flipFavoriteValue(
        id: String,
        favoriteList: MutableSet<String>,
        prefs: SharedPreferences,
        mode : String
    ) {
        if (mode == "add") {
            favoriteList.add(id)
        } else if (mode == "remove") {
            favoriteList.remove(id)
        }
        /** Push favorite update list in shared preferences */
        prefs.edit().putStringSet(SHARED_FAVORITE_LIST, favoriteList).apply()
    }

    private fun isFavorite(id: String, favoriteList: Set<String>): Boolean {
        favoriteList.forEach {
            if (it == id)
                return true
        }
        return false
    }

    override fun getItemCount(): Int {
        return this.centers.size

    }
}

