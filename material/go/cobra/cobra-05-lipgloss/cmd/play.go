package cmd

import (
	"fmt"
	"os"

	"github.com/spf13/cobra"

	tea "github.com/charmbracelet/bubbletea"
)

// evenoddCmd represents the evenodd command
var evenoddCmd = &cobra.Command{
	Use:   "play",
	Short: "Guess even or odd",
	Long:  `Try to guess if the dice roll is even or odd`,
	Run: func(cmd *cobra.Command, args []string) {
		p := tea.NewProgram(InitialModel())
		if _, err := p.Run(); err != nil {
			fmt.Printf("Alas, there's been an error: %v", err)
			os.Exit(1)
		}
	},
}

func init() {
	rootCmd.AddCommand(evenoddCmd)
}
