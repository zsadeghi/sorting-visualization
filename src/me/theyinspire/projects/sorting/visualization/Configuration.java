package me.theyinspire.projects.sorting.visualization;

import me.theyinspire.projects.sorting.visualization.sort.Sorters;

import java.util.Objects;

/**
 * @author Zohreh Sadeghi (zsadeghi@uw.edu)
 * @since 1.0 (11/29/16, 10:51 PM)
 */
public class Configuration {

    private final Sorters sorter;
    private final int interval;

    public Configuration(String[] args) {
        Objects.nonNull(args);
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments are needed to run this program");
        }
        sorter = Sorters.valueOf(args[0].toUpperCase());
        interval = Integer.parseInt(args[1]);
    }

    public Sorters getSorter() {
        return sorter;
    }

    public int getInterval() {
        return interval;
    }

}
