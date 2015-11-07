package ru.dikpost.pavlovtest.model;

/**
 * Created by oracle on 11/6/15.
 */
// origin_price->amount, image_item, id
public class ListItem
{
    float  itemPrice;
    int     itemId;
    String  imageUrl;

    public ListItem(float itemPrice, String imageUrl) {
        this.itemPrice = itemPrice;
        this.imageUrl = imageUrl;
    }

    public ListItem( float itemPrice, int itemId, String imageUrl)
    {
        this.itemPrice = itemPrice;
        this.itemId = itemId;
        this.imageUrl = imageUrl;
    }

    public float getItemPrice()
    {
        return itemPrice;
    }

    public void setItemPrice( float itemPrice )
    {
        this.itemPrice = itemPrice;
    }

    public int getItemId()
    {
        return itemId;
    }

    public void setItemId( int itemId )
    {
        this.itemId = itemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
