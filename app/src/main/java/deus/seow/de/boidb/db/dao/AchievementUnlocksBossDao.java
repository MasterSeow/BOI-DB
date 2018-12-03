package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.AchievementUnlocksBoss;


@Dao
public interface AchievementUnlocksBossDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AchievementUnlocksBoss achievementUnlocksBoss);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AchievementUnlocksBoss> achievementUnlocksBosses);

    @Query("SELECT * FROM AchievementUnlocksBoss")
    List<AchievementUnlocksBoss> getAchievementUnlocksBosses();

}
