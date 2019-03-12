package com.suock.api.dao;

import com.suock.api.model.GsmSupplyShortageMaterialChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GsmSupplyShortageMaterialChildDao extends JpaRepository<GsmSupplyShortageMaterialChild, Long> {

    @Query("select t from GsmSupplyShortageMaterialChild t where t.longId=?1 ")
    public List findGsmSupplyShortageMaterialChildByVendor(Integer GsmId);

}
