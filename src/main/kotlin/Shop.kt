data class Shop(var books: Array<Book?> = arrayOfNulls<Book>(0)) {
    /** класс является программным представлением магазинга
     * :param
     *   books: массив имеющихся в продаже книг
     **/

    /** метод для вывода доступных к покупке книг **/
    fun showBooksInStock(){
        var n = 0

        for (book in books){
            if (book!!.amount > 0)
                println("\"${book.name}\", ${book.amount} шт., ${book.cost} руб.")
            else n++
        }

        if ((books.size == 0) || (n == books.size))
            println("no books in shop")
    }

    /** метод для расчета предварительной стоимости книг **/
    fun costGuess(bookr: BookResponse): Int {
        for (book in books) {
            if (book?.name == bookr.name) {
                if (book.amount - bookr.amount >= 0) {
                    return bookr.amount * book.cost
                } else return -2
            }
        }
        return -1
    }

    /** метод для покупки книг у магазина **/
    fun buyBook(bookr: BookResponse): Boolean {
        for (i in 0..books.size) {
            if (books[i]?.name == bookr.name){
                books[i]!!.amount -= bookr.amount
                return true
            }
        }
        return false
    }

}