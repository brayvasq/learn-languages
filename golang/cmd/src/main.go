// Package main is the entry point of the app
package main

import (
	"os"

	"github.com/brayvasq/learn-languages/golang/cmd/src/cli"
)

// Main method. It will executes the app
func main() {
	commands := cli.NewCommands(os.Args)

	// Running the Commands processing
	commands.Process()
}
