package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"itemPoolId", "itemId"},
        foreignKeys = {
                @ForeignKey(entity = ItemPool.class, parentColumns = "id", childColumns = "itemPoolId"),
                @ForeignKey(entity = Item.class, parentColumns = "id", childColumns = "itemId", onDelete = CASCADE)
        })
public class ItemPoolHasItem {

    private final int itemPoolId;
    private final int itemId;

    public ItemPoolHasItem(int itemPoolId, int itemId) {

        this.itemPoolId = itemPoolId;
        this.itemId = itemId;
    }


    public int getItemPoolId() {
        return itemPoolId;
    }

    public int getItemId() {
        return itemId;
    }
}
