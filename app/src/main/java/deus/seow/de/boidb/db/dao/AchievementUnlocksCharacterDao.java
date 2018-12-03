package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.AchievementUnlocksCharacter;


@Dao
public interface AchievementUnlocksCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AchievementUnlocksCharacter achievementUnlocksCharacter);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AchievementUnlocksCharacter> achievementUnlocksCharacters);

    @Query("SELECT * FROM AchievementUnlocksCharacter")
    List<AchievementUnlocksCharacter> getAchievementUnlocksCharacters();

}
