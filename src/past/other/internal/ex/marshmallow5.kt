package past.other.internal.ex

import java.util.*

fun main(args: Array<String>) {
    val (n, m, t, k) = readLine()!!.split(' ').map(String::toLong)

    //道路をfrom:[(to,コスト,混雑度合)]の形式で保持する
    val roads = mutableMapOf<Long, MutableList<Triple<Long, Long, Long>>>()
    (1..n).forEach { roads[it] = mutableListOf() }//初期化
    (1..m).forEach {
        val (a, b, c, d) = readLine()!!.split(' ').map(String::toLong)
        roads[a]!!.add(Triple(b, c, d))//a⇒bへの道路を登録
        roads[b]!!.add(Triple(a, c, d))//b⇒aへの道路を登録
    }

    //各都市に到達可能な最短時間を保持する配列の宣言
    val minTimeArray = Array(n.toInt() + 1) { Long.MAX_VALUE }//初期値は∞
    minTimeArray[1] = 0//スタート地点への到達時間は0

    //各地点への最短到達時間を探索する。優先度付きキューを使用して、より早く到達可能な都市から探索を行う(多分ダイクストラ法)
    //探索用PriorityQueue。 Pair<次の都市, 次の都市に到達する時間＞。poll(要素の取出)を行うと、Queueの中で到達時間が最短の都市が取出される。
    val queue = PriorityQueue<Pair<Long, Long>>(n.toInt(),
            Comparator { o1: Pair<Long, Long>?, o2: Pair<Long, Long>? -> if (o1!!.second > o2!!.second) -1 else 1 })
    queue.add(Pair(1, 0))//探索のスタート地点を登録
    while (queue.isNotEmpty()) {
        val (cur, curTime) = queue.poll()!!//現在地,現在地点へ到達する時刻
        if (curTime > minTimeArray[cur.toInt()]) continue //いらないかも

        for ((to, cost, d) in roads[cur]!!) {//現在地から延びる道路のループ

            //道路通行中の最大混雑度合い
            val maxCrowdedDegree =
                    if (t in curTime..(curTime + cost)) {//道路通行中にピークtを迎える場合
                        d
                    } else {
                        Math.max(
                                d - Math.abs(t - curTime),//渡り始めの混雑度合
                                d - Math.abs(t - (curTime + cost))//渡り終りの混雑度合
                        )
                    }

            //混雑のために待機する必要がある時間
            val waitTime =
                    if (maxCrowdedDegree <= k) {//混雑が我慢できるなら待ち時間は0
                        0
                    } else if (curTime < t) {//現在時刻がTより前の場合に待つ必要がある時間 (今から時刻Tまで待機する時間＋Tから混雑度合いがKになるまで待つ時間)
                        (t - curTime) + (d - k)
                    } else {//現在時刻がT以降の場合に待つ必要がある時間(今から混雑度合いがkになるまでの時間)
                        maxCrowdedDegree - k
                    }

            //対象道路を利用する場合にtoに到着する時刻
            val toTime = curTime + cost + waitTime

            //目的地に到着可能な最短時刻を更新できる場合は更新し、Queueに追加する
            if (minTimeArray[to.toInt()] > toTime) {
                minTimeArray[to.toInt()] = toTime
                queue.add(Pair(to, toTime))
            }
        }
    }

    val time = minTimeArray[n.toInt()]
    println(if (time == Long.MAX_VALUE) -1 else time)//nへの到達時刻が初期値から更新されていない場合(=到着不可能)は-1を出力
}
