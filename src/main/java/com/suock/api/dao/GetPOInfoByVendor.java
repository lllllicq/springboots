package com.suock.api.dao;

import com.suock.api.model.POVendorPOInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetPOInfoByVendor extends JpaRepository<POVendorPOInfo, String> {

    @Query("select t from POVendorPOInfo t where t.vendorCode=?1")
    public List<POVendorPOInfo> getPOInfoByVendorNum(String vendorNum);


}
