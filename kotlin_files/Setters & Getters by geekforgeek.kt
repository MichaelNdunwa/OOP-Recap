package kotlin_files

class Company {
    var name = "no company name yet"
        private set

    fun myFunc(n: String) {
        name = n
    }
}

class Registration(email: String, pwd: String, age: Int, gender: Char) {
    var emailId = email
        get() = field.lowercase()
    var password = pwd
        set(value) {
            field = if (value.length > 6) value
                else throw IllegalArgumentException("Password is too small.")
        }
    var age = age
        set(value) {
            field = if (value < 18) value else throw IllegalArgumentException("Age must be 18+")
        }
    var gender = gender
        set(value) {
            field = if (value == 'M') value
                else throw IllegalArgumentException("Sorry, this is male only club.")
        }

}

fun main() {
    val programmers = Registration("NdunWa240@gmail.com", "small", 22, 'M')
    println(programmers.emailId)
    programmers.gender = 'F'
    programmers.password = "small"
}