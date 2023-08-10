package kotlin_files

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val employee = Employee()
    with(employee) {
        firstName = "Michael"
        lastName = "Ndunwa"
    }

    with(employee) {
        println(firstName)
        println(lastName)
    }
}

class Employee() {
    var firstName by FormatDelegate()
    var lastName by FormatDelegate()
}

class App() : A by FirstDelegate(), B by SecondDelegate(), C() {
    override fun printA() {
        TODO("Not yet implemented")
    }

    override fun printB() {
        TODO("Not yet implemented")
    }
}

interface A {
    fun printA()
}

interface B {
    fun printB()
}

open class FirstDelegate() : A {
    override fun printA() {
        TODO("Not yet implemented")
    }
}

open class SecondDelegate() : B {
    override fun printB() {
        TODO("Not yet implemented")
    }
}

open class C() {}
open class D() {}

class FormatDelegate() : ReadWriteProperty<Any?, String> {

    private var formattedString = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String = formattedString

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        formattedString = value.lowercase()
    }

}