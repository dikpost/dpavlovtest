package ru.dikpost.pavlovtest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
//import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ru.dikpost.pavlovtest.R;
import ru.dikpost.pavlovtest.model.ListItem;
import ru.dikpost.pavlovtest.model.Price;

/**
 * Created by oracle on 11/6/15.
 */
public class ImageAdapter extends   BaseAdapter /*ArrayAdapter<ListItem>*/ {

 //   private int layoutResId;
    private LayoutInflater inflater;
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    private ArrayList<ListItem> itemsList;
    private DisplayImageOptions options;

   // public ImageAdapter(){}
    public ImageAdapter(Context context,  ArrayList<ListItem> items) {

        itemsList = items;
        inflater = LayoutInflater.from(context);

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new SimpleBitmapDisplayer()) //(Color.WHITE, 5))
                .build();
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_list_item, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) view.findViewById(R.id.item_price);
            holder.image = (ImageView) view.findViewById(R.id.item_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        float price = itemsList.get(position).getItemPrice();
        holder.text.setText("Price: " + String.valueOf(price));

        ImageLoader.getInstance().displayImage(itemsList.get(position).getImageUrl(), holder.image, options, animateFirstListener);

        return view;
    }


 public class ViewHolder {
    TextView text;
    ImageView image;
}

 public class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

    List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        if (loadedImage != null) {
            ImageView imageView = (ImageView) view;
            boolean firstDisplay = !displayedImages.contains(imageUri);
            if (firstDisplay) {
                FadeInBitmapDisplayer.animate(imageView, 500);
                displayedImages.add(imageUri);
            }
        }
    }
  }
}
