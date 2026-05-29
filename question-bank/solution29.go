package main

import (
	"fmt"
	"math"
)

func divide1(dividend int, divisor int) int {
	if divisor == 0 {
		panic("Bad parameter")
	}
	sign := 1
	if dividend >= 0 && divisor < 0 || dividend <= 0 && divisor > 0 {
		sign = -1
	}

	d1 := math.Abs(float64(dividend))
	d2 := math.Abs(float64(divisor))

	times := 0
	for d1 >= d2 {
		times++
		d1 -= d2
	}

	result := sign * times
	if result > math.MaxInt32 {
		fmt.Println("====")
		return math.MaxInt32
	} else if result < math.MinInt32 {
		return math.MinInt32
	} else {
		return result
	}
}

func divide2(dividend int, divisor int) int {
	if divisor == 0 {
		panic("Bad parameter")
	}

	sign := 1
	if dividend >= 0 && divisor < 0 || dividend <= 0 && divisor > 0 {
		sign = -1
	}

	d1 := int(math.Abs(float64(dividend)))
	d2 := int(math.Abs(float64(divisor)))

	sum := 0
	times := 1
	result := 0
	for (sum + times*d2) <= d1 {
		sum += times * d2
		result += times
		times++
	}

	if sum < d1 {
		for sum+d2 <= d1 {
			sum += d2
			result++
		}
	}

	result = sign * result
	if result > math.MaxInt32 {
		return math.MaxInt32
	} else if result < math.MinInt32 {
		return math.MinInt32
	} else {
		return result
	}
}

func divide3(dividend int, divisor int) int {
	if divisor == 0 {
		panic("Bad parameter")
	}

	sign := 1
	if dividend >= 0 && divisor < 0 || dividend <= 0 && divisor > 0 {
		sign = -1
	}

	d1 := int(math.Abs(float64(dividend)))
	d2 := int(math.Abs(float64(divisor)))

	result := 0
	for d2 <= d1 {
		tempSum := d2
		multiple := 1
		for 2 * tempSum <= d1 {
			tempSum *= 2
			multiple *= 2
		}
		d1 -= tempSum
		result += multiple
	}

	result *= sign
	if result > math.MaxInt32 {
		return math.MaxInt32
	} else if result < math.MinInt32 {
		return math.MinInt32
	} else {
		return result
	}
}

func main() {
	dividend := 10
	divisor := 3
	result := divide3(dividend, divisor)
	fmt.Printf("result: %d\n", result)
}
