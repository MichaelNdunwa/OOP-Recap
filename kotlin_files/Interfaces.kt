package kotlin_files

fun main() {

}

interface Engine {
    fun startEngine() : String
}

class Cars(val name: String, val colour: String) : Engine {
    override fun startEngine(): String = "ON"

}