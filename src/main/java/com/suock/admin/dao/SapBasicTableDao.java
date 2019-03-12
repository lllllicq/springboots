package com.suock.admin.dao;

import com.suock.admin.model.SapBasicTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SapBasicTableDao extends JpaRepository<SapBasicTable,Long> {

    @Query("select st from SapBasicTable st where st.basicid.id=?1")
    public List<SapBasicTable> getSapBasicTableByBasicId(String id);

    @Transactional
    @Modifying
    @Query("delete from SapBasicTable where basicid.id=?1")
    public void deleteAllSapBasicTableByBasicId(String basicId);
}
