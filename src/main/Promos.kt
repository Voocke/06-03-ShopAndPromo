package main

import kotlin.random.Random

class Promos {
    val codes = arrayOf("TECHSAVE","ELECTRO","GADGET","TECHDEAL","SMARTBUY")
    val discounts = arrayOf(5.0,10.0,15.0,20.0,25.0)

    fun showPromos() {
        codes.forEachIndexed { i, name -> println("${i+1} $name") }
        val choice = input()
        if (choice == 0)
            return
        else {
            val discount = discounts[Random.nextInt(0, 4)]
            println("В промокоде ${codes[choice-1]} скидка равна $discount %")
            currentDiscount = discount
            Shop().afterPromo()
        }
    }

    fun input() : Int {
        return try{
            println("Выберите промокод (\"0\" чтобы пропустить)")
            when (val num = readln().toInt()) {
                in 0..5 -> num
                else -> {
                    println("Число вне заданного диапазона")
                    input()
                }
            }
        }
        catch (_: Exception){
            println("Ошибка ввода")
            input()
        }
    }
}