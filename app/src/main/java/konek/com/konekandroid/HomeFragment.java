package konek.com.konekandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import adapters.EditorsPickAdapter;
import adapters.RecyclerViewDataAdapter;
import model.EditorsPick;
import model.Event;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment {
    int mNum;
    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static HomeFragment newInstance(int num) {
        HomeFragment f = new HomeFragment();

        return new HomeFragment();
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */

    ArrayList<EditorsPick> allSampleData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
//        //call api
        try{
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(getText(R.string.eventFeedRequest).toString())
                    .header("id","administrator")
                    .header("x-access-token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYnNvbnR5cGUiOiJPYmplY3RJRCIsImlkIjoiV8KjT2XDrmrClFjDlsKHw6okIiwiaWF0IjoxNDc5OTE1OTEyfQ.rKqWPl2Ki4FMqA_YVuzKT3nPeO3DNIw6IHHUHazBK3o")
                    .build();
            Response response = client.newCall(request).execute();

            String result = response.body().string();
            Gson gson = new GsonBuilder().create();
            Type type = new TypeToken<List<EditorsPick>>(){}.getType();
            final ArrayList<EditorsPick> editorsPickList = gson.fromJson(result,type);

            RecyclerView my_recycler_view = (RecyclerView) v.findViewById(R.id.my_recycler_view);

            my_recycler_view.addOnItemTouchListener(
                    new RecyclerItemClickListener(getContext(), my_recycler_view ,new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // do whatever
                        }

                        @Override public void onLongItemClick(View view, int position) {
                            // do whatever
                        }
                    })
            );
            RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getContext(), editorsPickList);

            my_recycler_view.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));

            my_recycler_view.setAdapter(adapter);

        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT);
        }
        return v;
    }
}
