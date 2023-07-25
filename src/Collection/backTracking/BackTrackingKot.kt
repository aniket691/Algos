package Collection.backTracking

class BackTrackingKot {

    //graph coloring
    //https://takeuforward.org/data-structure/m-coloring-problem/
    fun graphColoring(G: Array<MutableList<Int>>, color: IntArray, i: Int, C: Int): Boolean {
        val n = G.size
        return solve(i, G, color, n, C)
    }
    private fun isSafe(node: Int, G: Array<MutableList<Int>>, color: IntArray, n: Int, col: Int): Boolean {
        for (it in G[node]) {
            if (color[it] == col) return false
        }
        return true
    }

    private fun solve(node: Int, G: Array<MutableList<Int>>, color: IntArray, n: Int, m: Int): Boolean {
        if (node == n) return true

        for (i in 1..m) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i
                if (solve(node + 1, G, color, n, m)) return true
                color[node] = 0
            }
        }
        return false
    }

}


