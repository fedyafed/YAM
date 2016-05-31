package com.github.fedyafed.yam.gameFields;

import com.github.fedyafed.yam.domains.Cell;
import com.github.fedyafed.yam.domains.Id;
import com.github.fedyafed.yam.generators.MinesGenerator;
import com.github.fedyafed.yam.settings.RectangularGameFieldSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RectangularGameField extends AbstractGameField implements GameField {
    private RectangularGameFieldSettings settings;

    public RectangularGameField(RectangularGameFieldSettings settings, MinesGenerator generator) {
        super(settings, generator);
        this.settings = settings;
        cells = IntStream.range(0, settings.getWidth() * settings.getHeight())
                .boxed()
                .map((Function<Integer, Id<Cell>>) Id::new)
                .collect(Collectors.toMap(id -> id, Cell::new));
    }

    @Override
    protected List<Cell> getNearCells(Cell cell) {
        int id = cell.getId().getId();
        int row = id / settings.getWidth();
        int column = id % settings.getWidth();
        List<Cell> nearCells = new ArrayList<>();
        nearCells.add(getCell(row - 1, column - 1));
        nearCells.add(getCell(row, column - 1));
        nearCells.add(getCell(row + 1, column - 1));
        nearCells.add(getCell(row - 1, column));
        nearCells.add(getCell(row + 1, column));
        nearCells.add(getCell(row - 1, column + 1));
        nearCells.add(getCell(row, column + 1));
        nearCells.add(getCell(row + 1, column + 1));
        nearCells.removeIf(Objects::isNull);
        return nearCells;
    }

    protected Cell getCell(int row, int column) {
        if (row < 0 || row >= settings.getHeight() ||
                column < 0 || column > settings.getWidth()) {
            return null;
        }
        Id<Cell> id = new Id<>(row * settings.getWidth() + column);
        return cells.get(id);
    }
}
