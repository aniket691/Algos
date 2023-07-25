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

    /**
     * @param board
     * @param i
     * @param j
     * @param curr
     * @param max
     * @return
     */

    //Longest Possible Route in a Matrix with Hurdle
    //https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
    public static int dfs(int[][] board, int i, int j, int curr, int max) {

        if (i == -1 || j == -1 || i == board.length ||
                j == board[0].length || board[i][j] != 1) {
            return max;
        }

        int temp = board[i][j];
        board[i][j] = '*';

        //save max here for every call
        max = dfs(board, i + 1, j, curr + 1, Math.max(curr, max));
        //System.out.println(curr);
        max = dfs(board, i - 1, j, curr + 1, Math.max(curr, max));
        //System.out.println(curr);
        max = dfs(board, i, j + 1, curr + 1, Math.max(curr, max));
        //System.out.println(curr);
        max = dfs(board, i, j - 1, curr + 1, Math.max(curr, max));
        //System.out.println(curr);
        board[i][j] = temp;

        return max;

    }

    //https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/submissions/

    /**
     * This code finds the maximum sum of fish that can be caught in a rectangular grid, where each cell in the grid represents the number of fish in that location. The algorithm works by iterating through each cell in the grid and checking if it contains any fish. If the cell contains fish, a recursive function called `task()` is called with the current cell's coordinates and an empty array `a`. The `task()` function then adds the number of fish in the current cell to `a[0]` and sets the current cell to 0 (indicating that the fish have been caught). The `task()` function then recursively calls itself for each adjacent cell (up, down, left, and right) that contains fish.
     * <p>
     * The `findMaxFish()` function starts by initializing the variable `sum` to 0. It then iterates through each cell in the grid and checks if the cell contains any fish. If it does, it calls `task()` with the current cell's coordinates and a reference to `a`. Once the `task()` function returns, `findMaxFish()` compares `a[0]` with the current value of `sum` and updates `sum` to the larger of the two values. Finally, `findMaxFish()` returns the maximum sum of fish that can be caught.
     * <p>
     * Algorithm:
     * 1. Initialize `sum` to 0.
     * 2. Iterate through each cell in the grid:
     * a. If the current cell contains fish, call `task()` with the current cell's coordinates and an empty array `a`.
     * b. Compare `a[0]` with the current value of `sum` and update `sum` to the larger of the two values.
     * 3. Return `sum`.
     * <p>
     * Intuition:
     * The code performs a depth-first search (DFS) on the grid, starting from each cell that contains fish. The `task()` function performs the DFS recursively, visiting adjacent cells that contain fish and adding their values to `a[0]`. The `findMaxFish()` function then iterates through each cell in the grid and calls `task()` for each cell that contains fish. The maximum sum of fish that can be caught is returned by `findMaxFish()` as `sum`.
     *
     * @param grid
     * @return
     */
    public int findMaxFish(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int[] a = new int[1];
                    task(grid, i, j, a);
                    sum = Math.max(sum, a[0]);
                }
            }
        }
        return sum;
    }

    public void task(int[][] grid, int i, int j, int a[]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        a[0] += grid[i][j];
        grid[i][j] = 0;
        task(grid, i + 1, j, a);
        task(grid, i - 1, j, a);
        task(grid, i, j + 1, a);
        task(grid, i, j - 1, a);
    }


    //https://www.hackerrank.com/challenges/crossword-puzzle/problem?isFullScreen=true

    /**
     * The code defines a method `placeWordHorizontally` which takes a 2D character array `arr`, a String `word`, and two integer indices `i` and `j`. The method returns a boolean array `wePlaced` indicating which characters of the `word` were successfully placed in the `arr`. The method tries to place the `word` horizontally at the position specified by `i` and `j` in the `arr`.
     * <p>
     * Algorithm:
     * 1. Initialize a boolean array `wePlaced` of length `word.length()` to keep track of which characters were successfully placed in the `arr`.
     * 2. For each character in `word`, check if the corresponding position in the `arr` (i.e., `arr[i][j + jj]`) is a `'-'` character.
     * 3. If the position in the `arr` is a `'-'` character, then place the corresponding character from the `word` in the `arr` at the same position (i.e., `arr[i][j + jj] = word.charAt(jj)`).
     * 4. Also, set the corresponding index in the `wePlaced` array to `true` (i.e., `wePlaced[jj] = true`) to indicate that the character was successfully placed in the `arr`.
     * 5. Finally, return the `wePlaced` array.
     * <p>
     * Note: The code assumes that the length of `word` is less than or equal to the number of columns in the `arr` starting from the `j` index.
     * <p>
     * The code implements a function `unPlaceWordHorizontally` which takes in a 2D character array `arr`, a boolean array `wePlaced`, and two integers `i` and `j`. The function unplaces a word from the character array `arr` by replacing the characters of the word with '-' characters starting from index `j` in row `i`.
     * <p>
     * The function iterates through the indices of the boolean array `wePlaced`. If the value of `wePlaced[jj]` is `true`, it means that a character was previously placed in that index of the row. So, the function replaces the character at index `j+jj` in row `i` with '-'.
     * <p>
     * Intuition:
     * This function is used to undo the placement of a word on a crossword puzzle when the word does not fit or is incorrect. It is necessary to remove the word from the puzzle before trying another word to avoid conflicts.
     * <p>
     * Algorithm:
     * 1. For each index `jj` in the range `0` to `wePlaced.length-1`:
     * - If `wePlaced[jj]` is `true`, set `arr[i][j+jj]` to `'-'`
     * 2. End the loop
     * 3. Return from the function.
     * <p>
     * <p>
     * The code 'canPlaceWordHorizontally' checks whether a given word can be placed horizontally in the crossword puzzle at a particular position (i, j) on the crossword grid. The function returns a boolean value indicating whether the word can be placed or not.
     * Here is the algorithm for the canPlaceWordHorizontally function:
     * <p>
     * Check if there is a valid position to place the word in the horizontal direction, i.e., whether there is a '+' symbol to the left and right of the starting position.
     * If the position is valid, iterate over each character of the word and check if the corresponding position in the crossword grid is empty (denoted by '-' symbol) or if the character in the word matches the character in the crossword grid at that position.
     * If all the characters match or the corresponding position is empty, continue iterating. If any character doesn't match, return false.
     * If the word can be placed horizontally without any conflicts, return true.
     * Overall, this function checks if the given word can fit in the horizontal direction at the given position without any conflicts, and returns true if it can be placed and false otherwise.
     * <p>
     * <p>
     * other funcs are same as above
     *
     * @param arr
     * @param word
     * @param i
     * @param j
     * @return
     */

    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */
    public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }

        return wePlaced;
    }

    public static void unPlaceWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (wePlaced[jj]) {
                arr[i][j + jj] = '-';
            }
        }
    }


    public static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length) {
                return false;
            }


            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }

        return wePlaced;
    }

    public static void unPlaceWordVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (wePlaced[ii]) {
                arr[i + ii][j] = '-';
            }
        }
    }


    public static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length) {
                return false;
            }


            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }


    public static void solution(char[][] arr, String[] words, int vidx, List<String> ans) {

        if (vidx == words.length) {
            if (ans.size() == 0) {
                for (char[] chars : arr) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < arr.length; j++) {
                        row.append(chars[j]);
                    }
                    ans.add(row.toString());
                }
            }
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1, ans);
                        unPlaceWordHorizontally(arr, wePlaced, i, j);
                    }

                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1, ans);
                        unPlaceWordVertically(arr, wePlaced, i, j);
                    }
                }
            }
        }
    }


    /**
     * The given code is a recursive backtracking solution to solve the word search puzzle. The function takes in a 2D character array `arr`, an array of words `words`, an index `vidx` that represents the current word being considered, and a list `ans` to store the final solution.
     * <p>
     * The base case of the recursion is when `vidx` becomes equal to the length of `words`. If `ans` is empty, it means the solution has not yet been found. In this case, the current state of `arr` is converted to a string representation and added to the `ans` list.
     * <p>
     * In each recursive call, the function selects a word `word` from the `words` array and checks if it can be placed horizontally or vertically at every position of the 2D character array `arr`. If the word can be placed horizontally, it is placed by calling the `placeWordHorizontally` function and the recursive call is made by incrementing `vidx` by 1. If the word cannot be placed horizontally, the function checks if the word can be placed vertically. If it can be placed vertically, it is placed using the `placeWordVertically` function and the recursive call is made by incrementing `vidx` by 1. If the word cannot be placed either horizontally or vertically, the function returns without making any changes to `arr`.
     * <p>
     * After the recursive call, the function uses the `unPlaceWordHorizontally` or `unPlaceWordVertically` function to undo the placement of the word that was just made. This is done so that the 2D character array `arr` is in its original state when the next recursive call is made.
     * <p>
     * Overall, the algorithm tries to place each word in every possible position in the 2D character array and then backtracks if the solution cannot be found. The function returns `void` and the solution is stored in the `ans` list.
     *
     * @param crossword
     * @param words
     * @return
     */
    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        // Write your code here

        List<String> ans = new ArrayList<>();

        char[][] arr = new char[10][10];
        for (int i = 0; i < crossword.size(); i++) {
            for (int j = 0; j < crossword.get(i).length(); j++) {
                arr[i][j] = crossword.get(i).charAt(j);
            }
        }

        String[] wordArr = words.split(";");
        solution(arr, wordArr, 0, ans);
        return ans;
    }

}
