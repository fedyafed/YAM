package com.github.fedyafed.yam.gameFields;

import com.github.fedyafed.yam.domains.Cell;
import com.github.fedyafed.yam.domains.Id;
import com.github.fedyafed.yam.exceptions.MineOpenedException;

import java.util.Collection;

/**
 * Created by fedya on 30.05.16.
 */
public interface GameField {
    Collection<? extends Cell> getCells();

    void userOpenCell(Id<Cell> cellId) throws MineOpenedException;

    void userOpenNearCell(Id<Cell> cellId) throws MineOpenedException;

    void initialize();

    void userMarkCell(Id<Cell> cellId);

    int getRemainToMark();

    boolean isGameFinished();
}
