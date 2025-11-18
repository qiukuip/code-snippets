import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int currLength = 0;
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < charArray.length; j++) {
                char c = charArray[j];
                if (set.contains(c)) {
                    set.clear();
                    currLength = 0;
                    break;
                } else {
                    currLength += 1;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                    }
                    if (j == charArray.length - 1) {
                        currLength = 0;
                    } else {
                        set.add(c);
                    }
                }
            }
        }

        return maxLength;
    }

    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        String r = "";
        for (int i = 0; i < charArray.length; i++) {
            int p1 = i - 1;
            int p2 = i + 1;
            while (p1 >= 0 && p2 < charArray.length && charArray[p1] == charArray[p2]) {
                if (charArray[p1] == charArray[p2]) {
                    p1--;
                    p2++;
                }
            }

            String tmp = new String(charArray, p1 + 1, p2 - (p1 + 1));
            if (tmp.length() > r.length()) {
                r = tmp;
            }

            if (p2 == charArray.length - 1) {
                break;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        List<String> list = List.of("dvdf", "pwwkew", "abcabcbb", "bbbbb");
        for (String s : list) {
            System.out.println(new Solution3().lengthOfLongestSubstring(s));
        }
    }
}

