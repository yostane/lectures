package main

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {
	z := 1.0
	previousZ := 0.0
	epsilon := 0.000001
	for i := 0; i < 10 && math.Abs(previousZ-z) > epsilon; i++ {
		previousZ = z
		z -= (z*z - x) / (2 * z)
		fmt.Println(z)
	}
	return z
}

func main() {
	fmt.Println(Sqrt(2), math.Sqrt(2))
	fmt.Println(Sqrt(9), math.Sqrt(9))
}
