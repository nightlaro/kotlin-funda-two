import kotlin.properties.Delegates

// 2-06 Challenge - Delegated Properties - Starter

/*
Challenge 1:
 Rewrite the `IceCream` class below:
 1. Use a default value for the name property.
 2. Lazily initialize the `ingredients` list.
*/

class IceCream {
    var name: String = "Mickrazy"
    val ingredients: MutableList<String> by lazy { mutableListOf("Milk", "Sleep", "green flowers that can be made into strong ropes") }
}

/*
Challenge 2:
Below is a `SpaceCar` and `SpaceBattery` class.
Dive into the inner workings of the car and rewrite the `SpaceBattery` class
below with delegated property observer functionality:

1. Add a `lowCharge` property of Boolean type to the class.
2. Flip the `lowCharge` Boolean when the `level` drops below 10%.
3. Ensure that when the tank fills back up, the `lowCharge` warning will turn off.
4. Add a `SpaceBattery` property to `SpaceCar`, make one, and charge it up. Then fly around for awhile.
*/

class SpaceCar(
    val make: String,
    val color: String,
    val battery: SpaceBattery
) {        //Idk if astronomicalMiles is a thing but it sounds cool
    fun fly(astronomicalMiles: Int) {
        for (miles in 0..astronomicalMiles) {
            battery.level -= 10
        }
    }
}

class SpaceBattery {
    var lowCharge = false
    // holy shit this thing is nice
    var level by Delegates.observable(0.0) { _, old, new ->
        lowCharge = new <= 10.0
    }
}

fun main() {
    // ~~~Challenge 1~~~
    // Make a new instance of IceCream
    val bestIceCream = IceCream()
    // Give it a name other than the default
    bestIceCream.name = "Mickrazy2.0"
    // Add some ingredients!
    bestIceCream.ingredients += "Four" + "Two" + "Zero"

    // ~~~Challenge 2~~~
    // Make a SpaceCar!
    val cybertruck = SpaceCar("VolleyTech", "Black", SpaceBattery())
    // Charge the battery!
    cybertruck.battery.level = 100.0
    // Fly around for awhile.
    cybertruck.fly(5)
    println(cybertruck.battery.level)
    println(cybertruck.battery.lowCharge)
    cybertruck.fly(2)
    println(cybertruck.battery.level)
    println(cybertruck.battery.lowCharge)
}