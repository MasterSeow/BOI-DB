package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"achievementId", "bossId"},
        foreignKeys = {
                @ForeignKey(entity = Achievement.class, parentColumns = "id", childColumns = "achievementId", onDelete = CASCADE),
                @ForeignKey(entity = Boss.class, parentColumns = "id", childColumns = "bossId")
        })
public class AchievementUnlocksBoss {

    private final int achievementId;
    private final int bossId;

    public AchievementUnlocksBoss(int achievementId, int bossId) {
        this.achievementId = achievementId;
        this.bossId = bossId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public int getBossId() {
        return bossId;
    }
}
