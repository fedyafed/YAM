package com.github.fedyafed.yam.domains;

import com.github.fedyafed.yam.core.GameField;
import com.github.fedyafed.yam.core.GameFieldFactory;
import com.github.fedyafed.yam.core.Settings;

/**
 * Created by fedya on 22.05.16.
 */
public class Game {
    private Settings settings;
    private GameField gameField;

    public Game(Settings settings, GameFieldFactory gameFieldFactory) {
        this.settings = settings;
        this.gameField = gameFieldFactory.getGameField(settings);

        newGame();
    }

    public void newGame() {
        gameField.initialize();
    }

    public Settings getSettings() {
        return settings;
    }

    public GameField getGameField() {
        return gameField;
    }
}
