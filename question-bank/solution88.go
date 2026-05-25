package main

import (
	"fmt"
)

func merge(nums1 []int, m int, nums2 []int, n int) {
	if m == 0 {
		for i := range n {
			nums1[i] = nums2[i]
		}
		return
	}
	if n == 0 {
		return
	}

	p1 := m - 1
	p2 := n - 1
	tempIndex := m + n - 1

	for p2 >= 0 {
		if p1 >= 0 && p2 >= 0 && nums1[p1] >= nums2[p2] {
			nums1[tempIndex] = nums1[p1]
			nums1[p1] = 0
			p1--
		} else {
			nums1[tempIndex] = nums2[p2]
			p2--
		}
		tempIndex--
	}
}

func printNums(nums []int) {
	length := len(nums)
	index := 0
	fmt.Printf("elements of nums: \n")
	for index < length {
		fmt.Printf("%d ", nums[index])
		index++
	}
	fmt.Println()
}

func main1() {
	// nums1 := []int{1, 2, 3, 0, 0, 0}
	// m := 3
	// nums2 := []int{2, 5, 6}
	// n := 3

	// nums1 := []int{4, 5, 6, 0, 0, 0}
	// m := 3
	// nums2 := []int{1, 2, 3}
	// n := 3

	// nums1 := []int{1}
	// m := 1
	// nums2 := []int{}
	// n := 0

	// nums1 := []int{0}
	// m := 0
	// nums2 := []int{1}
	// n := 1

	nums1 := []int{2, 0}
	m := 1
	nums2 := []int{1}
	n := 1

	merge(nums1, m, nums2, n)
	printNums(nums1)
}
