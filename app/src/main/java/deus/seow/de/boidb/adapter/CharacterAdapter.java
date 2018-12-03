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
import deus.seow.de.boidb.db.entity.Character;

public class CharacterAdapter extends BaseAdapter {

    private List<Character> characters;
    private LayoutInflater inflater;
    private Resources resources;
    private String packageName;
    private Context context;


    public CharacterAdapter(Context context) {
        characters = AppDatabase.getAppDatabase(context).characterDao().getCharacters();
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        packageName = context.getPackageName();
        this.context = context;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Character getItem(int position) {
        return characters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_character, parent, false) : convertView;
        Character character = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(character.getName());
        TextView unlock = view.findViewById(R.id.unlock);
        unlock.setText(character.getUnlock());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("c" + character.getId() + "_drawn", "drawable", packageName)));
        return view;
    }
}
