package com.github.fedyafed.yam;

import com.github.fedyafed.yam.gameFields.AbstractGameFieldFactory;
import com.github.fedyafed.yam.gameFields.GameField;
import com.github.fedyafed.yam.settings.GameFieldSettings;

/**
 * Created by fedya on 22.05.16.
 */
public class Game {
    private GameFieldSettings settings;
    private GameField gameField;

    public Game(GameFieldSettings settings, AbstractGameFieldFactory gameFieldFactory) {
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
}
