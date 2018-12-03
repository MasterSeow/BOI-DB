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
import deus.seow.de.boidb.adapter.ItemPoolAdapter;
import deus.seow.de.boidb.db.entity.ItemPool;
import deus.seow.de.boidb.ui.dialog.ItemPoolDialog;

public class ItemPoolFragment extends Fragment implements ItemPoolAdapter.Callback {

    public static ItemPoolFragment newInstance() {

        Bundle args = new Bundle();

        ItemPoolFragment fragment = new ItemPoolFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_itempool, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(new ItemPoolAdapter(getContext(), this));
    }

    @Override
    public void itemPoolSelected(ItemPool itemPool) {
        ItemPoolDialog.newInstance(itemPool).show(getFragmentManager(), ItemPoolDialog.TAG);
    }
}
