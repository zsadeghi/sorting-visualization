package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.sort.FactorySorter;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import java.awt.*;
import java.util.Random;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 9:19 PM)
 */
public class Main {

    public static void main(String[] args) {
        final Configuration configuration = new Configuration(args);
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", configuration.getSorter().name() + " SORT, interval: " + configuration.getInterval() + "ms");
        MainPanelLauncher launcher = new MainPanelLauncher();
        EventQueue.invokeLater(launcher);
        VisualizationProducer producer = new VisualizationProducer(launcher, configuration.getInterval());
        launcher.init(producer);
        new Thread(producer).start();
        final FactorySorter sorter = new FactorySorter(producer);
        sorter.select(configuration.getSorter());
        sorter.sort(generateNumbers());
    }

    private static int[] generateNumbers() {
        int[] numbers = new int[MainPanel.SIZE];
        final Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(2000);
        }
        return numbers;
    }

}
