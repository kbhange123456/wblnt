package com.weighBridge.consumer.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weighBridge.consumer.domain.WeighBridgeObj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface WBORepository extends CrudRepository<WeighBridgeObj, Long> {
	//LAST_UPDATED >= :startDate AND LAST_UPDATED <= :endDate"
	//@Query(value = "SELECT * FROM weight_bridge_master where entry_time >= :entryTimeStart AND entry_time<= :entryTimeEnd",nativeQuery=true)
	List<WeighBridgeObj> findAllByEntryTimeBetweenOrderByEntryTimeAsc(@Param("entryTimeStart") 
		      LocalDateTime entryTimeStart,@Param("entryTimeEnd") 
		      LocalDateTime entryTimeEnd);

	List<WeighBridgeObj> findAllByTtypeAndEntryTimeBetweenOrderByEntryTimeAsc(String ttype, LocalDateTime entryTimeStartLDT, LocalDateTime entryTimeEndLDT);
	
	List<WeighBridgeObj> findAllByMatAndEntryTimeBetweenOrderByEntryTimeAsc(String item, LocalDateTime entryTimeStartLDT, LocalDateTime entryTimeEndLDT);
	
	List<WeighBridgeObj> findAllByPendingTrueOrderByEntryTimeAsc();
	
	List<WeighBridgeObj> findAllByUlbAndEntryTimeBetweenOrderByEntryTimeAsc(String loading, LocalDateTime entryTimeStartLDT, LocalDateTime entryTimeEndLDT);
	
	List<WeighBridgeObj> findAllByPnameAndEntryTimeBetweenOrderByEntryTimeAsc(String party, LocalDateTime entryTimeStartLDT, LocalDateTime entryTimeEndLDT);
	
	List<WeighBridgeObj> findAllByVtypeAndEntryTimeBetweenOrderByEntryTimeAsc(String vehicle, LocalDateTime entryTimeStartLDT, LocalDateTime entryTimeEndLDT);
	
	@Query(value = "SELECT DISTINCT pname FROM weight_bridge_master_1", nativeQuery = true)
	List<String> findDistinctPname();
	
	@Query(value = "SELECT DISTINCT vtype FROM weight_bridge_master_1", nativeQuery = true)
	List<String> findDistinctVtype();
	
	
}