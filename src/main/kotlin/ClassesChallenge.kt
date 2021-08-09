// 3-06 Challenge - Classes - Starter

/*
Challenge 1 - Building a Class Hierarchy
Create a class named `Animal` that has…
1. a method named `speak()` that does nothing.

Create two `Animal` subclasses...
1. `WildAnimal` that...
  - has an `isPoisonous` property, that is a `Boolean`
2. `Pet` that...
  - has a stored property named `name`, that is a `String`
  - has a `play()` method that prints out a message
  - overrides `speak()` - It should print out a message

Create one subclass of your choice of `WildAnimal` or `Pet`. It should do at least one of the following:
 - override `speak()`
 - override `play()`
 - Add a new property with custom accessor
 - Add a new method
*/


/*
Challenge 2 - Overriding & Polymorphism
- Write a function that takes an `Animal` and does something different depending on what subclass it is.
  You'll need to do some safe casting and null checks!
- Create at least one instance of each class from the first challenge.
- Create an array that contains all of the instances.
- Call the function with each of your instances using a loop or whatever other method you'd like!
*/

open class Animal() {
    open fun speak() {
        println("One step... two step.. three step.. BOOM.. pow.. BOOM.. pow")
    }
}

open class WildAnimal(val isPoisonous : Boolean) : Animal() {

}

// defining variables inside of Pet(var one, var two) automatically creates a constructor?
// difference between Pet (name: String) vs Pet (private val name: String) ?
class Pet(private val name : String) : Animal() {
    fun play() {
        println("$name has played Black Jack and constantly gets a 21!")
    }

    override fun speak() {
        super.speak()
        println("My name is $name")
        println("I do what animals do but I am a pet so I'm special")
    }
}

class Simba(private val name : String, isPoisonous: Boolean) : WildAnimal(isPoisonous) {
    private var isKing : Boolean = false
        set(value) {
            println("Congratulations, you've come of age to become the wild King")
            field = value
        }
        get() {
            return if (field) {
                println("King $name")
                true
            } else {
                println("Level one $name")
                false
            }
        }

    override fun speak() {
        super.speak()
        if (isKing) {
            println("Bow down to the greak Rawrkanda (cus we are lions not panthers)")
        } else {
            println("MUST GRIND AND GAIN EXP TO BECOME KING")
        }
    }

    fun hunt() {
        println("$name uses Claw!")
        if (java.lang.Math.random() > .5) {
            println("It was very effective!")
        } else {
            println("$name loses a claw")
        }
    }

}

fun main() {
    val animal = Animal()
    val mochi = Pet("Mochi")
    val rattleSnake = WildAnimal(true)
    val mufasa = Simba("Mufasa", false)

    mochi.speak()
    mochi.play()

    fun doSomething(animal: Animal) {
        if (animal is Pet) {
            animal.speak()
        }
        val wildling = animal as? WildAnimal
        if (wildling != null) {
            println("Is this animal poisonous? ${wildling.isPoisonous}")
        }
    }

    doSomething(mufasa)

    val arraysOfAnimal = listOf<Animal>(animal, mochi, rattleSnake, mufasa)

    arraysOfAnimal.forEach {
        doSomething(it)
    }
}