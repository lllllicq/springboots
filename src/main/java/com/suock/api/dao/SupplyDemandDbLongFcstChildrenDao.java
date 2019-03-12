package com.suock.api.dao;

import com.suock.api.model.SupplyDemandDbLongFcstChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyDemandDbLongFcstChildrenDao extends JpaRepository<SupplyDemandDbLongFcstChildren, Long> {

    @Query("select t from SupplyDemandDbLongFcstChildren t where t.longId=?1 ")
    public List findSupplyDemandDbLongFcstChildrenByLongId(Long LongId);

}
