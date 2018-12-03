package deus.seow.de.boidb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ListView;

import deus.seow.de.boidb.R;
import deus.seow.de.boidb.adapter.ItemAdapter;
import deus.seow.de.boidb.db.entity.Item;
import deus.seow.de.boidb.ui.dialog.FilterDialog;
import deus.seow.de.boidb.ui.dialog.ItemDialog;

public class ItemFragment extends Fragment implements ItemAdapter.Callback, FilterDialog.Callback {

    private ItemAdapter itemAdapter;

    public static ItemFragment newInstance() {

        Bundle args = new Bundle();

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        ListView list = view.findViewById(R.id.list);
        itemAdapter = new ItemAdapter(getContext(), this);
        list.setAdapter(itemAdapter);
    }

    @Override
    public void itemSelected(Item item) {
        ItemDialog.newInstance(item).show(getFragmentManager(), ItemDialog.TAG);
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
                itemAdapter.resetFilters();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void filterSelected(String filter) {
        itemAdapter.applyFilter(filter);
    }
}
