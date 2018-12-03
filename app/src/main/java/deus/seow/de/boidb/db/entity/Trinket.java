package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Trinket {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String description;
    private final String effect;

    public Trinket(int id, String name, String description, String effect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    @Ignore
    public int getImageId() {
        //exclude unused Id's
        int imageId = id;
        if (imageId > 47)
            imageId--;
        return imageId;
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
