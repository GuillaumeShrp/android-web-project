package com.ismin.projectapp

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CentersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txvCenterName:TextView = itemView.findViewById(R.id.e_center_list_rs)
    var txvCenterAddress: TextView = itemView.findViewById(R.id.e_center_list_address)
    val imvFav: ImageButton = itemView.findViewById(R.id.e_center_fav)
    var iconeInfo: ImageView = itemView.findViewById(R.id.icon_surplace_drive)


    fun setFavorite(answer: Boolean){
        /** Set saved state favorite img*/
        if (answer) {
            imvFav.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            imvFav.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }

    fun setIconeInfo(answer: Boolean)
    {
        //Changement de l'icone en fonction du mode de prévlèvement
        if(answer)
        {
            iconeInfo.setImageResource(R.drawable.ic_car)
        }
        else
        {
            iconeInfo.setImageResource(R.drawable.ic_surplace)
        }

    }

}