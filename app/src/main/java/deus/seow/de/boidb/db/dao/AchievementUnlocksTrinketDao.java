package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.AchievementUnlocksTrinket;


@Dao
public interface AchievementUnlocksTrinketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AchievementUnlocksTrinket achievementUnlocksTrinket);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AchievementUnlocksTrinket> achievementUnlocksTrinkets);

    @Query("SELECT * FROM AchievementUnlocksTrinket")
    List<AchievementUnlocksTrinket> getAchievementUnlocksTrinkets();

}
