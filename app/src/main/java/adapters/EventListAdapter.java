package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import konek.com.konekandroid.R;
import model.Category;
import model.Event;

/**
 * Created by riyan on 10/20/16.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder>{
    private List<Event> eventsList;

    public class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public EventViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public EventListAdapter(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_event, parent, false);

        EventViewHolder viewHolder = new EventViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.title.setText(event.getTitle());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}
