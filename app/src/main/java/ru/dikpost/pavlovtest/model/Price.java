
package ru.dikpost.pavlovtest.model;


//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

public class Price {

    @Expose
    private float amount;
    @Expose
    private Currency currency;

    /**
     * 
     * @return
     *     The amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
