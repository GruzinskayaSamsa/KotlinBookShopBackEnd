class DataAdapter(){
    /** класс преобразует полученные исходные данные в
     * пригодный для дальнейшего использования вид **/

    /** метод возвращает указанный в данных баланс пользователя **/
    fun getFirstBalance(data: String?): Int = data?.substringAfter("balance: ")
        ?.substringBefore(",")?.toInt() ?: 0

    /** метод возвращает массив книг для магазина **/
    fun getBooks(data: String?): Array<Book?> {
        if (data == null) return arrayOfNulls<Book?>(0)

        val refactoringData: List<String> = data!!.substringAfter("books: [(").dropLast(2).split("), (")
        var books= arrayOfNulls<Book>(0)

        for (book in refactoringData){
            var bookName: String = book.substringAfter("\"").substringBefore("\", ")
            var amount: Int = book.substringAfterLast("\", ").substringBeforeLast(",").toInt()
            var cost: Int = book.substringAfterLast(", ").toInt()
            books += Book(bookName, amount, cost)
        }

        return books
    }

    /** метод возвращает новое значене more если переданная строка соответсвует формату,
     *  иначе возвращается старое значение **/
    fun searchMore(data: String = "", oldVar: Int = 0): Int {
        if (data.startsWith("filter more than ")) {
            return data.substringAfterLast("filter more than ").toInt()
        }
        return oldVar
    }

    /** метод возвращает новое значене less если переданная строка соответсвует формату,
     *  иначе возвращается старое значение **/
    fun searchLess(data: String = "", oldVar: Int = Int.MAX_VALUE): Int {
        if (data.startsWith("filter less than ")) {
            return data.substringAfterLast("filter less than ").toInt()
        }
        return oldVar
    }

}

