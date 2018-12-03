package deus.seow.de.boidb.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import deus.seow.de.boidb.db.entity.*;
import deus.seow.de.boidb.db.entity.Character;

public class DataParser {

    public static List<Achievement> parseAchievements(BufferedReader br) throws IOException {
        List<Achievement> achievements = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", description = "", condition = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    name = line;
                    break;
                case 2:
                    description = line;
                    break;
                case 3:
                    condition = line;
                    break;
                case 4:
                    id = Integer.parseInt(line);
                    break;
                case 5:
                    pointer = 0;
                    achievements.add(new Achievement(id, name, description, condition));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        achievements.add(new Achievement(id, name, description, condition));

        return achievements;
    }

    public static List<Character> parseCharacters(BufferedReader br) throws IOException {
        List<Character> characters = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", unlock = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line);
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    unlock = line;
                    break;
                case 4:
                    pointer = 0;
                    characters.add(new Character(id, name, unlock));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        characters.add(new Character(id, name, unlock));

        return characters;
    }

    public static List<Item> parseItems(BufferedReader br) throws IOException {
        List<Item> items = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", effect = "", activation = "", description = "";
        boolean passive = false;
        while ((line = br.readLine()) != null) {
            if (line.equals("Activated Collectibles")) {
                line = br.readLine();
            }
            if (line.equals("Passive Collectibles")) {
                passive = true;
                activation = "passive";
                line = br.readLine();
            }

            switch (pointer) {
                case 1:
                    name = line;
                    break;
                case 2:
                    id = Integer.parseInt(line);
                    break;
                case 3:
                    if (!passive) {
                        activation = line;
                        break;
                    } else {
                        pointer++;
                    }
                case 4:
                    description = line;
                    break;
                case 5:
                    effect = line;
                    break;
                case 6:
                    pointer = 0;
                    items.add(new Item(id, name, activation, description, effect));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        items.add(new Item(id, name, activation, description, effect));
        return items;
    }

    public static List<Trinket> parseTrinkets(BufferedReader br) throws IOException {
        List<Trinket> trinkets = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", description = "", effect = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line);
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    description = line;
                    break;
                case 4:
                    effect = line;
                    break;
                case 5:
                    pointer = 0;
                    trinkets.add(new Trinket(id, name, description, effect));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        trinkets.add(new Trinket(id, name, description, effect));
        return trinkets;
    }

    public static List<Boss> parseBosses(BufferedReader br) throws IOException {
        List<Boss> bosses = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "";
        boolean miniBoss = false;
        while ((line = br.readLine()) != null) {
            if (line.equals("MiniBoss")) {
                miniBoss = true;
                line = br.readLine();
            }
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line);
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    pointer = 0;
                    bosses.add(new Boss(id, name, miniBoss));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        bosses.add(new Boss(id, name, miniBoss));

        return bosses;
    }

    public static List<Seed> parseSeeds(BufferedReader br) throws IOException {
        List<Seed> seeds = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", description = "", effect = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line);
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    description = line;
                    break;
                case 4:
                    effect = line;
                    break;
                case 5:
                    pointer = 0;
                    seeds.add(new Seed(id, name, description, effect));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        seeds.add(new Seed(id, name, description, effect));

        return seeds;
    }

    public static List<Pill> parsePills(BufferedReader br) throws IOException {
        List<Pill> pills = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", effect = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line) + 1;
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    effect = line;
                    break;
                case 4:
                    pointer = 0;
                    pills.add(new Pill(id, name, effect));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        pills.add(new Pill(id, name, effect));

        return pills;
    }

    public static List<Card> parseCards(BufferedReader br) throws IOException {
        List<Card> cards = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", description = "", effect = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    name = line;
                    break;
                case 2:
                    id = Integer.parseInt(line);
                    break;
                case 3:
                    description = line;
                    break;
                case 4:
                    effect = line;
                    break;
                case 5:
                    pointer = 0;
                    cards.add(new Card(id, name, description, effect));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        cards.add(new Card(id, name, description, effect));

        return cards;
    }

    public static List<Monster> parseMonsters(BufferedReader br) throws IOException {
        List<Monster> monsters = new ArrayList<>();

        String line;
        int pointer = 1;
        int id = 0;
        String name = "", description = "";
        while ((line = br.readLine()) != null) {
            switch (pointer) {
                case 1:
                    id = Integer.parseInt(line);
                    break;
                case 2:
                    name = line;
                    break;
                case 3:
                    description = line;
                    break;
                case 4:
                    pointer = 0;
                    monsters.add(new Monster(id, name, description));
                    break;
                default:
                    break;
            }
            pointer++;
        }
        br.close();
        monsters.add(new Monster(id, name, description));

        return monsters;
    }

    public static List<ItemPool> parseItemPools(BufferedReader br) throws IOException {
        List<ItemPool> itemPools = new ArrayList<>();

        String line;
        int pointer = 1;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                itemPools.add(new ItemPool(pointer, line));
                pointer++;
            }
        }
        return itemPools;
    }

    public static List<ItemPoolHasItem> parseItemPoolHasItems(BufferedReader br) throws IOException {
        List<ItemPoolHasItem> itemPoolHasItems = new ArrayList<>();

        String line;
        int pointer = 0;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                pointer++;
            } else {
                itemPoolHasItems.add(new ItemPoolHasItem(pointer, Integer.parseInt(line)));
            }
        }
        br.close();

        return itemPoolHasItems;
    }

    public static List<AchievementUnlocksCharacter> parseCharacterUnlocks(BufferedReader br) throws IOException {
        List<AchievementUnlocksCharacter> unlocks = new ArrayList<>();

        String line;
        int pointer = 1;
        int achievementId = 0, characterId = 0;
        boolean isCharacterLine = false;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                isCharacterLine = false;
            }
            if (line.equals("Character")) {
                isCharacterLine = true;
                continue;
            }
            if (isCharacterLine) {
                switch (pointer) {
                    case 1:
                        achievementId = Integer.parseInt(line);
                        break;
                    case 2:
                        characterId = Integer.parseInt(line);
                        break;
                    case 3:
                        pointer = 0;
                        unlocks.add(new AchievementUnlocksCharacter(achievementId, characterId));
                        break;
                    default:
                        break;
                }
                pointer++;
            }
        }
        br.close();
        unlocks.add(new AchievementUnlocksCharacter(achievementId, characterId));

        return unlocks;
    }

    public static List<AchievementUnlocksBoss> parseBossUnlocks(BufferedReader br) throws IOException {
        List<AchievementUnlocksBoss> unlocks = new ArrayList<>();

        String line;
        int pointer = 1;
        int achievementId = 0, bossId = 0;
        boolean isBossLine = false;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                System.out.println(achievementId + " " + bossId);
                isBossLine = false;
            }
            if (line.equals("Boss")) {
                isBossLine = true;
                continue;
            }
            if (isBossLine) {
                switch (pointer) {
                    case 1:
                        achievementId = Integer.parseInt(line);
                        break;
                    case 2:
                        bossId = Integer.parseInt(line);
                        break;
                    case 3:
                        pointer = 0;
                        unlocks.add(new AchievementUnlocksBoss(achievementId, bossId));
                        break;
                    default:
                        break;
                }
                pointer++;
            }
        }
        br.close();
        unlocks.add(new AchievementUnlocksBoss(achievementId, bossId));

        return unlocks;
    }

    public static List<AchievementUnlocksTrinket> parseTrinketUnlocks(BufferedReader br) throws IOException {
        List<AchievementUnlocksTrinket> unlocks = new ArrayList<>();

        String line;
        int pointer = 1;
        int achievementId = 0, trinketId = 0;
        boolean isTrinketLine = false;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                isTrinketLine = false;
            }
            if (line.equals("Trinket")) {
                isTrinketLine = true;
                continue;
            }
            if (isTrinketLine) {
                switch (pointer) {
                    case 1:
                        achievementId = Integer.parseInt(line);
                        break;
                    case 2:
                        trinketId = Integer.parseInt(line);
                        break;
                    case 3:
                        pointer = 0;
                        unlocks.add(new AchievementUnlocksTrinket(achievementId, trinketId));
                        break;
                    default:
                        break;
                }
                pointer++;
            }
        }
        br.close();
        unlocks.add(new AchievementUnlocksTrinket(achievementId, trinketId));

        return unlocks;
    }

    public static List<AchievementUnlocksCard> parseCardUnlocks(BufferedReader br) throws IOException {
        List<AchievementUnlocksCard> unlocks = new ArrayList<>();

        String line;
        int pointer = 1;
        int achievementId = 0, cardId = 0;
        boolean isCardLine = false;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                isCardLine = false;
            }
            if (line.equals("Card")) {
                isCardLine = true;
                continue;
            }
            if (isCardLine) {
                switch (pointer) {
                    case 1:
                        achievementId = Integer.parseInt(line);
                        break;
                    case 2:
                        cardId = Integer.parseInt(line);
                        break;
                    case 3:
                        pointer = 0;
                        unlocks.add(new AchievementUnlocksCard(achievementId, cardId));
                        break;
                    default:
                        break;
                }
                pointer++;
            }
        }
        br.close();
        unlocks.add(new AchievementUnlocksCard(achievementId, cardId));

        return unlocks;
    }

    public static List<AchievementUnlocksItem> parseItemUnlocks(BufferedReader br) throws IOException {
        List<AchievementUnlocksItem> unlocks = new ArrayList<>();

        String line;
        int pointer = 1;
        int achievementId = 0, itemId = 0;
        boolean isItemLine = false;
        while ((line = br.readLine()) != null) {
            if (line.matches("[^0-9]+")) {
                isItemLine = false;
            }
            if (line.equals("Item")) {
                isItemLine = true;
                continue;
            }
            if (isItemLine) {
                switch (pointer) {
                    case 1:
                        achievementId = Integer.parseInt(line);
                        break;
                    case 2:
                        itemId = Integer.parseInt(line);
                        break;
                    case 3:
                        pointer = 0;
                        unlocks.add(new AchievementUnlocksItem(achievementId, itemId));
                        break;
                    default:
                        break;
                }
                pointer++;
            }
        }
        br.close();
        unlocks.add(new AchievementUnlocksItem(achievementId, itemId));

        return unlocks;
    }
}
