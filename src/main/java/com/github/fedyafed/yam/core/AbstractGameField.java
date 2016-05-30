package com.github.fedyafed.yam.core;

import com.github.fedyafed.yam.domains.Cell;
import com.github.fedyafed.yam.domains.Id;
import com.github.fedyafed.yam.exceptions.MineOpenedException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by fedya on 22.05.16.
 */
public abstract class AbstractGameField implements GameField {
    protected Map<Id<Cell>, Cell> cells;
    protected Settings settings;
    protected long closedFreeCells;
    protected long remainToMark;
    protected MinesGenerator generator;
    protected boolean generated;

    public AbstractGameField(Settings settings, MinesGenerator generator) {
        this.settings = settings;
        this.generator = generator;
    }

    @Override
    public void initialize() {
        generated = false;
        closedFreeCells = cells.size() - settings.getMinesCount();
        remainToMark = settings.getMinesCount();
        cells.values().forEach(Cell::reset);
    }

    protected abstract List<Cell> getNearCells(Cell cell);

    @Override
    public Collection<? extends Cell> getCells() {
        return Collections.unmodifiableCollection(cells.values());
    }

    @Override
    public void userOpenCell(Id<Cell> cellId) throws MineOpenedException {
        Cell cellToOpen = cells.get(cellId);
        if (!generated) {
            generated = true;
            generator.generateMines(getCells(), Collections.singletonList(cellToOpen), settings);
            cells.values().forEach(cell -> cell.setNearMinesCount(getNearMinesCount(cell)));
        }
        openCell(cellToOpen);
    }

    @Override
    public void userOpenNearCell(Id<Cell> cellId) throws MineOpenedException {
        Cell cell = cells.get(cellId);
        if (!cell.isOpened()) {
            return;
        }
        if (cell.getNearMinesCount() == getNearUserMinesCount(cell)) {
            for (Cell nearCell : getNearCells(cell)) {
                openCell(nearCell);
            }
        }
    }

    @Override
    public void userMarkCell(Id<Cell> cellId) {
        Cell cell = cells.get(cellId);
        if (cell.isOpened()) {
            return;
        }
        boolean marked = !cell.isMarked();
        if (marked) {
            remainToMark--;
        } else {
            remainToMark++;
        }
        cell.setIsMarked(marked);
    }

    protected void openCell(Cell cell) throws MineOpenedException {
        if (cell.isOpened() || cell.isMarked()) {
            return;
        }
        if (cell.isContainMine()) {
            mineOpened(cell);
        }
        cell.open();
        if (cell.getNearMinesCount() == 0) {
            for (Cell nearCell : getNearCells(cell)) {
                openCell(nearCell);
            }
        }
        closedFreeCells--;
    }

    protected long getNearMinesCount(Cell cell) {
        return this.getNearCells(cell).stream()
                .filter(Cell::isContainMine)
                .count();
    }

    protected long getNearUserMinesCount(Cell cell) {
        return this.getNearCells(cell).stream()
                .filter(Cell::isMarked)
                .count();
    }

    protected void openAll() {
        cells.values().forEach(Cell::open);
    }

    protected void mineOpened(Cell cell) throws MineOpenedException {
        openAll();
        throw new MineOpenedException(cell);
    }

    @Override
    public long getRemainToMark() {
        return remainToMark;
    }

    @Override
    public boolean isGameFinished() {
        return closedFreeCells == 0;
    }
}
