package com.github.fedyafed.yam.exceptions;

import com.github.fedyafed.yam.domains.Cell;

/**
 * Created by fedya on 23.05.16.
 */
public class MineOpenedException extends Exception {
    private Cell cell;

    public MineOpenedException(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
}
