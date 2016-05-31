package com.github.fedyafed.yam.generators;

import com.github.fedyafed.yam.domains.Cell;
import com.github.fedyafed.yam.settings.GameFieldSettings;

import java.util.Collection;
import java.util.Random;

/**
 * Created by fedya on 30.05.16.
 */
public class ProbabilisticMinesGenerator implements MinesGenerator {
    @Override
    public void generateMines(Collection<? extends Cell> cells, GameFieldSettings settings) {
        if (cells.size() < settings.getMinesCount()) {
            throw new IllegalArgumentException(String.format("Too many mines %d for field size %d",
                    settings.getMinesCount(),
                    cells.size()));
        }

        int minesCount = settings.getMinesCount();
        int cellsCount = cells.size();
        Random random = new Random();
        for (Cell cell : cells) {
            if (random.nextDouble() < ((double) minesCount) / cellsCount) {
                cell.setContainMine();
                minesCount--;
                if (minesCount == 0) {
                    return;
                }
            }
            cellsCount--;
        }
    }
}
