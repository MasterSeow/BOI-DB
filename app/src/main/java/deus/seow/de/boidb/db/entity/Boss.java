package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Boss {

    @PrimaryKey
    private final int id;
    private final String name;
    private final boolean miniBoss;

    public Boss(int id, String name, boolean miniBoss) {
        this.id = id;
        this.name = name;
        this.miniBoss = miniBoss;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isMiniBoss() {
        return miniBoss;
    }
}
