package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.*;
import deus.seow.de.boidb.db.entity.Character;


@Dao
public interface AchievementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Achievement achievement);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Achievement> achievements);

    @Query("SELECT * FROM Achievement")
    List<Achievement> getAchievements();

    @Query("SELECT * FROM Achievement WHERE id = :id")
    Achievement getAchievement(int id);

    @Query("SELECT id,name,activation,description,effect FROM Item LEFT JOIN AchievementUnlocksItem ON id=itemId WHERE achievementId = :achievementId")
    List<Item> getItemUnlocks(int achievementId);

    @Query("SELECT id,name,miniBoss FROM Boss LEFT JOIN AchievementUnlocksBoss ON id=bossId WHERE achievementId = :achievementId")
    List<Boss> getBossUnlocks(int achievementId);

    @Query("SELECT id,name,message,effect FROM Card LEFT JOIN AchievementUnlocksCard ON id=cardId WHERE achievementId = :achievementId")
    List<Card> getCardUnlocks(int achievementId);

    @Query("SELECT id,name,unlock FROM Character LEFT JOIN AchievementUnlocksCharacter ON id=characterId WHERE achievementId = :achievementId")
    List<Character> getCharacterUnlocks(int achievementId);

    @Query("SELECT id,name,description,effect FROM Trinket LEFT JOIN AchievementUnlocksTrinket ON id=trinketId WHERE achievementId = :achievementId")
    List<Trinket> getTrinketUnlocks(int achievementId);

    @Query("SELECT id,name,description,condition FROM Achievement LEFT JOIN AchievementUnlocksItem ON id=achievementId WHERE itemId = :itemId")
    List<Achievement> getAchievementForItem(int itemId);

    @Query("SELECT id,name,description,condition FROM Achievement LEFT JOIN AchievementUnlocksTrinket ON id=achievementId WHERE trinketId = :trinketId")
    List<Achievement> getAchievementForTrinket(int trinketId);

    @Query("SELECT id,name,description,condition FROM Achievement LEFT JOIN AchievementUnlocksCard ON id=achievementId WHERE cardId = :cardId")
    List<Achievement> getAchievementForCard(int cardId);

    @Query("SELECT id,name,description,condition FROM Achievement LEFT JOIN AchievementUnlocksCharacter ON id=achievementId WHERE characterId = :characterId")
    List<Achievement> getAchievementForCharacter(int characterId);

    @Query("SELECT id,name,description,condition FROM Achievement WHERE name LIKE :filter OR description LIKE :filter OR condition LIKE :filter")
    List<Achievement> filter(String filter);
}
