package com.github.fedyafed.yam.gameFields;

import com.github.fedyafed.yam.generators.MinesGeneratorFactory;
import com.github.fedyafed.yam.settings.GameFieldSettings;
import com.github.fedyafed.yam.settings.RectangularGameFieldSettings;

/**
 * Created by fedya on 31.05.16.
 */
public class RectangularGameFieldFactory implements GameFieldFactory {
    @Override
    public GameField getGameField(GameFieldSettings settings) {
        if (settings instanceof RectangularGameFieldSettings) {
            return getGameField((RectangularGameFieldSettings) settings);
        }
        throw new UnsupportedOperationException(String.format("Settings with class %s are not supported.", settings.getClass()));
    }

    public GameField getGameField(RectangularGameFieldSettings settings) {
        return new RectangularGameField(settings, MinesGeneratorFactory.getMinesGenerator(settings));
    }
}
