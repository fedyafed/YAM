package com.github.fedyafed.yam.generators;

import com.github.fedyafed.yam.settings.GameFieldSettings;
import com.github.fedyafed.yam.domains.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by fedya on 30.05.16.
 */
public class ShuffleMinesGenerator implements MinesGenerator {
    @Override
    public void generateMines(Collection<? extends Cell> cells, GameFieldSettings settings) {
        if (cells.size() < settings.getMinesCount()) {
            throw new IllegalArgumentException(String.format("Too many mines %d for field size %d",
                    settings.getMinesCount(),
                    cells.size()));
        }

        ArrayList<Cell> randomCells = new ArrayList<>();
        randomCells.addAll(cells);
        Collections.shuffle(randomCells);
        randomCells.stream()
                .limit(settings.getMinesCount())
                .forEach(Cell::setContainMine);
    }
}
