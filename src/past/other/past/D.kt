package past.other.past

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val nums = IntArray(n + 1) { 0 }
    nums[0] = 1
    (1..n).forEach { nums[readLine()!!.toInt()]++ }
    if (nums.contains(0)) {
        println(nums.indexOf(2).toString() + " " + nums.indexOf(0))
    } else {
        println("Correct")
    }
}
