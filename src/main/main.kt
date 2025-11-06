package main


val myProducts = TestProducts().products
var myCart: ProductCart = ProductCart(mutableListOf())

fun main() {
    menu()
}

fun menu() {
    println("===Интернет магазин техники===\n")
    println("Список доступных к покупке товаров: ")
    myProducts.forEachIndexed { index, products ->
        println("${ index+1 }] ${ products.fullName }") }

    println("\n1. Добавить товар в корзину " +
            "2. Удалить товар из корзины 3. Закончить покупку")
    when(readln()){
        "1" -> Shop().addProducts()
        "2" -> Shop().delProducts()
        "3" -> Shop().stopBuying()
        else -> {
            println("Некорректный ввод")
            menu()
        }
    }
}