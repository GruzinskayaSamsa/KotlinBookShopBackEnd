 open class BookResponse(private val name: String = "", private var amount: Int = 0) {

    fun changeAmount(change: Int) {
        amount += change
    }

    @JvmName("getName1")
    fun getName(): String = name

    @JvmName("getAmount1")
    fun getAmount(): Int = amount

}