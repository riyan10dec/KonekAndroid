package konek.com.konekandroid;

import android.content.ReceiverCallNotAllowedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import adapters.EventListAdapter;
import adapters.RecyclerViewDataAdapter;
import model.EditorsPick;
import model.Event;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListEventActivity extends AppCompatActivity {

    private EndlessRecyclerViewScrollListener scrollListener;
    private String editorsPickId;
    RecyclerView eventsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_default_event);
        String title = (String) getIntent().getExtras().getString("title");
        editorsPickId = (String) getIntent().getExtras().getString("editorsPickId");
        TextView titleTextView = (TextView) findViewById(R.id.itemTitleDefault);
        titleTextView.setText(title);
        //load events
        eventsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_list_default);
        //initialize item
        final List<Event> eventList = loadNextDataFromApi(0);
        final EventListAdapter eventListAdapter = new EventListAdapter(eventList);
        eventsRecyclerView.setAdapter(eventListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventsRecyclerView.setLayoutManager(linearLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                List<Event> eventList2 = loadNextDataFromApi(page);
                final int curSize = eventListAdapter.getItemCount();
                eventList.addAll(eventList2);

                view.post(new Runnable() {
                    @Override
                    public void run() {
                        eventListAdapter.notifyItemRangeInserted(curSize, eventList.size() - 1);
                    }
                });
            }
        };
          eventsRecyclerView.addOnScrollListener(scrollListener);
    }
    public List<Event> loadNextDataFromApi(int page){
        String result = "";
        try{
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(getText(R.string.eventListRequest).toString().replace("@id",editorsPickId).replace("@page",Integer.toString(page)))
                    .header("id",getText(R.string.loginid).toString())
                    .header("x-access-token",getText(R.string.token).toString())
                    .build();
            Response response = client.newCall(request).execute();

            result = response.body().string();
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);

        }
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<List<EditorsPick>>(){}.getType();
        final ArrayList<EditorsPick> editorsPicks = gson.fromJson(result,type);
        return editorsPicks.get(0).getAllItemsInSection();
    }
}
