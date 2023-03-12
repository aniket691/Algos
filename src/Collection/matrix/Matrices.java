package Collection.matrix;

import java.util.HashMap;
import java.util.HashSet;

public class Matrices {
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

        return false;
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

}

