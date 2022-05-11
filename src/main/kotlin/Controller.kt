class Controller() {
    /** класс отвечает за взаимодействие между программными представлениями пользоваиеля и магазина,
     * а также будущими программными представлениями(склад)
     **/

    /** метод отвечающий за покупку книг **/
    fun buyBook(user: User, shop: Shop, bookr: BookResponse){
        var cost: Int = shop.costGuess(bookr)
        var shopCheck: Boolean = false
        var userCheck: Boolean = false

        if (cost >= 0){
            if (user?.getBalance()!! - cost >= 0){
                shopCheck = shop.buyBook(bookr)
                userCheck = user.buyBook(cost, bookr)
            }
        }

        if (userCheck and shopCheck) println("deal")
        else println("no deal")
    }

}