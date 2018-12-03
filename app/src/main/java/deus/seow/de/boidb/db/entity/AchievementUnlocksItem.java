package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"achievementId", "itemId"},
        foreignKeys = {
                @ForeignKey(entity = Achievement.class, parentColumns = "id", childColumns = "achievementId", onDelete = CASCADE),
                @ForeignKey(entity = Item.class, parentColumns = "id", childColumns = "itemId")
        })
public class AchievementUnlocksItem {

    private final int achievementId;
    private final int itemId;

    public AchievementUnlocksItem(int achievementId, int itemId) {
        this.achievementId = achievementId;
        this.itemId = itemId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public int getItemId() {
        return itemId;
    }
}
