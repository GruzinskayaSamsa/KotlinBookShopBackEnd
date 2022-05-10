fun main() {

    var dataAdapter = DataBaseAdapter()
    var response: BookResponse
    var data: String? = readLine()

    var firstBalance: Int = dataAdapter.getFirstBalance(data)
    var books: Array<Book?> = dataAdapter.getBooks(data)

    var shop = Shop(books)
    var user = User(firstBalance)
    var informer = Informer()

    user.printBalance()
    shop.showBooksInStock()

    while (true) {
        data = readLine()!!.trim()

        if (data.substringBefore(" ") == "buy") {
            response = BookResponse(data.substringAfter(" \"").substringBeforeLast("\" "),
                data.substringAfterLast(" ").toInt())
            informer.buyBook(user, shop, response)
            continue
        }

        when (data) {
            "print balance" -> user.printBalance()
            "show books in stock" -> shop.showBooksInStock()
            "show bought books" -> user.showBoughtBooks()
            "exit" -> break
            else -> println("I don't understand")
        }
    }

}