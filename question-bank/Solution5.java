import java.util.List;

public class Solution5 {
    public static String longestPalindrome1(String s) {
        char[] charArray = s.toCharArray();
        String maxLenStr = "";
        for (int p1 = 0; p1 < charArray.length; p1++) {
            char c1 = charArray[p1];
            for (int p2 = p1; p2 < charArray.length; p2++) {
                char c2 = charArray[p2];
                if (c2 == c1) {
                    String subStr = new String(charArray, p1, p2 - p1 + 1);
                    if (isPalindromeStr(subStr) && subStr.length() > maxLenStr.length()) {
                        maxLenStr = subStr;
                    }
                }
            }
        }

        return maxLenStr;
    }

    private static boolean isPalindromeStr(String s) {
        if (s.length() == 1) {
            return true;
        }

        int p1 = 0;
        int p2 = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (p2 >= p1) {
            if (charArray[p1] == charArray[p2]) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }

        return true;
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

    public static String maxLengthOfSubString(String s) {
        char[] charArray = s.toCharArray();
        String r = "";
        // 奇数个
        for (int i = 0; i < charArray.length; i++) {
            int p1 = i;
            int p2 = i;
            while (p1 >= 0 && p2 < charArray.length && charArray[p1] == charArray[p2]) {
                p1--;
                p2++;
            }

            String tmp = new String(charArray, p1 + 1, (p2 - 1) - (p1 + 1) + 1);
            if (tmp.length() > r.length()) {
                r = tmp;
            }

            if (p2 == charArray.length - 1) {
                break;
            }
        }

        // 偶数个
        for (int i = 0; i < charArray.length - 1; i++) {
            int p1 = i;
            int p2 = i + 1;
            while (p1 >= 0 && p2 < charArray.length && charArray[p1] == charArray[p2]) {
                p1--;
                p2++;
            }

            String tmp = new String(charArray, p1 + 1, (p2 - 1) - (p1 + 1) + 1);
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
        List<String> list = List.of("dbbd", "aacabdkacaa", "AC", "ABABD", "ABCBA", "AA", "B");
//        List<String> list = List.of("cbbd");
        for (String s : list) {
            System.out.println(maxLengthOfSubString(s));
        }
    }
}
