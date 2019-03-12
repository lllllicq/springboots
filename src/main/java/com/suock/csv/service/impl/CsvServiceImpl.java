package com.suock.csv.service.impl;

import com.suock.csv.dao.CsvFileDao;
import com.suock.csv.dao.CsvTableColsDao;
import com.suock.csv.model.CsvFile;
import com.suock.csv.model.CsvTableCols;
import com.suock.csv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {

    @Autowired
    private CsvFileDao csvFileDao;
    @Autowired
    private CsvTableColsDao csvTableColsDao;


    @Override
    public Page<CsvFile> getAllCsvFileByPage(Example example, Pageable pageable) {
        return csvFileDao.findAll(example,pageable);
    }

    @Override
    public Page<CsvTableCols> getAllCsvTableColsByPage(Example example, Pageable pageable) {
        return csvTableColsDao.findAll(example,pageable);
    }

    @Override
    public void save(CsvFile csvFile) {
        csvFileDao.save(csvFile);
    }

    @Override
    public void save(CsvTableCols csvTableCols) {
        csvTableColsDao.save(csvTableCols);
    }

    @Override
    public List getAllTable() {
        return csvFileDao.getAllTable();
    }

    @Override
    public List getCsvTable(String CsvId) {
        return csvTableColsDao.getCsvTable(CsvId);
    }

    @Override
    public void deleteAllCsvTableColsByCsvFileId(String id) {
        csvTableColsDao.deleteAllCsvTableColsByCsvFileId(id);
    }

    @Override
    public List<CsvFile> getAllCsvFile() {
        return csvFileDao.findAll();
    }
}
