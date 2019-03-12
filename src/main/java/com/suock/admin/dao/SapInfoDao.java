package com.suock.admin.dao;

import com.suock.admin.model.SapInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapInfoDao extends JpaRepository<SapInfo,Long> {

}
