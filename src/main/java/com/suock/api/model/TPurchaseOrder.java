package com.suock.api.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_purchaseorder")
public class TPurchaseOrder implements Serializable {

    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "cloud_po_number",nullable = true,length = 10)
    private String cloudPoNumber;

    @Column(name = "purchaseorder_id",nullable = true,length = 64)
    private String purchaseOrderId;

    @Column(name = "line_number",nullable = true,length = 20)
    private String lineNumber;

    @Column(name = "line_item_type",nullable = true,length = 20)
    private String lineItemType;

    @Column(name = "factory_separation",nullable = true,length = 20)
    private String factorySeparation;

    @Column(name = "manufacturer_code",nullable = true,length = 20)
    private String manufacturerCode;

    @Column(name = "purchasing_code",nullable = true,length = 10)
    private String purchasingCode;

    @Column(name = "product_number",nullable = true,length = 20)
    private String productNumber;

    @Column(name = "specification_description",nullable = true,length = 100)
    private String specificationDescription;

    @Column(name = "deliverytime",nullable = true)
    private Date deliverytime;

    @Column(name = "library",nullable = true,length = 20)
    private String library;

    @Column(name = "purchase_order_number")
    private Integer purchaseOrderNumber;

    @Column(name = "po_create_user",nullable = true,length = 20)
    private String poCreateUser;

    @Column(name = "createtime")
    private Date createtime;

    @Column(name = "updatetime")
    private Date updatetime;

    @Column(name = "po_update_user")
    private String poUpdateUser;

    @Column(name = "approver1",nullable = true,length = 20)
    private String approver1;

    @Column(name = "approval_date1")
    private Date approvalDate1;

    @Column(name = "approver2",nullable = true,length = 20)
    private String approver2;

    @Column(name = "approval_date2")
    private Date approvalDate2;

    @Column(name = "approval_status",nullable = true,length = 10)
    private String approvalStatus;

    @Column(name = "receiving_number")
    private Integer receivingNumber;

    @Column(name = "open_asn")
    private Integer openAsn;

    @Column(name = "currency",nullable = true,length = 20)
    private String currency;

    @Column(name = "confirmation_deliverytime")
    private Date confirmationDeliverytime;

    @Column(name = "is_manual_order",nullable = true,length = 10)
    private String isManualOrder;

    @Column(name = "po_status",nullable = true,length = 10)
    private String poStatus;

    @Column(name = "sap_status",nullable = true,length = 10)
    private String sapStatus;

    @Column(name = "synchronization_status",nullable = true,length = 10)
    private String synchronizationStatus;

    @Column(name = "spare1",nullable = true,length = 100)
    private String spare1;

    @Column(name = "spare2",nullable = true,length = 100)
    private String spare2;

    @Column(name = "spare3",nullable = true,length = 100)
    private String spare3;

    @Column(name = "spare4",nullable = true,length = 100)
    private String spare4;

    @Column(name = "spare5",nullable = true,length = 100)
    private String spare5;

    @Column(name = "version",nullable = true,length = 10)
    private String version;

    @Column(name = "item",nullable = true,length = 20)
    private String item;

    @Column(name = "price")
    private Float price;

    @Column(name = "single_weight")
    private Integer singleWeight;

    @Column(name = "gross_weight")
    private Float grossWeight;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "company",nullable = true,length = 20)
    private String company;

    @Column(name = "approve_opinion",nullable = true,length = 255)
    private String approveOpinion;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCloudPoNumber() {
        return cloudPoNumber;
    }

    public void setCloudPoNumber(String cloudPoNumber) {
        this.cloudPoNumber = cloudPoNumber;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineItemType() {
        return lineItemType;
    }

    public void setLineItemType(String lineItemType) {
        this.lineItemType = lineItemType;
    }

    public String getFactorySeparation() {
        return factorySeparation;
    }

    public void setFactorySeparation(String factorySeparation) {
        this.factorySeparation = factorySeparation;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getPurchasingCode() {
        return purchasingCode;
    }

    public void setPurchasingCode(String purchasingCode) {
        this.purchasingCode = purchasingCode;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getSpecificationDescription() {
        return specificationDescription;
    }

    public void setSpecificationDescription(String specificationDescription) {
        this.specificationDescription = specificationDescription;
    }

    public Date getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public Integer getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPoCreateUser() {
        return poCreateUser;
    }

    public void setPoCreateUser(String poCreateUser) {
        this.poCreateUser = poCreateUser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPoUpdateUser() {
        return poUpdateUser;
    }

    public void setPoUpdateUser(String poUpdateUser) {
        this.poUpdateUser = poUpdateUser;
    }

    public String getApprover1() {
        return approver1;
    }

    public void setApprover1(String approver1) {
        this.approver1 = approver1;
    }

    public Date getApprovalDate1() {
        return approvalDate1;
    }

    public void setApprovalDate1(Date approvalDate1) {
        this.approvalDate1 = approvalDate1;
    }

    public String getApprover2() {
        return approver2;
    }

    public void setApprover2(String approver2) {
        this.approver2 = approver2;
    }

    public Date getApprovalDate2() {
        return approvalDate2;
    }

    public void setApprovalDate2(Date approvalDate2) {
        this.approvalDate2 = approvalDate2;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(Integer receivingNumber) {
        this.receivingNumber = receivingNumber;
    }

    public Integer getOpenAsn() {
        return openAsn;
    }

    public void setOpenAsn(Integer openAsn) {
        this.openAsn = openAsn;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getConfirmationDeliverytime() {
        return confirmationDeliverytime;
    }

    public void setConfirmationDeliverytime(Date confirmationDeliverytime) {
        this.confirmationDeliverytime = confirmationDeliverytime;
    }

    public String getIsManualOrder() {
        return isManualOrder;
    }

    public void setIsManualOrder(String isManualOrder) {
        this.isManualOrder = isManualOrder;
    }

    public String getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(String poStatus) {
        this.poStatus = poStatus;
    }

    public String getSapStatus() {
        return sapStatus;
    }

    public void setSapStatus(String sapStatus) {
        this.sapStatus = sapStatus;
    }

    public String getSynchronizationStatus() {
        return synchronizationStatus;
    }

    public void setSynchronizationStatus(String synchronizationStatus) {
        this.synchronizationStatus = synchronizationStatus;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSingleWeight() {
        return singleWeight;
    }

    public void setSingleWeight(Integer singleWeight) {
        this.singleWeight = singleWeight;
    }

    public Float getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Float grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

}
