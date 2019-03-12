package com.suock.csv.service;

import com.suock.csv.model.CsvFile;
import com.suock.csv.model.CsvTableCols;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CsvService {

    public Page<CsvFile> getAllCsvFileByPage(Example example, Pageable pageable);
    public Page<CsvTableCols> getAllCsvTableColsByPage(Example example, Pageable pageable);
    public void save(CsvFile csvFile);
    public void save(CsvTableCols csvTableCols);
    public List getAllTable();

    public List getCsvTable(String id);

    public void deleteAllCsvTableColsByCsvFileId(String id);

    public List<CsvFile> getAllCsvFile();
}
