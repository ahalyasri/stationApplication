package com.station.restServices.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.station.restServices.Repository.StationRepo;
import com.station.restServices.Service.StationService;
import com.station.restServices.models.Station;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationRepo stationRepo;

	@Override
	public void saveStation(Station station) {
		stationRepo.saveStation(station);

	}

	@Override
	public void deleteStation(Station station) {
		stationRepo.deleteStation(station);

	}

	@Override
	public Station findByStationId(String stationId) {
		return stationRepo.findByStationId(stationId);
	}

	@Override
	public Station findByStationName(String stationName) {
		return stationRepo.findByStationName(stationName);
	}

	@Override
	public List<Station> findByHdEnabled(String hdEnabled) {
		// TODO Auto-generated method stub
		return stationRepo.findByHdEnabled(hdEnabled);
	}

}
