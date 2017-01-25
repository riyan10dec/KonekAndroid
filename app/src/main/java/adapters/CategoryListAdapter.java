package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import konek.com.konekandroid.R;
import model.Category;

/**
 * Created by riyan on 10/20/16.
 */

public class CategoryListAdapter extends BaseAdapter{
    private List<Category> categoryList;
    private Context context;
    private LayoutInflater layoutInflater;
    private List<LinearLayout> eventList;

    public CategoryListAdapter(Context context, List<Category> categoryList) {
        this.categoryList = categoryList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_event,null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(categoryList.get(position).getCategoryName());

        //set events
        LinearLayout event;
        LinearLayout eventList = (LinearLayout) convertView.findViewById(R.id.containerEvents);
        for(int i=0; i < (int)R.string.eventItemPerCategory;i++){
            event = (LinearLayout) convertView.findViewById(R.id.defaultEvent);
            eventList.addView(event);
        }
        return null;
    }
}
