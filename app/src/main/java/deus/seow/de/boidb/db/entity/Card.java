package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Card {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String message;
    private final String effect;

    public Card(int id, String name, String message, String effect) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getEffect() {
        return effect;
    }
}
