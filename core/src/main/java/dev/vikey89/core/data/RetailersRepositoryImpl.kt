package dev.vikey89.core.data

class RetailersRepositoryImpl : RetailersRepository {

    override fun getRetailers(): List<Retailer> = (1 until 100).map { it.toRetailer() }
}
