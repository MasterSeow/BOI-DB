package deus.seow.de.boidb.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(primaryKeys = {"achievementId", "cardId"},
        foreignKeys = {
                @ForeignKey(entity = Achievement.class, parentColumns = "id", childColumns = "achievementId", onDelete = CASCADE),
                @ForeignKey(entity = Card.class, parentColumns = "id", childColumns = "cardId")
        })
public class AchievementUnlocksCard {

    private final int achievementId;
    private final int cardId;

    public AchievementUnlocksCard(int achievementId, int cardId) {
        this.achievementId = achievementId;
        this.cardId = cardId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public int getCardId() {
        return cardId;
    }
}
