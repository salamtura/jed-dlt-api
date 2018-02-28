package com.jedc.apps.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by BRAINERGY SOLUTIONS on 2/28/2018.
 */
public class PowerData {

    private Integer id;
    private BigDecimal amount;
    private String meterNumber;
    private String vendor;
    private Timestamp dateCreated;

    public PowerData() {
    }

    public PowerData(Integer id, BigDecimal amount, String meterNumber, String vendor, Timestamp dateCreated) {
        this.id = id;
        this.amount = amount;
        this.meterNumber = meterNumber;
        this.vendor = vendor;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "PowerData{" +
                "id=" + id +
                ", amount=" + amount +
                ", meterNumber='" + meterNumber + '\'' +
                ", vendor='" + vendor + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
