package Collection.string;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Strings {
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
