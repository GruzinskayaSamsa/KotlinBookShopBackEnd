data class Book(val name: String = "", var amount: Int = 0, private var cost: Int = 0): BookResponse(name, amount) {

    @JvmName("getCost1")
    fun getCost(): Int = cost

}