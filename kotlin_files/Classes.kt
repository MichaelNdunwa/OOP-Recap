package kotlin_files



object Database {
    init {
        println("Database just created..")
    }
}

class User(var firstName: String, var lastName: String, var age: Int) {
    init {
        fun love() = println("Like you said your first name is $firstName")
    }
}

enum class Directions (var direction: String, var distance: Int) {
    NORTH("north", 10),
    SOUTH("south", 20),
    EAST("east", 15),
    WEST("west", 40);

    fun printData() = "Direction = ${direction.uppercase()} and Distance = $distance"
}


enum class Colour(var value: String = "") {
    RED("red"),
    YELLOW("yellow"),
    BLUE("blue");
}

class ListView(val items: Array<String>) {
    inner class ListViewItem() {
        fun displayItem(position: Int) {
            println(items[position])
        }

        fun displayAllItems() {
            items.forEach { println(it) }
        }
    }
}



open class Vehicle(val name: String, val colour: String, doors: Int) {
    open fun move() = println("$name is moving.")
    open fun stop() = println("$name has stopped.")

}

class Car(name: String, colour: String, val engines: Int, val doors: Int) : Vehicle(name, colour, doors) {

    override fun move() {
        super.move()
    }
}

class Plane(name: String, colour: String, val engines: Int, val doors: Int) : Vehicle(name, colour, doors) {}


open class View() {
    open fun draw() = println("Drawing the view.")
}

open class Button(val text: String, val orientation: String) : View() {
    override fun draw() {
        println("Drawing the button.")
        super.draw()
    }
}

class RoundButton(text: String, orientation: String, val corners: Int) : Button(text, orientation) {
    override fun draw() {
        println("Drawing the round button.")
        super.draw()
    }
}