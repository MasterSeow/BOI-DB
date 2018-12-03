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
import deus.seow.de.boidb.db.entity.Monster;

public class MonsterAdapter extends BaseAdapter {

    private List<Monster> monsters;
    private LayoutInflater inflater;
    private Resources resources;
    private String packageName;
    private Context context;

    public MonsterAdapter(Context context) {
        monsters = AppDatabase.getAppDatabase(context).monsterDao().getMonsters();
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        packageName = context.getPackageName();
        this.context = context;
    }

    @Override
    public int getCount() {
        return monsters.size();
    }

    @Override
    public Monster getItem(int position) {
        return monsters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_monster, parent, false) : convertView;
        Monster monster = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(monster.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(monster.getDescription());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("m" + monster.getId(), "drawable", packageName)));
        return view;
    }
}
