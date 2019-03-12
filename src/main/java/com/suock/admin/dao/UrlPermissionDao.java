package com.suock.admin.dao;

import com.suock.admin.model.UrlPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlPermissionDao  extends JpaRepository<UrlPermission,Long> {
    @Query("select u from UrlPermission u where u.url=?1")
    public UrlPermission findUrlPermissionByUrl(String id);

    @Query("select u from UrlPermission u where u.status=?1 ")
    public Page<UrlPermission> getAllURlByStatus(int i, Pageable pageable);
}
