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
import deus.seow.de.boidb.db.entity.Seed;

public class SeedAdapter extends BaseAdapter {

    private List<Seed> seeds;
    private LayoutInflater inflater;

    public SeedAdapter(Context context) {
        seeds = AppDatabase.getAppDatabase(context).seedDao().getSeeds();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return seeds.size();
    }

    @Override
    public Seed getItem(int position) {
        return seeds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_seed, parent, false) : convertView;
        Seed seed = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(seed.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(seed.getDescription().replace(" - ", "\n"));
        TextView effect = view.findViewById(R.id.effect);
        effect.setText(seed.getEffect());
        return view;
    }
}
