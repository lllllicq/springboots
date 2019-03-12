package com.suock.admin.service;

import com.suock.admin.model.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SapService {
    public Page<SapInfo> getSapInfoAllByPageable(Example example, Pageable pageable);

    public Page<SapBasic> getSapBasicAllByPageable(Example of, Pageable pageable);

    public Page<SapBasicTable> getSapTableByPageable(Example matcher, Pageable pageable);

    public void save(SapInfo sapInfo);

    public void save(SapTable sapTable);

    public void save(SapParams sapParams);

    public void save(SapBasic sapBasci);

    public void save(SapBasicTable sapBasicTable);

    public void deleteAllSapParamsByTableId(String tableId);

    public void deleteAllSapBasicTableByBasicId(String basicId);

    public List<SapParams> getSapParamsAllByTableid(String id);

    public List<SapInfo> getSapInfoAll();

    public List<SapTable> getSapTableAll();

    public SapBasic getSapBasicById(String id);

    public List<SapBasicTable> getSapBasicTableByBasicId(String id);

    public SapInfo getSapInfoById(String id);
}
