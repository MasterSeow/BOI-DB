package deus.seow.de.boidb.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.entity.Item;

public class ItemAdapter extends BaseAdapter {

    AppDatabase db;
    private List<Item> items;
    private LayoutInflater inflater;
    private Resources resources;
    private String packageName;
    private Context context;
    private Callback callback;

    public interface Callback {
        void itemSelected(Item item);
    }

    public ItemAdapter(Context context, Callback callback) {
        this(context, callback, null);
    }

    public ItemAdapter(Context context, Callback callback, List<Item> items) {
        db = AppDatabase.getAppDatabase(context);
        if (items != null)
            this.items = items;
        else
            this.items = db.itemDao().getItems();

        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        packageName = context.getPackageName();
        this.context = context;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_item, parent, false) : convertView;
        final Item item = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(item.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(item.getDescription());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("i" + item.getImageId(), "drawable", packageName)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.itemSelected(item);
            }
        });
        return view;
    }

    public void resetFilters() {
        items = db.itemDao().getItems();
        notifyDataSetChanged();
    }

    public void applyFilter(String filter) {
        items = db.itemDao().filter("%" + filter + "%");
        notifyDataSetChanged();
    }
}
