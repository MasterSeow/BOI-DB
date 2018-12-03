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
import deus.seow.de.boidb.db.entity.Card;

public class CardAdapter extends BaseAdapter {

    private List<Card> cards;
    private LayoutInflater inflater;
    private Resources resources;
    private Context context;
    private String packageName;
    private Callback callback;

    public interface Callback {
        void cardSelected(Card card);
    }

    public CardAdapter(Context context, Callback callback) {
        cards = AppDatabase.getAppDatabase(context).cardDao().getCards();
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        this.context = context;
        this.callback = callback;
        packageName = context.getPackageName();
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ? inflater.inflate(R.layout.item_card, parent, false) : convertView;
        final Card card = getItem(position);
        TextView name = view.findViewById(R.id.name);
        name.setText(card.getName());
        TextView description = view.findViewById(R.id.description);
        description.setText(card.getMessage());
        ImageView image = view.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(resources.getIdentifier("r" + card.getId(), "drawable", packageName)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.cardSelected(card);
            }
        });
        return view;
    }
}
