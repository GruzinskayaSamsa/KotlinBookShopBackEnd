fun main() {
    var response: BookResponse // переменная для записи пользовательского запроса на покупку книги

    var dataAdapter = DataBaseAdapter() // создание экземпляра класса, отвечающего за обработку первичных данных
    var data: String? = readLine() // ввод первичных данных

    /** первичный баланс и первичный каталог товаров магазина **/
    var firstBalance: Int = dataAdapter.getFirstBalance(data)
    var books: Array<Book?> = dataAdapter.getBooks(data)

    /** экземпляры классов, представляющих пользователя, магазинг
     *  и контроллер, отвечающий за их взаимодействие **/
    var shop = Shop(books)
    var user = User(firstBalance)
    var informer = Controller()

    shop.showBooksInStock() // вывод каталога продаваемых книг
    user.printBalance() // вывод пользовательского баланса

    /** основной цикл выполнения **/
    while (true) {
        data = readLine()!!.trim() // чтение вводимых данных

        /** обработка команды покупки **/
        if (data.substringBefore(" \"") == "buy") {
            response = BookResponse(data.substringAfter(" \"").substringBeforeLast("\" "),
                data.substringAfterLast(" ").toInt())
            informer.buyBook(user, shop, response)
            continue
        }

        /** обработка остальных команд **/
        when (data) {
            "print balance" -> user.printBalance()
            "show books in stock" -> shop.showBooksInStock()
            "show bought books" -> user.showBoughtBooks()
            "exit" -> break
            else -> println("I don't understand")
        }
    }
}