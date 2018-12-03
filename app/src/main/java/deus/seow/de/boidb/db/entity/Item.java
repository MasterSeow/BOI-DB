package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Item {

    @PrimaryKey
    private final int id;
    private final String name;
    private final String activation;
    private final String description;
    private final String effect;

    public Item(int id, String name, String activation, String description, String effect) {
        this.id = id;
        this.name = name;
        this.activation = activation;
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
        if (imageId > 43)
            imageId--;
        if (imageId > 58)
            imageId--;
        if (imageId > 59)
            imageId--;
        if (imageId > 232)
            imageId--;
        if (imageId > 259)
            imageId--;
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getActivation() {
        return activation;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }
}
