package com.suock.admin.service;

import com.suock.admin.model.UrlPermission;
import com.suock.admin.model.UrlPermissionParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UrlPermissionService {
    public void save(UrlPermission urlPermission);
    public void save(UrlPermissionParam urlPermissionParam);
    public void deleteAll();
    public void delete(UrlPermission urlPermission);
    public void delete(UrlPermissionParam urlPermissionParam);

    public UrlPermission find(String id);
    public Page<UrlPermission> getAllURlByPage(Pageable pageable);

    public Page<UrlPermission> getAllURlByStatus(int i,Pageable pageable );

    public List<UrlPermissionParam> getParamsByUrl(String urLid);

    public void deleteAllParam();
}
