package mysqrt

import (
	"fmt"
	"math"
)

func SqrtInt(x int) int {
	for i := 1; i*i <= x; i += 1 {
		if i*i == x {
			return i
		}
	}
	return 0
}

func Sqrt(x, start, epsilon float64) float64 {
	z := start
	fmt.Println("computing sqrt of", x, "with start", start, "epsilon", epsilon)
	for math.Abs(z*z-x) > epsilon {
		z -= (z*z - x) / (2 * z)
		fmt.Println(z, z*z, "math.abs(z*z - x)", math.Abs(z*z-x))
	}
	return z
}
