package com.weighBridge.consumer.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.weighBridge.consumer.domain.WeighBridgeObj;

public interface WeighBridgeDAO {
	WeighBridgeObj insertWBObj(WeighBridgeObj wbo);
	List<Long> findAllIds();
	Long getLastId();
	Optional<WeighBridgeObj> findById(Long id);
	List<WeighBridgeObj> findAllByEntryTimeBetween(
			LocalDate startDateLD,
			LocalDate endDateLD);
	List<WeighBridgeObj> findAllByTtypeAndEntryTimeBetween(String ttype, LocalDate startDateLD, LocalDate endDateLD);
	List<WeighBridgeObj> findAllByMat(String item, LocalDate startDateLD, LocalDate endDateLD);
	List<WeighBridgeObj> findPending();
	List<WeighBridgeObj> findAllByUlb(String loading, LocalDate startDateLD, LocalDate endDateLD);
	List<WeighBridgeObj> findAllByPname(String party, LocalDate startDateLD, LocalDate endDateLD);
	List<WeighBridgeObj> findAllByVtype(String vehicle, LocalDate startDateLD, LocalDate endDateLD);
	List<String> getPartyNames();
	List<String> getVehicleTypes();
	
}
