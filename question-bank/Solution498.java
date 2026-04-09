import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longkun
 * @date 2026-04-09 21:29
 * @description 498. 对角线遍历
 */
public class Solution498 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int rowIndex = 0;
        int colIndex = 0;
        int direction = 1;
        List<Integer> result = new ArrayList<>();
        while (rowIndex < m && colIndex < n) {
            result.add(mat[rowIndex][colIndex]);
            if ((rowIndex == 0 && colIndex < n - 1 && direction == 1) || (rowIndex == m - 1 && direction == -1)) {
                direction = -direction;
                colIndex += 1;
                continue;
            } else if ((colIndex == 0 && rowIndex < m - 1 && direction == -1) || (colIndex == n - 1 && direction == 1)) {
                direction = -direction;
                rowIndex += 1;
                continue;
            }
            colIndex += direction;
            rowIndex -= direction;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
        int[][] arr = {
                {0, 1, 2},
                {3, 4, 5},
                {1, 3, 1}
        };
        int[] diagonalOrder = findDiagonalOrder(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
