// 4-07 Challenge Sealed Classes - Starter

/*
Challenge
Create a function that can take a `List` of `AcceptedCurrency` objects and the cost of an item
in Dollars, and return whether the user has sufficient funds in the list of currency objects
to pay for what they’re trying to buy.

Hint: Try a companion object!
*/

data class Item(val name: String, val cost: Float, val acceptedCurrency: List<Currency>)

sealed class Currency(private val amount : Float) {
    companion object {
        fun isSufficientFund(currency: List<Currency>,
                             item: Item) : Boolean {
            val totalOfDollars = currency.fold(0.0f) { acc, currency -> //seems like the same as reducer in javascript
                if (item.acceptedCurrency.contains(currency)) {
                    acc + currency.valueInDollars
                } else {
                    acc
                }
            }

            return if (totalOfDollars >= item.cost) {
                println("You can buy ${item.name} at the price of $${item.cost} and will have $${totalOfDollars - item.cost} left.")
                true
            } else {
                println("You cannot buy ${item.name} at the price of $${item.cost}, you need $${item.cost - totalOfDollars} more")
                false
            }
        }
    }

    abstract val valueInDollars: Float

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "MeowCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    class Dollar(amount: Float): Currency(amount) { override val valueInDollars = 1.0f }
    class Euro(amount: Float): Currency(amount) { override val valueInDollars = 1.25f }
    class Crypto(amount: Float): Currency(amount) { override val valueInDollars = 2534.92f }
}

fun main() {
    val currency = Currency.Crypto(.27541f)

    val dollars = Currency.Dollar(2000f)
    val crypto = Currency.Crypto(.23f)
    val euro = Currency.Euro(22.1f)

    val myBalance = listOf(dollars, crypto, euro)
    val graphicsCard = Item("NVIDIA Graphics Card 3080 TI", 1000f, myBalance)
    val aVolleyOffice = Item("HAYES BUILDING", 400000000f, listOf(crypto, euro))
    println(Currency.isSufficientFund(myBalance, graphicsCard))
    println(Currency.isSufficientFund(myBalance, aVolleyOffice))

}