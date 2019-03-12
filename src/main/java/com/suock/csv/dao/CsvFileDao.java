package com.suock.csv.dao;

import com.suock.csv.model.CsvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvFileDao extends JpaRepository<CsvFile, Long> {

    @Query(value="show tables", nativeQuery = true)
    public List getAllTable();
}

