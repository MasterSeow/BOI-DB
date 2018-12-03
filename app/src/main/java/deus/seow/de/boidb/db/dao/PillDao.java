package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Pill;


@Dao
public interface PillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pill pill);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Pill> pills);

    @Query("SELECT * FROM Pill")
    List<Pill> gettPills();

    @Query("SELECT * FROM Pill WHERE id = :id")
    Pill getPill(int id);
}
