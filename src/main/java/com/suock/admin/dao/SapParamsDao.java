package com.suock.admin.dao;

import com.suock.admin.model.SapInfo;
import com.suock.admin.model.SapParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SapParamsDao extends JpaRepository<SapParams,Long> {

    @Query("select s from SapParams s where s.tableid.id=?1")
    public List<SapParams> findAllByTableId(String id);

    @Transactional
    @Modifying
    @Query("delete from SapParams where tableid.id=?1")
    public void deleteAllSapParamsByTableId(String tableId);
}
