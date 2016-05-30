package com.github.fedyafed.yam.domains;

import java.util.Objects;

/**
 * Created by fedya on 22.05.16.
 */
public class Cell {
    Id<Cell> id;
    boolean isOpened;
    boolean isMarked;
    boolean containMine;
    long nearMinesCount;

    public Cell(Id<Cell> id) {
        Objects.requireNonNull(id, "Cell id must be not null.");
        this.id = id;
        reset();
    }

    public Id<Cell> getId() {
        return id;
    }

    public void setId(Id<Cell> id) {
        Objects.requireNonNull(id, "Cell id must be not null.");
        this.id = id;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setIsOpened(boolean isOpened) {
        this.isOpened = isOpened;
    }

    public long getNearMinesCount() {
        return nearMinesCount;
    }

    public void setNearMinesCount(long nearMinesCount) {
        this.nearMinesCount = nearMinesCount;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setIsMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public boolean isContainMine() {
        return containMine;
    }

    public void setContainMine(boolean containMine) {
        this.containMine = containMine;
    }

    public void reset() {
        isOpened = false;
        isMarked = false;
        nearMinesCount = 0;
        containMine = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return id.equals(cell.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
