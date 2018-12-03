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
import deus.seow.de.boidb.adapter.AchievementAdapter;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.dao.AchievementDao;
import deus.seow.de.boidb.db.entity.Achievement;
import deus.seow.de.boidb.db.entity.Trinket;

public class TrinketDialog extends DialogFragment implements AchievementAdapter.Callback {
    public static final String TAG = TrinketDialog.class.getSimpleName();

    private Trinket trinket;
    private List<View> achievementEntries = new ArrayList<>(0);

    public static TrinketDialog newInstance(Trinket trinket) {
        TrinketDialog fragment = new TrinketDialog();
        fragment.trinket = trinket;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_trinket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (trinket == null)
            getFragmentManager().beginTransaction().remove(this).commit();

        TextView id = view.findViewById(R.id.id);
        id.setText(String.valueOf(trinket.getId()));
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("t" + trinket.getImageId(), "drawable", getContext().getPackageName())));
        TextView name = view.findViewById(R.id.name);
        name.setText(trinket.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(trinket.getDescription());
        TextView effect = view.findViewById(R.id.effect);
        effect.setText(trinket.getEffect());

        TextView unlock = view.findViewById(R.id.unlocks);
        ListView unlocks = view.findViewById(R.id.unlockList);

        AchievementDao achievementDao = AppDatabase.getAppDatabase(getContext()).achievementDao();
        List<Achievement> achievements = achievementDao.getAchievementForTrinket(trinket.getId());
        if (!achievements.isEmpty()) {
            unlock.setVisibility(View.VISIBLE);
            unlocks.setVisibility(View.VISIBLE);
            unlocks.setAdapter(new AchievementAdapter(getContext(), this, achievements));
        }

    }

    @Override
    public void achievementSelected(Achievement achievement) {
        AchievementDialog.newInstance(achievement).show(getFragmentManager(), AchievementDialog.TAG);
    }
}
