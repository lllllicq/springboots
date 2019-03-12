package com.suock.csv.dao;

import com.suock.csv.model.CsvTableCols;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CsvTableColsDao extends JpaRepository<CsvTableCols, Long> {

    @Query(value="from CsvTableCols ctc where ctc.csvFileId=?1")
    public List getCsvTable(String csvId);

    @Transactional
    @Modifying
    @Query("delete from CsvTableCols where csvFileId=?1")
    public void deleteAllCsvTableColsByCsvFileId(String id);
}
