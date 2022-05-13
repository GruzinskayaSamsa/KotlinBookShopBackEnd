data class Shop(var books: Array<Book?> = arrayOfNulls<Book>(0)) {
    /** класс является программным представлением магазинга
     * :param
     *   books: массив имеющихся в продаже книг
     **/

    /** метод для вывода доступных к покупке книг **/
    fun showBooksInStock(){
        var n = 0

        for (book in books){
            if (book!!.getAmount() > 0)
                println("\"${book.getName()}\", ${book.getAmount()} шт., ${book.getCost()} руб.")
            else n++
        }

        if ((books.size == 0) || (n == books.size))
            println("no books in shop")
    }

    fun showBooksInStock(more: Int = 0, less: Int = Int.MAX_VALUE){
        var n = 0

        for (book in books){
            if ((book!!.getAmount() > 0) and (book.getCost() >= more) and (book.getCost() <= less))
                println("\"${book.getName()}\", ${book.getAmount()} шт., ${book.getCost()} руб.")
            else n++
        }

        if ((books.size == 0) || (n == books.size))
            println("no matching books in shop")
    }

    /** метод для расчета предварительной стоимости книг **/
    fun costGuess(bookr: BookResponse): Int {
        for (book in books) {
            if (book?.getName() == bookr.getName()) {
                return if (book.getAmount() - bookr.getAmount() >= 0) bookr.getAmount() * book.getCost()
                    else -2
            }
        }
        return -1
    }

    /** метод для покупки книг у магазина **/
    fun buyBook(bookr: BookResponse): Boolean {
        for (i in 0 until books.size) {
            if (books[i]?.getName() == bookr.getName()){
                books[i]!!.changeAmount(-bookr.getAmount())
                return true
            }
        }
        return false
    }

}