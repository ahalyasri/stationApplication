package com.station.restServices.Repository;

import java.util.List;

import com.station.restServices.models.Station;

public interface StationRepo {
	
	public void saveStation(Station station);
	
	
	public void deleteStation(Station station);
	
	public Station findByStationId(String stationId);
	
	public Station findByStationName(String stationName);
	
	public List<Station> findByHdEnabled(String hdEnabled) ;

}
