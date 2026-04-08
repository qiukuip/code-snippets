public class Solution53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(nums));
    }
}
