package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Boss;


@Dao
public interface BossDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Boss boss);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Boss> bosses);

    @Query("SELECT * FROM Boss")
    List<Boss> getBosses();

    @Query("SELECT * FROM Boss WHERE id = :id")
    Boss getBoss(int id);
}
