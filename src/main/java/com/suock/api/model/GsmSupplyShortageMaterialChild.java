package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "gsm_supply_shortage_material_child")
public class GsmSupplyShortageMaterialChild implements Serializable {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "predict_date",nullable = true)
    private Date predictDate;//预测日期
    @Column(name = "shortage_number",nullable = true)
    private Integer shortageNumber;
    @Column(name = "supply_number",nullable = true)
    private Integer supplyNumber;//供应数量
    @Column(name = "delta_number",nullable = true)
    private Integer deltaNumber;
    @Column(name = "gsm_supply",nullable = true)
    private Integer gsmSupply;
    @Column(name = "long_id",nullable = true)
    private Integer longId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPredictDate() {
        return predictDate;
    }

    public void setPredictDate(Date predictDate) {
        this.predictDate = predictDate;
    }

    public Integer getShortageNumber() {
        return shortageNumber;
    }

    public void setShortageNumber(Integer shortageNumber) {
        this.shortageNumber = shortageNumber;
    }

    public Integer getSupplyNumber() {
        return supplyNumber;
    }

    public void setSupplyNumber(Integer supplyNumber) {
        this.supplyNumber = supplyNumber;
    }

    public Integer getDeltaNumber() {
        return deltaNumber;
    }

    public void setDeltaNumber(Integer deltaNumber) {
        this.deltaNumber = deltaNumber;
    }

    public Integer getGsmSupply() {
        return gsmSupply;
    }

    public void setGsmSupply(Integer gsmSupply) {
        this.gsmSupply = gsmSupply;
    }

    public Integer getLongId() {
        return longId;
    }

    public void setLongId(Integer longId) {
        this.longId = longId;
    }
}
