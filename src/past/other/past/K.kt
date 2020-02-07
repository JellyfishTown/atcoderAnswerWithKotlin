package past.other.past

fun main(args: Array<String>) {
    class Lca(size: Int) {
        private val logSize = (Math.log(size.toDouble()) + 2).toInt()
        private val vertices = (0 until size).map { Vertex(it, logSize) }.toTypedArray()
        private var rootIndex = 0
        private var builded = false

        fun addEdge(x: Int, y: Int) {
            builded = false
            val vx = vertices[x]
            val vy = vertices[y]
            vx.edges.add(Edge(vx, vy))
            vy.edges.add(Edge(vy, vx))
        }

        fun setRoot(index: Int) {
            builded = false
            rootIndex = index
        }

        fun queryIndex(x: Int, y: Int): Int {
            return queryVertex(x, y).index
        }

        fun queryDepth(x: Int, y: Int): Int {
            return queryVertex(x, y).depth
        }

        fun getDepth(x: Int): Int {
            if (builded.not()) build();
            return vertices[x].depth
        }

        private fun build() {
            fun dfs(vertex: Vertex, parent: Vertex?, depth: Int) {
                vertex.powParents[0] = parent
                vertex.depth = depth
                for (v in vertex.edges.map { it.end }) {
                    if (v.visited) continue
                    v.visited = true
                    dfs(v, vertex, depth + 1)
                }
            }
            vertices[rootIndex].visited = true
            dfs(vertices[rootIndex], null, 0)

            for (k in 1 until logSize) {
                for (v in vertices) {
                    if (v.powParents[k - 1] != null)
                        v.powParents[k] = v.powParents[k - 1]!!.powParents[k - 1]
                }
            }
            builded = true
        }

        private fun queryVertex(x: Int, y: Int): Vertex {
            if (builded.not()) build()
            var vx = vertices[x]
            var vy = vertices[y]
            if (vx.depth > vy.depth) {
                val temp = vx
                vx = vy
                vy = temp
            }
            for (k in 0 until logSize) {
                if ((vy.depth - vx.depth) shr k and 1 == 1) {
                    vy = vy.powParents[k]!!
                }
            }
            if (vx == vy) return vx
            for (k in logSize - 1 downTo 0) {
                if (vx.powParents[k] != vy.powParents[k]) {
                    vx = vx.powParents[k]!!
                    vy = vy.powParents[k]!!
                }
            }
            return vx.powParents[0]!!
        }


        inner class Vertex(val index: Int, powParentsLength: Int) {
            var depth = 0
            var visited = false
            val powParents = Array<Vertex?>(powParentsLength) { null }
            val edges = mutableListOf<Edge>()
        }

        inner class Edge(val start: Vertex, val end: Vertex)

    }

    val n = readLine()!!.toInt()
    val lca = Lca(n)
    (0 until n).forEach {
        val p = readLine()!!.toInt()
        if (p == -1) lca.setRoot(it)
        else lca.addEdge(it, p - 1)
    }
    val q = readLine()!!.toInt()
    (1..q).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        val l = lca.queryIndex(a - 1, b - 1) + 1
        println(if (l == b) "Yes" else "No")
    }
}
