package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Seed {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String description;
    private final String effect;

    public Seed(int id, String name, String description, String effect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }
}
