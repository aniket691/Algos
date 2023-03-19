package Collection.string;

import java.util.*;

public class Strings {


    boolean isPalindrome(String s) {

        return false;
    }

    //https://leetcode.com/problems/valid-anagram/

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }


        return true;
    }

    //https://leetcode.com/problems/valid-parentheses/

    /**
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;

        Stack<Character> stk = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if (stk.isEmpty() == false && s.charAt(i) == ')' && stk.peek() == '(') {
                stk.pop();
            } else if (!stk.isEmpty() && s.charAt(i) == ']' && stk.peek() == '[') {
                stk.pop();
            } else if (!stk.isEmpty() && s.charAt(i) == '}' && stk.peek() == '{') {
                stk.pop();
            } else {
                stk.push(s.charAt(i));
            }
        }

        return stk.isEmpty();
    }

    //https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

    /**
     * @param str
     * @param count
     */
    static void fillCharCounts(String str,
                               int[] count) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    /* Print duplicates present
      in the passed string */
    static void printDups(String str) {
        // Create an array of size
        // 256 and fill count of
        // every character in it
        int count[] = new int[256];
        fillCharCounts(str, count);

        for (int i = 0; i < 256; i++)
            if (count[i] > 1)
                System.out.println((char) (i) +
                        ", count = " + count[i]);
    }


    /**
     * don't use replace function
     * create a new string ans
     * append if char to it
     * now iterate through the string
     * append curr char to ans if str of i-1 != str of i
     *
     * @param str
     * @return
     */
    public String removeConsecutiveCharacter(String str) {
        if (str == null || str.length() <= 0) return str;
        String ans = "";
        ans += str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                ans += str.charAt(i);
            }
        }
        return ans;
    }


    /**
     * sort the array of strings
     * if i < first.length ans  i < last.length
     * append curr char to ans else break
     * By sorting we can make a group of same words
     * <p>
     * alternative approach : brute force
     * trie
     */
    public String longestCommonPrefix(String[] strs) {

        String ans = "";

        if (strs.length <= 0) return ans;

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < first.length(); i++) {
            if ((i < first.length() && i < last.length()) &&
                    first.charAt(i) == last.charAt(i)) {
                ans += first.charAt(i);
            } else {
                break;
            }
        }
        return ans;
    }

    //https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/
    // Function which computes the sequence

    /**
     * @param str
     * @param input
     * @return
     */
    //    String str[]
    //            = { "2",    "22",  "222", "3",   "33", "333",
    //            "4",    "44",  "444", "5",   "55", "555",
    //            "6",    "66",  "666", "7",   "77", "777",
    //            "7777", "8",   "88",  "888", "9",  "99",
    //            "999",  "9999" };
    static String printSequence(String str[], String input) {
        String output = "";

        // length of input string
        int n = input.length();
        for (int i = 0; i < n; i++) {
            // Checking for space
            if (input.charAt(i) == ' ')
                output = output + "0";

            else {
                // Calculating index for each
                // character
                int position = input.charAt(i) - 'A';
                output = output + str[position];
            }
        }

        // Output sequence
        return output;
    }

    /**
     * insert all characters in set
     * and get all characters in put into the ans string
     * Linked Hash set can maintain order
     *
     * @param str
     * @return
     */
    String removeDuplicates(String str) {
        // code here
        Set<Character> set = new LinkedHashSet<>();

        for (Character ele : str.toCharArray()) {
            set.add(ele);
        }

        String ans = "";
        for (Character ele : set) {
            ans += ele;
        }

        return ans;
    }


    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int max = 0;

        while (r < s.length()) {

            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            max = Math.max(max, (r - l) + 1);
            r++;

        }
        return max;

        //     Set<Character> charSet = new HashSet<>();
        // int left = 0, right = 0, maxLen = 0;

        // while (right < s.length()) {
        //     if (!charSet.contains(s.charAt(right))) {
        //         charSet.add(s.charAt(right));
        //         right++;
        //         maxLen = Math.max(maxLen, right - left);
        //     } else {
        //         charSet.remove(s.charAt(left));
        //         left++;
        //     }
        // }

        // return maxLen;
    }

    //https://leetcode.com/problems/longest-repeating-character-replacement/

    /**
     * @param i
     * @param j
     * @param k
     * @param map
     * @param s
     * @return
     */
    public boolean windowisValid(int i, int j, int k, Map<Character, Integer> map, String s) {
        if ((j - i + 1) - Collections.max(map.values()) <= k) return true;
        return false;
    }

    public int characterReplacement(String s, int k) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {

            //put characters in map
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }

            //when window invalid make it valid
            while (!windowisValid(i, j, k, map, s)) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            //update ans
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    //https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    //TODO: nextPermutation
    static List<Integer> nextPermutation(int N, int arr[]) {
        // code here
        return new ArrayList<>();
    }

    //https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/

    /**
     * https://www.notion.so/Images-DSA-e319f659179d4ef790f8266dc86404c2?pvs=4#a9af40f6877e4611958424b6457d8b05 ==> image
     *
     * @param pat
     * @param txt
     * @param q
     */
    public static void search(char[] pat, char[] txt, int q) {
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int d = 256; // number of characters in the input alphabet
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + txt[i]) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j])
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt[i] * h) + txt[i + M]) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    //https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
    //longest palindromic subsequences
    public void lps(String s) {

        int n = s.length();
        int p = 1;
        int mod = 10000007;
        int pow = 1;

        long ph = 0;
        long sh = 0;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ph = ((ph * p) + (s.charAt(i) - 'a' + 1)) % mod;
            sh = (sh + (s.charAt(n - 1 - i) - 'a' + 1) * pow) % mod;

            pow = (pow * p) % mod;
            if (ph == sh) ans = i + 1;
        }

        System.out.println(ans);
    }




}
