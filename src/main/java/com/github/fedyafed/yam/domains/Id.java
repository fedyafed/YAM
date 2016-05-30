package com.github.fedyafed.yam.domains;

/**
 * Created by fedya on 22.05.16.
 */
public class Id<T> {
    int id;

    public Id(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id<?> id1 = (Id<?>) o;

        return id == id1.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
