import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = length - 1;
            int target = -nums[i];

            for (int j = i + 1; j < length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                while (j < k && nums[j] + nums[k] > target) {
                    --k;
                }

                if (j == k) {
                    break;
                }

                if (nums[j] + nums[k] == target) {
                    List<Integer> list = List.of(nums[i], nums[j], nums[k]);
                    resList.add(list);
                }
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
