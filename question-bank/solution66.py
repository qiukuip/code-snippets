# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def plusOne(self, digits: list[int]) -> list[int]:
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0
        return [1] + digits


if __name__ == "__main__":
    solution = Solution()
    print(solution.plusOne([1, 2, 3]))
    print(solution.plusOne([9, 9, 9]))
