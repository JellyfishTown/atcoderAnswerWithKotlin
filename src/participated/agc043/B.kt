package participated.agc043

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.toCharArray()
    val groupBy = aList.groupBy { it }
    val oCount = groupBy['1']!!.size
    val tCount = groupBy['2']!!.size
    val thCount = groupBy['3']!!.size

    when{
        (oCount==1&&tCount==1&&thCount==1)->{println(0)}
        (oCount==1&&tCount==1&&thCount==0)->{println(1)}
        (oCount==1&&tCount==0&&thCount==1)->{println(2)}
        (oCount==0&&tCount==1&&thCount==1)->{println(1)}
        (oCount==1&&tCount==0&&thCount==0)->{println(1)}
        (oCount==0&&tCount==1&&thCount==0)->{println(2)}
        (oCount==0&&tCount==0&&thCount==1)->{println(3)}
        (oCount==0&&tCount==0&&thCount==0)->{println(0)}
    }
}
