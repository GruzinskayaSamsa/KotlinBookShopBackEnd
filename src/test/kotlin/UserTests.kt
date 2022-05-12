import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class UserTests {
    
    @Test
    fun printBalancePositive() {
        var user = User(1000)
        assertEquals(println("balance: 1000"), user.printBalance(), "баланс должен быть 1000")
    }

    @Test
    fun printBalanceZero() {
        var user = User(0)
        assertEquals(println("balance: 0"), user.printBalance(), "баланс должен быть 0")
    }

    @Test
    fun printBalanceNegative() {
        var user = User(-100)
        assertEquals(println("your balance is negative\nyou are in debt: -100"), user.printBalance(),
            "должно выводится сообщение о задолженнсоти ")
    }

    @Test
    fun buyBooCostMoreThanBalance() {
        var user = User()
        var response = BookResponse("BookName", 1)
        assertEquals(false, user.buyBook(1000, response),
            "покупка не должна осуществляться из-за нехватки средств")
    }

    @Test
    fun buyBookCostEqualsBalance() {
        var user = User(1000)
        var response = BookResponse("BookName", 1)
        assertEquals(true, user.buyBook(1000, response),
            "покупка должна пройти корректно")
    }

    @Test
    fun buyBookCostSmallerThanBalance() {
        var user = User(1000)
        var response = BookResponse("BookName", 1)
        assertEquals(true, user.buyBook(900, response),
            "покупка должна пройти корректно")
    }

    @Test
    fun showBoughtBooksNoBoughtBooks(){
        var user = User()
        assertEquals(println("you have no bought books"), user.showBoughtBooks(),
            "должно выводится сообщение об отсутствии купленных книг")
    }

    @Test
    fun showBoughtBooksSomeBooksBought(){
        var responseList: Array<BookResponse?> = arrayOf(BookResponse("Выстрел в ногу. Детектив", 2),
            BookResponse("C++ за полчаса", 1))
        var user = User(boughtBooks = responseList)
        assertEquals(println("\"Выстрел в ногу. Детектив\", 2 шт.\n" +
                "\"C++ за полчаса\", 1 шт."), user.showBoughtBooks(),
            "должен выводиться перечень купленных книг")
    }

    @Test
    fun checkCostCostMoreBalance() {
        var user = User()
        assertEquals(false, user.checkCost(5000), "баланса не хватит для покупки")
    }

    @Test
    fun checkCostNegativeCost() {
        var user = User(100)
        assertEquals(false, user.checkCost(-5000), "невозможная цена")
    }

    @Test
    fun checkCostAllCorrect() {
        var user = User(100)
        assertEquals(true, user.checkCost(50), "покупка возможна")
    }

}