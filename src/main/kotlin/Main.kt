fun main() {
    var response: BookResponse // переменная для записи пользовательского запроса на покупку книги
    var oldMore: Int
    var oldLess:Int
    var more: Int = 0// переменная для записи минимального значения цены при фильтрации
    var less: Int = Int.MAX_VALUE// переменная для записи максимального значения цены при фильтрации

    var dataAdapter = DataAdapter() // создание экземпляра класса, отвечающего за обработку первичных данных
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
        if (data.startsWith("buy \"")) {
            response = BookResponse(data.substringAfter(" \"").substringBeforeLast("\" "),
                data.substringAfterLast(" ").toInt())
            informer.buyBook(user, shop, response)
            continue
        }

        if (data.startsWith("filter")) {
            oldMore = more
            oldLess = less
            more = dataAdapter.searchMore(data, oldVar = more)
            less = dataAdapter.searchLess(data, oldVar = less)
            if ((oldMore != more) or (oldLess != less)) continue
        }

        /** обработка остальных команд **/
        when (data) {
            "print balance" -> user.printBalance()
            "show books in stock" -> shop.showBooksInStock(more = more, less = less)
            "show bought books" -> user.showBoughtBooks()
            "exit" -> break
            "filter reset" -> {more = 0
                                less = Int.MAX_VALUE}
            else -> println("I don't understand")
        }
    }
}