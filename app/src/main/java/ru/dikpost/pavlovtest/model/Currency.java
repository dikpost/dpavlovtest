
package ru.dikpost.pavlovtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("currency_id")
    @Expose
    private Integer currencyId;

    @SerializedName("short_title")
    @Expose
    private String shortTitle;

    @Expose
    private String title;

    @SerializedName("system_name")
    @Expose
    private String systemName;

    /**
     * 
     * @return
     *     The currencyId
     */
    public Integer getCurrencyId() {
        return currencyId;
    }

    /**
     * 
     * @param currencyId
     *     The currency_id
     */
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * 
     * @return
     *     The shortTitle
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * 
     * @param shortTitle
     *     The short_title
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The systemName
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 
     * @param systemName
     *     The system_name
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

}
