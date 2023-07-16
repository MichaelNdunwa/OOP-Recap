package kotlin_files

fun main() {
    DayOfTheWeek.values().forEach { day ->
        println("Day ${day.ordinal}: ${day.name}")
    }
    println()
    val dayIndex = 1
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    println()
    val tuesday = DayOfTheWeek.findValue("tuesday")
    println("Tuesday is day ${tuesday?.ordinal}")
}

enum class DayOfTheWeek(val todayName: String) {
    Sunday("Sunday"),
    Monday("Monday"),
    Tuesday("Tuesday"),
    Wednesday("Wednesday"),
    Thursday("Thursday"),
    Friday("Friday"),
    Saturday("Saturday");

    companion object {
        fun findValue(value: String): DayOfTheWeek? {
            return values().find { it.todayName.uppercase() == value.uppercase()}
        }
    }
}