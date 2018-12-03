package deus.seow.de.boidb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import deus.seow.de.boidb.R;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button character = view.findViewById(R.id.button_character);
        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(CharacterFragment.newInstance());
            }
        });
        Button item = view.findViewById(R.id.button_item);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(ItemFragment.newInstance());
            }
        });
        Button itempool = view.findViewById(R.id.button_itempool);
        itempool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(ItemPoolFragment.newInstance());
            }
        });
        Button achievement = view.findViewById(R.id.button_achievement);
        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(AchievementFragment.newInstance());
            }
        });
        Button trinket = view.findViewById(R.id.button_trinket);
        trinket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(TrinketFragment.newInstance());
            }
        });
        Button boss = view.findViewById(R.id.button_boss);
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(BossFragment.newInstance());
            }
        });
        Button card = view.findViewById(R.id.button_cards);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(CardFragment.newInstance());
            }
        });
        Button monster = view.findViewById(R.id.button_monster);
        monster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(MonsterFragment.newInstance());
            }
        });
        Button pill = view.findViewById(R.id.button_pill);
        pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(PillFragment.newInstance());
            }
        });
        Button seed = view.findViewById(R.id.button_seed);
        seed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(SeedFragment.newInstance());
            }
        });

    }

    public void switchFragment(Fragment fragment) {
        final String TAG = fragment.getClass().getSimpleName();
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null)
            if (fragmentManager.findFragmentByTag(TAG) == null)
                fragmentManager.beginTransaction().addToBackStack(TAG).replace(R.id.container, fragment, TAG).commit();
    }
}