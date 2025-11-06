package main

class Shop {

    fun input(): List<Int>{
        return try {
            println("Выберите товар в формате(\"номер товара\" \"количество\")     q для выхода")
            val temp = readln()
            if (temp == "q")
                menu()
            val input = temp.split(" ").map { it.toInt() }
            if (input.size == 2)
                input
            else{
                input()
            }

        }
        catch (_: Exception){
            println("ОШИБКА: Некорректный ввод")
            input()
        }
    }

    fun addProducts() {
        val (num, count) = input()
        val item = myProducts[num-1]
        val product = Products(item.productName,item.price)
        product.count = count

        if (product in myCart.contents) {
            myCart.contents.find {
                it.productName == product.productName
            }?.count += product.count
        }
        else{
            myCart.contents += product
        }
        println("Ваша корзина: \n")
        myCart.showCart()
        menu()
    }

    fun delProducts() {
        try {
            if (myCart.contents == listOf<ProductCart>()){
                println("Корзина пуста")
                menu()
            }
            else{
                println("Ваша корзина: \n")
                myCart.showCart()
                val (num, count) = input()
                val item = myProducts[num-1]
                val product = Products(item.productName,item.price)
                val findProduct = myCart.contents.find {
                    it.productName == product.productName }
                val index = myCart.contents.indexOf(findProduct)

                if (product in myCart.contents){

                    if (myCart.contents[index].count <= count)
                        myCart.contents.removeAt(index)
                    else
                        myCart.contents[index].count -= count
                }
                else
                    println("Такого товара нет в корзине или он не существует")
                println("Ваша корзина: \n")
                myCart.showCart()
                menu()
            }
        }
        catch (_: Exception){
            println("ОШИБКА: Некорректный ввод")
            delProducts()
        }
    }
    fun countDiscount(): Double{
        var fullPrice = 0.0
        myCart.contents.forEach {fullPrice += it.count * it.price }
        return when {
            fullPrice > 75000 -> 15.0
            fullPrice > 50000 -> 10.0
            fullPrice > 25000 -> 5.0
            else -> 0.0
        }
    }

    fun stopBuying() {
        println("=====ЧЕК=====")
        myCart.showCart()
        myCart.total()

    }
}
