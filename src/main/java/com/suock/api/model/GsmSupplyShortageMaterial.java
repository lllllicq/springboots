package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gsm_supply_shortage_material")

public class GsmSupplyShortageMaterial implements Serializable {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//编号
    @Column(name = "cloud_I_fcst_no",nullable = true)
    private String cloudIFcstNo;//流水号  年与日加三位
    @Column(name = "material",nullable = true)
    private String material;//物料号
    @Column(name = "descripition_cn",nullable = true)
    private String descripitionCn;
    @Column(name = "descripition_en",nullable = true)
    private String descripitionEn;//物料描述(英文)
    @Column(name = "material_group",nullable = true)
    private String materialGroup;
    @Column(name = "impact",nullable = true)
    private String impact;
    @Column(name = "whereuserd",nullable = true)
    private String whereuserd;
    @Column(name = "buyer",nullable = true)
    private String buyer;
    @Column(name = "alt",nullable = true)
    private String  alt;
    @Column(name = "altgroup",nullable = true)
    private String altgroup;
    @Column(name = "vmi_stock",nullable = true)
    private Integer vmiStock;
    @Column(name = "roh",nullable = true)
    private String roh;
    @Column(name = "qi_stock",nullable = true)
    private Integer qiStock;
    @Column(name = "run_time",nullable = true)
    private Date runTime;
    @Column(name = "doi",nullable = true)
    private Integer doi;
    @Column(name = "vendor",nullable = true)
    private String vendor;
    @Column(name = "vendor_email",nullable = true)
    private String vendorEmail;
    @Column(name = "Quoda",nullable = true)
    private String Quoda;
    @Column(name = "shortage_ttl_number",nullable = true)
    private Integer shortageTtlNumber;
    @Column(name = "supply_ttl_number",nullable = true)
    private Integer supplyTtlNumber;
    @Column(name = "delta_ttl_number",nullable = true)
    private Integer deltaTtlNumber;
    @Column(name = "is_test",nullable = true)
    private Integer isTest;
    @Column(name = "remark",nullable = true)
    private Integer remark;
    @Column(name = "is_success",nullable = true)
    private Integer isSuccess;
    @Column(name = "text1",nullable = true)
    private String text1;
    @Column(name = "text2",nullable = true)
    private String text2;
    @Column(name = "text3",nullable = true)
    private String text3;
    @Column(name = "field_drills_inventory",nullable = true)
    private Integer fieldDrillsInventory;
    @Column(name = "heavy_ware",nullable = true)
    private String heavyWare;
    @Column(name = "defective_return_ware",nullable = true)
    private String defectiveReturnWare;
    @Column(name = "disable_inventory",nullable = true)
    private Integer disableInventory;
    @Column(name = "version",nullable = true)
    private String version;
    @Column(name = "shortage",nullable = true)
    private String shortage;
    @Column(name = "send_status",nullable = true)
    private Integer sendStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCloudIFcstNo() {
        return cloudIFcstNo;
    }

    public void setCloudIFcstNo(String cloudIFcstNo) {
        this.cloudIFcstNo = cloudIFcstNo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescripitionCn() {
        return descripitionCn;
    }

    public void setDescripitionCn(String descripitionCn) {
        this.descripitionCn = descripitionCn;
    }

    public String getDescripitionEn() {
        return descripitionEn;
    }

    public void setDescripitionEn(String descripitionEn) {
        this.descripitionEn = descripitionEn;
    }

    public String getMaterialGroup() {
        return materialGroup;
    }

    public void setMaterialGroup(String materialGroup) {
        this.materialGroup = materialGroup;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getWhereuserd() {
        return whereuserd;
    }

    public void setWhereuserd(String whereuserd) {
        this.whereuserd = whereuserd;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAltgroup() {
        return altgroup;
    }

    public void setAltgroup(String altgroup) {
        this.altgroup = altgroup;
    }

    public Integer getVmiStock() {
        return vmiStock;
    }

    public void setVmiStock(Integer vmiStock) {
        this.vmiStock = vmiStock;
    }

    public String getRoh() {
        return roh;
    }

    public void setRoh(String roh) {
        this.roh = roh;
    }

    public Integer getQiStock() {
        return qiStock;
    }

    public void setQiStock(Integer qiStock) {
        this.qiStock = qiStock;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public Integer getDoi() {
        return doi;
    }

    public void setDoi(Integer doi) {
        this.doi = doi;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getQuoda() {
        return Quoda;
    }

    public void setQuoda(String quoda) {
        Quoda = quoda;
    }

    public Integer getShortageTtlNumber() {
        return shortageTtlNumber;
    }

    public void setShortageTtlNumber(Integer shortageTtlNumber) {
        this.shortageTtlNumber = shortageTtlNumber;
    }

    public Integer getSupplyTtlNumber() {
        return supplyTtlNumber;
    }

    public void setSupplyTtlNumber(Integer supplyTtlNumber) {
        this.supplyTtlNumber = supplyTtlNumber;
    }

    public Integer getDeltaTtlNumber() {
        return deltaTtlNumber;
    }

    public void setDeltaTtlNumber(Integer deltaTtlNumber) {
        this.deltaTtlNumber = deltaTtlNumber;
    }

    public Integer getIsTest() {
        return isTest;
    }

    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public Integer heavy_ware() {
        return fieldDrillsInventory;
    }

    public void setFieldDrillsInventory(Integer fieldDrillsInventory) {
        this.fieldDrillsInventory = fieldDrillsInventory;
    }
    public Integer getFieldDrillsInventory() {
        return fieldDrillsInventory;
    }

    public String getHeavyWare() {
        return heavyWare;
    }

    public void setHeavyWare(String heavyWare) {
        this.heavyWare = heavyWare;
    }

    public String getDefectiveReturnWare() {
        return defectiveReturnWare;
    }

    public void setDefectiveReturnWare(String defectiveReturnWare) {
        this.defectiveReturnWare = defectiveReturnWare;
    }

    public Integer getDisableInventory() {
        return disableInventory;
    }

    public void setDisableInventory(Integer disableInventory) {
        this.disableInventory = disableInventory;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getShortage() {
        return shortage;
    }

    public void setShortage(String shortage) {
        this.shortage = shortage;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    @Transient
    public List<GsmSupplyShortageMaterialChild > list;

    public List<GsmSupplyShortageMaterialChild > getList() {

        return list;
    }

    public void setList(List<GsmSupplyShortageMaterialChild > list) {

        this.list = list;
    }

}
