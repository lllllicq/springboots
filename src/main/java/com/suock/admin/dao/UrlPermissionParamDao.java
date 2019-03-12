package com.suock.admin.dao;

import com.suock.admin.model.UrlPermissionParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlPermissionParamDao extends JpaRepository<UrlPermissionParam,Long> {

    @Query("select u from UrlPermissionParam u where u.url=?1")
    public List<UrlPermissionParam> getParamsByUrl(String urLid);
}
