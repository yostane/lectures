package main

import (
	"io"
	"os"
	"strings"
)

type rot13Reader struct {
	r io.Reader
}

func (r rot13Reader) Read(b []byte) (int, error) {
	n, err := r.r.Read(b)
	if err != nil {
		return 0, err
	}
	for i := range n {
		if b[i] < 'A' || b[i] > 'z' || (b[i] > 'Z' && b[i] < 'a') {
			continue
		}
		middleLetter := 'M'
		if b[i] >= 'a' {
			middleLetter = 'm'
		}
		if b[i] > byte(middleLetter) {
			b[i] -= 13
		} else {
			b[i] += 13
		}
	}
	return n, nil
}

func main() {
	s := strings.NewReader("Lbh penpxrq gur pbqr!")
	r := rot13Reader{s}
	io.Copy(os.Stdout, &r)
}
