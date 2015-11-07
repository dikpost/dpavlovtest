package ru.dikpost.pavlovtest.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import ru.dikpost.pavlovtest.R;
import ru.dikpost.pavlovtest.activity.MainActivity;
import ru.dikpost.pavlovtest.adapter.ImageAdapter;
import ru.dikpost.pavlovtest.common.Constants;

import ru.dikpost.pavlovtest.common.StorageSingleton;
import ru.dikpost.pavlovtest.model.IncomData;
import ru.dikpost.pavlovtest.model.Item;
import ru.dikpost.pavlovtest.model.ListItem;
import ru.dikpost.pavlovtest.request.ApiMethods;
import ru.dikpost.pavlovtest.service.DataService;

/**
 * A placeholder fragment containing a simple view.
 */
public class ImageListFragment extends Fragment {

    private static final String LOG = "PavlovTest";
 //   public static final String FRAGMENT_NAME = "imageListFragment";
    public static final int INDEX = 0;

    private AbsListView listView;
    ArrayList<ListItem> itemsList;
    ImageAdapter imageAdapter;
    DataBroadcastReceiver dataBroadcastReceiver;

    public ImageListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        if( Constants.DEBUG ) Log.d(LOG, "ImageListFragment.onCreateView()");

        listView = (ListView) v.findViewById(android.R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (Constants.DEBUG) Log.d(LOG, "onItemClict: position = " + position);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, DetailViewFragment.INDEX);
                intent.putExtra(Constants.Extra.DATA_POSITION, position);
                startActivity(intent);
            }
        });



        return v;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( Constants.DEBUG) Log.d(LOG, "ImageListFragment.onCreate()");

        dataBroadcastReceiver = new DataBroadcastReceiver();



    }

    @Override
    public void onResume() {
        super.onResume();
        if( Constants.DEBUG) Log.d(LOG, "ImageListFragment.onResume()");
        getActivity().registerReceiver(this.dataBroadcastReceiver, new IntentFilter( Constants.Extra.BROADCAST_ACTION ));

        updateUI();
    }

    @Override
    public void onStart(){
        super.onStart();
        if( Constants.DEBUG) Log.d(LOG, "ImageListFragment.onStart()");


    }

    @Override
    public void onPause(){
        super.onPause();
        if( Constants.DEBUG ) Log.d(LOG, "ImageListFragment.onPause()");
         ImageLoader.getInstance().stop();

        getActivity().unregisterReceiver( dataBroadcastReceiver );
    }

    @Override
    public void onStop(){
        super.onStop();
        if( Constants.DEBUG ) Log.d(LOG, "ImageListFragment.onStop()");
       // ImageLoader.getInstance().stop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if( Constants.DEBUG ) Log.d(LOG, "ImageListFragment.onDestroy()");


    }

    class DataBroadcastReceiver extends BroadcastReceiver {

        public void onReceive( Context context, Intent intent ){

            String op = intent.getStringExtra("operation");
            Log.d("DataServoce", "onReceive()");

            if( "data_received".equals( op )) updateUI();
        }

    }


    private void updateUI(){

        if(StorageSingleton.getInstance().getData() == null ) return;

        itemsList = new ArrayList<>();
        if( StorageSingleton.getInstance().getData().size() > 0) {
            for( Item item : StorageSingleton.getInstance().getData()) {
                itemsList.add(new ListItem( item.getOriginPrice().getAmount(), item.getImageItem()));
            }
        }

        imageAdapter = new ImageAdapter( getActivity(), itemsList );
        listView.setAdapter(imageAdapter);
    }



} // class MainActivityFragment
