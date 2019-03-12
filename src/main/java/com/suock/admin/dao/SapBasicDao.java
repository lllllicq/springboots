package com.suock.admin.dao;

import com.suock.admin.model.SapBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapBasicDao extends JpaRepository<SapBasic,Long> {

}
