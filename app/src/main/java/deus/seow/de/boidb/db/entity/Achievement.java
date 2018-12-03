package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Achievement {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String description;
    private final String condition;

    public Achievement(int id, String name, String description, String condition) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }
}
