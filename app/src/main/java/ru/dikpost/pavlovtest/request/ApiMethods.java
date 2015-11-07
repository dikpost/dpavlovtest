package ru.dikpost.pavlovtest.request;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import ru.dikpost.pavlovtest.model.IncomData;

/**
 * Created by oracle on 11/6/15.
 */
public interface ApiMethods {

        @GET( "/api/?api_key=ca3e173c79f471cc04d53ce6b349d9cf&city_id=1&method=get_offer_coupons&category_id=26" )
        Call<IncomData> getData(@Query("offset") int offset, @Query("limit") int limit/*, Callback<Result> cb*/ );

}
