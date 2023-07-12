package kotlin_files


/***
 * Exercise 1:
 * Create a class called ‘Circle’ with a property called ‘radius’ (Double).
 * Implement custom getters and setters for the radius property to ensure that the radius is
 * always non-negative. If a negative value is assigned, set the radius to 0.
 */
class Circle() {
    var radius: Double = -4.0
        set(value) {
            field = if (field > 0) value else 0.0
        }
}

/***
 * Exercise 2:
 * Create a class called ‘Temperature’ with a property called ‘celsius’ (Double).
 * Implement custom getters and setters for the ‘celsius’ property to convert temperatures between
 * Celsius and Fahrenheit. The getter should return the value in Celsius, and the setter should
 * accept a value in Celsius and update the corresponding Fahrenheit value.
 */
class Temperature() {
    var celsius = 0.0
        get() = field
        set(value) {
            field = (value * 9.0 / 5.0) + 32.0
        }
}

/***
 * Exercise 3:
 * Create a class called User with properties ‘firstName’ (String) and ‘lastName’ (String).
 * Implement a custom getter for a read-only property called ‘fullName’ that returns the concatenation
 * of the first name and last name with a space in between.
 */
class Users(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"
}

/***
 * Exercise 4:
 * Create a class called ‘Product’ with properties ‘name’ (String) and ‘price’ (Double).
 * Implement a custom setter for the ‘price’ property to ensure that the price is always
 * non-negative. If a negative value is assigned, set the price to 0.
 * */
class Product(var name: String, price: Double) {
    var price = price
        set(value) {
            field = if (value > 0.0) value else 0.0
        }
}

/***
 * Exercise 5:
 * Create a class called ‘BankAccount’ with properties ‘accountNumber’ (String) and ‘balance’ (Double).
 * Implement a custom setter for the balance property to log a message whenever the balance is updated.
 * The setter should also ensure that the balance is never negative.

 */
class Account(val accountNumber: String, balance: Double) {
    var balance = balance
        set(value) {
            field = if (value > 0.0) value else throw IllegalArgumentException("Invalid Input")
            println("$value was added to your account.")
        }
}


fun main() {
    val account = Account("Michael", 4.0)
    account.balance = -0.0

}