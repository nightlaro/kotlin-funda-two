// 4-05 Challenge Enum Classes - Starter

/*
Challenge - Transform SimpleDate into an Enum Class!
- Make it an Enum Class and call it `Month` instead of `SimpleDate`
- Turn that months array into the enum cases
- Get the monthsUntilJingleBells and monthsUntilHalloweenDecorations methods working again
- Write a new property named `season` with a custom getter that will return the season of the year
for each month. (Maybe model `Season` as another Enum Class?)
*/

enum class Season {
    FALL, SUMMER, WINTER, SPRING;
}

enum class Month(val season: Season) {
    January(Season.WINTER),
    February(Season.WINTER),
    March(Season.SPRING),
    April(Season.SPRING),
    May(Season.SPRING),
    June(Season.SUMMER),
    July(Season.SUMMER),
    August(Season.SUMMER),
    September(Season.FALL),
    October(Season.FALL),
    November(Season.FALL),
    December(Season.WINTER);

    fun monthsUntilJingleBells(): Int {
        return December.ordinal - this.ordinal
    }

    fun monthsUntilHalloweenDecorations() : Int {
        val halloweenStart = September.ordinal
        val halloweenEnd = October.ordinal
        return when(this.ordinal) {
            in January.ordinal..halloweenStart -> halloweenStart - this.ordinal
            in halloweenStart..halloweenEnd -> 0
            else -> halloweenStart + (values().size - this.ordinal)
        }
    }
}

fun main() {
    val currentMonth = Month.August
    println("Time until we spend a lot of money for a world wide culture: ${currentMonth.monthsUntilJingleBells()}")
    println("Time until we spooked ${currentMonth.monthsUntilHalloweenDecorations()}")
    println("Current Season: ${currentMonth.season}")
}