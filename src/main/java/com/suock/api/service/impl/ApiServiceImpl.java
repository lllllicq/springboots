package com.suock.api.service.impl;

import com.suock.api.dao.*;
import com.suock.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.suock.api.service.ApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apiService")
public class ApiServiceImpl implements ApiService {

	@Autowired
	private ApiDao apiDao;

	@Autowired
	private SupplyDemandDbLongFcstDao supplyDemandDbLongFcstDao;
	@Autowired
	private SupplyDemandDbLongFcstChildrenDao supplyDemandDbLongFcstChildrenDao;

	@Autowired
	private SupplyDemandDbWeekFcstDao supplyDemandDbWeekFcstDao;
	@Autowired
	private SupplyDemandDbWeekFcstChildrenDao supplyDemandDbWeekFcstChildrenDao;

	@Autowired
	private GsmSupplyShortageMaterialDao gsmSupplyShortageMaterialDao;
	@Autowired
	private GsmSupplyShortageMaterialChildDao gsmSupplyShortageMaterialChildDao;

	@Autowired
	private GetPOInfoByVendor getPOInfoByVendorDao;

	@Override
	public void save(TPurchaseOrder obj) {
		apiDao.save(obj);
	}

	@Override
	public List findPoByShopName(String shopName) {
		return apiDao.findPoByShopName(shopName);
	}

	@Override
	public void saveOrUpdateSupplyDemandDbLongFcst(SupplyDemandDbLongFcst supplyDemandDbLongFcst) {
		supplyDemandDbLongFcstDao.save(supplyDemandDbLongFcst);
	}

	@Override
	public void saveOrUpdateSupplyDemandDbLongFcstChildren(SupplyDemandDbLongFcstChildren supplyDemandDbLongFcstChildren) {
		supplyDemandDbLongFcstChildrenDao.save(supplyDemandDbLongFcstChildren);
	}

	@Override
	public void saveOrUpdateSupplyDemandDbWeekFcst(SupplyDemandDbWeekFcst supplyDemandDbWeekFcst) {
		supplyDemandDbWeekFcstDao.save(supplyDemandDbWeekFcst);
	}

	@Override
	public void saveOrUpdateSupplyDemandDbWeekFcstChildren(SupplyDemandDbWeekFcstChildren supplyDemandDbWeekFcstChildren) {
		supplyDemandDbWeekFcstChildrenDao.save(supplyDemandDbWeekFcstChildren);
	}

	@Override
	public void saveOrUpdateGsmSupplyShortageMaterial(GsmSupplyShortageMaterial gsmSupplyShortageMaterial) {
		gsmSupplyShortageMaterialDao.save(gsmSupplyShortageMaterial);
	}

	@Override
	public void saveOrUpdateGsmSupplyShortageMaterialChild(GsmSupplyShortageMaterialChild gsmSupplyShortageMaterialChild) {
		gsmSupplyShortageMaterialChildDao.save(gsmSupplyShortageMaterialChild);
	}

	@Override
	public List findSupplyDemandDbLongFcstByVendor(String shopName) {
		List<SupplyDemandDbLongFcst> list=supplyDemandDbLongFcstDao.findSupplyDemandDbLongFcstByVendor(shopName);
		for (SupplyDemandDbLongFcst supplyDemandDbLongFcst:list ) {
			supplyDemandDbLongFcst.setList(supplyDemandDbLongFcstChildrenDao.findSupplyDemandDbLongFcstChildrenByLongId(supplyDemandDbLongFcst.getId()));
		}
		return list;
	}
	@Override
	public List findSupplyDemandDbWeekFcstByVendor(String shopName) {
		List<SupplyDemandDbWeekFcst> list=supplyDemandDbWeekFcstDao.findSupplyDemandDbWeekFcstByVendor(shopName);
		for (SupplyDemandDbWeekFcst supplyDemandDbWeekFcst:list ) {
			supplyDemandDbWeekFcst.setList(supplyDemandDbWeekFcstChildrenDao.findSupplyDemandDbWeekFcstChildrenByWeekId(supplyDemandDbWeekFcst.getId()));
		}
		return list;
	}

	@Override
	public List findGsmSupplyShortageMaterialByVendor(String shopName) {
		List<GsmSupplyShortageMaterial> list=gsmSupplyShortageMaterialDao.findGsmSupplyShortageMaterialByVendor(shopName);
		System.out.println("======================================"+list.size());
		for (GsmSupplyShortageMaterial gsmSupplyShortageMaterial:list ) {

			gsmSupplyShortageMaterial.setList(gsmSupplyShortageMaterialChildDao.findGsmSupplyShortageMaterialChildByVendor(gsmSupplyShortageMaterial.getId()));
		}
		return list;
	}

	@Override
	public void saveOrUpdatePOVendorPOInfo(POVendorPOInfo poInfo) {
		//getPOInfoByVendorDao.save(poInfo);
		getPOInfoByVendorDao.saveAndFlush(poInfo);
	}

	@Override
	public List<POVendorPOInfo> getPOInfoByVendor(String vendorNum) {
		List<POVendorPOInfo> poInfos = getPOInfoByVendorDao.getPOInfoByVendorNum(vendorNum);
		return poInfos;
	}
}
