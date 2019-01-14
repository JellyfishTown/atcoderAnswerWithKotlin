package participated.ext003

//https://keyence2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val nList = readLine()!!.split(' ').map(String::toLong)
    if (nList.contains(1) && nList.contains(9) && nList.contains(7) && nList.contains(4)) {
        println("YES")
    } else {
        println("NO")
    }
}
