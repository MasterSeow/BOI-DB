package deus.seow.de.boidb.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.ViewAdapter;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.dao.AchievementDao;
import deus.seow.de.boidb.db.entity.*;
import deus.seow.de.boidb.db.entity.Character;

public class AchievementDialog extends DialogFragment {
    public static final String TAG = AchievementDialog.class.getSimpleName();

    private Achievement achievement;
    private List<View> entries = new ArrayList<>(0);

    public static AchievementDialog newInstance(Achievement achievement) {
        AchievementDialog fragment = new AchievementDialog();
        fragment.achievement = achievement;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_achievement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (achievement == null)
            getFragmentManager().beginTransaction().remove(this).commit();

        TextView id = view.findViewById(R.id.id);
        id.setText(String.valueOf(achievement.getId()));
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("a" + achievement.getId(), "drawable", getContext().getPackageName())));
        TextView name = view.findViewById(R.id.name);
        name.setText(achievement.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(achievement.getDescription());
        TextView condition = view.findViewById(R.id.condition);
        condition.setText(achievement.getCondition());

        TextView unlock = view.findViewById(R.id.unlocks);
        ListView unlocks = view.findViewById(R.id.unlockList);

        AchievementDao achievementDao = AppDatabase.getAppDatabase(getContext()).achievementDao();

        for (Boss boss : achievementDao.getBossUnlocks(achievement.getId())) {
            entries.add(createBossView(boss, unlocks));
        }
        for (Card card : achievementDao.getCardUnlocks(achievement.getId())) {
            entries.add(createCardView(card, unlocks));
        }
        for (Character character : achievementDao.getCharacterUnlocks(achievement.getId())) {
            entries.add(createCharacterView(character, unlocks));
        }
        for (Item item : achievementDao.getItemUnlocks(achievement.getId())) {
            entries.add(createItemView(item, unlocks));
        }
        for (Trinket trinket : achievementDao.getTrinketUnlocks(achievement.getId())) {
            entries.add(createTrinketView(trinket, unlocks));
        }

        if (!entries.isEmpty()) {
            unlock.setVisibility(View.VISIBLE);
            unlocks.setVisibility(View.VISIBLE);
            unlocks.setAdapter(new ViewAdapter(entries));
        }

    }

    private View createItemView(final Item item, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_item, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(item.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("i" + item.getImageId(), "drawable", getContext().getPackageName())));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDialog.newInstance(item).show(getFragmentManager(), ItemDialog.TAG);
            }
        });
        return view;
    }

    private View createBossView(Boss boss, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_boss, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(boss.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("b" + boss.getId(), "drawable", getContext().getPackageName())));
        return view;
    }

    private View createCardView(final Card card, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_card, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(card.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("r" + card.getId(), "drawable", getContext().getPackageName())));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardDialog.newInstance(card).show(getFragmentManager(), CardDialog.TAG);
            }
        });
        return view;
    }

    private View createCharacterView(Character character, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_character, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(character.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("c" + character.getId() + "_drawn", "drawable", getContext().getPackageName())));
        return view;
    }

    private View createTrinketView(final Trinket trinket, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_trinket, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(trinket.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("t" + trinket.getImageId(), "drawable", getContext().getPackageName())));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrinketDialog.newInstance(trinket).show(getFragmentManager(), TrinketDialog.TAG);
            }
        });
        return view;
    }
}
