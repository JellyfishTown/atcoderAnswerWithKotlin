package util

fun main(args: Array<String>) {
    val data = arrayOf(10, 20, 20, 30, 30, 30, 40, 40, 40, 40, 50)
    println(binarySearch(data, 25))
    println(binarySearch(data, 30))
    println(binarySearch(data, 35))
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

fun binarySearch(list: Array<Int>, key: Int): Int {
    fun isOk(index: Int, key: Int): Boolean {
        return list[index] <= key
    }

    var ngIndex = -1
    var okIndex = list.size

    while (Math.abs(okIndex - ngIndex) > 1) {
        val mid = (okIndex + ngIndex) / 2
        if (isOk(mid, key)) okIndex = mid
        else ngIndex = mid
    }
    return okIndex
}