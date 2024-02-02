package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPage extends JFrame {
    private JButton backButton;
    private JCheckBox soundCheckBox;
    private JCheckBox musicCheckBox;
    private JSlider volumeSlider;
    private GameFrame gameFrame;

    public SettingsPage(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Settings Page");
        setSize(400, 300);
        setLayout(null);

        backButton = new JButton("Back");
        backButton.setBounds(150, 200, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackToGameFrame();
            }
        });

        soundCheckBox = new JCheckBox("Sound");
        soundCheckBox.setBounds(50, 50, 100, 30);

        musicCheckBox = new JCheckBox("Music");
        musicCheckBox.setBounds(50, 100, 100, 30);

        JLabel volumeLabel = new JLabel("Volume");
        volumeLabel.setBounds(50, 150, 60, 30);

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        volumeSlider.setBounds(120, 150, 200, 30);

        add(backButton);
        add(soundCheckBox);
        add(musicCheckBox);
        add(volumeLabel);
        add(volumeSlider);
    }

    private void goBackToGameFrame() {
        gameFrame.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        SettingsPage settingsPage = new SettingsPage(gameFrame);
        settingsPage.setVisible(true);
    }
}