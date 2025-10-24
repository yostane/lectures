package cmd

import (
	"fmt"

	"github.com/spf13/cobra"
	"github.com/spf13/viper"
)

var serveCmd = &cobra.Command{
	Use:   "serve",
	Short: "Starts the server",
	RunE: func(cmd *cobra.Command, args []string) error {
		// We get the configuration value from Viper, not from the flag directly.
		port := viper.GetInt("port")
		fmt.Printf("Starting server on port: %d\\n", port)
		// In a real app, you would start a server here.
		return nil
	},
}

func init() {
	rootCmd.AddCommand(serveCmd)

	// Define a local flag for the 'serve' command.
	serveCmd.Flags().Int("port", 8080, "Port to run the server on")

}
