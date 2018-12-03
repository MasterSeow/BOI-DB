package deus.seow.de.boidb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import deus.seow.de.boidb.db.dao.*;
import deus.seow.de.boidb.db.entity.*;
import deus.seow.de.boidb.db.entity.Character;


@Database(entities = {Achievement.class, Character.class, Item.class, Trinket.class, Boss.class, Card.class, Monster.class, Pill.class, Seed.class, ItemPool.class, ItemPoolHasItem.class, AchievementUnlocksTrinket.class, AchievementUnlocksItem.class, AchievementUnlocksCharacter.class, AchievementUnlocksCard.class, AchievementUnlocksBoss.class}, version = 8, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "boidb")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public abstract AchievementDao achievementDao();

    public abstract CharacterDao characterDao();

    public abstract ItemDao itemDao();

    public abstract TrinketDao trinketDao();

    public abstract BossDao bossDao();

    public abstract CardDao cardDao();

    public abstract MonsterDao monsterDao();

    public abstract PillDao pillDao();

    public abstract SeedDao seedDao();

    public abstract ItemPoolDao itemPoolDao();

    public abstract ItemPoolHasItemDao itemPoolHasItemDao();

    public abstract AchievementUnlocksBossDao achievementUnlocksBossDao();

    public abstract AchievementUnlocksCardDao achievementUnlocksCardDao();

    public abstract AchievementUnlocksCharacterDao achievementUnlocksCharacterDao();

    public abstract AchievementUnlocksItemDao achievementUnlocksItemDao();

    public abstract AchievementUnlocksTrinketDao achievementUnlocksTrinketDao();
}
