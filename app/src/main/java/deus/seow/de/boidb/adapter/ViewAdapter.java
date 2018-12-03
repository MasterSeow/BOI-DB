package deus.seow.de.boidb.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ViewAdapter extends BaseAdapter {
    private List<View> entries;

    public ViewAdapter(List<View> entries) {
        this.entries = entries;
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return entries.get(position);
    }

    public void setEntries(List<View> newEntries) {
        this.entries = newEntries;
        notifyDataSetChanged();
    }

}
