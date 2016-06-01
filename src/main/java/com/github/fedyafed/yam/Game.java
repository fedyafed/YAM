package com.github.fedyafed.yam;

import com.github.fedyafed.yam.domains.Cell;
import com.github.fedyafed.yam.domains.Id;
import com.github.fedyafed.yam.exceptions.MineOpenedException;
import com.github.fedyafed.yam.gameFields.GameField;
import com.github.fedyafed.yam.gameFields.GameFieldFactory;
import com.github.fedyafed.yam.gameFields.RectangularGameFieldFactory;
import com.github.fedyafed.yam.settings.GameFieldSettings;
import com.github.fedyafed.yam.settings.RectangularGameFieldSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fedya on 22.05.16.
 */
public class Game {
    private GameFieldSettings settings;
    private GameField gameField;

    public Game(GameFieldSettings settings, GameFieldFactory gameFieldFactory) {
        this.settings = settings;
        this.gameField = gameFieldFactory.getGameField(settings);

        newGame();
    }

    public void newGame() {
        gameField.initialize();
    }

    public GameFieldSettings getSettings() {
        return settings;
    }

    public GameField getGameField() {
        return gameField;
    }

    public static void main(String[] args) {
        GameFieldSettings settings = new RectangularGameFieldSettings(5, 10, 10);
        GameFieldFactory gameFieldFactory = new RectangularGameFieldFactory();
        Game game = new Game(settings, gameFieldFactory);
        GameField gameField = game.getGameField();
        List<Cell> closedCells = new ArrayList<>();
        closedCells.addAll(gameField.getCells());

        Random random = new Random();
        try {
            do {
                Id<Cell> cellId = closedCells.get(random.nextInt(closedCells.size())).getId();
                gameField.userOpenCell(cellId);
                closedCells.removeIf(Cell::isOpened);
            } while (!gameField.isGameFinished());
            System.out.println("Congratulations! You win this game!");
        } catch (MineOpenedException e) {
            System.out.println("Mine was opened! CellId is:" + e.getCell().getId().getId());
        }
    }
}
