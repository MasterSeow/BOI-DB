package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Trinket;


@Dao
public interface TrinketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Trinket trinket);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Trinket> trinkets);

    @Query("SELECT * FROM Trinket")
    List<Trinket> getTrinkets();

    @Query("SELECT * FROM Trinket WHERE id = :id")
    Trinket getTrinket(int id);
}
