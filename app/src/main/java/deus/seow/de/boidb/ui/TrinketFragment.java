package deus.seow.de.boidb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.TrinketAdapter;
import deus.seow.de.boidb.db.entity.Trinket;
import deus.seow.de.boidb.ui.dialog.TrinketDialog;

public class TrinketFragment extends Fragment implements TrinketAdapter.Callback {

    public static TrinketFragment newInstance() {

        Bundle args = new Bundle();

        TrinketFragment fragment = new TrinketFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trinket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(new TrinketAdapter(getContext(), this));
    }

    @Override
    public void trinketSelected(Trinket trinket) {
        TrinketDialog.newInstance(trinket).show(getFragmentManager(), TrinketDialog.TAG);
    }
}
