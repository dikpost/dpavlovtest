package ru.dikpost.pavlovtest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import ru.dikpost.pavlovtest.R;
import ru.dikpost.pavlovtest.common.Constants;
import ru.dikpost.pavlovtest.common.StorageSingleton;
import ru.dikpost.pavlovtest.model.Item;

/**
 * Created by oracle on 11/6/15.
 */
public class DetailViewFragment extends Fragment {

    public static final int INDEX = 1;
    int position;

    TextView textDescr;
    ImageView image;

    Item itemData;

    public static DetailViewFragment newInstance( int pos ) {
        DetailViewFragment fragment = new DetailViewFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable( "position", pos );

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        textDescr = (TextView) v.findViewById(R.id.item_desc);
        image = (ImageView) v.findViewById(R.id.item_image );

        position = getArguments().getInt("position", 0);
        itemData = StorageSingleton.getInstance().getData().get( position );
        if( itemData != null){

            ImageLoader.getInstance().displayImage( itemData.getImageItem(), image );
            textDescr.setText( itemData.getTitle75() );
        }

        if( Constants.DEBUG ) Log.d("DetailViewFragment","args: " + position );

        return v;
    }

}
