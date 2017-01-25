package adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import konek.com.konekandroid.CategoryActivity;
import konek.com.konekandroid.EventDetailActivity;
import konek.com.konekandroid.HomeActivity;
import konek.com.konekandroid.R;
import model.Event;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<Event> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<Event> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_defaultevent, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        Event singleItem = itemsList.get(i);
        holder.title.setText(singleItem.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        public RelativeLayout rlEvent;
        public TextView seen;
        public TextView title;
        public TextView eventPlace;
        public TextView eventDate;
        public TextView shared;
        public TextView loved;

        public SingleItemRowHolder(View view) {
            super(view);

            //set view
             rlEvent = (RelativeLayout) view.findViewById(R.id.rlEvent);
             seen = (TextView) view.findViewById(R.id.viewCount);
             title = (TextView) view.findViewById(R.id.eventTitle);
             eventPlace = (TextView) view.findViewById(R.id.eventPlaceText);
             eventDate = (TextView) view.findViewById(R.id.eventTimeText);
             shared = (TextView) view.findViewById(R.id.shared);
             loved = (TextView) view.findViewById(R.id.loved);
        }

    }

}