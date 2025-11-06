package main

data class Products(val productName: String = "temp", val price: Double = 0.0) {
    val fullName: String
        get() = "$productName: $price"
    var count: Int = 1
        set(value){
            if (value in 0..<99)
                field = value
        }
}