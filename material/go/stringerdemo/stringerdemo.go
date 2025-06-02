package main

import (
	"fmt"
	"strconv"
	"strings"
)

type IPAddr [4]byte

func (ipAddr IPAddr) String() string {
	// Slice of length 0 and capacity 4 (size of array)
	s := make([]string, 0, len(ipAddr))
	for _, v := range ipAddr {
		s = append(s, strconv.Itoa(int(v)))
	}
	return strings.Join(s, ".")
}

func main() {
	hosts := map[string]IPAddr{
		"loopback":  {127, 0, 0, 1},
		"googleDNS": {8, 8, 8, 8},
	}
	for name, ip := range hosts {
		fmt.Printf("%v: %v\n", name, ip)
	}
}
