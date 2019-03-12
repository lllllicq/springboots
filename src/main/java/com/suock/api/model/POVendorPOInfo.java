package com.suock.api.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "po_vendor_po_info")
public class POVendorPOInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "poVersion",nullable = true)
    private String version;

    @Column(name = "plant",nullable = true)
    private String plant;

    @Column(name = "vendorCode",nullable = true)
    private String vendorCode;

    @Column(name = "material",nullable = true)
    private String material;

    @Column(name = "po",nullable = true)
    private String po;

    @Column(name = "poLine",nullable = true)
    private Integer poLine;

    @Column(name = "quantity",nullable = true)
    private Integer quantity;

    @Column(name = "currency",nullable = true)
    private String currency;

    @Column(name = "price",nullable = true)
    private float price;

    @Column(name = "rma",nullable = true)
    private String rma;

    @Column(name = "deliveryDate",nullable = true)
    private Date deliveryDate;

    @Column(name = "actualShipmentTime",nullable = true)
    private Date actualShipmentTime;

    @Column(name = "GRQty",nullable = true)
    private Integer GRQty;

    @Column(name = "openASN",nullable = true)
    private Integer openASN;

    @Column(name = "location",nullable = true)
    private String location;

    @Column(name = "locationDes",nullable = true)
    private String locationDes;

    @Column(name = "buyerCode",nullable = true)
    private String buyerCode;

    @Column(name = "specification",nullable = true)
    private String specification;

    @Column(name = "unit",nullable = true)
    private String unit;

    @Column(name = "manual",nullable = true)
    private String manual;

    @Column(name = "poStatus",nullable = true)
    private Integer poStatus;

    @Column(name = "retCode",nullable = true)
    private String retCode;

    @Column(name = "retMessage",nullable = true)
    private String retMessage;

    @Column(name = "createTime",nullable = true)
    private Date createTime;

    @Column(name = "updateTime",nullable = true)
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public Integer getPoLine() {
        return poLine;
    }

    public void setPoLine(Integer poLine) {
        this.poLine = poLine;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRma() {
        return rma;
    }

    public void setRma(String rma) {
        this.rma = rma;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getActualShipmentTime() {
        return actualShipmentTime;
    }

    public void setActualShipmentTime(Date actualShipmentTime) {
        this.actualShipmentTime = actualShipmentTime;
    }

    public Integer getGRQty() {
        return GRQty;
    }

    public void setGRQty(Integer GRQty) {
        this.GRQty = GRQty;
    }

    public Integer getOpenASN() {
        return openASN;
    }

    public void setOpenASN(Integer openASN) {
        this.openASN = openASN;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDes() {
        return locationDes;
    }

    public void setLocationDes(String locationDes) {
        this.locationDes = locationDes;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public Integer getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(Integer poStatus) {
        this.poStatus = poStatus;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
















