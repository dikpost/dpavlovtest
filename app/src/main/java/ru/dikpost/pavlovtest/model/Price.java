
package ru.dikpost.pavlovtest.model;


import com.google.gson.annotations.Expose;

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
