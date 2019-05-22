package util

fun main(args: Array<String>) {
    val data = arrayOf(10, 20, 20, 30, 30, 30, 40, 40, 40, 40, 50)
    println(data.lowerBound(25))
    println(data.upperBound(25))
    println(data.size)
}


fun Array<Int>.lowerBound(target: Int, d: Int = 1): Int {
    val binarySearch = this.binarySearch(target - d)
    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
}

fun Array<Int>.upperBound(target: Int, d: Int = 1): Int {
    val binarySearch = this.binarySearch(target + d)
    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
}

fun Array<Double>.lowerBound(target: Int, d: Double = 0.0000001): Int {
    val binarySearch = this.binarySearch(target - d)
    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
}

fun Array<Double>.upperBound(target: Int, d: Double = 0.0000001): Int {
    val binarySearch = this.binarySearch(target + d)
    return if (binarySearch >= 0) binarySearch else Math.abs(binarySearch) - 1
}
