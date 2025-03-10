package main

import "fmt"

// fibonacci is a function that returns
// a function that returns an int.
func fibonacci() func() int {
	nm1 := 0
	nm2 := 0

	return func() int {
		n := nm1 + nm2
		nm2 = nm1
		nm1 = n
		if n == 0 {
			nm2 = 1
		}
		return n
	}
}

func main() {
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}
