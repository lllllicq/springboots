package com.suock.api.dao;

import com.suock.api.model.SupplyDemandDbWeekFcst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyDemandDbWeekFcstDao extends JpaRepository<SupplyDemandDbWeekFcst, Long> {

    @Query("select t from SupplyDemandDbWeekFcst t where t.vendor=?1 ")
    public List findSupplyDemandDbWeekFcstByVendor(String shopName);

}
