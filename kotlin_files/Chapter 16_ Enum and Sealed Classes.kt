package kotlin_files

import java.util.Calendar


enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

    fun daysUntil(other: DayOfTheWeek): Int {
        return if (this.ordinal < other.ordinal)  other.ordinal - this.ordinal
            else other.ordinal - this.ordinal + DayOfTheWeek.values().count()
    }
    companion object {
/*
        fun findValue(value: String?): String {
            DayOfTheWeek.values().forEach {
                if (it.name.lowercase() == value?.lowercase())
                    return it.name
            }
            return "The day you entered is not in days of the week try again."
        }
*/
        fun deleteThisLater(day: DayOfTheWeek) = println("Today is ${day.name}")

        fun today(): DayOfTheWeek {
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            var adjustedDay = calendarDayOfWeek - 2
            val days = DayOfTheWeek.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }
    }
}

sealed class AcceptedCurrency {
    abstract val valueInDollar: Float
    var amount = 0.0f

    class Dollar: AcceptedCurrency() {
        override val valueInDollar = 1.0f
    }

    class Euro: AcceptedCurrency() {
        override val valueInDollar: Float = 1.25f
    }

    class Crypto: AcceptedCurrency() {
        override val valueInDollar = 2534.92f
    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "GeekCoin"
        }

    fun totalValueInDollars() = amount * valueInDollar

}

// Creating extension function for accessing the names of the currency
private fun AcceptedCurrency.getCurrencyName(): String {
    return when (this) {
        is AcceptedCurrency.Dollar -> "Dollar"
        is AcceptedCurrency.Crypto -> "Crypto"
        is AcceptedCurrency.Euro -> "Euro"
    }
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }

    println("\n**********************************")
    val dayIndex = 5
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at index $dayIndex is $dayAtIndex")

    println("\n**********************************")
    val friday = DayOfTheWeek.valueOf("Friday")
    println("${friday.name} is day ${friday.ordinal}")

   /* println("\n**********************************")
    val notADay = DayOfTheWeek.findValue("Blernsday")
    println("Not a day: $notADay")*/

    println("\n**********************************")
    DayOfTheWeek.deleteThisLater(DayOfTheWeek.Friday)

    /*val javaCalendarDays = arrayOf("Not a day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    println("Enter any days of the week:")
    var input = readln()
    var index = 1
    javaCalendarDays.forEach {
        if (it == input) index = javaCalendarDays.indexOf(input)
    }
    var adjustedDay = index - 2
    if (adjustedDay < 0) adjustedDay += javaCalendarDays.size - 1
    println(DayOfTheWeek.values()[adjustedDay])*/

    println("\n**********************************")
    val today = DayOfTheWeek.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    val secondDay = DayOfTheWeek.Saturday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay")

    println("\n**********************************")
    when (today) {
        DayOfTheWeek.Monday -> println("I don't care if $today's blue.")
        DayOfTheWeek.Tuesday -> println("$today's gray")
        DayOfTheWeek.Wednesday -> println("And $today, too")
        DayOfTheWeek.Thursday -> println("$today, I don't care about you.")
        DayOfTheWeek.Friday -> println("It's $today, I'm in love")
        DayOfTheWeek.Saturday -> println("$today, Wait...")
        DayOfTheWeek.Sunday -> println("$today always comes too late")
    }

    println("\n**********************************")
    println("******** SEALED CLASSES **********")
    println("**********************************\n")

    val currency = AcceptedCurrency.Crypto()
    println("You've got some ${currency.getCurrencyName()}")

    println("\n***** Calculating currency in Dollars *****")
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars.")

}
