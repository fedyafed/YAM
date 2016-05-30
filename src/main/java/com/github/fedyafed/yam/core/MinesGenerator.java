package com.github.fedyafed.yam.core;

import com.github.fedyafed.yam.domains.Cell;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fedya on 30.05.16.
 */
public interface MinesGenerator {
    default void generateMines(Collection<? extends Cell> cells, Collection<? extends Cell> freeCells, Settings settings) {
        List<Cell> availableCells = cells.stream()
                .filter(cell -> !freeCells.contains(cell))
                .collect(Collectors.toList());
        generateMines(availableCells, settings);
    }

    void generateMines(Collection<? extends Cell> cells, Settings settings);
}
