package main

class ProductCart(var contents: MutableList<Products> = mutableListOf()) {
    fun showCart() {
        contents.forEachIndexed { i, products ->
            val index = myProducts.indexOf(myCart.contents[i])
            val sum = products.price * products.count
            println("${index+1}] ${products.count} шт. ${products.productName} $sum руб." +
                    " - сумма без скидки, скидка ${Shop().countDiscount()}%, " +
                    "цена с учетом скидки - ${sum - (sum * (Shop().countDiscount()/100.0))}")
        }
    }
    fun total() {
        println()
        var count = 0
        contents.forEach { count += it.count }
        println("Общее количество позиций: $count")

        var sum = 0.0
        contents.forEach { sum += it.price * it.count }
        println("Общая сумма без скидки $sum")

        println("Скидка: ${Shop().countDiscount()}")
        val sumOffDiscount = sum * (Shop().countDiscount()/100.0)
        println("Сумма скидки: $sumOffDiscount")

        println("Итого: ${sum - sumOffDiscount}")
    }
}