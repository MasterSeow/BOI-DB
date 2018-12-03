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
import deus.seow.de.boidb.db.entity.Pill;

public class PillAdapter extends BaseAdapter {

    private List<Pill> pills;
    private LayoutInflater inflater;

    public PillAdapter(Context context) {
        pills = AppDatabase.getAppDatabase(context).pillDao().gettPills();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pills.size();
    }

    @Override
    public Pill getItem(int position) {
        return pills.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_pill, parent, false) : convertView;
        Pill pill = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(pill.getName());
        TextView effect = view.findViewById(R.id.effect);
        effect.setText(pill.getEffect());
        return view;
    }
}
