package main

import "golang.org/x/tour/pic"

func Pic(dx, dy int) [][]uint8 {
	columns := make([][]uint8, dx)
	for x := 0; x < dx; x++ {
		row := make([]uint8, dy)
		for y := 0; y < dy; y++ {
			row[y] = uint8((x + y) / 2)
			// row[y] = uint8(x ^ y)
		}
		columns[x] = row
	}
	return columns
}

func main() {
	pic.Show(Pic)
}
