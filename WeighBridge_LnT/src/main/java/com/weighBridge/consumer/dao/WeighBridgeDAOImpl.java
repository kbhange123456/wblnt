package com.weighBridge.consumer.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weighBridge.consumer.domain.WeighBridgeObj;
import com.weighBridge.consumer.repository.WBORepository;

@Service
public class WeighBridgeDAOImpl implements WeighBridgeDAO{
	
	private WBORepository wbor;
	
	@Autowired
	public WeighBridgeDAOImpl(WBORepository wbor) {
		this.wbor = wbor;
	}
	
	@Override
	public WeighBridgeObj insertWBObj(WeighBridgeObj wbo) {
		wbor.save(wbo);
		return wbo;
	}
	

	@Override
	public List<Long> findAllIds() {
		Iterable<WeighBridgeObj> wboList = wbor.findAll();
		List<Long> idList= new ArrayList<Long>();
		for(WeighBridgeObj wbo : wboList) {
			idList.add(wbo.getId());
		}
		return idList;
	}

	@Override
	public Long getLastId() {
		Iterable<WeighBridgeObj> wboList = wbor.findAll();
		Long maxId = (long) 0;
		for(WeighBridgeObj wbo : wboList) {
			if(wbo.getId()>maxId) {
				maxId=wbo.getId();
			}
		}
		return maxId;
	}

	@Override
	public Optional<WeighBridgeObj> findById(Long id) {
		return wbor.findById(id);
	}

	public List<WeighBridgeObj> findAllByEntryTimeBetween(LocalDate entryTimeStart, LocalDate entryTimeEnd) {
		LocalDateTime entryTimeStartLDT = entryTimeStart.atStartOfDay();
		LocalDateTime entryTimeEndLDT = entryTimeEnd.atTime(23, 59);
		List<WeighBridgeObj> dateWiseList = wbor.findAllByEntryTimeBetweenOrderByEntryTimeAsc(entryTimeStartLDT, entryTimeEndLDT);
		return dateWiseList;
	}



	@Override
	public List<WeighBridgeObj> findAllByTtypeAndEntryTimeBetween(String ttype, LocalDate startDateLD, LocalDate endDateLD) {
		LocalDateTime entryTimeStartLDT = startDateLD.atStartOfDay();
		LocalDateTime entryTimeEndLDT = endDateLD.atTime(23, 59);
		List<WeighBridgeObj> ttypeWiseList = wbor.findAllByTtypeAndEntryTimeBetweenOrderByEntryTimeAsc(ttype,entryTimeStartLDT,entryTimeEndLDT);
		return ttypeWiseList;
	}


	public List<WeighBridgeObj> findAllByMat(String item, LocalDate startDateLD, LocalDate endDateLD) {
		LocalDateTime entryTimeStartLDT = startDateLD.atStartOfDay();
		LocalDateTime entryTimeEndLDT = endDateLD.atTime(23, 59);
		List<WeighBridgeObj> itemWiseList = wbor.findAllByMatAndEntryTimeBetweenOrderByEntryTimeAsc(item,entryTimeStartLDT,entryTimeEndLDT);
		return itemWiseList;
	}

	@Override
	public List<WeighBridgeObj> findPending() {
		List<WeighBridgeObj> pendingList = wbor.findAllByPendingTrueOrderByEntryTimeAsc();
		return pendingList;
	}

	@Override
	public List<WeighBridgeObj> findAllByUlb(String loading, LocalDate startDateLD, LocalDate endDateLD) {
		LocalDateTime entryTimeStartLDT = startDateLD.atStartOfDay();
		LocalDateTime entryTimeEndLDT = endDateLD.atTime(23, 59);
		List<WeighBridgeObj> loadingList = wbor.findAllByUlbAndEntryTimeBetweenOrderByEntryTimeAsc(loading,entryTimeStartLDT,entryTimeEndLDT);
		return loadingList;
	}

	@Override
	public List<WeighBridgeObj> findAllByPname(String party, LocalDate startDateLD, LocalDate endDateLD) {
		LocalDateTime entryTimeStartLDT = startDateLD.atStartOfDay();
		LocalDateTime entryTimeEndLDT = endDateLD.atTime(23, 59);
		List<WeighBridgeObj> pnameList = wbor.findAllByPnameAndEntryTimeBetweenOrderByEntryTimeAsc(party,entryTimeStartLDT,entryTimeEndLDT);
		return pnameList;
	}

	@Override
	public List<WeighBridgeObj> findAllByVtype(String vehicle, LocalDate startDateLD, LocalDate endDateLD) {
		LocalDateTime entryTimeStartLDT = startDateLD.atStartOfDay();
		LocalDateTime entryTimeEndLDT = endDateLD.atTime(23, 59);
		List<WeighBridgeObj> vtypeList = wbor.findAllByVtypeAndEntryTimeBetweenOrderByEntryTimeAsc(vehicle,entryTimeStartLDT,entryTimeEndLDT);
		return vtypeList;
	}

	@Override
	public List<String> getPartyNames() {
		List<String>  partyNames = wbor.findDistinctPname();
		return partyNames;
	}

	@Override
	public List<String> getVehicleTypes() {
		List<String>  partyNames = wbor.findDistinctVtype();
		return partyNames;
	}

}
