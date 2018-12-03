package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"achievementId", "trinketId"},
        foreignKeys = {
                @ForeignKey(entity = Achievement.class, parentColumns = "id", childColumns = "achievementId", onDelete = CASCADE),
                @ForeignKey(entity = Trinket.class, parentColumns = "id", childColumns = "trinketId")
        })
public class AchievementUnlocksTrinket {

    private final int achievementId;
    private final int trinketId;

    public AchievementUnlocksTrinket(int achievementId, int trinketId) {
        this.achievementId = achievementId;
        this.trinketId = trinketId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public int getTrinketId() {
        return trinketId;
    }
}
