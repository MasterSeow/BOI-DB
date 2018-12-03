package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Character;


@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Character character);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Character> characters);

    @Query("SELECT * FROM Character")
    List<Character> getCharacters();

    @Query("SELECT * FROM Character WHERE id = :id")
    Character getCharacter(int id);
}
