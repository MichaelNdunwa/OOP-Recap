package kotlin_files

/***
 * Exercise 1: Enum Class
 * Create an enum class called Weekday that represents the days of the week (Monday, Tuesday, etc.).
 * Implement a function isWeekend() that takes a Weekday value as a parameter and returns true if
 * it's a weekend day (Saturday or Sunday), and false otherwise.
 */

enum class Weekday(var weekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

//    fun Weekday.isWeekend() : Boolean {
//        return if (this.weekend == weekend)
//    }
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
    Green,
    Blue;

    fun mixColors(color1: Color, color2: Color) {
        val color1 = color1.name.lowercase(); val color2 = color2.name.lowercase()
         if (color1 == "red" && color2 == "red") {
            println("$color1 + $color2 = Red")
        }
        else if (color1 == "blue" && color2 == "blue") {
            println("$color1 + $color2 = Blue")
        }
        else if (color1 == "yellow" && color2 == "yellow") {
            println("$color1 + $color2 = Yellow")
        }
        else if (color1 == "red" && color2 == "blue" || color1 == "blue" && color2 == "red") {
            println("$color1 + $color2 = Purple")
        }
        else if (color1 == "red" && color2 == "yellow" || color1 == "yellow" && color2 == "red") {
            println("$color1 + $color2 = Orange")
        }
        else if (color1 == "blue" && color2 == "yellow" || color1 == "yellow" && color2 == "blue") {
            println("$color1 + $color2 = Green")
        }
        else println("I only mix primary colors. Try again with primary colors.")
    }
}

fun main() {
    val red = Color.Red; val blue = Color.Blue; val green = Color.Green
}