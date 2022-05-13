import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class DataAdapterTest {

    @Test
    fun getFirstBalanceCorrectData() {
        var adapter = DataAdapter()
        val data: String = "balance: 1000, books: [(\"Алгебра, 10 класс\", 5, 100)]"
        assertEquals(1000, adapter.getFirstBalance(data),
            "возвращаемое значение должно равняться 1000")
    }

    @Test
    fun getFirstBalanceNoData() {
        var adapter = DataAdapter()
        val data: String? = null
        assertEquals(0, adapter.getFirstBalance(data),
            "возвращаемое значение должно равняться 0")
    }

    @Test
    fun getBooksCorrectData() {
        var adapter = DataAdapter()
        val data: String = "balance: 1000, books: [(\"Алгебра, 10 класс\", 5, 100)," +
                " (\"Теория чисел, 2 класс\", 42, 500)]"
        var checkBooks: Array<Book?> = arrayOf(Book("Алгебра, 10 класс", 5, 100),
            Book("Теория чисел, 2 класс", 42, 500))
        var realBooks: Array<Book?> = adapter.getBooks(data)

        for (i in 0 until checkBooks.size){
            assertEquals(checkBooks[i], realBooks[i],
                "экземпляры класса Book должны содержать указанные в передаваемом сообщении данные")
        }
    }

    @Test
    fun getBooksNoData() {
        var adapter = DataAdapter()
        val data = null
        var checkBooks: Array<Book?> = arrayOfNulls<Book?>(0)
        var realBooks: Array<Book?> = adapter.getBooks(data)

        for (i in 0 until checkBooks.size)
            assertEquals(checkBooks[i], realBooks[i],
            "возвращаемое значение должно быть пустым массивом")
    }

    @Test
    fun searchMoreCorrectData() {
        var adapter = DataAdapter()
        assertEquals(300, adapter.searchMore("filter more than 300"),
            "должно возвращаться указанное в сообщение значение")
    }

    @Test
    fun searchMoreNotData() {
        var adapter = DataAdapter()
        assertEquals(3, adapter.searchMore(oldVar = 3),
            "должно возвращаться старое значение")
    }

    @Test
    fun searchMoreIncorrectData() {
        var adapter = DataAdapter()
        assertEquals(5, adapter.searchMore("filter more 300", oldVar = 5),
            "должно возвращаться старое значение")
    }

    @Test
    fun searchLessCorrectData() {
        var adapter = DataAdapter()
        assertEquals(300, adapter.searchLess("filter less than 300"),
            "должно возвращаться указанное в сообщение значение")
    }

    @Test
    fun searchLessNotData() {
        var adapter = DataAdapter()
        assertEquals(3, adapter.searchLess(oldVar = 3),
            "должно возвращаться старое значение")
    }

    @Test
    fun searchLessIncorrectData() {
        var adapter = DataAdapter()
        assertEquals(5, adapter.searchLess("filter more 300", oldVar = 5),
            "должно возвращаться старое значение")
    }


}