import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> resultList = new ArrayList<>();

        int length = candidates.length;
        int left = 0;
        int right = length - 1;

        while (left < right) {
            if (candidates[left] == target) {
                resultList.add(List.of(candidates[left]));
            } else if (candidates[right] == target) {
                resultList.add(List.of(candidates[right]));
            }

            int tempSum = candidates[left] + candidates[right];
            if (tempSum > target) {
                right--;
            } else if (tempSum < target) {
                int t1 = target - candidates[left];
                if (t1 % candidates[right] == 0) {
                    int times = t1 / candidates[right];
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < times; i++) {
                        list.add(candidates[right]);
                    }
                    list.add(candidates[left]);
                    resultList.add(list);
                }
                int t2 = target - candidates[right];
                if (t2 % candidates[left] == 0) {
                    int times = t2 / candidates[left];
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < times; i++) {
                        list.add(candidates[left]);
                    }
                    list.add(candidates[right]);
                    resultList.add(list);
                }
                left++;
            } else {
                resultList.add(List.of(candidates[left], candidates[right]));
                left++;
                right--;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        // int[] candidates = {2, 3, 6, 7};
        int[] candidates = {2, 3, 5};
        int target =  8;
        Solution39 solution = new Solution39();
        System.out.println(solution.combinationSum(candidates, target));
    }
}
