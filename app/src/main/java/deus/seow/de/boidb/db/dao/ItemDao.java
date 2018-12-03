package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Item;


@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Item item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Item> items);

    @Query("SELECT * FROM Item")
    List<Item> getItems();

    @Query("SELECT * FROM Item WHERE id = :id")
    Item getItem(int id);

    @Query("SELECT * FROM Item WHERE name LIKE :filter OR activation LIKE :filter OR description LIKE :filter OR effect LIKE :filter")
    List<Item> filter(String filter);
}
