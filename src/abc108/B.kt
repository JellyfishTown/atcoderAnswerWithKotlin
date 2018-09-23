package abc108

fun main(args: Array<String>) {
    val (x1, y1, x2, y2) = readLine()!!.split(' ').map(String::toInt)
    val x = Math.max(x1, x2) - Math.min(x1, x2)
    val y = Math.max(y1, y2) - Math.min(y1, y2)

    if (x2 >= x1 && y2 >= y1) {
        println("${x2 - y} ${y2 + x} ${x1 - y} ${y1 + x}")
    }else if(x1 >= x2 && y2 >= y1){
        println("${x2 - y} ${y2 - x} ${x1 - y} ${y1 - x}")
    }else if(x1 >= x2 && y1 >= y2){
        println("${x2 + y} ${y2 - x} ${x1 + y} ${y1 - x}")
    }else{
        println("${x2 + y} ${y2 + x} ${x1 + y} ${y1 + x}")
    }
}


