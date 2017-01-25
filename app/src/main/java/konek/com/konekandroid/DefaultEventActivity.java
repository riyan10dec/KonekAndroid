package konek.com.konekandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import adapters.CategoryListAdapter;
import adapters.EventListAdapter;
import model.Category;
import model.Event;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DefaultEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //call api
//        try{
//            OkHttpClient client = new OkHttpClient();
//
//            Request request = new Request.Builder()
//                    .url(getText(R.string.defaultEventRequest).toString())
//                    .build();
//            Response response = client.newCall(request).execute();
//            String result = response.body().toString();
//            Gson gson = new GsonBuilder().create();
//            Type type = new TypeToken<List<Event>>(){}.getType();
//            List<Event> eventList = gson.fromJson(result,type);
//            //iterate list
//            EventListAdapter eventListAdapter = new EventListAdapter(eventList);
//            ListView listView = (ListView) findViewById(R.id.defaultEventList);
//            listView.setAdapter(eventListAdapter);
//        }
//        catch (Exception e){
//            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
//        }
    }
}
