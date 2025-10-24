package cmd

import (
	"fmt"
	"math/rand/v2"

	tea "github.com/charmbracelet/bubbletea"
	"github.com/charmbracelet/lipgloss"
)

type model struct {
	choices  []string
	cursor   int
	selected int
	result   int
}

func InitialModel() model {
	return model{
		choices: []string{"Pair", "Impair"},
		// On pose que -1 => pas de sélection
		selected: -1,
		// On pose -1 => le joueur n'a pas encore faire de choix
		result: -1,
	}
}

func (m model) Init() tea.Cmd {
	// Just return `nil`, which means "no I/O right now, please."
	return nil
}

// Mise à jour du modèle suite aux interactions avec l'utilisateur
func (m model) Update(msg tea.Msg) (tea.Model, tea.Cmd) {
	switch msg := msg.(type) {
	case tea.KeyMsg:
		switch msg.String() {
		case "ctrl+c", "q":
			return m, tea.Quit
		case "up", "k":
			m.result = -1
			if m.cursor > 0 {
				m.cursor--
			}
		case "down", "j":
			m.result = -1
			if m.cursor < len(m.choices)-1 {
				m.cursor++
			}
		case " ":
			m.selected = m.cursor
		case "enter":
			if m.selected == -1 {
				break
			}
			isEven := rand.IntN(7)%2 == 0
			if isEven && m.choices[m.selected] == "Pair" {
				m.result = 1
			} else if !isEven && m.choices[m.selected] == "Impair" {
				m.result = 1
			} else {
				m.result = 0
			}
		}
	}
	return m, nil
}

func (m model) View() string {
	titleStyle := lipgloss.NewStyle().
		Bold(true).
		Foreground(lipgloss.Color("#FAFAFA")).
		Background(lipgloss.Color("#7D56F4")).
		Padding(1).
		Width(22)
	cursorStyle := lipgloss.NewStyle().
		Bold(true).
		Foreground(lipgloss.Color("#788f02"))
	s := titleStyle.Render("Pair ou impair ?")
	s += "\n\n"
	for i, choice := range m.choices {
		cursor := " "
		if m.cursor == i {
			cursor = ">"
		}
		cursor = cursorStyle.Render(cursor)
		checked := " "
		if m.selected == i {
			checked = "x"
		}
		s += fmt.Sprintf("%s [%s] %s\n", cursor, checked, choice)
	}
	resultText := ""
	switch m.result {
	case 1:
		resultText = lipgloss.NewStyle().
			Bold(true).
			Foreground(lipgloss.Color("#788f02")).Render("You won!")
	case 0:
		resultText = lipgloss.NewStyle().
			Bold(true).
			Foreground(lipgloss.Color("#d40909")).Render("You Lost!")
	}
	s += fmt.Sprintf("Dice roll -> %s\n", resultText)
	s += "\nPress q to quit.\n"
	return s
}
