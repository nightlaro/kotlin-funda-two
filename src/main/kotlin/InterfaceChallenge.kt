import kotlin.math.PI

// 3-08 Challenge - Interfaces - Starter

/*
Challenge 1:
  - Create an interface `Shape` that defines a property `area` of type Double.
  - Implement `Shape` with classes representing Square, Triangle, and Circle.
  - Add a circle, a square, and a triangle to an array.
  - Convert the array of shapes to an array of areas using map.
 **HINTS**
 - The area of a square = one of its sides squared
 - The area of a triangle = 0.5 multiplied by its base multiplied by its height
 - The area of a circle = pi multiplied by its radius squared
*/

interface Shape {
    val area : Double
}

class Square(private val sides: Double) : Shape {
    override val area : Double
        get() = sides * sides
}
class Triangle(private val base: Double, private val height: Double) : Shape {
    override val area : Double
        get() = 0.5 * (base * height)
}
class Circle(private val radius: Double) : Shape {
    override val area : Double
        get() = PI * (radius * radius)
}

fun main() {
    val shapes = arrayOf(Square(20.0), Triangle(25.4, 14.2), Circle(3.0))
    val areasOfShapes = shapes.map {
        it.area
    }
    println("$areasOfShapes")
}