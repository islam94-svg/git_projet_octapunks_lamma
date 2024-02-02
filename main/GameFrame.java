package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameFrame extends JFrame {

    private JButton playButton;
    private JButton settingsButton;
    private JButton quitButton;
    private ImageIcon backgroundImage;
    private JLabel backgroundLabel;

    public GameFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Frame");
        setSize(400, 300);
        setLayout(null);

        // Créer une JLabel contenant l'image d'arrière-plan
        backgroundImage = new ImageIcon("C:\\Users\\manso\\git_projet_octapunks_lamma\\main\\src\\png-transparent-humanoid-robot-telegram-robocup-robot-electronics-sticker-humanoid-robot.png");
        backgroundLabel = new JLabel();
        add(backgroundLabel);

        playButton = new JButton("Play");
        playButton.setBounds(150, 50, 100, 30);
        playButton.setBackground(Color.decode("#000080"));
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        // Définir le bouton en tant que composant transparent
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        backgroundLabel.add(playButton);

        settingsButton = new JButton("Paramètres");
        settingsButton.setBounds(150, 120, 100, 30);
        settingsButton.setBackground(Color.decode("#000080"));
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSettingsPage();
            }
        });
        // Définir le bouton en tant que composant transparent
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        backgroundLabel.add(settingsButton);

        quitButton = new JButton("Quitter");
        quitButton.setBounds(150, 190, 100, 30);
        quitButton.setBackground(Color.decode("#000080"));
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Définir le bouton en tant que composant transparent
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);
        backgroundLabel.add(quitButton);

        // Ajouter un ComponentListener pour redimensionner l'image d'arrière-plan et les boutons
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });

        resizeComponents();
    }

    private void resizeComponents() {
        // Redimensionner l'image d'arrière-plan
        Image image = backgroundImage.getImage();
        Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImage);
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        // Redimensionner les boutons en fonction de la taille de la fenêtre
        int buttonWidth = (int) (getWidth() * 0.25);
        int buttonHeight = (int) (getHeight() * 0.1);
        int buttonX = (getWidth() - buttonWidth) / 2;

        playButton.setBounds(buttonX, (int) (getHeight() * 0.2), buttonWidth, buttonHeight);
        settingsButton.setBounds(buttonX, (int) (getHeight() * 0.4), buttonWidth, buttonHeight);
        quitButton.setBounds(buttonX, (int) (getHeight() * 0.6), buttonWidth, buttonHeight);
    }

    private void startGame() {
        Grid grid = new Grid(5, 10);
        GamePage gamePage = new GamePage();
        gamePage.setVisible(true);
        dispose();
    }

    private void openSettingsPage() {
        GameFrame gameFrame = new GameFrame();

        SettingsPage settingsPage = new SettingsPage(gameFrame);
        settingsPage.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }
}