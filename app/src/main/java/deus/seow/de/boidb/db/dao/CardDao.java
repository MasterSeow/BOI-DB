package deus.seow.de.boidb.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import deus.seow.de.boidb.db.entity.Card;


@Dao
public interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Card card);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Card> cards);

    @Query("SELECT * FROM Card")
    List<Card> getCards();

    @Query("SELECT * FROM Card WHERE id = :id")
    Card getCard(int id);
}
