package ru.dikpost.pavlovtest.model;

/**
 * Created by oracle on 11/6/15.
 */
// origin_price->amount, image_item, id
public class DetailsItem
{
    String  itemDescr;
    int     itemId;
    String  imageUrl;

    public DetailsItem( String itemDescr, String imageUrl) {
        this.itemDescr = itemDescr;
        this.imageUrl = imageUrl;
    }

    public DetailsItem( String itemDescr, int itemId, String imageUrl)
    {
        this.itemDescr = itemDescr;
        this.itemId = itemId;
        this.imageUrl = imageUrl;
    }

    public String getItemDescr()
    {
        return itemDescr;
    }

    public void setItemDescr( String itemDescr )
    {
        this.itemDescr = itemDescr;
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
