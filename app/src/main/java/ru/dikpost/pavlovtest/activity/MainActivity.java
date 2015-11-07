package ru.dikpost.pavlovtest.activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import ru.dikpost.pavlovtest.R;
import ru.dikpost.pavlovtest.common.Constants;
import ru.dikpost.pavlovtest.common.StorageSingleton;
import ru.dikpost.pavlovtest.fragment.DetailViewFragment;
import ru.dikpost.pavlovtest.fragment.ImageListFragment;
import ru.dikpost.pavlovtest.service.DataService;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "PavlovTest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        int frIndex = getIntent().getIntExtra(Constants.Extra.FRAGMENT_INDEX, 0);
        int pos = getIntent().getIntExtra(Constants.Extra.DATA_POSITION, 0);
        Fragment fr;
        String tag;

        switch (frIndex) {
            default:
            case ImageListFragment.INDEX:
                tag = ImageListFragment.class.getSimpleName();
                fr = getFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new ImageListFragment();
                }
                break;
            case DetailViewFragment.INDEX:
                tag = DetailViewFragment.class.getSimpleName();
                fr = getFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = DetailViewFragment.newInstance( pos );
                }
                break;
        }

        getFragmentManager().beginTransaction().replace(android.R.id.content, fr, tag).commit();

       // if(StorageSingleton.getInstance().getData() == null ) {


       // }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
