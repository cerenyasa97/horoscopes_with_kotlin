package com.cerenyasa.horoscopes

import java.io.Serializable

data class Horoscopes(var name: String, var date: String, var symbol: Int, var bigSymbol: Int, var details: String): Serializable{}