package com.github.fedyafed.yam.settings;

/**
 * Created by fedya on 22.05.16.
 */
public abstract class GameFieldSettings {
    private int minesCount;

    public GameFieldSettings(int minesCount) {
        this.minesCount = minesCount;
    }

    public int getMinesCount() {
        return minesCount;
    }
}
