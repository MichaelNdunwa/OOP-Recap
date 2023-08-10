package kotlin_files

fun main() {
    val student1 = Student("Michael", "Computer Engineering", "200L")
    val student2 = Student("Amos", "Microbiology", "200L")
    val student3 = Student("Michael", "Computer Engineering", "200L")

    println(student1 == student2)
    println(student1)

    /*val orange1 = Orange(); val orange2 = Orange()
    println(orange1 == orange2)*/
}

data class Student(val name: String, val department: String, val level: String)

/*class Student(val name: String, val department: String, val level: String) : Any()  {
    override fun equals(other: Any?): Boolean {
        if (this === other) true

        if (other is Student)
            return this.name == other.name && this.department == other.department && this.level == other.level

        return true
    }

    override fun hashCode(): Int = 0

    override fun toString(): String = "I'm $name, am studying $department and am in $level."
}*/

abstract class Fruit {
    abstract fun numberOfSeeds() : Int
}

class Orange : Fruit() {
    override fun numberOfSeeds(): Int {
        TODO("Not yet implemented")
    }
}