package util

/**
 * https://algs4.cs.princeton.edu/99misc/util.SegmentTree.java.html
 * The `util.SegmentTree` class is an structure for efficient search of cummulative data.
 * It performs  Range Minimum Query and Range Sum Query in O(log(n)) time.
 * It can be easily customizable to support Range Max Query, Range Multiplication Query etc.
 *
 *
 * Also it has been develop with  `LazyPropagation` for range updates, which means
 * when you perform update operations over a range, the update process affects the least nodes as possible
 * so that the bigger the range you want to update the less time it consumes to update it. Eventually those changes will be propagated
 * to the children and the whole array will be up to date.
 *
 *
 * Example:
 *
 *
 * SegmentTreeHeap st = new SegmentTreeHeap(new Integer[]{1,3,4,2,1, -2, 4});
 * st.update(0,3, 1)
 * In the above case only the node that represents the range [0,3] will be updated (and not their children) so in this case
 * the update task will be less than n*log(n)
 *
 * Memory usage:  O(n)
 *
 * @param array the Initialization array
 * @author Ricardo Pacheco
 */
class SegmentTree(array: IntArray) {
    private val heap: Array<Node?>
    private val array: IntArray = array.copyOf(array.size)
    val size: Int = (2 * Math.pow(2.0, Math.floor(Math.log(array.size.toDouble()) / Math.log(2.0) + 1))).toInt()


    /**
     * Time-Complexity:  O(n*log(n))
     *
     */
    init {
        //The max size of this array is about 2 * 2 ^ log2(n) + 1
        heap = arrayOfNulls(size)
        build(1, 0, array.size)
    }

    //Initialize the Nodes of the Segment tree
    private fun build(v: Int, from: Int, size: Int) {
        heap[v] = Node()
        heap[v]!!.from = from
        heap[v]!!.to = from + size - 1
        if (size == 1) {
            heap[v]!!.sum = array[from]
            heap[v]!!.min = array[from]
        } else { //Build childs
            build(2 * v, from, size / 2)
            build(2 * v + 1, from + size / 2, size - size / 2)
            heap[v]!!.sum = heap[2 * v]!!.sum + heap[2 * v + 1]!!.sum
            //min = min of the children
            heap[v]!!.min = Math.min(heap[2 * v]!!.min, heap[2 * v + 1]!!.min)
        }
    }

    /**
     * Range Sum Query
     *
     * Time-Complexity: O(log(n))
     *
     * @param  from from index
     * @param  to to index
     * @return sum
     */
    fun rsq(from: Int, to: Int): Int {
        return rsq(1, from, to)
    }

    private fun rsq(v: Int, from: Int, to: Int): Int {
        val n = heap[v]
        //If you did a range update that contained this node, you can infer the Sum without going down the tree
        if (n!!.pendingVal != null && contains(n.from, n.to, from, to)) {
            return (to - from + 1) * n.pendingVal!!
        }
        if (contains(from, to, n.from, n.to)) {
            return heap[v]!!.sum
        }
        if (intersects(from, to, n.from, n.to)) {
            propagate(v)
            val leftSum = rsq(2 * v, from, to)
            val rightSum = rsq(2 * v + 1, from, to)
            return leftSum + rightSum
        }
        return 0
    }

    /**
     * Range Min Query
     *
     * Time-Complexity: O(log(n))
     *
     * @param  from from index
     * @param  to to index
     * @return min
     */
    fun rMinQ(from: Int, to: Int): Int {
        return rMinQ(1, from, to)
    }

    private fun rMinQ(v: Int, from: Int, to: Int): Int {
        val n = heap[v]
        //If you did a range update that contained this node, you can infer the Min value without going down the tree
        if (n!!.pendingVal != null && contains(n.from, n.to, from, to)) {
            return n.pendingVal!!
        }
        if (contains(from, to, n.from, n.to)) {
            return heap[v]!!.min
        }
        if (intersects(from, to, n.from, n.to)) {
            propagate(v)
            val leftMin = rMinQ(2 * v, from, to)
            val rightMin = rMinQ(2 * v + 1, from, to)
            return Math.min(leftMin, rightMin)
        }
        return Int.MAX_VALUE
    }

    /**
     * Range Update Operation.
     * With this operation you can update either one position or a range of positions with a given number.
     * The update operations will update the less it can to update the whole range (Lazy Propagation).
     * The values will be propagated lazily from top to bottom of the segment tree.
     * This behavior is really useful for updates on portions of the array
     *
     *
     * Time-Complexity: O(log(n))
     *
     * @param from  from index
     * @param to    to index
     * @param value value
     */
    fun update(from: Int, to: Int, value: Int) {
        update(1, from, to, value)
    }

    private fun update(v: Int, from: Int, to: Int, value: Int) { //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
        val n = heap[v]
        /**
         * If the updating-range contains the portion of the current Node  We lazily update it.
         * This means We do NOT update each position of the vector, but update only some temporal
         * values into the Node; such values into the Node will be propagated down to its children only when they need to.
         */
        if (contains(from, to, n!!.from, n.to)) {
            change(n, value)
        }
        if (n.size() == 1) return
        if (intersects(from, to, n.from, n.to)) {
            /**
             * Before keeping going down to the tree We need to propagate the
             * the values that have been temporally/lazily saved into this Node to its children
             * So that when We visit them the values  are properly updated
             */
            propagate(v)
            update(2 * v, from, to, value)
            update(2 * v + 1, from, to, value)
            n.sum = heap[2 * v]!!.sum + heap[2 * v + 1]!!.sum
            n.min = Math.min(heap[2 * v]!!.min, heap[2 * v + 1]!!.min)
        }
    }

    //Propagate temporal values to children
    private fun propagate(v: Int) {
        val n = heap[v]
        if (n!!.pendingVal != null) {
            change(heap[2 * v], n.pendingVal!!)
            change(heap[2 * v + 1], n.pendingVal!!)
            n.pendingVal = null //unset the pending propagation value
        }
    }

    //Save the temporal values that will be propagated lazily
    private fun change(n: Node?, value: Int) {
        n!!.pendingVal = value
        n.sum = n.size() * value
        n.min = value
        array[n.from] = value
    }

    //Test if the range1 contains range2
    private fun contains(from1: Int, to1: Int, from2: Int, to2: Int): Boolean {
        return from2 >= from1 && to2 <= to1
    }

    //check inclusive intersection, test if range1[from1, to1] intersects range2[from2, to2]
    private fun intersects(from1: Int, to1: Int, from2: Int, to2: Int): Boolean {
        return (from2 in from1..to1 //  (.[..)..] or (.[...]..)
                || from1 in from2..to2 // [.(..]..) or [..(..)..
                )
    }

    //The Node class represents a partition range of the array.
    internal class Node {
        var sum = 0
        var min = 0
        //Here We store the value that will be propagated lazily
        var pendingVal: Int? = null
        var from = 0
        var to = 0
        fun size(): Int {
            return to - from + 1
        }
    }
}
fun main(args: Array<String>) {
    val array = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toIntArray()
    val st = SegmentTree(array)
    println(st.size)
    println(st.rMinQ(0,3))
    println(st.rsq(0,3))
    st.update(0,5,20)
    println(st.rMinQ(0,3))
    println(st.rsq(0,3))

}