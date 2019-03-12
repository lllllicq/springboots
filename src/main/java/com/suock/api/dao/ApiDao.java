package com.suock.api.dao;

import com.suock.api.model.TPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiDao extends JpaRepository<TPurchaseOrder, Long> {
    @Query("select t from TPurchaseOrder t where t.manufacturerCode=?1 ")
    public List findPoByShopName( String shopName);
}
