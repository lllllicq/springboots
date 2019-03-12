package com.suock.api.dao;

import com.suock.api.model.SupplyDemandDbLongFcst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyDemandDbLongFcstDao extends JpaRepository<SupplyDemandDbLongFcst, Long> {

    @Query("select t from SupplyDemandDbLongFcst t where t.vendor=?1 ")
    public List findSupplyDemandDbLongFcstByVendor(String shopName);

}
