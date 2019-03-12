package com.suock.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "supply_demand_db_long_fcst")
public class SupplyDemandDbLongFcst implements Serializable {

    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private Long id;//编号
    @Column(name = "cloud_i_fcst_no",nullable = true)
    private String cloudIFcstNo;//流水号  年与日加三位
    @Column(name = "version",nullable = true)
    private String version;//版本
    @Column(name = "material",nullable = true)
    private String material;//物料号
    @Column(name = "description",nullable = true)
    private String description;//描述
    @Column(name = "description_en",nullable = true)
    private String descriptionEn;//物料描述(英文)
    @Column(name = "vendor",nullable = true)
    private String vendor;//供应商
    @Column(name = "brand",nullable = true)
    private String brand;//品牌
    @Column(name = "vendor_mpn",nullable = true)
    private String  vendorMpn;//厂商MPN
    @Column(name = "remark",nullable = true)
    private String remark;//备注
    @Column(name = "tvmi_stk",nullable = true)
    private Integer tvmiStk;//预测总数
    @Column(name = "is_test",nullable = true)
    private Integer isTest;//0测试数据 1生产数据
    @Column(name = "is_success",nullable = true)
    private Integer isSuccess;//0成功 1失败
    @Column(name = "create_date",nullable = true)
    private Date createDate;

    @Transient
    public List<SupplyDemandDbLongFcstChildren> list;

    public List<SupplyDemandDbLongFcstChildren> getList() {
        return list;
    }

    public void setList(List<SupplyDemandDbLongFcstChildren> list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCloudIFcstNo() {
        return cloudIFcstNo;
    }

    public void setCloudIFcstNo(String cloudIFcstNo) {
        this.cloudIFcstNo = cloudIFcstNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVendorMpn() {
        return vendorMpn;
    }

    public void setVendorMpn(String vendorMpn) {
        this.vendorMpn = vendorMpn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTvmiStk() {
        return tvmiStk;
    }

    public void setTvmiStk(Integer tvmiStk) {
        this.tvmiStk = tvmiStk;
    }

    public Integer getIsTest() {
        return isTest;
    }

    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
