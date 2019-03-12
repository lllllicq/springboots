package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "supply_demand_db_long_fcst_child")
public class SupplyDemandDbLongFcstChildren implements Serializable {
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private Long id;
    @Column(name = "predict_date",nullable = true)
    private Date predictDate;//预测日期
    @Column(name = "predict_week",nullable = true)
    private Integer predictWeek;//预测周
    @Column(name = "predict_number",nullable = true)
    private Integer predictNumber;//预测数量
    @Column(name = "supply_number",nullable = true)
    private Integer supplyNumber;//供应数量
    @Column(name = "long_id",nullable = true)
    private Long longId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPredictDate() {
        return predictDate;
    }

    public void setPredictDate(Date predictDate) {
        this.predictDate = predictDate;
    }

    public Integer getPredictWeek() {
        return predictWeek;
    }

    public void setPredictWeek(Integer predictWeek) {
        this.predictWeek = predictWeek;
    }

    public Integer getPredictNumber() {
        return predictNumber;
    }

    public void setPredictNumber(Integer predictNumber) {
        this.predictNumber = predictNumber;
    }

    public Integer getSupplyNumber() {
        return supplyNumber;
    }

    public void setSupplyNumber(Integer supplyNumber) {
        this.supplyNumber = supplyNumber;
    }

    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }
}
