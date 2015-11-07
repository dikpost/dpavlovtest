
package ru.dikpost.pavlovtest.model;

//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class IncomData {

    @Expose
    private Result result;

    /**
     * 
     * @return
     *     The result
     */
    public Result getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(Result result) {
        this.result = result;
    }

    /// class Result

    public class Result {

        @Expose
        private Integer error;
        @Expose
        private String count;
        @Expose
        private Data data;

        @SerializedName("data_time")
        @Expose
        private String dataTime;

        @SerializedName("serialized_time")
        @Expose
        private String serializedTime;

        @SerializedName("current_time")
        @Expose
        private String currentTime;

        /**
         *
         * @return
         *     The error
         */
        public Integer getError() {
            return error;
        }

        /**
         *
         * @param error
         *     The error
         */
        public void setError(Integer error) {
            this.error = error;
        }

        /**
         *
         * @return
         *     The count
         */
        public String getCount() {
            return count;
        }

        /**
         *
         * @param count
         *     The count
         */
        public void setCount(String count) {
            this.count = count;
        }

        /**
         *
         * @return
         *     The data
         */
        public Data getData() {
            return data;
        }

        /**
         *
         * @param data
         *     The data
         */
        public void setData(Data data) {
            this.data = data;
        }

        /**
         *
         * @return
         *     The dataTime
         */
        public String getDataTime() {
            return dataTime;
        }

        /**
         *
         * @param dataTime
         *     The data_time
         */
        public void setDataTime(String dataTime) {
            this.dataTime = dataTime;
        }

        /**
         *
         * @return
         *     The serializedTime
         */
        public String getSerializedTime() {
            return serializedTime;
        }

        /**
         *
         * @param serializedTime
         *     The serialized_time
         */
        public void setSerializedTime(String serializedTime) {
            this.serializedTime = serializedTime;
        }

        /**
         *
         * @return
         *     The currentTime
         */
        public String getCurrentTime() {
            return currentTime;
        }

        /**
         *
         * @param currentTime
         *     The current_time
         */
        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

    }

    // clase Data

    public class Data {

        @Expose
        private List<Item> items = new ArrayList<Item>();

        /**
         *
         * @return
         *     The items
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         *
         * @param items
         *     The items
         */
        public void setItems(List<Item> items) {
            this.items = items;
        }

    } // class Data

}
