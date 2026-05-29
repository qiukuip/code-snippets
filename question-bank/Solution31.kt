/**
 * @time        2026-05-29 11:43
 * @author      qiukui-note
 * @description LeetCode Q.31 求整数序列的下一个排列
 */

class Solution31 {
    fun nextPermutation(nums: IntArray) {
        val n = nums.size
        for (i in n - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                val minBiggerIndex = findMinBigger(nums, nums[i], i + 1)
                swap(nums, i, minBiggerIndex)
                resort(nums, i + 1)
                return
            }
        }

        resort(nums, 0)
    }

    fun resort(nums: IntArray, index: Int) {
        val n = nums.size - index
        for (i in 0..<n) {
            val k = n - 1 - i
            for (j in 0..<n - 1 - i) {
                if (nums[j + index] > nums[j + index + 1]) {
                    swap(nums, j + index, j + index + 1)
                }
            }
        }
    }

    fun swap(nums: IntArray, index1: Int, index2: Int) {
        val temp = nums[index2]
        nums[index2] = nums[index1]
        nums[index1] = temp
    }

    fun findMinBigger(nums: IntArray, target: Int, endIndexFromTail: Int): Int {
        var nextValueIndex = -1
        var nextValue = Int.MAX_VALUE
        for (i in (nums.size - 1) downTo endIndexFromTail) {
            if (nums[i] in (target + 1)..<nextValue) {
                nextValue = nums[i]
                nextValueIndex = i
            }
        }
        return nextValueIndex
    }
}

fun main() {
    val arrs = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(1, 3, 2),
        intArrayOf(2, 1, 3),
        intArrayOf(2, 3, 1),
        intArrayOf(3, 1, 2),
        intArrayOf(3, 2, 1),
        intArrayOf(1),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(5, 4, 7, 5, 3, 2),
        intArrayOf(1, 5, 1),
        intArrayOf(5, 1, 1)
    )
    val solution = Solution31()
    for (nums in arrs) {
        println("=====")
        println(nums.contentToString())
        solution.nextPermutation(nums)
        println(nums.contentToString())
    }
}