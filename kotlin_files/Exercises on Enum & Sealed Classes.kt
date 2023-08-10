package kotlin_files

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.PI
import kotlin.math.pow

/***
 * Exercise 1: Enum Class
 * Create an enum class called Weekday that represents the days of the week (Monday, Tuesday, etc.).
 * Implement a function isWeekend() that takes a Weekday value as a parameter and returns true if
 * it's a weekend day (Saturday or Sunday), and false otherwise.
 */

enum class Weekday(val weekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);
}

fun isWeekend(weekday: Weekday): Boolean {
    val theDay = weekday.weekend
    return if (theDay) theDay else theDay
}


fun checkCustomDay(customDay: String) {
    var customDay = customDay.lowercase()
    var dayList = mutableListOf<Weekday>()
    Weekday.values().forEach {
        if (customDay == it.name.lowercase()) dayList.add(it)
    }

    val today = dayList[0]
    if (dayList.isNotEmpty()) {
        when(today.weekend) {
            true -> println("$today is weekend come back during weekdays.")
            false -> println("$today is a weekday, come back during the weekend.")
        }
    } else {
        println("Invalid input: $today is not in days of the week, try again.")
    }
}

fun checkCurrentDay() {
    var today = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).lowercase()
    var day: Weekday = Weekday.Monday
    Weekday.values().forEach {
        if (today == it.name.lowercase()) day = it
    }

    when (isWeekend(day)) {
        true -> println("$today is weekend come back during weekdays.")
        false -> println("$today is a weekday, come back during the weekend.")
    }
}

/*fun main() {
    println("Today is what?")
    checkCustomDay(readln())

}*/

/***
 * Exercise 2: Enum Class
 * Create an enum class called 'Color' that represents different colors (Red, Green, Blue, etc.).
 * Implement a function 'mixColors()' that takes two 'Color' values as parameters and returns a new
 * 'Color' value representing the mixture of the two colors. Define the color mixing logic
 * based on your preference.
 */

enum class Color {
    Red,
    Yellow,
    Blue;

    companion object {
        fun mixColors(color1: Color, color2: Color): String {
            val color1 = color1.name.lowercase();
            val color2 = color2.name.lowercase()
            return when {
                color1 == "red" && color2 == "red" -> "$color1 + $color2 = Red"
                color1 == "blue" && color2 == "blue" -> "$color1 + $color2 = Blue"
                color1 == "yellow" && color2 == "yellow" -> "$color1 + $color2 = Yellow"
                color1 == "red" && color2 == "blue" || color1 == "blue" && color2 == "red" -> "$color1 + $color2 = Purple"
                color1 == "red" && color2 == "yellow" || color1 == "yellow" && color2 == "red" -> "$color1 + $color2 = Orange"
                color1 == "blue" && color2 == "yellow" || color1 == "yellow" && color2 == "blue" -> "$color1 + $color2 = Green"
                else -> "I only mix primary colors. Try again with primary colors."
            }
        }
    }
}

/*
fun main() {
    val red = Color.Red; val blue = Color.Blue; val yellow = Color.Yellow;
    println(Color.mixColors(yellow, red))
}*/


/**
 * Exercise 3: Sealed Class
 * Create a sealed class called Result that represents the result of an operation.
 * Implement two subclasses: Success and Error. The Success class should contain a message
 * indicating the successful result, while the Error class should contain an error message.
 * Implement a function printResult() that takes a Result object and prints either the
 * success message or the error message.
 */

sealed class Results {
    class Success(val message: String = "Success!!") : Results()
    class Error(val message: String = "Failed") : Results()
    object Neutral {
        fun print() = println("This is an object neutral inside a Results sealed class.")
    }
}

fun printResult(result: Results) {
    when(result) {
        is Results.Success -> println(result.message)
        is Results.Error -> println(result.message)
    }
}

/*fun main() {
    printResult(Results.Success())
    Results.Neutral.print()
}*/


/***
 * Exercise 4: Sealed Class
 * Create a sealed class called Shape that represents different geometric shapes
 * (Circle, Rectangle, Triangle, etc.). Implement subclasses for each shape and provide properties
 * and methods specific to each shape. Implement a function calculateArea() that takes a Shape
 * object and calculates its area based on the specific shape.
 */

sealed class Shapes {
    class Circle(private val radius: Double) : Shapes() {
        override fun area() = PI * radius.pow(2)
    }

    class Rectangle(
        private val length: Double,
        private val width: Double
    ) : Shapes() {
        override fun area() = length * width
    }

    class Triangle(
        private val base: Double,
        private val height: Double
    ) : Shapes() {
        override fun area() = (base * height) / 2.0
    }

    class Square(private val side: Double) : Shapes() {
        override fun area() = side.pow(2)
    }
    abstract fun area(): Double
}

fun calculateArea(shape: Shapes) {
    when (shape) {
        is Shapes.Circle -> println("The area of the Circle is ${shape.area()}")
        is Shapes.Rectangle -> println("The area of the Rectangle is ${shape.area()}")
        is Shapes.Square -> println("The area of the Square is ${shape.area()}")
        is Shapes.Triangle -> println("The area of the Triangle is ${shape.area()}")
    }
}

/*fun main() {
    calculateArea(Shapes.Rectangle(10.0, 5.0))
    calculateArea(Shapes.Triangle(10.0, 8.0))
}*/

/***
 * Exercise 5: Enum Class and Sealed Class Combined
 * Create an enum class called Direction that represents the cardinal directions (North, South, East, West).
 * Create a sealed class called Movement with subclasses Walk and Run. Implement a function move()
 * that takes a Direction and a Movement object and prints a message indicating the movement direction and speed.
 */

enum class Directionz {
    North, South, East, West;
}

sealed class Movements {
    class Walk(val speed: Double): Movements() {}
    class Run(val speed: Double): Movements() {}
}

fun move(direction: Directionz, movements: Movements) {
    when (movements) {
        is Movements.Run -> println("You're running in the $direction direction, with the speed of ${movements.speed} m/s.")
        is Movements.Walk -> println("You're walking in the $direction direction, with the speed of ${movements.speed} m/s.")
    }
}

/*
fun main() {
    move(Directionz.North, Movements.Walk(5.6))
}*/

