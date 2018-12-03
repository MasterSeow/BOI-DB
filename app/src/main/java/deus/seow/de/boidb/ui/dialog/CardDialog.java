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

import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.AchievementAdapter;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.dao.AchievementDao;
import deus.seow.de.boidb.db.entity.Achievement;
import deus.seow.de.boidb.db.entity.Card;

public class CardDialog extends DialogFragment implements AchievementAdapter.Callback {
    public static final String TAG = CardDialog.class.getSimpleName();

    private Card card;

    public static CardDialog newInstance(Card card) {
        CardDialog fragment = new CardDialog();
        fragment.card = card;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (card == null)
            getFragmentManager().beginTransaction().remove(this).commit();

        TextView id = view.findViewById(R.id.id);
        id.setText(String.valueOf(card.getId()));
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("r" + card.getId(), "drawable", getContext().getPackageName())));
        TextView name = view.findViewById(R.id.name);
        name.setText(card.getName());
        TextView message = view.findViewById(R.id.message);
        message.setText(card.getMessage());
        TextView effect = view.findViewById(R.id.effect);
        effect.setText(card.getEffect());

        TextView unlock = view.findViewById(R.id.unlocks);
        ListView unlocks = view.findViewById(R.id.unlockList);

        AchievementDao achievementDao = AppDatabase.getAppDatabase(getContext()).achievementDao();
        List<Achievement> achievements = achievementDao.getAchievementForCard(card.getId());
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
