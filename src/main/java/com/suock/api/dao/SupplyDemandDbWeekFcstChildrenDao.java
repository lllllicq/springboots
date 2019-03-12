package com.suock.api.dao;

import com.suock.api.model.SupplyDemandDbWeekFcstChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyDemandDbWeekFcstChildrenDao extends JpaRepository<SupplyDemandDbWeekFcstChildren, Long> {

    @Query("select t from SupplyDemandDbWeekFcstChildren t where t.weekId=?1")
    public List findSupplyDemandDbWeekFcstChildrenByWeekId(Long WeekId);

}
