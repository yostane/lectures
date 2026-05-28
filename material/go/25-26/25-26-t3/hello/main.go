package main // package qui contient la fonction main

import (
	"fmt"
)

// *int -> passage par référence
// int -> passage par valeur (une copie)
func add(a *int, b int) int {
	// a étant une adresse dans la mémoire, *a permet de localiser (pointer) la valeur à cette adresse
	*a = 5
	b = -10
	return *a + b
}

type Item struct {
	itemId   uint64
	qunatity uint
}

func resetQuatity(item *Item) {
	item.qunatity = 0
}

func main() {
	var x, y int = 3, 4
	// var f float64 = math.Sqrt(float64(x*x + y*y))
	// var z uint = uint(f)
	// // u := x + f // erreur car go ne convertit pas implicitement les types car il est fortement typé
	// u := float64(x) + f
	// v := x + int(f)
	// fmt.Println(x, y, z, u, v)

	// &x signfie l'adresse de x en mémoire
	fmt.Println(add(&x, y))
	fmt.Println(x, y)

	item := Item{1, 10}
	resetQuatity(&item)
	fmt.Println(item.qunatity)
}
