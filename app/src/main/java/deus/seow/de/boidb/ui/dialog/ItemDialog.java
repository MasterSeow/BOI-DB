package deus.seow.de.boidb.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.AchievementAdapter;
import deus.seow.de.boidb.adapter.ViewAdapter;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.dao.AchievementDao;
import deus.seow.de.boidb.db.dao.ItemPoolHasItemDao;
import deus.seow.de.boidb.db.entity.Achievement;
import deus.seow.de.boidb.db.entity.Item;
import deus.seow.de.boidb.db.entity.ItemPool;

public class ItemDialog extends DialogFragment implements AchievementAdapter.Callback {
    public static final String TAG = ItemDialog.class.getSimpleName();

    private Item item;
    private List<View> itemPoolEntries = new ArrayList<>(0);

    public static ItemDialog newInstance(Item item) {
        ItemDialog fragment = new ItemDialog();
        fragment.item = item;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (item == null)
            getFragmentManager().beginTransaction().remove(this).commit();

        TextView id = view.findViewById(R.id.id);
        id.setText(String.valueOf(item.getId()));
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(getContext().getDrawable(getResources().getIdentifier("i" + item.getImageId(), "drawable", getContext().getPackageName())));
        TextView name = view.findViewById(R.id.name);
        name.setText(item.getName());
        TextView activation = view.findViewById(R.id.actication);
        activation.setText(item.getActivation());
        TextView description = view.findViewById(R.id.description);
        description.setText(item.getDescription());
        TextView effect = view.findViewById(R.id.effect);
        effect.setText(item.getEffect());

        ListView itemPoolList = view.findViewById(R.id.itempoolList);
        ItemPoolHasItemDao itemPoolHasItemDao = AppDatabase.getAppDatabase(getContext()).itemPoolHasItemDao();
        for (ItemPool itemPool : itemPoolHasItemDao.getItemHasItemPools(item.getId())) {
            itemPoolEntries.add(createItemPoolView(itemPool, itemPoolList));
        }
        itemPoolList.setAdapter(new ViewAdapter(itemPoolEntries));

        TextView unlock = view.findViewById(R.id.unlocks);
        ListView unlocks = view.findViewById(R.id.unlockList);

        AchievementDao achievementDao = AppDatabase.getAppDatabase(getContext()).achievementDao();
        List<Achievement> achievements = achievementDao.getAchievementForItem(item.getId());
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

    private View createItemPoolView(final ItemPool itemPool, ListView container) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_itempool, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(itemPool.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemPoolDialog.newInstance(itemPool).show(getFragmentManager(), ItemPoolDialog.TAG);
            }
        });
        return view;
    }

}
