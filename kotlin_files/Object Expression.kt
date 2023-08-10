package kotlin_files

class CircleButton(val text: String, val id: Int, onClickListener: OnClickListener)

interface OnClickListener {
    fun onClick()
}

class ClickListener() : OnClickListener {
    override fun onClick() {
        println("Click and Listen")
    }
}

fun main() {
    val clickListener = ClickListener()
    clickListener.onClick()

    val loginButton = CircleButton("Login", 1234, clickListener)
    val signUpButton = CircleButton(
        "SignUp",
        2433,
        object : OnClickListener {
            override fun onClick() {
                TODO("Not yet implemented")
            }
        })

//    println(loginButton)
}