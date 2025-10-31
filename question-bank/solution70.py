# !/us/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def climbStairs1(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            return self.climbStairs1(n - 1) + self.climbStairs1(n - 2)
        
    def climbStairs(self, n: int) -> int:
        first = 0
        second = 1
        for i in range(n):
            result = first + second
            first = second
            second = result
        return result


if __name__ == "__main__":
    solution = Solution()
    n = 44
    result = solution.climbStairs(n)
    print(f"result is {str(result)}")
