package com.jedc.apps.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by BRAINERGY SOLUTIONS on 2/28/2018.
 */
@Entity
@Table(name = "pwr_data", schema = "powercoin")
public class PwrData {
    private Integer id;
    private BigDecimal amount;
    private String meterNumber;
    private String vendor;
    private Timestamp dateCreated;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "meter_number", nullable = true, length = 120)
    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    @Basic
    @Column(name = "vendor", nullable = true, length = 120)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "date_created", nullable = true)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PwrData pwrData = (PwrData) o;

        if (id != null ? !id.equals(pwrData.id) : pwrData.id != null) return false;
        if (amount != null ? !amount.equals(pwrData.amount) : pwrData.amount != null) return false;
        if (meterNumber != null ? !meterNumber.equals(pwrData.meterNumber) : pwrData.meterNumber != null) return false;
        if (vendor != null ? !vendor.equals(pwrData.vendor) : pwrData.vendor != null) return false;
        if (dateCreated != null ? !dateCreated.equals(pwrData.dateCreated) : pwrData.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (meterNumber != null ? meterNumber.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
