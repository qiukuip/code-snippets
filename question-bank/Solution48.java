import java.util.Arrays;

/**
 * @author longkun
 * @date 2026-04-09 21:31
 * @description 48. 旋转图像，原地旋转二维数组
 * 将给定的 n x n 矩阵顺时针旋转 90 度。
 * 空间复杂度：O(1) - 原地旋转，不需要额外空间。
 * 时间复杂度：O(n^2) - 每个元素都会被访问并移动一次。
 */
public class Solution48 {
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int round = 0; round < size / 2; round++) {
            int currSize = size - round * 2;
            int currRowIndex = round;
            int endIndex = round + currSize - 1;
            for (int index = currRowIndex, i = 0; index < endIndex; index++, i++) {
                int temp1 = matrix[index][endIndex];
                matrix[index][endIndex] = matrix[currRowIndex][index];

                int temp2 = matrix[endIndex][endIndex - i];
                matrix[endIndex][endIndex - i] = temp1;

                int temp3 = matrix[endIndex - i][currRowIndex];
                matrix[endIndex - i][currRowIndex] = temp2;

                matrix[currRowIndex][index] = temp3;
            }
        }
    }

    private static void print(int[][] arr) {
        for (int[] sub : arr) {
            System.out.print(Arrays.toString(sub));
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//        };

//        int[][] arr = {
//                {1, 2},
//                {3, 4}
//        };

//        int[][] arr = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//        };

        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        rotate(arr);

        print(arr);
    }
}
