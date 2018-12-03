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
import deus.seow.de.boidb.db.entity.Trinket;

public class TrinketAdapter extends BaseAdapter {

    private List<Trinket> trinkets;
    private LayoutInflater inflater;
    private Resources resources;
    private String packageName;
    private Context context;
    private Callback callback;

    public interface Callback {
        void trinketSelected(Trinket trinket);
    }

    public TrinketAdapter(Context context, Callback callback) {
        trinkets = AppDatabase.getAppDatabase(context).trinketDao().getTrinkets();
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        packageName = context.getPackageName();
        this.context = context;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return trinkets.size();
    }

    @Override
    public Trinket getItem(int position) {
        return trinkets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_trinket, parent, false) : convertView;
        final Trinket trinket = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(trinket.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(trinket.getDescription());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("t" + trinket.getImageId(), "drawable", packageName)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.trinketSelected(trinket);
            }
        });
        return view;
    }
}
