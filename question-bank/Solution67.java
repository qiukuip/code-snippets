/**
 * @author longkun
 * @date 2026-04-10 22:10
 * @description LeetCode 67: 二进制求和
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 思路：从字符串的末尾开始，逐位相加，如果相加结果大于等于2，则进位1。最后，如果还有进位，则在结果的最前面添加一个1。
 * </p>
 */
public class Solution67 {
    public String addBinary1(String a, String b) {
        String str1 = a;
        String str2 = b;
        if (a.length() != b.length()) {
            str1 = a.length() > b.length() ? a : b;
            int length = Math.max(a.length(), b.length());
            StringBuilder shortStr = new StringBuilder(a.length() < b.length() ? a : b);
            while (shortStr.length() < length) {
                shortStr.insert(0, "0");
            }
            str2 = shortStr.toString();
        }

        return getStringBuilder(str1, str2);
    }

    private static String getStringBuilder(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int temp = 0;
        int p = charArray1.length - 1;
        StringBuilder result = new StringBuilder();
        while (p >= 0) {
            int curr = charArray1[p] - '0' + charArray2[p] - '0' + temp;
            if (curr == 3) {
                curr = 1;
                temp = 1;
            } else if (curr == 2) {
                curr = 0;
                temp = 1;
            } else {
                temp = 0;
            }
            result.insert(0, curr);
            p--;
        }
        if (temp == 1) {
            result.insert(0, temp);
        }
        return result.toString();
    }

    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        int temp = 0;
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int num1 = a.length() == n ? a.charAt(i) - '0' : i - (n - a.length()) >= 0 ? a.charAt(i - (n - a.length())) - '0' : 0;
            int num2 = b.length() == n ? b.charAt(i) - '0' : i - (n - b.length()) >= 0 ? b.charAt(i - (n - b.length())) - '0' : 0;
            int curr = num1 + num2 + temp;
            if (curr == 3) {
                curr = 1;
                temp = 1;
            } else if (curr == 2) {
                curr = 0;
                temp = 1;
            } else {
                temp = 0;
            }
            result.insert(0, curr);
        }
        if (temp == 1) {
            result.insert(0, temp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
//        String a = "1111";
//        String b = "1111";
//        4, 3, 2, 1, 0;
//        1, 0
//        |len| = 3

//        String a = "11";
//        String b = "1";
        System.out.println(new Solution67().addBinary(a, b));
    }
}
