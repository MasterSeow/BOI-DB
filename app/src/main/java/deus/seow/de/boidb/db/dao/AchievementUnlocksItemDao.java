package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.AchievementUnlocksItem;


@Dao
public interface AchievementUnlocksItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AchievementUnlocksItem achievementUnlocksItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AchievementUnlocksItem> achievementUnlocksItems);

    @Query("SELECT * FROM AchievementUnlocksItem")
    List<AchievementUnlocksItem> getAchievementUnlocksItems();

}
