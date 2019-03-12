package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "supply_demand_db_week_fcst_child")
public class SupplyDemandDbWeekFcstChildren implements Serializable {
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private Long id;
    @Column(name = "week_id",nullable = true)
    private Long weekId;//预测日期
    @Column(name = "predict_week",nullable = true)
    private Integer predictWeek;//预测周
    @Column(name = "predict_date",nullable = true)
    private Date predictDate;//预测数量
    @Column(name = "predict_number",nullable = true)
    private Integer predictNumber;//供应数量
    @Column(name = "supply_number",nullable = true)
    private Integer supplyNumber;
    @Column(name = "update_demand_number",nullable = true)
    private Integer updateDemandNumber;//预测日期
    @Column(name = "gsm_number_supply",nullable = true)
    private Integer gsmNumberSupply;//预测周
    @Column(name = "gr_number",nullable = true)
    private Integer grNumber;//预测数量
    @Column(name = "vendor_plan",nullable = true)
    private Integer vendorPlan;//供应数量
    @Column(name = "finished_products_number",nullable = true)
    private Long finishedProductsNumber;


}
