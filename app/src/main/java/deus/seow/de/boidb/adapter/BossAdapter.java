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
import deus.seow.de.boidb.db.entity.Boss;

public class BossAdapter extends BaseAdapter {

    private List<Boss> bosses;
    private LayoutInflater inflater;
    private Resources resources;
    private Context context;
    private String packageName;

    public BossAdapter(Context context) {
        bosses = AppDatabase.getAppDatabase(context).bossDao().getBosses();
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        this.context = context;
        packageName = context.getPackageName();
    }

    @Override
    public int getCount() {
        return bosses.size();
    }

    @Override
    public Boss getItem(int position) {
        return bosses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_boss, parent, false) : convertView;
        Boss boss = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(boss.getName());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("b" + boss.getId(), "drawable", packageName)));
        return view;
    }
}
