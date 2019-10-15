package past.other.internal.m6

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    //添え字の頂点から延びる辺のSetを保持する配列
    val branches = Array(1001) { mutableSetOf<Int>() }

    //点a⇒b、b→aをそれぞれ保持
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        branches[a].add(b)
        branches[b].add(a)
    }

    //1頂点から出る辺本数の最大値を取得する。
    val maxBranchNum = branches.map { it.size }.max()!!

    //n頂点、n-1本の辺で連結グラフの場合、ループ構造は確実に発生しない
    //そのため点を削除するとそれに紐づく各頂点はそれぞれ異なる連結成分となる
    println(maxBranchNum)
}


