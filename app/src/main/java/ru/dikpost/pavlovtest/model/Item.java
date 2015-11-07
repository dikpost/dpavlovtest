
package ru.dikpost.pavlovtest.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @Expose
    private String id;

    @SerializedName("title_75")
    @Expose
    private String title75;

    @Expose
    private Price price;

    @Expose
    private float discount;

    @SerializedName("origin_price")
    @Expose
    private Price originPrice;

    @SerializedName("image_item")
    @Expose
    private String imageItem;

    @SerializedName("is_only_discount")
    @Expose
    private String isOnlyDiscount;

    @SerializedName("not_show_discount")
    @Expose
    private String notShowDiscount;

    @Expose
    private String url;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The title75
     */
    public String getTitle75() {
        return title75;
    }

    /**
     * 
     * @param title75
     *     The title_75
     */
    public void setTitle75(String title75) {
        this.title75 = title75;
    }

    /**
     * 
     * @return
     *     The price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The discount
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * 
     * @param discount
     *     The discount
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    /**
     * 
     * @return
     *     The originPrice
     */
    public Price getOriginPrice() {
        return originPrice;
    }

    /**
     * 
     * @param originPrice
     *     The origin_price
     */
    public void setOriginPrice(Price originPrice) {
        this.originPrice = originPrice;
    }

    /**
     * 
     * @return
     *     The imageItem
     */
    public String getImageItem() {
        return imageItem;
    }

    /**
     * 
     * @param imageItem
     *     The image_item
     */
    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
    }

    /**
     * 
     * @return
     *     The isOnlyDiscount
     */
    public String getIsOnlyDiscount() {
        return isOnlyDiscount;
    }

    /**
     * 
     * @param isOnlyDiscount
     *     The is_only_discount
     */
    public void setIsOnlyDiscount(String isOnlyDiscount) {
        this.isOnlyDiscount = isOnlyDiscount;
    }

    /**
     * 
     * @return
     *     The notShowDiscount
     */
    public String getNotShowDiscount() {
        return notShowDiscount;
    }

    /**
     * 
     * @param notShowDiscount
     *     The not_show_discount
     */
    public void setNotShowDiscount(String notShowDiscount) {
        this.notShowDiscount = notShowDiscount;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
