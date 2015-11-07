package ru.dikpost.pavlovtest.common;

import java.util.List;

import ru.dikpost.pavlovtest.model.Item;

/**
 * Created by oracle on 11/6/15.
 */
public class StorageSingleton {

    private static StorageSingleton instance = null;
    List<Item> data = null;

    public static StorageSingleton getInstance(){

        if( instance == null ){
            instance = new StorageSingleton();
        }
        return instance;
    }

    public  List<Item> getData(){
        return data;
    }

    public void setData(  List<Item> data ){
        this.data = data;
    }

}
