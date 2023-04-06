package Collection.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BackTracking {

    //https://takeuforward.org/data-structure/rat-in-a-maze/

    /**
     * @param i
     * @param j
     * @param a
     * @param n
     * @param ans
     * @param move
     * @param vis
     */
    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,
                              int vis[][]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis);
        return ans;
    }

    //https://takeuforward.org/data-structure/combination-sum-1/

    /**
     * @param ind
     * @param arr
     * @param target
     * @param ans
     * @param ds
     */
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    //TODO: backtracking crossword puzzle
    //https://www.hackerrank.com/challenges/crossword-puzzle/problem

    public class Solution {
        static final int SIZE = 10;
        static final int[] R_OFFSETS = {0, 1};
        static final int[] C_OFFSETS = {1, 0};

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            char[][] grid = new char[SIZE][SIZE];
            for (int r = 0; r < SIZE; r++) {
                String line = sc.next();
                for (int c = 0; c < SIZE; c++) {
                    grid[r][c] = line.charAt(c);
                }
            }
            String[] words = sc.next().split(";");

            char[][] solution = solve(grid, words);
            IntStream.range(0, SIZE).forEach(r -> System.out.println(String.valueOf(solution[r])));

            sc.close();
        }

        static char[][] solve(char[][] grid, String[] words) {
            return search(grid, Arrays.stream(words).collect(Collectors.toSet()), 0, 0, 0);
        }

        static char[][] search(char[][] grid, Set<String> remainWords, int r, int c, int direction) {
            if (r == SIZE) {
                return grid;
            }
            if (c == SIZE) {
                return search(grid, remainWords, r + 1, 0, 0);
            }
            if (direction == R_OFFSETS.length) {
                return search(grid, remainWords, r, c + 1, 0);
            }

            int insertLength = countInsertLength(grid, r, c, direction);
            if (insertLength > 1) {
                for (String remainWord : new ArrayList<>(remainWords)) {
                    if (canInsert(grid, r, c, direction, insertLength, remainWord)) {
                        List<Integer> insertOffsets = new ArrayList<Integer>();

                        for (int insertOffset = 0; insertOffset < insertLength; insertOffset++) {
                            int insertR = r + R_OFFSETS[direction] * insertOffset;
                            int insertC = c + C_OFFSETS[direction] * insertOffset;

                            if (grid[insertR][insertC] == '-') {
                                grid[insertR][insertC] = remainWord.charAt(insertOffset);

                                insertOffsets.add(insertOffset);
                            }
                        }
                        remainWords.remove(remainWord);

                        char[][] subResult = search(grid, remainWords, r, c, direction + 1);
                        if (subResult != null) {
                            return subResult;
                        }

                        remainWords.add(remainWord);
                        for (int insertOffset : insertOffsets) {
                            int insertR = r + R_OFFSETS[direction] * insertOffset;
                            int insertC = c + C_OFFSETS[direction] * insertOffset;

                            grid[insertR][insertC] = '-';
                        }
                    }
                }

                return null;
            } else {
                return search(grid, remainWords, r, c, direction + 1);
            }
        }

        static int countInsertLength(char[][] grid, int r, int c, int direction) {
            int prevR = r - R_OFFSETS[direction];
            int prevC = c - C_OFFSETS[direction];
            if (prevR >= 0 && prevR < SIZE && prevC >= 0 && prevC < SIZE && grid[prevR][prevC] != '+') {
                return 0;
            }

            int insertLength = 0;
            while (r >= 0 && r < SIZE && c >= 0 && c < SIZE && grid[r][c] != '+') {
                insertLength++;

                r += R_OFFSETS[direction];
                c += C_OFFSETS[direction];
            }
            return insertLength;
        }

        static boolean canInsert(char[][] grid, int r, int c, int direction, int insertLength, String word) {
            return word.length() == insertLength && IntStream.range(0, word.length()).allMatch(insertOffset -> {
                int insertR = r + R_OFFSETS[direction] * insertOffset;
                int insertC = c + C_OFFSETS[direction] * insertOffset;

                return grid[insertR][insertC] == '-' || grid[insertR][insertC] == word.charAt(insertOffset);
            });
        }
    }

}
