package com.cerenyasa.horoscopes

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopesArrayAdapter(var comingContext: Context, var resource: Int, var textViewResourceId: Int, var horoscopes: Array<String>, var horoscopeDates: Array<String>, var horoscopeImages: Array<Int>) :
    ArrayAdapter<String>(comingContext, resource, textViewResourceId, horoscopes) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var one_row_view = convertView
        var viewHolder : ViewHolder? = null

        if(one_row_view == null){
            val inflater = LayoutInflater.from(comingContext)
            one_row_view = inflater.inflate(R.layout.one_row, parent, false)
            viewHolder = ViewHolder(one_row_view)

            one_row_view.tag = viewHolder
        }
        else{
            viewHolder = one_row_view.getTag() as ViewHolder
        }

        viewHolder.horoscopeImage.setImageResource(horoscopeImages[position])
        viewHolder.horoscopeName.text = horoscopes[position]
        viewHolder.horoscopeDates.text = horoscopeDates[position]

        return one_row_view!!
    }

    class ViewHolder(oneRowView: View){
        var horoscopeImage : ImageView
        var horoscopeName : TextView
        var horoscopeDates : TextView

        init {
            this.horoscopeImage = oneRowView.findViewById<ImageView>(R.id.horoscopeImage)
            this.horoscopeName = oneRowView.findViewById<TextView>(R.id.etHName)
            this.horoscopeDates = oneRowView.findViewById<TextView>(R.id.etHDate)
        }
    }
}