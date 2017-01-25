package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import konek.com.konekandroid.R;
import model.Event;
import model.User;

/**
 * Created by riyan on 1/4/17.
 */

public class JoinedUserAdapter extends RecyclerView.Adapter<JoinedUserAdapter.UserHolder> {
    private ArrayList<User> itemsList;
    private Context mContext;

    public JoinedUserAdapter(Context context, ArrayList<User> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_joined_user, null);
        UserHolder mh = new UserHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int i) {
        User singleItem = itemsList.get(i);
        //holder.title.setText(singleItem.getEventTitle());
        Picasso.with(mContext)
                .load(singleItem.getProfilePicture())
                .fit()
                .into(holder.user);
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        public RelativeLayout rlEvent;
        public ImageButton user;
        public UserHolder(View view) {
            super(view);

            //set view
            rlEvent = (RelativeLayout) view.findViewById(R.id.rlEvent);
            user = (ImageButton) view.findViewById(R.id.circleUserImage);

        }

    }
}
