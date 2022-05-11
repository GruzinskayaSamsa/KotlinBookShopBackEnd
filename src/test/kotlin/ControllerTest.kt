import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ControllerTest {

    @Test
    fun buyBookNegativeCost() {
        var controller = Controller()
        var user = User()
        var shop = Shop()
        var response = BookResponse("BookName1", 1)

        assertEquals(println("no deal"), controller.buyBook(user, shop, response),
            "покупка не должна производиться")
    }

    @Test
    fun buyBookCostMoreBalance() {
        var booksForShop: Array<Book?> = arrayOf(Book("BookName1", 1, 100))
        var controller = Controller()
        var user = User()
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName1", 1)

        assertEquals(println("no deal"), controller.buyBook(user, shop, response),
            "покупка не должна производиться")
    }

    @Test
    fun buyBookCorrect() {
        var booksForShop: Array<Book?> = arrayOf(Book("BookName1", 1, 100))
        var controller = Controller()
        var user = User(1000)
        var shop = Shop(booksForShop)
        var response = BookResponse("BookName1", 1)

        assertEquals(println("deal"), controller.buyBook(user, shop, response),
            "покупка должна производиться")
    }

}