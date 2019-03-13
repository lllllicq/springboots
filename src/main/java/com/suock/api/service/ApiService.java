package com.suock.api.service;

import com.suock.api.model.*;

import java.util.List;


public interface ApiService {
	public void save(TPurchaseOrder obj);
	public List findPoByShopName(String shopName);

	public void saveOrUpdateSupplyDemandDbLongFcst(SupplyDemandDbLongFcst supplyDemandDbLongFcst);
	public void saveOrUpdateSupplyDemandDbLongFcstChildren(SupplyDemandDbLongFcstChildren supplyDemandDbLongFcstChildren);
	public List findSupplyDemandDbLongFcstByVendor(String shopName);

	public void saveOrUpdateSupplyDemandDbWeekFcst(SupplyDemandDbWeekFcst supplyDemandDbWeekFcst);
	public void saveOrUpdateSupplyDemandDbWeekFcstChildren(SupplyDemandDbWeekFcstChildren supplyDemandDbWeekFcstChildren);
	public List findSupplyDemandDbWeekFcstByVendor(String shopName);

	public void saveOrUpdateGsmSupplyShortageMaterial(GsmSupplyShortageMaterial gsmSupplyShortageMaterial);
	public void saveOrUpdateGsmSupplyShortageMaterialChild(GsmSupplyShortageMaterialChild gsmSupplyShortageMaterialChild);
	public List findGsmSupplyShortageMaterialByVendor(String shopName);

	public List<POVendorPOInfo> getPOInfoByVendor(String vendorNum);

	public void saveOrUpdatePOVendorPOInfo(POVendorPOInfo poInfo);

}
