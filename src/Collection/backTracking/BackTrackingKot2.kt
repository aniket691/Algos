package Collection.backTracking

import java.util.*

class BackTrackingKot2 {

    fun graphColoring(G: Array<MutableList<Int>>, color: IntArray, i: Int, C: Int): Boolean {
        val n = G.size
        return solve(i, G, color, n, C)
    }

    private fun isSafe(node: Int, G: Array<MutableList<Int>>, color: IntArray, n: Int, col: Int): Boolean {
        for (it in G[node]) {
            if (color[it] == col) return false;
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

        return false;

    }


}


fun main() {

    fun printNightsTour(chess: Array<IntArray>, r: Int, c: Int, move: Int) {
        if (c < 0 || c < 0 || r == chess.size || c == chess.size) {
            return
        } else if (move == chess.size * chess.size) {
            chess[r][c] = move
            //print board
            chess[r][c] = 0
            return
        }

        chess[r][c]= move
        printNightsTour(chess,r-2,c+1,move+1)

    }

    val sc: Scanner = Scanner(System.`in`)
    var n = sc.nextInt();

    var arr = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            arr[i][j] = sc.nextInt()
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            print(arr[i][j])
        }
        println()
    }


}


