# !/usr/bin/python3
# -*- coding: utf-8 -*-


from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        nodeIndex1 = l1
        nodeIndex2 = l2
        l3 = None
        nodeIndex3 = None
        tempVal = 0
        while nodeIndex1 != None or nodeIndex2 != None or tempVal != 0:
            tempNode = ListNode(0, None)
            val1 = nodeIndex1.val if nodeIndex1 else 0
            val2 = nodeIndex2.val if nodeIndex2 else 0
            val3 = val1 + val2 + tempVal
            if (val3 >= 10):
                tempVal = 1
                val3 = val3 - 10
            else:
                tempVal = 0
            
            tempNode.val = val3

            if l3 is None:
                l3 = tempNode
                nodeIndex3 = l3
            else:
                nodeIndex3.next = tempNode
                nodeIndex3 = nodeIndex3.next

            nodeIndex1 = nodeIndex1.next if nodeIndex1 else None
            nodeIndex2 = nodeIndex2.next if nodeIndex2 else None
        
        return l3


if __name__ == "__main__":
    solution = Solution()
    # node13 = ListNode(3, None)
    # node12 = ListNode(4, node13)
    # node11 = ListNode(2, node12)
    # node23 = ListNode(4, None)
    # node22 = ListNode(6, node23)
    # node21 = ListNode(5, node22)

    # node11 = ListNode(0, None)
    # node21 = ListNode(0, None)

    node17 = ListNode(9, None)
    node16 = ListNode(9, node17)
    node15 = ListNode(9, node16)
    node14 = ListNode(9, node15)
    node13 = ListNode(9, node14)
    node12 = ListNode(9, node13)
    node11 = ListNode(9, node12)
    node24 = ListNode(9, None)
    node23 = ListNode(9, node24)
    node22 = ListNode(9, node23)
    node21 = ListNode(9, node22)

    l3 = solution.addTwoNumbers(node11, node21)

    while l3 is not None:
        print(f"node: {l3.val}")
        l3 = l3.next

