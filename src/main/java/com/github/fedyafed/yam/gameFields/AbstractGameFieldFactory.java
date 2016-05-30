package com.github.fedyafed.yam.gameFields;

import com.github.fedyafed.yam.settings.GameFieldSettings;

/**
 * Created by fedya on 30.05.16.
 */
public abstract class AbstractGameFieldFactory {

    public abstract GameField getGameField(GameFieldSettings settings);
}
