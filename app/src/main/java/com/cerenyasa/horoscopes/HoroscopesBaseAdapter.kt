package com.cerenyasa.horoscopes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HoroscopesBaseAdapter(var context: Context, var allHoroscopes: ArrayList<Horoscopes>) : BaseAdapter() {

    override fun getCount(): Int {
        return allHoroscopes.count()
    }

    override fun getItem(position: Int): Horoscopes {
        return allHoroscopes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var one_row_view = convertView
        var viewHolder: ViewHolder? = null

        if(convertView == null){
            val inflater = LayoutInflater.from(context)
            one_row_view = inflater.inflate(R.layout.one_row, parent, false)
            viewHolder = ViewHolder(one_row_view)

            one_row_view.tag = viewHolder
        }else{
            viewHolder = one_row_view?.getTag() as ViewHolder
        }

        var currentHoroscope = getItem(position)

        viewHolder.imageView.setImageResource(currentHoroscope.symbol)
        viewHolder.nameText.text = currentHoroscope.name
        viewHolder.dateText.text = currentHoroscope.date

        return one_row_view!!
    }

    class ViewHolder(oneRowView: View){
        val imageView: ImageView
        val nameText: TextView
        val dateText: TextView

        init {
            imageView = oneRowView.findViewById<ImageView>(R.id.horoscopeImage)
            nameText = oneRowView.findViewById<TextView>(R.id.etHName)
            dateText = oneRowView.findViewById<TextView>(R.id.etHDate)
        }
    }
}

