package Collection.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void towerOfHanoi(int n, char s, char h, char d) {
        if (n == 0) return;
        // Write your code here
        if (n == 1) {
            System.out.println(s + " " + d);
            return;
        }

        towerOfHanoi(n - 1, s, d, h);
        System.out.println(s + " " + d);
        towerOfHanoi(n - 1, h, s, d);

    }

    public static boolean checkSequence(String a, String b) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (b.length() == 0) return true;

        if (a.length() == 0) return false;

        if (a.charAt(0) == b.charAt(0)) {
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            return checkSequence(a.substring(1), b);
        }

    }

    // Function to print all the permutations of str
    static void allStringUsingChars(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            allStringUsingChars(ros, ans + ch);
        }
    }

//    public static void subsetsSumK(int arr[], int k) {
//        int count = 5;
//
//        helper(arr, k, 0, arr.length, new ArrayList<>());
//    }

//    public static void helper(int[] arr, int k, int i, int n, List<Integer> smallAns) {
//
//        if (n == 0) {
//            if (k == 0) System.out.println(smallAns);
//            return;
//        }
//
//        //not include
//        helper(arr, k, i + 1, n - 1, smallAns);
//
//        smallAns.add(arr[i]);
//
//        //include
//        helper(arr, k - arr[i], i + 1, n - 1, smallAns);
//
//    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        seq(nums, ans, 0, main);
        return main;
    }

    static void seq(int[] nums, ArrayList<Integer> ans, int i, List<List<Integer>> main) {
        if (i == nums.length) {
            main.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        seq(nums, ans, i + 1, main);
        ans.remove(ans.size() - 1);
        seq(nums, ans, i + 1, main);
    }

    //https://leetcode.com/problems/powx-n/

    /**
     * if n id odd n-1
     * if n is even n/2
     * if n == 0 1
     * if n < 0 1/ ans of func
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        if (n % 2 == 1)
            return x * myPow(x, n - 1);

        if (n % 2 == 0)
            return myPow(x * x, n / 2);

        // if its not positive then it will surely be negavtive
        return 1 / myPow(x, -n);
    }

    //https://leetcode.com/problems/valid-palindrome/

    /**
     * remove unwanted character
     * check i and s.length()-i-1
     * return true or false accordingly
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string) {
        string = removeNonAlphanumericChars(string);
        return helper(string);

    }

    /**
     * @param string
     * @return
     */
    public static boolean helper(String string) {

        if (string.equals("") || string.length() == 1) {
            return true;
        }

        if (string.charAt(0) == string.charAt(string.length() - 1))
            return helper(string.substring(1, string.length() - 1));

        return false;
    }

    /**
     * @param string
     * @return
     */
    public static String removeNonAlphanumericChars(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }


    /****/
    //https://leetcode.com/playground/B98MMhfv

    /****/
    //Understand recursion by printing something N times: https://takeuforward.org/recursion/in...
    public static void Ntimes(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("something");
        Ntimes(n - 1);
    }

    /**
     * @param n
     */
    // Print 1 to N using recursion: https://takeuforward.org/recursion/pr...
    public static void OneToN(int n) {
        if (n == 1) {
            return;
        }
        // N to 1
        //System.out.println(n-1);
        OneToN(n - 1);
        // 1 to N
        System.out.println(n - 1);
    }

    // Print N to 1 using recursion: https://takeuforward.org/recursion/pr...
    public static void NToOne(int n) {
        if (n == 1) {
            return;
        }
        // N to 1
        System.out.println(n - 1);
        OneToN(n - 1);
        // 1 to N
        //System.out.println(n-1);
    }

    /**
     * @param n
     * @param ans
     * @return
     */
    // Sum of first N numbers: https://takeuforward.org/data-structu...
    public static int SumOfN(int n, int ans) {
        if (n == 0) {
            return ans;
        }
        // N to 1
        ans += n;
        return SumOfN(n - 1, ans);
        // 1 to N
        //System.out.println(n-1);
    }

    /**
     * @param n
     * @return
     */
    // Factorial of N numbers: https://takeuforward.org/data-structu...
    public static int factOfN(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factOfN(n - 1);
    }

    /**
     * @param arr
     * @param i
     * @param j
     */
    // Reverse an array: https://takeuforward.org/data-structu...
    public static void reverseHelper(int arr[], int i, int j) {
        if (j > i) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseHelper(arr, i + 1, j - 1);
    }

    public static void reverseArr(int[] arr) {
        reverseHelper(arr, 0, arr.length - 1);
        return;
    }

    // Check if a string is palindrome or not: https://takeuforward.org/data-structu...
    public static void isPalHelper(int arr[], int i, int j) {
        return;
    }

    /**
     * @param arr
     */
    public static void isPal(int[] arr) {
        isPalHelper(arr, 0, arr.length - 1);
    }

    // Fibonacci Number: https://takeuforward.org/arrays/print...
    public static int fibo(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        return fibo(n - 2) + fibo(n - 1);
    }

    /**
     * @param arr
     * @param fsf
     * @param i
     * @param x
     * @return
     */
    //count the number of occurances and store index in array
    public static int[] coundIndOfOccu(int arr[], int fsf, int i, int x) {
        if (i == arr.length) {
            //when we are out of bound return new array to store index of x which we have found
            return new int[fsf];
        }
        if (arr[i] == x) {
            int iarr[] = coundIndOfOccu(arr, fsf + 1, i + 1, x);
            //found so far keeps the track of index on which x is found so far
            //we don't need to check if current index contains x because we have checked it aboove
            //here (arr[i] == x)
            iarr[fsf] = i;
            return iarr;
        } else {
            int iarr[] = coundIndOfOccu(arr, fsf, i + 1, x);
            return iarr;
        }
    }

    /**
     * @param str
     * @return
     */
    public static ArrayList<String> getss(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> res = getss(ros);
        ArrayList<String> mlist = new ArrayList<>();
        //no
        for (String ele : res) {
            mlist.add("" + ele);
        }
        //yes
        for (String ele : res)
            mlist.add(ch + ele);
        return mlist;
    }


    static String[] codes = {
            ".,",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tu",
            "vwx",
            "yz"
    };

    /**
     * @param str
     * @return
     */
    public static ArrayList<String> getKpc(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        //123
        //1
        char ch = str.charAt(0);
        //23
        String ros = str.substring(1);
        //ans of 23
        ArrayList<String> rres = getKpc(ros);
        //main ans list
        ArrayList<String> mres = new ArrayList<>();
        //get curr num's string code
        String codeforch = codes[ch - '0'];
        //combining sub result with current code 
        //ex code pqrs
        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for (String rstr : rres) {
                mres.add(chcode + rstr);
            }
        }
        return mres;
    }

    /**
     * @param n
     * @return
     */
    public static ArrayList<String> getStaircasePath(int n) {
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> path1 = getStaircasePath(n - 1);
        ArrayList<String> path2 = getStaircasePath(n - 2);
        ArrayList<String> path3 = getStaircasePath(n - 3);
        ArrayList<String> paths = new ArrayList<>();
        for (String path : path1) {
            paths.add(1 + path);
        }
        for (String path : path2) {
            paths.add(2 + path);
        }
        for (String path : path3) {
            paths.add(3 + path);
        }
        return paths;
    }

    /**
     * @param sr
     * @param sc
     * @param dr
     * @param dc
     * @return
     */
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        if (sc < dc) {
            hpaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            vpaths = getMazePaths(sr + 1, sc, dr, dc);
        }
        ArrayList<String> paths = new ArrayList<>();
        for (String hpath : hpaths) {
            paths.add("h" + hpath);
        }
        for (String vpath : vpaths) {
            paths.add("v" + vpath);
        }
        return paths;
    }

    //TODO: https://www.youtube.com/watch?v=F6T3tD8Pw20&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=32

    //flood fill

    /**
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc], sr, sc);
        return image;
    }

    public void dfs(int[][] grid, int i, int j, int color, int toColor, int sr, int sc) {

        if (i == -1 ||
                j == -1 ||
                i == grid.length ||
                j == grid[0].length)
            return;

        if (grid[i][j] == color) return;
        if (grid[i][j] != toColor) return;

        grid[i][j] = color;

        //right
        dfs(grid, i, j + 1, color, toColor, sr, sc);
        //down
        dfs(grid, i + 1, j, color, toColor, sr, sc);
        //left
        dfs(grid, i, j - 1, color, toColor, sr, sc);
        //top
        dfs(grid, i - 1, j, color, toColor, sr, sc);
    }


    //target sum
    // set is the subset
    // sos is sum of subset
    // tar is target

    /**
     * @param arr
     * @param idx
     * @param set
     * @param sos
     * @param tar
     */
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

        if (sos == tar) {
            System.out.println(set);
            return;
        }

        if (idx == arr.length) return;

        //no
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);

        //yes
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + " ", sos + arr[idx], tar);
        //System.out.println(set);
    }


}
