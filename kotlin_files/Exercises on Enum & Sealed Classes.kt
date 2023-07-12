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

fun main() {
//    println(Weekday.values().isWeekend(Weekday.Monday))
}

/***
 * Exercise 2: Enum Class
 * Create an enum class called Color that represents different colors (Red, Green, Blue, etc.).
 * Implement a function mixColors() that takes two Color values as parameters and returns a new
 * Color value representing the mixture of the two colors. Define the color mixing logic
 * based on your preference.
 */

