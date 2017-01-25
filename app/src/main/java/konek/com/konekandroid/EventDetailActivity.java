package konek.com.konekandroid;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.*;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapters.JoinedUserAdapter;
import model.EditorsPick;
import model.Event;
import model.User;

public class EventDetailActivity  extends AppCompatActivity implements Serializable {
    public Event getEp() {
        return ep;
    }

    public void setEp(Event ep) {
        this.ep = ep;
    }

    Event ep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetail);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null)
            ep = (Event) b.getSerializable("item");
        //Event ep = (Event) intent.getSerializableExtra("item");
        ImageView imageTitle = (ImageView) findViewById(R.id.eventDetailImage);
        //imageTitle.setImageBitmap(ep.getImagePath());]
        Picasso.with(EventDetailActivity.this)
                .setLoggingEnabled(true);
        Picasso.with(EventDetailActivity.this)
                .load(ep.getImagePath())
                .fit()
                .into(imageTitle);
        TextView eventTitle = (TextView) findViewById(R.id.eventDetailTitle);
        eventTitle.setText(ep.getEventTitle());

        TextView eventDate = (TextView) findViewById(R.id.eventDetailDate);
        eventDate.setText(ep.getEventDate());

        TextView eventPlace = (TextView) findViewById(R.id.eventDetailPlace);
        eventPlace.setText(ep.getEventPlace());

        TextView eventHost = (TextView) findViewById(R.id.eventDetailHoster);
        eventHost.setText(ep.getPosterName());

        TextView eventDesc = (TextView) findViewById(R.id.eventDetailDescContent);
        eventDesc.setText(ep.getDescription());
        ArrayList<User> joinedUsers = new ArrayList<User>(ep.getJoinedUser());
        JoinedUserAdapter joinedUserAdapter = new JoinedUserAdapter(this, joinedUsers);
        RecyclerView joinedUserRecycler = (RecyclerView) findViewById(R.id.recyclerEventDetailJoinedUser);
        joinedUserRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        joinedUserRecycler.setAdapter(joinedUserAdapter);

        try{

            GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            LatLng position = new LatLng(Float.valueOf(ep.getLatitude()), Float.valueOf(ep.getLatitude()));
            Marker marker = map.addMarker(new MarkerOptions()
                    .position(position)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
            .title(ep.getEventPlace()));

            // Move the camera instantly to hamburg with a zoom of 15.
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));

            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        }catch (Exception e){
            Log.e("a",e.getMessage(),e);
        }
    }
}
