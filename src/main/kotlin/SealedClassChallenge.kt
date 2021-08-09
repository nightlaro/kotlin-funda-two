// 4-07 Challenge Sealed Classes - Starter

/*
Challenge
Create a function that can take a `List` of `AcceptedCurrency` objects and the cost of an item
in Dollars, and return whether the user has sufficient funds in the list of currency objects
to pay for what they’re trying to buy.

Hint: Try a companion object!
*/

sealed class AcceptedCurrency {
    companion object {
        fun isSufficientFund(acceptedCurrency: List<AcceptedCurrency>, //needed help with this challenge through video,
                                                                        // description was confusing and forgot some syntax but this makes sense
                             cost: Float) : Boolean {
            val totalOfDollar = acceptedCurrency.fold(0.0f) { acc, currency -> //seems like the same as reducer in javascript
                acc + currency.valueInDollars
            }
            return totalOfDollar >= cost
        }
    }
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    class Dollar: AcceptedCurrency() { override val valueInDollars = 1.0f }
    class Euro: AcceptedCurrency() { override val valueInDollars = 1.25f }
    class Crypto: AcceptedCurrency() { override val valueInDollars = 2534.92f }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "MeowCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    // Challenge

}

fun main() {
    val currency = AcceptedCurrency.Crypto()
    currency.amount = .27541f

    val dollars = AcceptedCurrency.Dollar()
    dollars.amount = 2000f
    val crypto = AcceptedCurrency.Crypto()
    crypto.amount = .23f
    val euro = AcceptedCurrency.Euro()
    euro.amount = 22.1f

    val myBalance = listOf(dollars, crypto, euro)
    val costOf3070TI_GPU = 1000f

    println(AcceptedCurrency.isSufficientFund(myBalance, costOf3070TI_GPU))

}