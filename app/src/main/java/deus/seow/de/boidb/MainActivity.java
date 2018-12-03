package deus.seow.de.boidb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.DataParser;
import deus.seow.de.boidb.ui.MainFragment;

public class MainActivity extends AppCompatActivity {

    //TODO create callbacks and dialogs for detail views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
        AppDatabase db = AppDatabase.getAppDatabase(this);
        //fill Database if empty
        try {
            if (db.achievementDao().getAchievements().isEmpty())
                db.achievementDao().insert(DataParser.parseAchievements(new BufferedReader(new InputStreamReader(getAssets().open("achievements.txt")))));
            if (db.characterDao().getCharacters().isEmpty())
                db.characterDao().insert(DataParser.parseCharacters(new BufferedReader(new InputStreamReader(getAssets().open("characters.txt")))));
            if (db.itemDao().getItems().isEmpty())
                db.itemDao().insert(DataParser.parseItems(new BufferedReader(new InputStreamReader(getAssets().open("items.txt")))));
            if (db.trinketDao().getTrinkets().isEmpty())
                db.trinketDao().insert(DataParser.parseTrinkets(new BufferedReader(new InputStreamReader(getAssets().open("trinkets.txt")))));
            if (db.bossDao().getBosses().isEmpty())
                db.bossDao().insert(DataParser.parseBosses(new BufferedReader(new InputStreamReader(getAssets().open("bosses.txt")))));
            if (db.seedDao().getSeeds().isEmpty())
                db.seedDao().insert(DataParser.parseSeeds(new BufferedReader(new InputStreamReader(getAssets().open("seeds.txt")))));
            if (db.pillDao().gettPills().isEmpty())
                db.pillDao().insert(DataParser.parsePills(new BufferedReader(new InputStreamReader(getAssets().open("pills.txt")))));
            if (db.cardDao().getCards().isEmpty())
                db.cardDao().insert(DataParser.parseCards(new BufferedReader(new InputStreamReader(getAssets().open("cards.txt")))));
            if (db.monsterDao().getMonsters().isEmpty())
                db.monsterDao().insert(DataParser.parseMonsters(new BufferedReader(new InputStreamReader(getAssets().open("monsters.txt")))));
            if (db.itemPoolDao().getItemPools().isEmpty())
                db.itemPoolDao().insert(DataParser.parseItemPools(new BufferedReader(new InputStreamReader(getAssets().open("itempool.txt")))));
            if (db.itemPoolHasItemDao().getItemPoolHasItems().isEmpty())
                db.itemPoolHasItemDao().insert(DataParser.parseItemPoolHasItems(new BufferedReader(new InputStreamReader(getAssets().open("itempool.txt")))));
            if (db.achievementUnlocksCharacterDao().getAchievementUnlocksCharacters().isEmpty())
                db.achievementUnlocksCharacterDao().insert(DataParser.parseCharacterUnlocks(new BufferedReader(new InputStreamReader(getAssets().open("unlock.txt")))));
            if (db.achievementUnlocksBossDao().getAchievementUnlocksBosses().isEmpty())
                db.achievementUnlocksBossDao().insert(DataParser.parseBossUnlocks(new BufferedReader(new InputStreamReader(getAssets().open("unlock.txt")))));
            if (db.achievementUnlocksCardDao().getAchievementUnlocksCards().isEmpty())
                db.achievementUnlocksCardDao().insert(DataParser.parseCardUnlocks(new BufferedReader(new InputStreamReader(getAssets().open("unlock.txt")))));
            if (db.achievementUnlocksTrinketDao().getAchievementUnlocksTrinkets().isEmpty())
                db.achievementUnlocksTrinketDao().insert(DataParser.parseTrinketUnlocks(new BufferedReader(new InputStreamReader(getAssets().open("unlock.txt")))));
            if (db.achievementUnlocksItemDao().getAchievementUnlocksItems().isEmpty())
                db.achievementUnlocksItemDao().insert(DataParser.parseItemUnlocks(new BufferedReader(new InputStreamReader(getAssets().open("unlock.txt")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
