import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ShopTest {

    @Test
    fun showBooksInStockNoBooks() {
        var shop = Shop()
        assertEquals(println("no books in shop"), shop.showBooksInStock(),
            "должно выводится сообщение об отсутствии книг в магазине")
    }

    @Test
    fun showBooksInStockOnlyBooksWithZeroAmount() {
        var books: Array<Book?> = arrayOf(Book("BookName1", 0, 100),
            Book("BookName2", 0, 200), Book("BookName3", 0, 300))
        var shop = Shop(books)
        assertEquals(println("no books in shop"), shop.showBooksInStock(),
            "должно выводится сообщение об отсутствии книг в магазине")
    }

    @Test
    fun showBooksInStockSomeBooksWithZeroAmount() {
        var books: Array<Book?> = arrayOf(Book("BookName1", 0, 100),
            Book("BookName2", 2, 200), Book("BookName3", 3, 300))
        var shop = Shop(books)
        assertEquals(println("\"BookName2\", 2 шт., 200 руб.\n\"BookName3\", 3 шт., 300 руб."),
            shop.showBooksInStock(),
            "должны выводиться продающиеся книги")
    }

    @Test
    fun showBooksInStockAllBooksCorrectAmount() {
        var books: Array<Book?> = arrayOf(Book("BookName1", 1, 100),
            Book("BookName2", 2, 200), Book("BookName3", 3, 300))
        var shop = Shop(books)
        assertEquals(println("\"BookName1\", 1 шт., 100 руб.\n\"BookName2\", 2 шт., 200 руб.\n" +
                "\"BookName3\", 3 шт., 300 руб."),
            shop.showBooksInStock(),
            "должны выводиться продающиеся книги")
    }

    @Test
    fun costGuessNoBookInShop() {
        var shop = Shop()
        var response = BookResponse("BookName", 1)
        assertEquals(-1, shop.costGuess(response), "возвращаеиое значение должно быть -1")
    }

    @Test
    fun costGuessNoBookAmountInShop() {
        var booksForShop = arrayOf<Book?>(Book("BookName", 1, 100))
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName", 4)
        assertEquals(-2, shop.costGuess(response), "возвращаеиое значение должно быть -2")
    }

    @Test
    fun costGuessAmountEquals() {
        var booksForShop = arrayOf<Book?>(Book("BookName", 1, 100))
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName", 1)
        assertEquals(100, shop.costGuess(response),
            "возвращаеиое значение должно равняться цене купленной книги")
    }

    @Test
    fun costGuessAmountLess() {
        var booksForShop = arrayOf<Book?>(Book("BookName", 4, 100))
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName", 1)
        assertEquals(100, shop.costGuess(response),
            "возвращаеиое значение должно равняться цене купленной книги")
    }

    @Test
    fun buyBookNoBook() {
        var booksForShop = arrayOf<Book?>(Book("BookName1", 1, 100))
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName", 1)
        assertEquals(false, shop.buyBook(response), "покупка не должна производиться")
    }

    @Test
    fun buyBookCorrect() {
        var booksForShop = arrayOf<Book?>(Book("BookName", 1, 100))
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName", 1)
        assertEquals(true, shop.buyBook(response), "покупка должна производиться")
    }

}