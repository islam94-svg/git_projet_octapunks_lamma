package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePage extends JFrame {
    private JPanel codePanel;
    private JTextArea codeTextArea;
    private JTextArea memory1TextArea;
    private JTextArea memory2TextArea;
    private JPanel gamePanel;
    private JButton stepButton;
    private JButton stopButton;

    public GamePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Page");
        setSize(800, 600);

        // Zone de code
        codePanel = new JPanel(new BorderLayout());

        codeTextArea = new JTextArea();
        codeTextArea.setEditable(true);
        JScrollPane codeScrollPane = new JScrollPane(codeTextArea);

        codePanel.add(codeScrollPane, BorderLayout.CENTER);
        add(codePanel, BorderLayout.WEST);

        // Zones de mémoire
        JPanel memoryPanel = new JPanel(new GridLayout(2, 1));

        memory1TextArea = new JTextArea();
        memory1TextArea.setEditable(false);
        JScrollPane memory1ScrollPane = new JScrollPane(memory1TextArea);

        memory2TextArea = new JTextArea();
        memory2TextArea.setEditable(false);
        JScrollPane memory2ScrollPane = new JScrollPane(memory2TextArea);

        memoryPanel.add(memory1ScrollPane);
        memoryPanel.add(memory2ScrollPane);
        add(memoryPanel, BorderLayout.EAST);

        // Zone de jeu
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        // Boutons
        JPanel buttonPanel = new JPanel();

        stepButton = new JButton("Pas");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez ici la logique supplémentaire à exécuter lors de l'appui sur le bouton Pas
            }
        });
        buttonPanel.add(stepButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Réinitialise le robot et réactive la zone de code
                // Code à ajouter
            }
        });
        buttonPanel.add(stopButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GamePage gamePage = new GamePage();
            gamePage.setVisible(true);
        });
    }
}