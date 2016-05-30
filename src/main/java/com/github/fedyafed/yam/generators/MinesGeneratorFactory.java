package com.github.fedyafed.yam.generators;

import com.github.fedyafed.yam.settings.RectangularGameFieldSettings;

/**
 * Created by fedya on 31.05.16.
 */
public class MinesGeneratorFactory {
    public static MinesGenerator getMinesGenerator(RectangularGameFieldSettings settings) {
        return new ShuffleMinesGenerator();
    }
}
