package com.cerenyasa.horoscopes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import androidx.palette.graphics.get
import com.cerenyasa.horoscopes.databinding.ActivityHoroscopeDetailBinding

class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityHoroscopeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        var position = intent.extras?.get("position") as Int
        var allHoroscopes = intent.extras?.get("allHoroscopes") as ArrayList<Horoscopes>

        setSupportActionBar(detailBinding.animToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        detailBinding.collapsingToolbar.title = allHoroscopes.get(position).name

        detailBinding.header.setImageResource(allHoroscopes.get(position).bigSymbol)
        detailBinding.tvHoroscopeDetails.setText(allHoroscopes.get(position).details)

        var bitmap = BitmapFactory.decodeResource(resources, allHoroscopes.get(position).bigSymbol)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
                var color = palette?.getVibrantColor(R.attr.colorAccent)
                detailBinding.collapsingToolbar.setContentScrimColor(color!!)
                window.statusBarColor = color!!
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}