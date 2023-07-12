package kotlin_files

// Exercise 1:
class Person constructor(val name: String, val age: Int, val address: String) {
    constructor(name: String) : this(name, 0, "")
}

// Exercise 2:
class Book constructor(val title: String, val author: String, val publicationYear: Int) {
    constructor(title: String, author: String) : this(title, author, 0)
}

// Exercise 3:
class Rectangle constructor(val width: Double, val height: Double) {
    constructor(length: Double) : this(length, length)
}

// Exercise 4:
class Moto constructor(val make: String, val model: String, val year: Int, val color: String) {
    constructor(make: String, model: String) : this(make, model, 0, "")
}

// Exercise 5:
class BankAccount constructor(
    val accountNumber: String, val accountHolderName: String, var balance: Double
    ) {
    constructor(accountNumber: String, accountHolder: String) : this(accountNumber, accountHolder, 0.0)
}