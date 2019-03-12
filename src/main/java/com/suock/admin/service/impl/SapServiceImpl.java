package com.suock.admin.service.impl;

import com.suock.admin.dao.*;
import com.suock.admin.model.*;
import com.suock.admin.service.SapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SapServiceImpl implements SapService {

    @Autowired
    private SapInfoDao sapInfoDao;

    @Autowired
    private SapBasicDao sapBasicDao;

    @Autowired
    private SapBasicTableDao sapBasicTableDao;

    @Autowired
    private SapParamsDao sapParamsDao;

    @Autowired
    private SapTableDao sapTableDao;


    @Override
    public Page<SapInfo> getSapInfoAllByPageable(Example example, Pageable pageable) {
        return sapInfoDao.findAll(example,pageable);
    }

    @Override
    public Page<SapBasic> getSapBasicAllByPageable(Example of, Pageable pageable) {
        return sapBasicDao.findAll(of,pageable);
    }

    @Override
    public Page<SapBasicTable> getSapTableByPageable(Example of, Pageable pageable) {
        return sapTableDao.findAll(of,pageable);
    }

    @Override
    public void save(SapInfo sapInfo) {
        sapInfoDao.save(sapInfo);
    }

    @Override
    public List<SapParams> getSapParamsAllByTableid(String id) {
        return sapParamsDao.findAllByTableId(id);
    }

    @Override
    public void save(SapTable sapTable) {
        sapTableDao.save(sapTable);
    }

    @Override
    public void save(SapParams sapParams) {
        sapParamsDao.save(sapParams);
    }

    @Override
    public void deleteAllSapParamsByTableId(String tableId) {
        sapParamsDao.deleteAllSapParamsByTableId(tableId);
    }

    @Override
    public List<SapInfo> getSapInfoAll() {
        return sapInfoDao.findAll();
    }

    @Override
    public List<SapTable> getSapTableAll() {
        return sapTableDao.findAll();
    }

    @Override
    public SapBasic getSapBasicById(String id) {
        SapBasic sapBasic=new SapBasic();
        sapBasic.setId(id);
        return sapBasicDao.findOne(Example.of(sapBasic,ExampleMatcher.matching()));
    }

    @Override
    public List<SapBasicTable> getSapBasicTableByBasicId(String id) {
        return sapBasicTableDao.getSapBasicTableByBasicId(id);
    }

    @Override
    public void save(SapBasic sapBasci) {
        sapBasicDao.save(sapBasci);
    }

    @Override
    public void save(SapBasicTable sapBasicTable) {
        sapBasicTableDao.save(sapBasicTable);
    }

    @Override
    public void deleteAllSapBasicTableByBasicId(String basicId) {
        sapBasicTableDao.deleteAllSapBasicTableByBasicId(basicId);
    }

    @Override
    public SapInfo getSapInfoById(String id) {
        SapInfo sapInfo=new SapInfo();
        sapInfo.setId(id);
        return sapInfoDao.findOne(Example.of(sapInfo,ExampleMatcher.matching()));
    }
}
