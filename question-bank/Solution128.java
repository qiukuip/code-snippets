import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author longkun
 * @date 2026-04-08 21:10
 * @description LeetCode 128: 最长连续序列
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        nums = Arrays.stream(nums).distinct().sorted().toArray();

        int maxLen = 0;
        int currLen = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (curr == prev) {
                continue;
            } else if (curr - prev == 1) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        Solution128 solution = new Solution128();
        System.out.println(solution.longestConsecutive(nums));
    }
}
