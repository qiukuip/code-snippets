package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func print(head *ListNode) {
	t := head
	for t != nil {
		fmt.Printf("found val: %d\n", t.Val)
		t = t.Next
	}
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	p2 := head
	p1 := head.Next
	for p1 != nil {
		if p1.Val == p2.Val {
			p2.Next = p1.Next
			p1.Next = nil
			p1 = p2.Next
		} else {
			p2 = p2.Next
			p1 = p1.Next
		}
	}
	return head
}

// func main() {
// 	n5 := ListNode{Val: 5}
// 	n4 := ListNode{5, &n5}
// 	n3 := ListNode{2, &n4}
// 	n2 := ListNode{1, &n3}
// 	n1 := ListNode{1, &n2}
//
// 	deleteDuplicates(&n1)
//
// 	print(&n1)
// }
