package kotlin_files

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

fun main() {
  /*  val success = Result.Success("SUCCESS!")
    val progress = Result.Progress("PROGRESS!")
    val exception = IllegalArgumentException("NonRecoverableError")
    val nonRecoverableError = Result.Error.NonRecoverableError(exception, "NON_RECOVERABLE_ERROR")

    getData(nonRecoverableError)*/

//    println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
    println(LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()))
}

fun getData(result: Result) {
    when (result) {
        is Result.Success -> result.showMessage()
        is Result.Progress -> result.showMessage( )
        is Result.Error.RecoverableError -> result.showMessage()
        is Result.Error.NonRecoverableError -> result.showMessage()
        is Result.Error -> result.showMessage()
    }
}

sealed class Result(private val message: String) {
    fun showMessage() = println("Result: $message")
    class Success(message: String) : Result(message)
    sealed class Error(message: String) : Result(message) {
        class RecoverableError(exception: Exception, message: String) : Error(message)
        class NonRecoverableError(exception: Exception, message: String) : Error(message)
    }
    class Progress(message: String) : Result(message)
}
