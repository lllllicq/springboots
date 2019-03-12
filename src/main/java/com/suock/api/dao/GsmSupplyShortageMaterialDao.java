package com.suock.api.dao;

import com.suock.api.model.GsmSupplyShortageMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GsmSupplyShortageMaterialDao extends JpaRepository<GsmSupplyShortageMaterial, Long> {

    @Query("select t from GsmSupplyShortageMaterial t where t.vendor=?1 ")
    public List findGsmSupplyShortageMaterialByVendor(String shopName);

}
