class DataBaseAdapter(){
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
            var amount: Int = book.substringAfter("\", ").substringBeforeLast(",").toInt()
            var cost: Int = book.substringAfterLast(", ").toInt()
            books += Book(bookName, amount, cost)
        }

        return books
    }

}