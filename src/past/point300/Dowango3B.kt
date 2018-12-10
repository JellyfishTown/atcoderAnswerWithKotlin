fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    val s25 = mutableListOf<Char>()
    val s52 = mutableListOf<Char>()
    var flag = true
    var currentLv = 0
    var maxLv = 0
    for (c in s) {
        if (flag) {
            s25.add('2')
            s52.add('5')
        } else {
            s25.add('5')
            s52.add('2')
        }
        flag = !flag
    }

    for (i in 0 until s.size) {
        if (s25[i] == '2' && (s[i] == '2' || s[i] == '?')) {
            currentLv++
        } else if (currentLv > 0 && s25[i] == '5' && (s[i] == '5' || s[i] == '?')) {
            currentLv++
        } else {
            maxLv = Math.max(maxLv, currentLv - if (currentLv % 2 == 1) 1 else 0)
            currentLv = 0
        }
    }
    maxLv = Math.max(maxLv, currentLv - if (currentLv % 2 == 1) 1 else 0)
    currentLv = 0
    for (i in 0 until s.size) {
        if (s52[i] == '2' && (s[i] == '2' || s[i] == '?')) {
            currentLv++
        } else if (currentLv > 0 && s52[i] == '5' && (s[i] == '5' || s[i] == '?')) {
            currentLv++
        } else {
            maxLv = Math.max(maxLv, currentLv - if (currentLv % 2 == 1) 1 else 0)
            currentLv = 0
        }
    }
    maxLv = Math.max(maxLv, currentLv - if (currentLv % 2 == 1) 1 else 0)
    println(maxLv)
}
