package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private BufferedImage image;
    private int imageX = 0;
    private int imageY = 0;
    private int mouseX = 0;
    private int mouseY = 0;
    private boolean codeLocked = false;

    public GamePanel() {
        setPreferredSize(new Dimension(640, 800));

        try {
            image = ImageIO.read(new File("C:\\Users\\manso\\git_projet_octapunks_lamma\\main\\src\\png-transparent-humanoid-robot-telegram-robocup-robot-electronics-sticker-humanoid-robot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!codeLocked) {
                    mouseX = e.getX();
                    mouseY = e.getY();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!codeLocked) {
                    int dx = e.getX() - mouseX;
                    int dy = e.getY() - mouseY;
                    imageX += dx;
                    imageY += dy;
                    mouseX = e.getX();
                    mouseY = e.getY();
                    repaint();
                }
            }
        });
    }

    public void lockCode() {
        codeLocked = true;
    }

    public void unlockCode() {
        codeLocked = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = image.getWidth() / 16; // Divise la largeur de l'image par 4 (ajustez le facteur de réduction selon vos besoins)
        int imageHeight = image.getHeight() / 16; // Divise la hauteur de l'image par 4 (ajustez le facteur de réduction selon vos besoins)
        g.drawImage(image, imageX, imageY, imageWidth, imageHeight, null);
    }
}