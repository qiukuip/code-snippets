package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	tempHead := &ListNode{
		Val:  -1,
		Next: head,
	}
	curr := tempHead.Next

	for curr != nil && curr.Next != nil {
		if curr == tempHead.Next {
			p2 := curr.Next
			curr.Next = p2.Next
			p2.Next = curr
			tempHead.Next = p2
		} else {
			p2 := curr.Next
			p3 := p2.Next
			// 处理链表只有两个节点的情况
			if p3 == nil {
				break
			}
			p2.Next = p3.Next
			p3.Next = p2
			curr.Next = p3
			curr = p2
		}
	}

	return tempHead.Next
}

func printList(head *ListNode) {
	p := head
	for p != nil {
		fmt.Printf("%d  ", p.Val)
		p = p.Next
	}
	fmt.Println()
}

func main2() {
	// values := []int{1, 2, 3, 4}
	// values := []int{1}
	values := []int{1, 2}
	head := ListNode{
		Val:  values[0],
		Next: nil,
	}
	p := &head
	for i, value := range values {
		if i == 0 {
			continue
		}
		listNode := ListNode{
			Val:  value,
			Next: nil,
		}
		p.Next = &listNode
		p = p.Next
	}
	printList(&head)

	newHead := swapPairs(&head)
	printList(newHead)
}
