package Collection.string;

import java.util.*;

public class Strings {


    boolean isPalindrome(String s) {

        return false;
    }

    //https://leetcode.com/problems/valid-anagram/

    /**
     * Algorithm: Check if two strings are anagrams or not
     * <p>
     * Input: Two strings s and t
     * <p>
     * Output: True if the strings are anagrams, False otherwise
     * <p>
     * Check if either s or t is null, return false if either one is null
     * Check if length of s is not equal to length of t, return false if not equal
     * Create a HashMap called map
     * For each character c in string s do the following:
     * a. If map does not contain c, add c to map with value 1
     * b. Else, increment the value of c in map by 1
     * For each character c in string t do the following:
     * a. If map contains c, decrement the value of c in map by 1
     * For each key c in map do the following:
     * a. If the value of c in map is greater than 0, return false
     * Return true
     * Comments:
     * This algorithm is used to check if two strings are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. This algorithm uses a HashMap to store the frequency of each character in string s. Then, it checks the frequency of each character in string t by decrementing the value in the map. Finally, it checks if all values in the map are equal to zero, which indicates that both strings contain the same characters with the same frequency.
     * <p>
     * This algorithm has a time complexity of O(n), where n is the length of the strings s and t. This is because the algorithm loops through each character in the strings only once. The space complexity is O(k), where k is the number of distinct characters in the strings s and t. This is because the algorithm uses a HashMap to store the frequency of each character, which can be at most the number of distinct characters in the strings. Overall, this algorithm is efficient and can be used for checking anagrams of relatively short strings.
     *
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
     * The given code is an implementation of the sliding window algorithm to find the length of the longest substring without repeating characters in a given string.
     * <p>
     * Algorithm:
     * <p>
     * Initialize a HashSet to store the unique characters in the substring.
     * Initialize variables l, r, and max to 0, which will represent the left, right boundaries of the sliding window, and the maximum length of the substring without repeating characters found so far.
     * Loop until the right boundary r reaches the end of the string.
     * If the HashSet contains the character at the right boundary r, remove the character at the left boundary l from the HashSet and increment l until the HashSet no longer contains the character at the right boundary r.
     * Add the character at the right boundary r to the HashSet.
     * Calculate the length of the current substring without repeating characters as r - l + 1 and update the max variable if the length is greater than the current max.
     * Increment the right boundary r.
     * Return the maximum length of the substring without repeating characters found.
     * Comments:
     * <p>
     * The algorithm uses a sliding window approach where the size of the window is increased or decreased based on whether the current substring contains repeating characters or not.
     * The HashSet is used to keep track of the unique characters in the substring.
     * The max variable is used to keep track of the maximum length of the substring without repeating characters found so far.
     * The time complexity of this algorithm is O(n), where n is the length of the input string, as each character in the string is visited at most twice.
     * The space complexity of this algorithm is O(min(n, m)), where m is the size of the character set. Since the size of the character set is fixed, the space complexity is constant for most practical purposes.
     *
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
     * The given code is an implementation of the "Longest Repeating Character Replacement" problem. The problem statement is to find the length of the longest substring that contains only one repeating character and can be modified by replacing up to k characters.
     * <p>
     * The algorithm implemented here uses a sliding window approach to find the longest substring. It maintains a window of characters with the maximum repeating character count and moves the window forward until it becomes invalid (i.e., the number of characters that need to be replaced to make the substring valid exceeds k).
     * <p>
     * Here is the intuition and the algorithm implemented by the given code:
     * <p>
     * Initialize a window with two pointers, i and j, pointing to the start of the string.
     * Initialize a map that stores the count of each character in the window.
     * While the j pointer is less than the length of the string, repeat the following steps:
     * Add the character at the jth position to the map and increment its count.
     * Check if the window is invalid by calling the windowisValid function. The function calculates the number of characters that need to be replaced to make the window valid. If the number is less than or equal to k, then the window is valid. Otherwise, the function returns false, and we need to move the i pointer forward to make the window valid.
     * If the window is valid, update the answer with the length of the window, i.e., j - i + 1.
     * Increment the j pointer to move the window forward.
     * If the window is invalid, move the i pointer forward and update the map by decrementing the count of the character at the ith position.
     * Return the answer.
     * The code implements the above algorithm with two functions: windowisValid and characterReplacement. The windowisValid function checks if the window is valid or not, and the characterReplacement function implements the sliding window approach to find the longest substring.
     * <p>
     * The time complexity of the algorithm is O(n), where n is the length of the input string, as we only iterate through the string once. The space complexity of the algorithm is O(1) since the maximum size of the map is 26 (for 26 alphabets), which is constant.
     *
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

    /**
     * Create a megaMap, which is a map of maps. The key of the outer map is a map that contains the count of each character in the string. The value of the outer map is a list of strings that have the same character count.
     * For each string in the input array:
     * a. Compute the character count map by iterating over the characters in the string and updating the count in the map.
     * b. If the character count map is not present in the megaMap:
     * i. Create a new list with the current string.
     * ii. Add the character count map and the list to the megaMap.
     * c. If the character count map is already present in the megaMap:
     * i. Retrieve the list corresponding to the map.
     * ii. Add the current string to the list.
     * Create a list of lists by iterating over the values of the megaMap.
     * Add each list to the result list.
     * Return the result list.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        //create megaMap
        Map<Map<Character, Integer>, List<String>> megaMap = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {

            //make hash
            Map<Character, Integer> map = new HashMap<>();
            String temp = strs[i];

            for (int j = 0; j < temp.length(); j++) {
                map.put(temp.charAt(j), map.getOrDefault(temp.charAt(j), 0) + 1);
            }

            //if hash present in megamap == false
            if (!megaMap.containsKey(map)) {
                //add hash and add curr word to list of mega map
                List<String> list = new ArrayList<>();
                list.add(temp);
                megaMap.put(map, list);
            }
            //else
            else {
                //add word to list of megaMap
                List tempList = megaMap.get(map);
                tempList.add(temp);
                megaMap.put(map, tempList);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> ele : megaMap.values()) {
            ans.add(ele);
        }
        return ans;
    }

    //https://leetcode.com/problems/palindromic-substrings/description/

    /**
     * Initialize three variables l, h, and ans to 0.
     * Iterate through each character in the string s.
     * For each character, find all palindromic substrings that have that character as their center.
     * There are two cases to consider:
     * Case 1: Palindromic substring has odd length.
     * Set l and h to the current index i.
     * Expand the substring by incrementing h and decrementing l as long as the characters at l and h are equal and l and h are still within the bounds of the string.
     * Increment ans by 1 for each palindromic substring found.
     * Case 2: Palindromic substring has even length.
     * Set l to the current index i and h to i + 1.
     * Expand the substring by incrementing h and decrementing l as long as the characters at l and h are equal and l and h are still within the bounds of the string.
     * Increment ans by 1 for each palindromic substring found.
     * Return the total number of palindromic substrings found in the string s
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        int l = 0;
        int h = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            l = h = i;
            while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                ans += 1;
                l -= 1;
                h += 1;
            }
            l = i;
            h = i + 1;
            while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                ans += 1;
                l -= 1;
                h += 1;
            }
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
