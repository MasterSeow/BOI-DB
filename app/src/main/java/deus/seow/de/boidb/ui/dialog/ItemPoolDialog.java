package deus.seow.de.boidb.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.ItemAdapter;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.dao.ItemPoolHasItemDao;
import deus.seow.de.boidb.db.entity.Item;
import deus.seow.de.boidb.db.entity.ItemPool;

public class ItemPoolDialog extends DialogFragment implements ItemAdapter.Callback {
    public static final String TAG = ItemPoolDialog.class.getSimpleName();

    private ItemPool itemPool;
    private List<View> entries = new ArrayList<>(0);

    public static ItemPoolDialog newInstance(ItemPool itemPool) {
        ItemPoolDialog fragment = new ItemPoolDialog();
        fragment.itemPool = itemPool;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_itempool, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (itemPool == null)
            getFragmentManager().beginTransaction().remove(this).commit();

        TextView name = view.findViewById(R.id.name);
        name.setText(itemPool.getName());

        ListView itemList = view.findViewById(R.id.item_list);

        ItemPoolHasItemDao itemPoolHasItemDao = AppDatabase.getAppDatabase(getContext()).itemPoolHasItemDao();
        itemList.setAdapter(new ItemAdapter(getContext(), this, itemPoolHasItemDao.getItemPoolHasItems(itemPool.getId())));
    }

    @Override
    public void itemSelected(Item item) {
        ItemDialog.newInstance(item).show(getFragmentManager(), ItemDialog.TAG);
    }
}
