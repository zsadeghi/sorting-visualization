package me.theyinspire.projects.sorting.visualization.sort;

import me.theyinspire.projects.sorting.visualization.viz.Visualization;
import me.theyinspire.projects.sorting.visualization.viz.VisualizationProducer;

import java.util.EnumMap;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:47 PM)
 */
public class FactorySorter implements Sorter {

    private final VisualizationProducer producer;
    private final EnumMap<Sorters, Sorter> sorters = new EnumMap<>(Sorters.class);
    private Sorters selected = Sorters.BUBBLE;

    public FactorySorter(VisualizationProducer producer) {
        this.producer = producer;
        sorters.put(Sorters.BUBBLE, new BubbleSorter(producer));
        sorters.put(Sorters.INSERTION, new InsertionSorter(producer));
        sorters.put(Sorters.MERGE, new MergeSorter(producer));
        sorters.put(Sorters.QUICK, new QuickSorter(producer));
        sorters.put(Sorters.SELECTION, new SelectionSorter(producer));
    }

    public void select(Sorters selected) {
        this.selected = selected;
    }

    @Override
    public void sort(int[] items) {
        producer.visualize(new Visualization(items, 0, items.length, 0));
        sorters.get(selected).sort(items);
    }

}
