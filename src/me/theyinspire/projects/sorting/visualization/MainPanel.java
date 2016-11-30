package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 9:21 PM)
 */
public class MainPanel extends JPanel {

    static final int SIZE = 200;
    private int[] array;

    MainPanel(VisualizationProducer producer) {
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        clear();
        addMouseListener(new VisualizationControllerMouseAdapter(producer));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g.create();
        int width = (int) ((getSize().getWidth() - 50) / array.length);
        int height = (int) (getSize().getHeight() - 100);
        int max = getMax() + 20;
        graphics.setColor(Color.WHITE);
        Rectangle background = new Rectangle(25, 25, (int) getSize().getWidth() - 50, (int) getSize().getHeight() - 100);
        graphics.fill(background);
        graphics.setColor(Color.BLACK);
        graphics.draw(background);
        if (max == 0) {
            return;
        }
        int offset = (int) ((background.getWidth() - array.length * width) / 2);
        int bottom = (int) getSize().getHeight() - 75;
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            int x = 25 + offset + width * i;
            int y = (int) (bottom - ((double) height / max * number));
            Rectangle rectangle = new Rectangle(x, y - 1, width, bottom - y - 1);
            graphics.setColor(Color.ORANGE);
            graphics.fill(rectangle);
            graphics.setColor(Color.RED);
            graphics.draw(rectangle);
        }
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        String title = System.getProperty("apple.awt.application.name");
        graphics.drawString(title, (int) getSize().getWidth() / 2 - graphics.getFontMetrics().stringWidth(title) / 2, (int) getSize().getHeight() - 30);
        graphics.dispose();
    }

    private int getMax() {
        int max = 0;
        for (int anArray : array) {
            max = Math.max(max, anArray);
        }
        return max;
    }

    void draw(int[] array, int from, int to, int offset) {
        System.arraycopy(array, from, this.array, offset, to - from);
        repaint();
    }

    void clear() {
        this.array = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

}
