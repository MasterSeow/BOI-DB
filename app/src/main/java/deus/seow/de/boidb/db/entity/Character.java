package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Character {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String unlock;

    public Character(int id, String name, String unlock) {
        this.id = id;
        this.name = name;
        this.unlock = unlock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnlock() {
        return unlock;
    }
}
