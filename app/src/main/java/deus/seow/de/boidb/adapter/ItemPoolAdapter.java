package deus.seow.de.boidb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.entity.ItemPool;

public class ItemPoolAdapter extends BaseAdapter {

    private List<ItemPool> itemsPools;
    private LayoutInflater inflater;
    private Callback callback;

    public interface Callback {
        void itemPoolSelected(ItemPool itemPool);
    }

    public ItemPoolAdapter(Context context, Callback callback) {
        itemsPools = AppDatabase.getAppDatabase(context).itemPoolDao().getItemPools();
        inflater = LayoutInflater.from(context);
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return itemsPools.size();
    }

    @Override
    public ItemPool getItem(int position) {
        return itemsPools.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_itempool, parent, false) : convertView;
        final ItemPool itemPool = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(itemPool.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.itemPoolSelected(itemPool);
            }
        });
        return view;
    }
}
