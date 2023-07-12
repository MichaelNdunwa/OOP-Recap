package kotlin_files


fun main() {
    val car = Car("BMW", "RED", 1, 4)
    val plane = Plane("Boeing", "WHITE and GREEN", 4, 8)
}

class PersonalAccount(val name: String) {
    private var balance: Int = 0; private var transactions: MutableList<Int> = mutableListOf()

    fun deposit(amount: Int) {
        if (amount > 0) {
            transactions.add(amount)
            balance += amount
            println("$amount deposited. Balance is now ${this.balance}")
        } else {
            println("Cannot deposit negative sums")
        }
    }

    fun withdraw(withdrawal: Int) {
        if (withdrawal < balance) {
            transactions.add(-withdrawal)
            balance += -withdrawal
            println("$withdrawal withdrawn. Balance is now balance")
        }
        else if (withdrawal < 0) println("Cannot withdrawal negative sums.")
        else println("The amount you want to withdrawal is greater than the amount you have.")
    }
}
