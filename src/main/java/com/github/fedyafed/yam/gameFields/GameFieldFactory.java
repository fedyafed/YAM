package com.github.fedyafed.yam.gameFields;

import com.github.fedyafed.yam.settings.GameFieldSettings;

/**
 * Created by fedya on 01.06.16.
 */
public interface GameFieldFactory {
    GameField getGameField(GameFieldSettings settings);
}
