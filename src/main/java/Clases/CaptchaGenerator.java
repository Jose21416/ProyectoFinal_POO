package Clases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGenerator {
    private String captchaText;
    private final int width = 160;
    private final int height = 50;

    public BufferedImage generateCaptchaImage() {
        BufferedImage captchaImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = captchaImage.createGraphics();

        // Fondo
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Texto aleatorio
        captchaText = generateRandomText(6);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(Color.BLACK);
        g2d.drawString(captchaText, 20, 35);

        // Líneas aleatorias
        g2d.setColor(Color.GRAY);
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int x1 = rand.nextInt(width);
            int y1 = rand.nextInt(height);
            int x2 = rand.nextInt(width);
            int y2 = rand.nextInt(height);
            g2d.drawLine(x1, y1, x2, y2);
        }

        g2d.dispose();
        return captchaImage;
    }

    public String getCaptchaText() {
        return captchaText;
    }

    private String generateRandomText(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder text = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            text.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return text.toString();
    }
}