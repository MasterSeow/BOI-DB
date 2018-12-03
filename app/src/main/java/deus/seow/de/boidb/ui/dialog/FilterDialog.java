package deus.seow.de.boidb.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.AchievementAdapter;
import deus.seow.de.boidb.db.entity.Achievement;

public class FilterDialog extends DialogFragment implements AchievementAdapter.Callback {
    public static final String TAG = FilterDialog.class.getSimpleName();
    private Callback callback;

    public interface Callback {
        void filterSelected(String filter);
    }

    public static FilterDialog newInstance(Callback callback) {
        FilterDialog fragment = new FilterDialog();
        fragment.callback = callback;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText filterET = view.findViewById(R.id.textFilter);
        Button applyButton = view.findViewById(R.id.applyButton);
        final FilterDialog filterDialog = this;
        if (callback == null)
            getFragmentManager().beginTransaction().remove(filterDialog).commit();

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.filterSelected(filterET.getText().toString());
                getFragmentManager().beginTransaction().remove(filterDialog).commit();
            }
        });

    }

    @Override
    public void achievementSelected(Achievement achievement) {
        AchievementDialog.newInstance(achievement).show(getFragmentManager(), AchievementDialog.TAG);
    }
}
