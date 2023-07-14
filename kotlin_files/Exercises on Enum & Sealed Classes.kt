package kotlin_files

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

fun Weekday.isWeekend(): Boolean {
    return if (this.weekend == true) this.weekend
    else this.weekend
}



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
    class Success(val message: String = "Success!!")
    class Error(val message: String = "Failed")
}

fun printResult(result: Results) = println()