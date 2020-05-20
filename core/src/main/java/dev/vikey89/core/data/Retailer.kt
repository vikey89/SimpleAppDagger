package dev.vikey89.core.data

data class Retailer(val id: Int, val name: String)

fun Int.toRetailer() = Retailer(this, "Retailer $this")