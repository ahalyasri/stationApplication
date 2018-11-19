package com.station.restServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.station.restServices.Service.StationService;
import com.station.restServices.models.Station;

import io.swagger.annotations.Api;

@RestController
@Api(value="StationControllerApi")
@RequestMapping(path="/api/")
public class StationController {

	@Autowired
	private StationService stationService;
	
	
	
	@RequestMapping(value = "/saveOrUpdateStation", method = RequestMethod.POST)
	@ResponseBody
	public Station saveOrUpdate(@RequestBody Station station){
		stationService.saveStation(station);
		return station;
	}
	
	@RequestMapping(value = "/removeStation", method = RequestMethod.POST)
	@ResponseBody
	public Station remove(@RequestBody Station station){
		stationService.deleteStation(station);
		return station;
	}
	
	@RequestMapping(value = "/searchByIDOrName", method = RequestMethod.POST)
	@ResponseBody
	public Station findById(@RequestBody Station station){
		Station stationS = null;
		if(station.getStationId()!=null)
		stationS = stationService.findByStationId(station.getStationId());
		else if(station.getName()!=null)
			stationS = stationService.findByStationName(station.getName());
		return stationS;
	}
	
	@RequestMapping(value = "/searchByHDEnabled", method = RequestMethod.POST)
	@ResponseBody
	public List<Station> findByHDEnabled(@RequestBody Station station){
		List<Station> stationList = stationService.findByHdEnabled(station.getHdEnabled());
		return stationList;
	}
	
	
}
