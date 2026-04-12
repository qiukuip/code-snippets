import java.util.Arrays;

/**
 * @author longkun
 * @date 2026-04-12
 * @description LeetCode 66: 加一
 * <p>
 * 非负整数用数组表示（高位在前），对整个数加 1。
 * 思路：从末位开始处理进位；若全部为 9，则新建长度 +1 的数组，首位为 1。
 * </p>
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {9, 5, 9};
//        System.out.println(Arrays.toString(new Solution66().plusOne(a)));
        System.out.println(Arrays.toString(new Solution66().plusOne(b)));
    }
}
