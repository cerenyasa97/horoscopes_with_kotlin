package com.cerenyasa.horoscopes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.cerenyasa.horoscopes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var allHoroscopes: ArrayList<Horoscopes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createData()

        var horoscopesBaseAdapter = HoroscopesBaseAdapter(this, allHoroscopes)
        binding.listHoroscopes.adapter = horoscopesBaseAdapter

        binding.listHoroscopes.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity, HoroscopeDetailActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("allHoroscopes", allHoroscopes)
            startActivity(intent)
        }

        window.statusBarColor = resources.getColor(R.color.status_bar_color)
    }

    private fun createData() {
        allHoroscopes = ArrayList<Horoscopes>(12)

        var horoscopes = resources.getStringArray(R.array.horoscopes)
        var horoscopeDates = resources.getStringArray(R.array.horoscopeDates)
        var horoscopeImages = arrayOf(
            R.drawable.koc1,
            R.drawable.boga2,
            R.drawable.ikizler3,
            R.drawable.yengec4,
            R.drawable.aslan5,
            R.drawable.basak6,
            R.drawable.terazi7,
            R.drawable.akrep8,
            R.drawable.yay9,
            R.drawable.oglak10,
            R.drawable.kova11,
            R.drawable.balik12
        );
        var horoscopeBigImages = arrayOf(
            R.drawable.koc_buyuk1,
            R.drawable.boga_buyuk2,
            R.drawable.ikizler_buyuk3,
            R.drawable.yengec_buyuk4,
            R.drawable.aslan_buyuk5,
            R.drawable.basak_buyuk6,
            R.drawable.terazi_buyuk7,
            R.drawable.akrep_buyuk8,
            R.drawable.yay_buyuk9,
            R.drawable.oglak_buyuk10,
            R.drawable.kova_buyuk11,
            R.drawable.balik_buyuk12
        );

        var horoscopeDetails = resources.getStringArray(R.array.horoscopeDetails)

        for(i in 0..11){
            allHoroscopes.add(Horoscopes(horoscopes[i], horoscopeDates[i], horoscopeImages[i], horoscopeBigImages[i], horoscopeDetails[i]))
        }
    }
}