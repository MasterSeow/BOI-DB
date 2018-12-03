package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Seed;


@Dao
public interface SeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Seed seed);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Seed> seeds);

    @Query("SELECT * FROM Seed")
    List<Seed> getSeeds();

    @Query("SELECT * FROM Seed WHERE id = :id")
    Seed getSeed(int id);
}
