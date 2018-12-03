package deus.seow.de.boidb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ListView;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.AchievementAdapter;
import deus.seow.de.boidb.db.entity.Achievement;
import deus.seow.de.boidb.ui.dialog.AchievementDialog;
import deus.seow.de.boidb.ui.dialog.FilterDialog;

public class AchievementFragment extends Fragment implements AchievementAdapter.Callback, FilterDialog.Callback {

    AchievementAdapter achievementAdapter;

    public static AchievementFragment newInstance() {

        Bundle args = new Bundle();

        AchievementFragment fragment = new AchievementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_achievement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        ListView list = view.findViewById(R.id.list);
        achievementAdapter = new AchievementAdapter(getContext(), this);
        list.setAdapter(achievementAdapter);
    }

    @Override
    public void achievementSelected(Achievement achievement) {
        AchievementDialog.newInstance(achievement).show(getFragmentManager(), AchievementDialog.TAG);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filter, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_option_filter:
                FilterDialog.newInstance(this).show(getFragmentManager(), FilterDialog.TAG);
                return true;
            case R.id.menu_option_reset_filter:
                achievementAdapter.resetFilters();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void filterSelected(String filter) {
        achievementAdapter.applyFilter(filter);
    }
}
