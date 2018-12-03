package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Item;
import deus.seow.de.boidb.db.entity.ItemPool;
import deus.seow.de.boidb.db.entity.ItemPoolHasItem;


@Dao
public interface ItemPoolHasItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemPoolHasItem itemPoolHasItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ItemPoolHasItem> itemPoolHasItems);

    @Query("SELECT * FROM ItemPoolHasItem")
    List<ItemPoolHasItem> getItemPoolHasItems();

    @Query("SELECT id,name,activation,description,effect FROM Item LEFT JOIN ItemPoolHasItem ON id=itemId WHERE itemPoolId = :itemPoolId")
    List<Item> getItemPoolHasItems(int itemPoolId);

    @Query("SELECT id,name FROM ItemPool LEFT JOIN ItemPoolHasItem ON id=itemPoolId WHERE itemId = :itemId")
    List<ItemPool> getItemHasItemPools(int itemId);
}
