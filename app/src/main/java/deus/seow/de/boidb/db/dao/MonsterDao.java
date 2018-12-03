package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Monster;


@Dao
public interface MonsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Monster monster);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Monster> monsters);

    @Query("SELECT * FROM Monster")
    List<Monster> getMonsters();

    @Query("SELECT * FROM Monster WHERE id = :id")
    Monster getMonster(int id);
}
