package com.github.fedyafed.yam.settings;

/**
 * Created by fedya on 30.05.16.
 */
public class RectangularGameFieldSettings extends GameFieldSettings {
    private int width;
    private int height;

    public RectangularGameFieldSettings(int minesCount, int width, int height) {
        super(minesCount);
        this.width = width;
        this.height = height;

        if (minesCount > height * width) {
            throw new IllegalArgumentException(String.format("Too many mines %d for field %dx%d", minesCount, height, width));
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
