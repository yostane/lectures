package main

import (
	"fmt"
	"math"
)

type ErrNegativeSqrt float64

func (e ErrNegativeSqrt) Error() string {
	return fmt.Sprintf("cannot Sqrt negative number: %f", float64(e))
}

func Sqrt(x float64) (float64, error) {
	if x < 0 {
		return 0, ErrNegativeSqrt(x)
	}
	z := 1.0
	previousZ := 0.0
	epsilon := 0.000001
	for i := 0; i < 10 && math.Abs(previousZ-z) > epsilon; i++ {
		previousZ = z
		z -= (z*z - x) / (2 * z)
		fmt.Println(z)
	}
	return z, nil
}

func main() {
	sqrt2, err := Sqrt(2)
	if err != nil {
		fmt.Println(sqrt2, math.Sqrt(2))
	}
	sqrt9, err := Sqrt(9)
	if err != nil {
		fmt.Println(sqrt9, math.Sqrt(9))
	}
	fmt.Println(Sqrt(-2))
}
