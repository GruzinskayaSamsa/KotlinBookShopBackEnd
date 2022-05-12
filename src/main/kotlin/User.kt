data class User(var balance: Int = 0, var boughtBooks: Array<BookResponse?> = arrayOfNulls<BookResponse>(0)) {
    /** класс является программным представлением ползователя
    * :param
    *   balance: средства пользователя
    *   boughtBooks: массив купленных пользователем книг
    **/

    /** метод для преобритения книги со стороны пользователя **/
    fun buyBook(cost: Int, bookr: BookResponse): Boolean {
        if (balance - cost >= 0) balance -= cost
        else return false
        var ok: Boolean = false

        for (book in boughtBooks) {
            if (book?.getName() == bookr.getName()){
                book.changeAmount(bookr.getAmount())
                ok = true
                break
            }
        }
        if (!ok) {
            boughtBooks += bookr
            ok = true
        }

        return ok
    }

    /** метод для вывода баланса пользователя **/
    fun printBalance() {
        if (balance >= 0)println("balance: $balance")
        else println("your balance is negative\n" +
                "you are in debt: $balance")
    }

    /** метод для вывода купленных книг **/
    fun showBoughtBooks() {
        if (boughtBooks.size == 0) println("you have no bought books")
        else {
            for (book in boughtBooks)
                println("\"${book?.getName()}\", ${book?.getAmount()} шт.")
        }
    }

    /** метод для проверки возможности покупки **/
    fun checkCost(cost:Int): Boolean = ((balance - cost >= 0) and (cost >= 0))

}