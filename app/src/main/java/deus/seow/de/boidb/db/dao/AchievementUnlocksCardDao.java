package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.AchievementUnlocksCard;


@Dao
public interface AchievementUnlocksCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AchievementUnlocksCard achievementUnlocksCard);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AchievementUnlocksCard> achievementUnlocksCards);

    @Query("SELECT * FROM AchievementUnlocksCard")
    List<AchievementUnlocksCard> getAchievementUnlocksCards();

}
