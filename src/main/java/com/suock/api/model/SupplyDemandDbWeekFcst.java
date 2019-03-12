package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "supply_demand_db_week_fcst")
public class SupplyDemandDbWeekFcst implements Serializable {

    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private Long id;
    @Column(name = "week_no",nullable = true)
    private String weekNo;
    @Column(name = "version",nullable = true)
    private String version;
    @Column(name = "factory_the",nullable = true)
    private String factoryThe;
    @Column(name = "material",nullable = true)
    private String material;
    @Column(name = "description",nullable = true)
    private String description;
    @Column(name = "description_en",nullable = true)
    private String descriptionEn;
    @Column(name = "vendor",nullable = true)
    private String vendor;
    @Column(name = "vendor_mpn",nullable = true)
    private String  vendorMpn;
    @Column(name = "procurement_code",nullable = true)
    private String procurementCode;
    @Column(name = "min_order",nullable = true)
    private Integer minOrder;
    @Column(name = "brand",nullable = true)
    private String brand;
    @Column(name = "create_date",nullable = true)
    private Date createDate;
    @Column(name = "tvmi_stk",nullable = true)
    private String tvmiStk;
    @Column(name = "is_test",nullable = true)
    private Integer isTest;
    @Column(name = "id_success",nullable = true)
    private Integer idSuccess;
    @Column(name = "remark",nullable = true)
    private String remark;
    @Column(name = "lev_part_number",nullable = true)
    private String levPartNumber;
    @Column(name = "state",nullable = true)
    private String state;
    @Column(name = "is_update",nullable = true)
    private Integer isUpdate;
    @Column(name = "model",nullable = true)
    private String model;
    @Column(name = "part_number",nullable = true)
    private String  partNumber;
    @Column(name = "even_sheet_no",nullable = true)
    private String evenSheetNo;
    @Column(name = "critical_parts",nullable = true)
    private Integer criticalParts;
    @Column(name = "lead_time",nullable = true)
    private String leadTime;
    @Column(name = "dept",nullable = true)
    private String dept;
    @Column(name = "target",nullable = true)
    private Integer target;
    @Column(name = "plants_no",nullable = true)
    private String plantsNo;
    @Column(name = "tower",nullable = true)
    private String tower;
    @Column(name = "weekly_capacity",nullable = true)
    private Integer weeklyCapacity;
    @Column(name = "all_demand_number",nullable = true)
    private Integer allDemandNumber;
    @Column(name = "wip_number",nullable = true)
    private Integer wipNumber;
    @Column(name = "open_op_number",nullable = true)
    private Integer openOpNumber;
    @Column(name = "supply_product_number",nullable = true)
    private Integer supplyProductNumber;
    @Column(name = "product_intransit_number",nullable = true)
    private Integer  productIntransitNumber;
    @Column(name = "vmi_stock",nullable = true)
    private Integer vmiStock;
    @Column(name = "vendor_number",nullable = true)
    private Integer vendorNumber;
    @Column(name = "finished_products_number",nullable = true)
    private Integer finishedProductsNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(String weekNo) {
        this.weekNo = weekNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFactoryThe() {
        return factoryThe;
    }

    public void setFactoryThe(String factoryThe) {
        this.factoryThe = factoryThe;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorMpn() {
        return vendorMpn;
    }

    public void setVendorMpn(String vendorMpn) {
        this.vendorMpn = vendorMpn;
    }

    public String getProcurementCode() {
        return procurementCode;
    }

    public void setProcurementCode(String procurementCode) {
        this.procurementCode = procurementCode;
    }

    public Integer getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(Integer minOrder) {
        this.minOrder = minOrder;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTvmiStk() {
        return tvmiStk;
    }

    public void setTvmiStk(String tvmiStk) {
        this.tvmiStk = tvmiStk;
    }

    public Integer getIsTest() {
        return isTest;
    }

    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }

    public Integer getIdSuccess() {
        return idSuccess;
    }

    public void setIdSuccess(Integer idSuccess) {
        this.idSuccess = idSuccess;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevPartNumber() {
        return levPartNumber;
    }

    public void setLevPartNumber(String levPartNumber) {
        this.levPartNumber = levPartNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getEvenSheetNo() {
        return evenSheetNo;
    }

    public void setEvenSheetNo(String evenSheetNo) {
        this.evenSheetNo = evenSheetNo;
    }

    public Integer getCriticalParts() {
        return criticalParts;
    }

    public void setCriticalParts(Integer criticalParts) {
        this.criticalParts = criticalParts;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getPlantsNo() {
        return plantsNo;
    }

    public void setPlantsNo(String plantsNo) {
        this.plantsNo = plantsNo;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public Integer getWeeklyCapacity() {
        return weeklyCapacity;
    }

    public void setWeeklyCapacity(Integer weeklyCapacity) {
        this.weeklyCapacity = weeklyCapacity;
    }

    public Integer getAllDemandNumber() {
        return allDemandNumber;
    }

    public void setAllDemandNumber(Integer allDemandNumber) {
        this.allDemandNumber = allDemandNumber;
    }

    public Integer getWipNumber() {
        return wipNumber;
    }

    public void setWipNumber(Integer wipNumber) {
        this.wipNumber = wipNumber;
    }

    public Integer getOpenOpNumber() {
        return openOpNumber;
    }

    public void setOpenOpNumber(Integer openOpNumber) {
        this.openOpNumber = openOpNumber;
    }

    public Integer getSupplyProductNumber() {
        return supplyProductNumber;
    }

    public void setSupplyProductNumber(Integer supplyProductNumber) {
        this.supplyProductNumber = supplyProductNumber;
    }

    public Integer getProductIntransitNumber() {
        return productIntransitNumber;
    }

    public void setProductIntransitNumber(Integer productIntransitNumber) {
        this.productIntransitNumber = productIntransitNumber;
    }

    public Integer getVmiStock() {
        return vmiStock;
    }

    public void setVmiStock(Integer vmiStock) {
        this.vmiStock = vmiStock;
    }

    public Integer getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(Integer vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public Integer getFinishedProductsNumber() {
        return finishedProductsNumber;
    }

    public void setFinishedProductsNumber(Integer finishedProductsNumber) {
        this.finishedProductsNumber = finishedProductsNumber;
    }

    @Transient
    public List<SupplyDemandDbWeekFcstChildren> list;

    public List<SupplyDemandDbWeekFcstChildren> getList() {
        return list;
    }

    public void setList(List<SupplyDemandDbWeekFcstChildren> list) {
        this.list = list;
    }


}
