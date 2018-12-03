package deus.seow.de.boidb.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.db.AppDatabase;
import deus.seow.de.boidb.db.entity.Achievement;

public class AchievementAdapter extends BaseAdapter {

    private List<Achievement> achievements;
    private LayoutInflater inflater;
    private Resources resources;
    private Context context;
    private String packageName;
    private Callback callback;
    private SharedPreferences prefs;
    private AppDatabase db;

    public interface Callback {
        void achievementSelected(Achievement achievement);
    }

    public AchievementAdapter(Context context, Callback callback) {
        this(context, callback, null);
    }

    public AchievementAdapter(Context context, Callback callback, List<Achievement> achievements) {
        db = AppDatabase.getAppDatabase(context);
        if (achievements != null)
            this.achievements = achievements;
        else
            this.achievements = db.achievementDao().getAchievements();

        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        packageName = context.getPackageName();
        this.context = context;
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return achievements.size();
    }

    @Override
    public Achievement getItem(int position) {
        return achievements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView == null) ? inflater.inflate(R.layout.item_achievement, parent, false) : convertView;
        final Achievement achievement = getItem(position);
        final TextView name = view.findViewById(R.id.name);
        name.setText(achievement.getName());
        if (prefs.getBoolean("a" + achievement.getId(), false))
            name.setTextColor(Color.GREEN);
        else
            name.setTextColor(Color.RED);
        TextView description = view.findViewById(R.id.description);
        description.setText(achievement.getDescription());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("a" + achievement.getId(), "drawable", packageName)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.achievementSelected(achievement);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!prefs.getBoolean("a" + achievement.getId(), false)) {
                    prefs.edit().putBoolean("a" + achievement.getId(), true).apply();
                    name.setTextColor(Color.GREEN);
                } else {
                    prefs.edit().putBoolean("a" + achievement.getId(), false).apply();
                    name.setTextColor(Color.RED);
                }
                System.out.println("do stuff");
                return true;
            }
        });
        return view;
    }

    public void resetFilters() {
        achievements = db.achievementDao().getAchievements();
        notifyDataSetChanged();
    }

    public void applyFilter(String filter) {
        achievements = db.achievementDao().filter("%" + filter + "%");
        notifyDataSetChanged();
    }
}
