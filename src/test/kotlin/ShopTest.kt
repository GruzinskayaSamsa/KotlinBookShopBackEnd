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

}