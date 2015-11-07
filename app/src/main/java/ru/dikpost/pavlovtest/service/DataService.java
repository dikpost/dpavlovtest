package ru.dikpost.pavlovtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import ru.dikpost.pavlovtest.common.Constants;
import ru.dikpost.pavlovtest.common.StorageSingleton;
import ru.dikpost.pavlovtest.model.IncomData;
import ru.dikpost.pavlovtest.request.ApiMethods;

/**
 * Created by oracle on 11/7/15.
 */
public class DataService extends Service {

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("DataService", "DataService onStartCommand");

//        int offset = intent.getIntExtra("offset", 0);
//        int limit = intent.getIntExtra("limit", 10);

        initRetrofit( 0, 10);


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // инициализация retrofit ля асинхронного получения данных
    private void initRetrofit( int offset, int limit ){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMethods apiService = retrofit.create(ApiMethods.class);
        Call call = apiService.getData( offset, limit );

        call.enqueue(new Callback<IncomData>() {

            @Override
            public void onResponse(Response<IncomData> response) {
                IncomData model = response.body();

                if (model == null) {
                    //404 or the response cannot be converted to User.
                    if (Constants.DEBUG) Log.d("DataService", "404 or can not convert response");

                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            if (Constants.DEBUG)
                                Log.d("DataService", "responseBody = " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (Constants.DEBUG) Log.d("DataService", "responseBody = null");
                    }
                } else {
                    //200
                    StorageSingleton.getInstance().setData(model.getResult().getData().getItems() );

                    Intent intent = new Intent();
                    intent.setAction( Constants.Extra.BROADCAST_ACTION );
                    intent.putExtra("operation","data_received");
                    sendBroadcast(intent);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (Constants.DEBUG) Log.d("DataService", "retrofit failure: t = " + t.getMessage());
            }
        });

    } // initRetrofit()

}
