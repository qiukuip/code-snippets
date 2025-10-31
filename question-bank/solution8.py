# !/usr/bin/python3
# -*- coding: utf-8 -*-


class Solution:
    def myAtoi(self, s: str) -> int:
        blankCharFlag = True
        signFlag = False
        prefixZeroFlag = True
        numFlag = False
        sign = ""
        str = ""
        for i in range(len(s)):
            if blankCharFlag:
                if s[i] == " ":
                    continue
                else:
                    blankCharFlag = False
                    signFlag = True
            if signFlag:
                signFlag = False
                numFlag = True
                if s[i] == "-":
                    sign = "-"
                    continue
                elif s[i] == "+":
                    sign = ""
                    continue
                else:
                    sign = ""
            if numFlag:
                if prefixZeroFlag and ord(s[i]) == 48:
                    continue
                if ord(s[i]) < 48 or ord(s[i]) > 90:
                    break
                else:
                    str += s[i]
                    prefixZeroFlag = False
            
        if (len(str)) == 0:
            str = "0"
        else:
            str = sign + str
        
        num = int(str)
        if num > 2**31 - 1:
            return 2**31 - 1
        elif num < -2**31:
            return -2**31
        else:
            return num
        

if __name__ == "__main__":
    solution = Solution()
    s = "21474836460"
    result = solution.myAtoi(s)
    print(f"result is {result}")
