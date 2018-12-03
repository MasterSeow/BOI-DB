package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"achievementId", "characterId"},
        foreignKeys = {
                @ForeignKey(entity = Achievement.class, parentColumns = "id", childColumns = "achievementId", onDelete = CASCADE),
                @ForeignKey(entity = Character.class, parentColumns = "id", childColumns = "characterId")
        })
public class AchievementUnlocksCharacter {

    private final int achievementId;
    private final int characterId;

    public AchievementUnlocksCharacter(int achievementId, int characterId) {
        this.achievementId = achievementId;
        this.characterId = characterId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public int getCharacterId() {
        return characterId;
    }
}
