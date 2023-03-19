package Collection.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Matrices {

    //https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

    /**
     * @param mat
     */
    public void printDiagonal(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        for (int g = 0; g < rows; g++) {
            for (int i = 0, j = g; j < rows; i++, j++) {
                System.out.println(mat[i][j]);
            }
        }
    }

    //https://leetcode.com/problems/set-matrix-zeroes/

    /**
     * @param matrix
     */

    //TODO: correct the code and include optimal solution
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(matrix[0][0]);

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }


    }

    //https://leetcode.com/problems/spiral-matrix/
    //TODO: print spiral
    public List<Integer> spiralOrder(int[][] matrix) {

        return new ArrayList<>();
    }


    /**
     * check row = > row+int(row_no)+element
     * check col = > col+int(col_no)+element
     * check box = > box+int((i/3*3))+(int(j/3))+element
     *
     * @param board
     * @return
     */
    //TODO: learn back tracking solution
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //if false means element is already present in the hashset
                    if (!set.add("row" + i + board[i][j]) ||
                            //if false means element is already present in the hashset
                            !set.add("coloumn" + j + board[i][j])) {
                        return false;
                    }
                    //if false means element is already present in the hashset
                    if (!set.add("box" + (i / 3) * 3 + j / 3 + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * rotate image
     * ==> Steps
     * 1) transpose the matrix
     * 2) reverse each row of matrix
     * ==> Problems
     * 1) how to transpose matrix in-place
     * 2) how to reverse every row in matrix
     * 3) confusion between pass by value and pass by reference
     * ==> Different cases
     * 1) matrix can be empty
     */

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void rotate(int[][] matrix) {

        //how to transpose a matrix in-place
        //if we will run jth loop till end then we will end up swapping the required elements twice
        //which will result in the original array
        //to prevent this we will run the jth loop till i only
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //how to reverse a matrix
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length / 2; i++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix[j].length - i - 1];
                matrix[j][matrix[j].length - i - 1] = temp;
            }
        }
    }


    /**
     * check if word exists
     *
     * @param board
     * @param word
     * @return ==> Problems
     * 1) how to check if character exits in adjacent cells
     * 2) how to use enum for that
     * 3) how to know which character is current and how to know which we need to find
     * 4) how to keep track of current and to find
     * 5) when to return false and when to return true
     * 6) how to know if we are on the adjacent cell
     * ==> Cases
     * 1) what if the given word is not present in the matrix
     * ==> Steps/Intuition
     * 1) for every element we can check left right bottom top if our target is present
     * 2) if present the keep moving on
     * 3) else return false;
     * ==> Mistakes
     * ==> Learnings
     * 1) DFS
     * 2) BackTracking
     */
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return dfs(board, word, i, j, 0);
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int count) {

        if (count == word.length()) return true;

        if (i == -1 || j == -1 || i == board.length ||
                j == board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';

        boolean flag = dfs(board, word, i + 1, j, count + 1) ||
                dfs(board, word, i - 1, j, count + 1) ||
                dfs(board, word, i, j + 1, count + 1) ||
                dfs(board, word, i, j - 1, count + 1);

        board[i][j] = temp;

        return flag;
    }

    public static void commonElements(int Mat[][], int r, int c) {
        // Map
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < c; i++) {
            map.put(Mat[0][i], 1);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Store and avoid duplicate elements of same row
                if (map.containsKey(Mat[i][j]) && map.get(Mat[i][j]) == i) {
                    map.put(Mat[i][j], map.get(Mat[i][j]) + 1);
                }

                if (i == r - 1 && map.containsKey(Mat[i][j]) && map.get(Mat[i][j]) == r) {
                    System.out.print(Mat[i][j] + " ");
                }
            }
        }

    }

    //https://leetcode.com/problems/number-of-islands/

    /**
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, 0);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int count) {

        if (i == -1 ||
                j == -1 ||
                i == grid.length ||
                j == grid[0].length)
            return;

        if (grid[i][j] == '*') return;

        if (grid[i][j] == '0') return;


        grid[i][j] = '*';

        //right
        dfs(grid, i, j + 1, count);

        //down
        dfs(grid, i + 1, j, count);

        //left
        dfs(grid, i, j - 1, count);

        //top
        dfs(grid, i - 1, j, count);

    }

    //https://leetcode.com/problems/surrounded-regions/

    /**
     * @param grid
     * @param i
     * @param j
     */
    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == 'O') {
            grid[i][j] = '1';

            if (i + 1 < grid.length) dfs(grid, i + 1, j);
            if (i > 0) dfs(grid, i - 1, j);
            if (j + 1 < grid[i].length) dfs(grid, i, j + 1);
            if (j > 0) dfs(grid, i, j - 1);
        }
    }

    public void solve(char[][] grid) {
        if (grid.length == 0) {
            return;
        }
        int row = grid.length, col = grid[0].length;

        // first row and last row
        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col - 1);
        }
        // first col and last col
        for (int j = 1; j < col - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, row - 1, j);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == '1') {
                    grid[i][j] = 'O';
                }
            }
        }
    }


    //https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
    public static void commonElements1(int Mat[][], int r, int c) {
        // Map
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < c; i++) {
            map.put(Mat[0][i], 1);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Store and avoid duplicate elements of same row
                if (map.containsKey(Mat[i][j]) && map.get(Mat[i][j]) == i) {
                    map.put(Mat[i][j], map.get(Mat[i][j]) + 1);
                }

                if (i == r - 1 && map.containsKey(Mat[i][j]) && map.get(Mat[i][j]) == r) {
                    System.out.print(Mat[i][j] + " ");
                }
            }
        }

    }


    // function to check if there is any duplicate elements in the firstRow
    public static boolean seen(int arr[], int element, int end) {
        for (int i = 0; i < end; i++) {
            if (element == arr[i]) return true;
        }
        return false;
    }

    public static void commonElements2(int Mat[][], int r, int c) {
        // pick one by one element of the first row and check if they are present in all rows.
        for (int firstRow = 0; firstRow < c; firstRow++) {
            // pick element
            int element = Mat[0][firstRow];
            // if duplicate then skip the element
            if (seen(Mat[0], element, firstRow)) continue;
            // variable for tracking rows.
            int count = 0;
            // if element is not present in anyone of the row then skip the element.
            int flag = 0;
            // traverse from 1st to last row
            for (int row = 1; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    // if element is found then increment the counter
                    if (element == Mat[row][col]) {
                        count++;
                        // if present in last row and count is equal to row-1, then print it
                        if (row == r - 1 && count == r - 1)
                            System.out.println(element);
                            // if count is same as row then break to avoid adding duplicates
                        else if (row != r - 1 && count == row)
                            break;
                            // if element not present in the current row then set flag to 1,
                        else {
                            flag = 1;
                            break;
                        }
                    }
                }
                // break the outer loop and check for next element.
                if (flag == 1) break;
            }
        }
    }

    //https://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
    public void printXOPattern(int n) {

    }
}

