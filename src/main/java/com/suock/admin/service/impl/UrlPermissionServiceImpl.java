package com.suock.admin.service.impl;

import com.suock.admin.dao.UrlPermissionDao;
import com.suock.admin.dao.UrlPermissionParamDao;
import com.suock.admin.model.UrlPermission;
import com.suock.admin.model.UrlPermissionParam;
import com.suock.admin.service.UrlPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlPermissionServiceImpl implements UrlPermissionService {
    @Autowired
    private UrlPermissionDao urlPermissionDao;
    @Autowired
    private UrlPermissionParamDao urlPermissionParamDao;


    @Override
    public void save(UrlPermission urlPermission) {
        urlPermissionDao.save(urlPermission);
    }

    @Override
    public void save(UrlPermissionParam urlPermissionParam) {
        urlPermissionParamDao.save(urlPermissionParam);
    }


    @Override
    public void deleteAll() {
        urlPermissionDao.deleteAllInBatch();
    }

    @Override
    public void delete(UrlPermission urlPermission) {
        urlPermissionDao.delete(urlPermission);
    }

    @Override
    public void delete(UrlPermissionParam urlPermissionParam) {
        urlPermissionParamDao.delete(urlPermissionParam);
    }

    @Override
    public UrlPermission find(String id) {
        return urlPermissionDao.findUrlPermissionByUrl(id);
    }

    @Override
    public Page<UrlPermission> getAllURlByPage(Pageable pageable) {
        return urlPermissionDao.findAll(pageable);
    }

    @Override
    public Page<UrlPermission> getAllURlByStatus(int i, Pageable pageable) {
        return urlPermissionDao.getAllURlByStatus(i,pageable);
    }

    @Override
    public List<UrlPermissionParam> getParamsByUrl(String urLid) {
        return urlPermissionParamDao.getParamsByUrl(urLid);
    }

    @Override
    public void deleteAllParam() {
        urlPermissionParamDao.deleteAllInBatch();
    }
}
