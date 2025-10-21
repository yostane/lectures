package main

import (
	"fmt"

	"example.com/m/myapp/mysqrt"
)

func main() {
	fmt.Println("SqrtInt(10)", mysqrt.SqrtInt(10))
	fmt.Println("Sqrt(99, 1, 0.000001)", mysqrt.Sqrt(10, 1, 0.000001))
}
