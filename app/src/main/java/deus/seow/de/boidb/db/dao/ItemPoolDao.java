package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.ItemPool;


@Dao
public interface ItemPoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemPool itemPool);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ItemPool> itemPools);

    @Query("SELECT * FROM ItemPool")
    List<ItemPool> getItemPools();

    @Query("SELECT * FROM ItemPool WHERE id = :id")
    ItemPool getItemPool(int id);
}
